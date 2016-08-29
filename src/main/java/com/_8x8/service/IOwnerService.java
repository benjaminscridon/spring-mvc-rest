package com._8x8.service;

import com._8x8.model.Car;
import com._8x8.model.Owner;

import java.util.List;

/**
 * Created by bscridon on 29.08.2016.
 */
public interface IOwnerService {

    Owner addOwner(Owner owner);

    Owner findOwnerById(Long id);

    List<Owner> getAllOwners();

    Owner updateOwner(Owner oldOwner);

    void deleteOwner(Long id);
}
