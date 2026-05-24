package com.example.sdwan.repository;

import com.example.sdwan.model.Site;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SiteRepository extends MockJsonRepository<Site> {

    @Override
    protected String mockDataPath() {
        return "mock/sites.json";
    }

    @Override
    protected TypeReference<Map<String, Site>> typeReference() {
        return new TypeReference<>() {};
    }
}
