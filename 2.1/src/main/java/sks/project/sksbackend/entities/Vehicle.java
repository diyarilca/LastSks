package sks.project.sksbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="vehicle_types")
	private String vehicleType;
	
	@Column(name ="driver_name")
	private String driverName;
	
	@Column(name ="driver_phone")
	private String driverPhone;
	
	@Column(name ="tow_plate")
	private String towPlate; 
	
	@Column(name ="trailer_plate")
	private String trailerPlate;
	
	@ManyToOne
	@JoinColumn(name = "shipment_id", referencedColumnName = "id")
	private Shipment shipment;

	
	
	
	
	
}
