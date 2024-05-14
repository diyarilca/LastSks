package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.entities.Company;
import sks.project.sksbackend.entities.Product;
import sks.project.sksbackend.entities.Ship;
import sks.project.sksbackend.entities.Shipment;
import sks.project.sksbackend.entities.Vehicle;
import sks.project.sksbackend.repositoryDataAccess.CompanyRepository;
import sks.project.sksbackend.repositoryDataAccess.ProductRepository;
import sks.project.sksbackend.repositoryDataAccess.ShipRepository;
import sks.project.sksbackend.repositoryDataAccess.ShipmentRepository;
import sks.project.sksbackend.repositoryDataAccess.VehicleRepository;
import sks.project.sksbackend.serviceBusiness.ShipmentService;

@AllArgsConstructor
@Service
public class ShipmentServiceImpl implements ShipmentService{

		private ShipRepository shipRepository;
	    private CompanyRepository companyRepository;
	    private ProductRepository productRepository;
	    private VehicleRepository vehicleRepository;
	    private ShipmentRepository shipmentRepository;
	    
	    
	    @Override
	    public Shipment createShipment(Long companyId, Long shipId, Long productId, List<Long> vehicleIds, String departurePoint, String destinationPoint, String customerPhone, String price, String comment) {
	        // İlgili ID'lerle ilişkilendirilmiş varlıkları bul
	        Company company = companyRepository.findById(companyId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid company ID"));
	        Ship ship = shipRepository.findById(shipId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid ship ID"));
	        Product product = productRepository.findById(productId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
	        
	        List<Vehicle> vehicles = vehicleIds.stream()
	                .map(id -> vehicleRepository.findById(id)
	                        .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle ID: " + id)))
	                .collect(Collectors.toList());

	        // Yeni bir Shipment örneği oluştur ve değerleri ayarla
	        Shipment shipment = new Shipment();
	        shipment.setCompany(company);
	        shipment.setShip(ship);
	        shipment.setProduct(product);
	        shipment.setVehicles(vehicles); // Dikkat: vehicles olarak ayarla
	        shipment.setDeparturePoint(departurePoint);
	        shipment.setDestinationpoint(destinationPoint); 
	        shipment.setCustomerPhone(customerPhone);
	        shipment.setPrice(price);
	        shipment.setComment(comment);

	        // Oluşturulan sevkiyatı kaydet ve geri döndür
	        return shipmentRepository.save(shipment);
	    }

	    @Override
	    public Shipment updateShipment(Long shipmentId, String departurePoint, String destinationPoint, String customerPhone, String price, String comment) {
	        Shipment shipment = shipmentRepository.findById(shipmentId).orElseThrow(() -> new IllegalArgumentException("Invalid shipment ID"));
	        shipment.setDeparturePoint(departurePoint);
	        shipment.setDestinationpoint(destinationPoint);
	        shipment.setCustomerPhone(customerPhone);
	        shipment.setPrice(price);
	        shipment.setComment(comment);

	        return shipmentRepository.save(shipment);
	    }

	    @Override
	    public void deleteShipment(Long shipmentId) {
	        shipmentRepository.deleteById(shipmentId);
	    }

	    @Override
	    public Optional<Shipment> getShipmentById(Long shipmentId) {
	        return shipmentRepository.findById(shipmentId);
	    }

	    @Override
	    public List<Shipment> getAllShipments() {
	        return shipmentRepository.findAll();
	    }

		@Override
		public int getShipmentCount() {
			 return (int) shipmentRepository.count();
		}

}
