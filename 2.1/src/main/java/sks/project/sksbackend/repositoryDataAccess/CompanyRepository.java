package sks.project.sksbackend.repositoryDataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sks.project.sksbackend.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}

