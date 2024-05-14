package sks.project.sksbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.entities.Vehicle;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.serviceBusiness.VehicleService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	private VehicleService vehicleService;
	
	 @GetMapping
	    public ResponseEntity<List<Vehicle>> getAllVehicle() {
	        List<Vehicle> vehicles = vehicleService.getAllVehicle();
	        return ResponseEntity.ok(vehicles);
	    }

	    @GetMapping("{id}")
	    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") Long vehicleId) {
	        try {
	            Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
	            return ResponseEntity.ok(vehicle);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("{id}")
	    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") Long vehicleId, @RequestBody Vehicle updateVehicle) {
	        try {
	            Vehicle vehicle = vehicleService.updateVehicle(vehicleId, updateVehicle);
	            return ResponseEntity.ok(vehicle);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long vehicleId) {
	        try {
	            vehicleService.deleteVehicle(vehicleId);
	            return ResponseEntity.ok("Araç silme işlemi başarılı");
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
	        Vehicle savedVehicle = vehicleService.createVehicle(vehicle);
	        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
	    }
	
	
	
}
