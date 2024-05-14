package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.entities.Vehicle;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.repositoryDataAccess.VehicleRepository;
import sks.project.sksbackend.serviceBusiness.VehicleService;


@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{
	
	private VehicleRepository vehicleRepository;

	 @Override
	    public Vehicle getVehicleById(Long vehicleId) {
	        return vehicleRepository.findById(vehicleId)
	                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip araç mevcut değil " + vehicleId));
	    }

	    @Override
	    public List<Vehicle> getAllVehicle() {
	        return vehicleRepository.findAll();
	    }

	    @Override
	    public Vehicle updateVehicle(Long vehicleId, Vehicle updateVehicle) {
	        Vehicle vehicle = vehicleRepository.findById(vehicleId)
	                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip araç mevcut değil " + vehicleId));

	        vehicle.setVehicleType(updateVehicle.getVehicleType());
	        vehicle.setDriverName(updateVehicle.getDriverName());
	        vehicle.setDriverPhone(updateVehicle.getDriverPhone());
	        vehicle.setTowPlate(updateVehicle.getTowPlate());
	        vehicle.setTrailerPlate(updateVehicle.getTrailerPlate());

	        return vehicleRepository.save(vehicle);
	    }

	    @Override
	    public void deleteVehicle(Long vehicleId) {
	        Vehicle vehicle = vehicleRepository.findById(vehicleId)
	                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip araç mevcut değil " + vehicleId));

	        vehicleRepository.delete(vehicle);
	    }

	    @Override
	    public Vehicle createVehicle(Vehicle vehicle) {
	        return vehicleRepository.save(vehicle);
	    }

}