package com.example.sdwan.service;

import com.example.sdwan.model.Organization;
import com.example.sdwan.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    private final OrganizationRepository repository;

    @Autowired
    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public List<Organization> getAllOrganizations() {
        return repository.findAll().entrySet().stream()
                .map(e -> { e.getValue().setOrgId(e.getKey()); return e.getValue(); })
                .toList();
    }

    public Optional<Organization> getOrganization(String orgId) {
        return repository.findById(orgId).map(org -> { org.setOrgId(orgId); return org; });
    }
}

