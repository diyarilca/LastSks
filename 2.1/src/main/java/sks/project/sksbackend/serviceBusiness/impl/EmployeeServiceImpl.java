package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.entities.Employee;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.repositoryDataAccess.EmployeeRepository;
import sks.project.sksbackend.serviceBusiness.EmployeeService;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
//6.olarak service business katmanı içerisinde EmployeeService sınıfı oluşturuldu
	 

	    @Autowired
	    private EmployeeRepository employeeRepository;
	    
	    
	 

	    @Override
	    public Employee createEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    @Override
	    public Employee getEmployeeById(Long employeeId) {
	        return employeeRepository.findById(employeeId)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));
	    }

	    @Override
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    @Override
	    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
	        Employee employee = employeeRepository.findById(employeeId)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

	        employee.setFirstName(updatedEmployee.getFirstName());
	        employee.setLastName(updatedEmployee.getLastName());
	        employee.setEmail(updatedEmployee.getEmail());

	        return employeeRepository.save(employee);
	    }

	    @Override
	    public void deleteEmployee(Long employeeId) {
	        Employee employee = employeeRepository.findById(employeeId)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

	        employeeRepository.delete(employee);
	    }

}
