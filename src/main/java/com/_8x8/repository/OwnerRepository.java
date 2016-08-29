package com._8x8.repository;

import com._8x8.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by bscridon on 29.08.2016.
 */
public interface OwnerRepository extends JpaRepository<Owner,Long> {

    @Query("select o from Owner o where o.email = ?1")
    Owner findByEmailAddress(String email);
}
