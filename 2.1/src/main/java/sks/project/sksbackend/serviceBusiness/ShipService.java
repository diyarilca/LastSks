package sks.project.sksbackend.serviceBusiness;

import java.util.List;

import sks.project.sksbackend.entities.Ship;

public interface ShipService {
	
	
	Ship getShipById(Long shipId); 
	
	List<Ship> getAllShip();
	
	Ship updateShip(Long shipId, Ship updateShip); 
	
	void deleteShip(Long shipId); 
	
	Ship createShip(Ship ship);
	
	

}