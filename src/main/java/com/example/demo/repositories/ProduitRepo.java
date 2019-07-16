package com.example.demo.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.*;


public interface ProduitRepo extends CrudRepository<Produit, Long>{

	
	Set<Produit> findByDepot(Depot d);
	Set<Produit> findByType(Type t);


}

