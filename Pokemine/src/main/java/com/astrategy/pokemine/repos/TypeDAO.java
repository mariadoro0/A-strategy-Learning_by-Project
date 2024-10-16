package com.astrategy.pokemine.repos;

import com.astrategy.pokemine.entities.Types;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDAO extends JpaRepository<Types, Integer> {
    Types findByName(String type);
}
