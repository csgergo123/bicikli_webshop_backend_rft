package com.example.demo.repositories;

import com.example.demo.entities.Rendeles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendelesRepository extends CrudRepository<Rendeles, Integer> {

}
