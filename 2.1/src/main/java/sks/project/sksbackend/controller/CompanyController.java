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
import sks.project.sksbackend.entities.Company;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.serviceBusiness.CompanyService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyService companyService; //dependency injection

	  @GetMapping
	    public ResponseEntity<List<Company>> getAllCompany() {
	        List<Company> companies = companyService.getAllCompany();
	        return ResponseEntity.ok(companies);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long companyId) {
	        Company company = companyService.getCompanyById(companyId);
	        return ResponseEntity.ok(company);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Company> updateCompany(@PathVariable("id") Long companyId, @RequestBody Company updateCompany) {
	        try {
	            Company updatedCompany = companyService.updateCompany(companyId, updateCompany);
	            return ResponseEntity.ok(updatedCompany);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long companyId) {
	        try {
	            companyService.deleteCompany(companyId);
	            return ResponseEntity.ok("Kullanıcı silme işlemi başarılı");
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
	        Company savedCompany = companyService.createCompany(company);
	        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
	    }
	
	
}
