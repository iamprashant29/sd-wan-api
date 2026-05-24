package com.example.sdwan.repository;

import com.example.sdwan.model.Organization;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class OrganizationRepository extends MockJsonRepository<Organization> {

    @Override
    protected String mockDataPath() {
        return "mock/organizations.json";
    }

    @Override
    protected TypeReference<Map<String, Organization>> typeReference() {
        return new TypeReference<>() {};
    }
}
