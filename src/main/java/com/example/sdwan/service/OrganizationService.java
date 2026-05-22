package com.example.sdwan.service;

import com.example.sdwan.model.Organization;
import com.example.sdwan.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationService {

    private final OrganizationRepository repository;

    @Autowired
    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public Optional<Organization> getOrganization(String orgId) {
        return repository.findById(orgId);
    }
}

