package com.example.sdwan.repository;

import com.example.sdwan.model.Site;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class SiteRepository {

    private Map<String, Site> sitesData = Collections.emptyMap();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void loadMockData() {
        try {
            ClassPathResource resource = new ClassPathResource("mock/sites.json");
            sitesData = objectMapper.readValue(resource.getInputStream(),
                    new TypeReference<Map<String, Site>>() {});
        } catch (Exception e) {
            sitesData = Collections.emptyMap();
        }
    }

    public List<Site> findAll() {
        return List.copyOf(sitesData.values());
    }

    public Optional<Site> findById(String siteId) {
        return Optional.ofNullable(sitesData.get(siteId));
    }
}
