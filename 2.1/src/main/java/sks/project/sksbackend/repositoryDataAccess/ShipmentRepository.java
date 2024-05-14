package sks.project.sksbackend.repositoryDataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sks.project.sksbackend.entities.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment,Long>{
	

}
