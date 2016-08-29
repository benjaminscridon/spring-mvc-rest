package com._8x8.service;

import com._8x8.model.Owner;
import com._8x8.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bscridon on 29.08.2016.
 */
@Service
public class OwnerService implements IOwnerService {

    private OwnerRepository ownerRepository;

    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

    @Override
    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner findOwnerById(Long id) {
        return ownerRepository.findOne(id);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner updateOwner(Owner oldOwner) {
        return ownerRepository.save(oldOwner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.delete(id);

    }

    @Override
    public Owner findByEmailAddress(String email) {
        return ownerRepository.findByEmailAddress(email);
    }
}
