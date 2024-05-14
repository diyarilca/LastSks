package sks.project.sksbackend.serviceBusiness;

import java.util.List;

import sks.project.sksbackend.entities.Vehicle;

public interface VehicleService {

	Vehicle getVehicleById(Long vehicleId);
	
	List<Vehicle> getAllVehicle();
	
	Vehicle updateVehicle(Long vehicleId, Vehicle updateVehicle);
	
	void deleteVehicle(Long vehicleId);
	
	Vehicle createVehicle(Vehicle vehicle);
}
