package sks.project.sksbackend.serviceBusiness;

import java.util.List;
import java.util.Optional;

import sks.project.sksbackend.entities.Shipment;

public interface ShipmentService {

	

	    Shipment updateShipment(Long shipmentId, String departurePoint, String destinationPoint, String customerPhone, String price, String comment);

	    void deleteShipment(Long shipmentId);

	    int getShipmentCount();

	    List<Shipment> getAllShipments();

		Optional<Shipment> getShipmentById(Long shipmentId);

		Shipment createShipment(Long companyId, Long shipId, Long productId, List<Long> vehicleIds,
				String departurePoint, String destinationPoint, String customerPhone, String price, String comment);
}
