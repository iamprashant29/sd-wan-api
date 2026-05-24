package com.example.sdwan.repository;

import com.example.sdwan.model.SiteHealth;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class DashboardRepository {

    private static final Logger log = LoggerFactory.getLogger(DashboardRepository.class);

    private static final String ORGS_PATH = "mock/organizations.json";
    private static final String CHART_PATH = "mock/chart-api-datasets.json";

    @Autowired
    private ObjectMapper mapper;

    /**
     * Attempts to read the mock chart dataset and extract a list of site nodes.
     * The method is defensive: it searches the JSON tree for an array of objects that
     * look like site entries (contain a name field or siteName) and returns them.
     */
    public List<JsonNode> readSiteNodes() throws IOException {
        // try organizations.json first (it contains explicit site objects), otherwise fall back
        ClassPathResource resource = new ClassPathResource(ORGS_PATH);
        if (!resource.exists()) {
            resource = new ClassPathResource(CHART_PATH);
        }
        JsonNode root = mapper.readTree(resource.getInputStream());

        List<JsonNode> results = new ArrayList<>();

        // If root itself is an array, consider it
        if (root.isArray()) {
            for (JsonNode n : root) {
                if (isLikelySiteNode(n)) results.add(n);
                // if elements contain nested arrays, search them
                results.addAll(findSiteNodesRecursively(n));
            }
            if (!results.isEmpty()) return results;
        }

        // otherwise search recursively for arrays that look like site lists
        results.addAll(findSiteNodesRecursively(root));
        return results;
    }

    private List<JsonNode> findSiteNodesRecursively(JsonNode node) {
        List<JsonNode> found = new ArrayList<>();
        if (node == null) return found;

        // If the current object itself looks like a site entry, return it directly.
        if (node.isObject() && isLikelySiteNode(node)) {
            found.add(node);
            return found;
        }

        if (node.isArray()) {
            // check if elements look like site entries
            boolean anySiteLike = false;
            for (JsonNode el : node) {
                if (isLikelySiteNode(el)) {
                    anySiteLike = true;
                    break;
                }
            }
            if (anySiteLike) {
                for (JsonNode el : node) {
                    if (el.isObject()) found.add(el);
                }
                return found;
            }
            // otherwise continue searching inside elements
            for (JsonNode el : node) {
                found.addAll(findSiteNodesRecursively(el));
            }
            return found;
        }

        if (node.isObject()) {
            Iterator<String> names = node.fieldNames();
            while (names.hasNext()) {
                String fname = names.next();
                JsonNode child = node.get(fname);
                found.addAll(findSiteNodesRecursively(child));
            }
        }
        return found;
    }

    private boolean isLikelySiteNode(JsonNode node) {
        if (node == null || !node.isObject()) return false;
        if (node.has("siteName") || node.has("site_name") || node.has("name") || node.has("site")) return true;
        // also check status/totalDevices style
        if (node.has("status") && (node.has("totalEdgeDevices") || node.has("totalDevices") || node.has("devices"))) return true;
        return false;
    }

    /**
     * Convert a site JsonNode into our SiteHealth model using conservative field lookups.
     */
    public SiteHealth toSiteHealth(JsonNode node) {
        String siteName = firstText(node, "siteName", "site_name", "name", "site");
        if (siteName == null) siteName = "Unknown";

        String status = firstText(node, "status", "state");

        int total = firstInt(node, "totalEdgeDevices", "totalDevices", "total_devices", "devicesCount", "deviceCount");

        int online = firstInt(node, "online", "onlineDevices", "online_count");
        int offline = firstInt(node, "offline", "offlineDevices", "offline_count");

        int healthy = firstInt(node, "healthy");
        int degraded = firstInt(node, "degraded");
        int down = firstInt(node, "down");

        // derive totals when missing
        if (total == -1) {
            if (healthy >= 0 || degraded >= 0 || down >= 0) {
                total = Math.max(0, (healthy < 0 ? 0 : healthy) + (degraded < 0 ? 0 : degraded) + (down < 0 ? 0 : down));
            } else if (online >= 0 || offline >= 0) {
                total = Math.max(0, (online < 0 ? 0 : online) + (offline < 0 ? 0 : offline));
            }
        }

        if (online == -1) {
            if (healthy >= 0) online = healthy;
            else if (total >= 0 && offline >= 0) online = Math.max(0, total - offline);
            else online = 0;
        }

        if (offline == -1) {
            if (down >= 0 && degraded >= 0) {
                // assume degraded and down are not online
                offline = (degraded < 0 ? 0 : degraded) + (down < 0 ? 0 : down);
            } else if (total >= 0) {
                offline = Math.max(0, total - online);
            } else {
                offline = 0;
            }
        }

        if (status == null) {
            if (down > 0) status = "DOWN";
            else if (degraded > 0) status = "DEGRADED";
            else status = "HEALTHY";
        }

        // ensure non-negative totals
        if (total < 0) total = online + offline;
        if (online < 0) online = 0;
        if (offline < 0) offline = 0;

        return new SiteHealth(siteName, status, total, online, offline);
    }

    private String firstText(JsonNode node, String... names) {
        for (String n : names) {
            if (node.has(n) && node.get(n).isTextual()) return node.get(n).asText();
            if (node.has(n) && node.get(n).isNumber()) return node.get(n).asText();
        }
        return null;
    }

    private int firstInt(JsonNode node, String... names) {
        for (String n : names) {
            if (node.has(n) && node.get(n).canConvertToInt()) return node.get(n).asInt();
        }
        return -1;
    }
}

