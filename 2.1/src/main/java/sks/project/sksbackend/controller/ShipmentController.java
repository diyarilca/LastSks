package sks.project.sksbackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import sks.project.sksbackend.entities.Shipment;
import sks.project.sksbackend.entities.Vehicle;
import sks.project.sksbackend.serviceBusiness.ShipmentService;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/shipments")
public class ShipmentController {

	@Autowired
    private ShipmentService shipmentService;

    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
        List<Long> vehicleIds = new ArrayList<>();
        for (Vehicle vehicle : shipment.getVehicles()) {
            vehicleIds.add(vehicle.getId());
        }
        Shipment createdShipment = shipmentService.createShipment(shipment.getCompany().getId(), shipment.getShip().getId(), shipment.getProduct().getId(), vehicleIds, shipment.getDeparturePoint(), shipment.getDestinationpoint(), shipment.getCustomerPhone(), shipment.getPrice(), shipment.getComment());
        return new ResponseEntity<>(createdShipment, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Shipment> updateShipment(@PathVariable("id") Long id, @RequestBody Shipment shipment) {
        Shipment updatedShipment = shipmentService.updateShipment(id, shipment.getDeparturePoint(), shipment.getDestinationpoint(), shipment.getCustomerPhone(), shipment.getPrice(), shipment.getComment());
        if (updatedShipment != null) {
            return new ResponseEntity<>(updatedShipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable("id") Long shipmentId) {
        shipmentService.deleteShipment(shipmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable("id") Long shipmentId) {
        Optional<Shipment> shipment = shipmentService.getShipmentById(shipmentId);
        return shipment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Shipment>> getAllShipments() {
        List<Shipment> shipments = shipmentService.getAllShipments();
        return new ResponseEntity<>(shipments, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getShipmentCount() {
        int count = shipmentService.getShipmentCount();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
