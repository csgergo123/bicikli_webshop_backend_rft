package com.example.demo.repositories;

import com.example.demo.entities.Bicikli;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicikliRepository extends CrudRepository<Bicikli, Integer> {

}
