package sks.project.sksbackend.repositoryDataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sks.project.sksbackend.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
