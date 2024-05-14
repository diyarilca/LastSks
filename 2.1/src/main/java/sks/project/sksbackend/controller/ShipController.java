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
import sks.project.sksbackend.entities.Ship;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.serviceBusiness.ShipService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/ship")
public class ShipController {

	private ShipService shipService;
	
	@GetMapping
    public ResponseEntity<List<Ship>> getAllShip() {
        List<Ship> ships = shipService.getAllShip();
        return ResponseEntity.ok(ships);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ship> getShipById(@PathVariable("id") Long shipId) {
        try {
            Ship ship = shipService.getShipById(shipId);
            return ResponseEntity.ok(ship);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Ship> updateShip(@PathVariable("id") Long shipId, @RequestBody Ship updateShip) {
        try {
            Ship ship = shipService.updateShip(shipId, updateShip);
            return ResponseEntity.ok(ship);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShip(@PathVariable("id") Long shipId) {
        try {
            shipService.deleteShip(shipId);
            return ResponseEntity.ok("Gemi silme işlemi başarılı");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ship> createShip(@RequestBody Ship ship) {
        Ship savedShip = shipService.createShip(ship);
        return new ResponseEntity<>(savedShip, HttpStatus.CREATED);
    }
	
	
	
}