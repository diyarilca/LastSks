package sks.project.sksbackend.serviceBusiness;

import java.util.List;

import sks.project.sksbackend.entities.Company;


public interface CompanyService {
	
	List<Company> getAllCompany();
	
	Company getCompanyById(Long companyId);
	
	Company updateCompany(Long CompanyId, Company updateCompany);
	
	void deleteCompany(Long CompanyId);
	
	Company createCompany(Company company);

}