package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String label;
	private int stockMin, qte,prix;

	
	@JsonIgnore
	@OneToOne
	private Type type;
	
	@JsonIgnore
	@OneToOne
	private Depot depot;
	
	public Produit(String label, int stockMin, int qte, int prix, Type type) {
		super();
		this.label = label;
		this.stockMin = stockMin;
		this.qte = qte;
		this.prix = prix;
		this.type = type;
	}
	public Produit(String label, int stockMin, int qte, int prix, Type type,Depot depot) {
		super();
		this.label = label;
		this.stockMin = stockMin;
		this.qte = qte;
		this.prix = prix;
		this.type = type;
		this.depot = depot;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", label=" + label + ", stockMin=" + stockMin + ", qte=" + qte + ", prix=" + prix
				+ "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	
}
