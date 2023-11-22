package com.pi_engenhariadesoftware.pi_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi_engenhariadesoftware.pi_project.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
}
