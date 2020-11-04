package com.example.demo.repositories;

import com.example.demo.entities.Kepek;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KepekRepository extends CrudRepository<Kepek, Integer> {

}
