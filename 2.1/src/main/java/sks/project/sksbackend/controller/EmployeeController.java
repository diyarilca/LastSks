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
import sks.project.sksbackend.entities.Employee;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.serviceBusiness.EmployeeService;


@CrossOrigin("*") //tüm kaynakların tüm kaynaklardan istek almasına izin verir anlamına gelir. react tarafında bu olmadığında sıkıntı çekiyoruz.
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
//7.olarak controller katmanı oluşturuldu.
	private EmployeeService employeeService;
	
	
	  @PostMapping
	    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	        Employee savedEmployee = employeeService.createEmployee(employee);
	        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	    }

	    @GetMapping("{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
	        try {
	            Employee employee = employeeService.getEmployeeById(employeeId);
	            return ResponseEntity.ok(employee);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        List<Employee> employees = employeeService.getAllEmployees();
	        return ResponseEntity.ok(employees);
	    }

	    @PutMapping("{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
	                                                    @RequestBody Employee updatedEmployee) {
	        try {
	            Employee employee = employeeService.updateEmployee(employeeId, updatedEmployee);
	            return ResponseEntity.ok(employee);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
	        try {
	            employeeService.deleteEmployee(employeeId);
	            return ResponseEntity.ok("Employee deleted successfully!");
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	
	
}
