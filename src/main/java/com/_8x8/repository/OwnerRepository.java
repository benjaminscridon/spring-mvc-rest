package com._8x8.repository;

import com._8x8.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bscridon on 29.08.2016.
 */
public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
