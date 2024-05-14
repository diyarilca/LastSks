package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.entities.Company;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.repositoryDataAccess.CompanyRepository;
import sks.project.sksbackend.serviceBusiness.CompanyService;


@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{
	
	 @Autowired
	    private CompanyRepository companyRepository;

	    @Override
	    public List<Company> getAllCompany() {
	        return companyRepository.findAll();
	    }

	    @Override
	    public Company getCompanyById(Long companyId) {
	        return companyRepository.findById(companyId)
	                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip firma mevcut değil " + companyId));
	    }

	    @Override
	    public Company updateCompany(Long companyId, Company updatedCompany) {
	        Company company = companyRepository.findById(companyId)
	                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip firma mevcut değil " + companyId));

	        company.setCompanyName(updatedCompany.getCompanyName());
	        company.setPhoneNumber(updatedCompany.getPhoneNumber());
	        company.setEmail(updatedCompany.getEmail());
	        company.setTaxOffice(updatedCompany.getTaxOffice());
	        company.setTaxNumber(updatedCompany.getTaxNumber());
	        company.setAddress(updatedCompany.getAddress());

	        return companyRepository.save(company);
	    }

	    @Override
	    public void deleteCompany(Long companyId) {
	        Company company = companyRepository.findById(companyId)
	                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip firma mevcut değil " + companyId));

	        companyRepository.delete(company);
	    }

	    @Override
	    public Company createCompany(Company company) {
	        return companyRepository.save(company);
	    }
}
