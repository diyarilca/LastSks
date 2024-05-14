package sks.project.sksbackend.serviceBusiness;

import java.util.List;

import sks.project.sksbackend.entities.Employee;

public interface EmployeeService {
//5.olarak service business katmanı oluşturuldu interface olarak
	Employee createEmployee(Employee employee);

	Employee getEmployeeById(Long employeeId);

	List<Employee> getAllEmployees();

	Employee updateEmployee(Long employeeId, Employee updatedEmployee);

	void deleteEmployee(Long employeeId);

}
