package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.AdministratorRepository;
import com.example.model.AdministratorClass;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorProfileRepository;

    public AdministratorClass saveAdministratorProfile(AdministratorClass administratorProfile) {
        return administratorProfileRepository.save(administratorProfile);
    }

    public Optional<AdministratorClass> findById(Long id) {
        return administratorProfileRepository.findById(id);
    }

    public void deleteAdministratorProfile(Long id) {
        administratorProfileRepository.deleteById(id);
    }

    public List<AdministratorClass> findAll() {
        return administratorProfileRepository.findAll();
    }
}
