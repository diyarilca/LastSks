package sks.project.sksbackend.repositoryDataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sks.project.sksbackend.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
