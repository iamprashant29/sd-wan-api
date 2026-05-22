package com.example.sdwan.repository;

import com.example.sdwan.model.Organization;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrganizationRepository {

    private static final String MOCK_PATH = "mock/organizations.json";

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Map<String, Organization> organizations = Collections.emptyMap();

    @PostConstruct
    public void init() {
        loadMockData();
    }

    private void loadMockData() {
        try {
            ClassPathResource resource = new ClassPathResource(MOCK_PATH);
            organizations = objectMapper.readValue(
                    resource.getInputStream(),
                    new TypeReference<Map<String, Organization>>() {}
            );
        } catch (IOException e) {
            // In a real project replace with proper logging
            System.err.println("Failed to load mock organizations from " + MOCK_PATH + ": " + e.getMessage());
            organizations = Collections.emptyMap();
        }
    }

    public Optional<Organization> findById(String orgId) {
        return Optional.ofNullable(organizations.get(orgId));
    }

    public Map<String, Organization> findAll() {
        return Collections.unmodifiableMap(organizations);
    }
}

