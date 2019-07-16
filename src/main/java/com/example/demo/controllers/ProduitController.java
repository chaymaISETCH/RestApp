package com.example.demo.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.repositories.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
	
	private ProduitRepo produitRepo;
	
	//@AutoWired not required (auto)
	@Autowired
	public ProduitController(ProduitRepo produitRepo) {
		super();
		this.produitRepo = produitRepo;
	}


	@GetMapping("/")
	public  Set<Produit> getProduit(){
		 
		Set<Produit> set = new HashSet<Produit>();
		produitRepo.findAll().forEach( p->{
			
		set.add(p);
		System.out.println(p);});
		return set;
		
	}
	@PostMapping(value="/addProduit")
	public String addProduit(@RequestBody Produit p) {
	
		if(produitRepo.save(p) != null)
			return "produit added";
		return "Oooooooooooops something wrong";
		
	}

	
	@PutMapping("/editProduit/{id}")
	public Produit editAuthor(@RequestBody Produit p, @PathVariable Long id) {
		p.setId(id);
		return produitRepo.save(p);
	}
	
	
	@DeleteMapping("/deleteProduit/{id}")
	public String deleteProduit(@PathVariable Long id) {
		
		produitRepo.deleteById(id);
		return "deleted";
		
	}
	
	
	
	@GetMapping("/getByType/{id}")
	public Set<Produit> getByType(@PathVariable Long id) {
		Set<Produit> set = new HashSet<Produit>();
		produitRepo.findByType(new Type(id)).forEach( p-> set.add(p));
		
		return set;
		
	
	}
	@GetMapping(value = "/{id}")
	public Produit getAuthors(@PathVariable Long id) {
		
		System.out.println("id : "+id);
		Optional<Produit> opt = produitRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	

	}
	
	@GetMapping("/getByDepot/{id}")
	public Set<Produit> getByDepo(@PathVariable Long id) {
		
		Set<Produit> set = new HashSet<Produit>();
		produitRepo.findByDepot(new Depot(id)).forEach( p-> set.add(p));
		
		return set;
		
	
	}
}
