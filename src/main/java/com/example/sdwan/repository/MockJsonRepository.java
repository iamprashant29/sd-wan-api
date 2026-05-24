package com.example.sdwan.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class MockJsonRepository<T> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    private Map<String, T> data = Collections.emptyMap();

    protected abstract String mockDataPath();

    protected abstract TypeReference<Map<String, T>> typeReference();

    @PostConstruct
    public final void loadMockData() {
        try {
            ClassPathResource resource = new ClassPathResource(mockDataPath());
            data = objectMapper.readValue(resource.getInputStream(), typeReference());
            log.info("Loaded {} entries from {}", data.size(), mockDataPath());
        } catch (Exception e) {
            log.error("Failed to load mock data from {}: {}", mockDataPath(), e.getMessage());
            data = Collections.emptyMap();
        }
    }

    public List<T> findAll() {
        return List.copyOf(data.values());
    }

    public Map<String, T> findAllAsMap() {
        return Collections.unmodifiableMap(data);
    }

    public Optional<T> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }
}
