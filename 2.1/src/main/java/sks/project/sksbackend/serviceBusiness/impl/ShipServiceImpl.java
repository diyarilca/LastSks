package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.entities.Ship;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.repositoryDataAccess.ShipRepository;
import sks.project.sksbackend.serviceBusiness.ShipService;


@Service
@AllArgsConstructor
public class ShipServiceImpl implements ShipService{
	
	private ShipRepository shipRepository;

	@Override
    public Ship getShipById(Long shipId) {
        return shipRepository.findById(shipId)
                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip gemi mevcut değil " + shipId));
    }

    @Override
    public List<Ship> getAllShip() {
        return shipRepository.findAll();
    }

    @Override
    public Ship updateShip(Long shipId, Ship updateShip) {
        Ship ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip gemi mevcut değil " + shipId));

        ship.setShipName(updateShip.getShipName());
        ship.setExporter(updateShip.getExporter());
        ship.setDeparturePort(updateShip.getDeparturePort());
        ship.setDestinationPort(updateShip.getDestinationPort());

        return shipRepository.save(ship);
    }

    @Override
    public void deleteShip(Long shipId) {
        Ship ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip gemi mevcut değil " + shipId));

        shipRepository.delete(ship);
    }

    @Override
    public Ship createShip(Ship ship) {
        return shipRepository.save(ship);
    }
	
	

}