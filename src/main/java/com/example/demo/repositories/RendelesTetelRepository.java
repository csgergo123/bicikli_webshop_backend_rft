package com.example.demo.repositories;

import com.example.demo.entities.RendelesTetel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendelesTetelRepository extends CrudRepository<RendelesTetel, Integer> {

}
