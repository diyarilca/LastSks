package sks.project.sksbackend.repositoryDataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sks.project.sksbackend.entities.Ship;

public interface ShipRepository extends JpaRepository<Ship, Long>{

}
