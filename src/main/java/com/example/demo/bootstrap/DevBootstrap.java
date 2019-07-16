package com.example.demo.bootstrap;

import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.*;
import com.example.demo.repositories.*;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private TypeRepo typeRepo;
	private ProduitRepo produitRepo;
	private DepotRepo depotRepo;
	
	
	
	private void initData() {
		
		Type t = new Type("type 1");
		
		typeRepo.save(t);
		Type t1 = new Type("type 2");
		
		typeRepo.save(t1);
		Depot d  = new Depot("Depot 1 ","ariana", "depot@gmail.com","+216 71 000 002",2041);
		depotRepo.save(d);
		Depot d1  = new Depot("Depot 2 ","ariana", "depot@gmail.com","+216 71 000 002",2041);
		depotRepo.save(d1);
		Produit p = new Produit("produit 1 ",20,50,250,t,d);
		Produit p2 = new Produit("produit 2 ",20,50,250,t1,d1);

		produitRepo.save(p);
		produitRepo.save(p2);
	
		System.out.println("*****"+produitRepo.findByDepot(d));
		
		
	}
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}

		
}
