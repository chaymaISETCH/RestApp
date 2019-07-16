package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Depot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nom,ville,email,tel;
	
	private int codePostal;
	@JsonIgnore
	@OneToMany(mappedBy = "depot",cascade = CascadeType.ALL)
	private Set<Produit> produits;

	public Depot(String nom, String ville, String email, String tel, int codePostal) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.email = email;
		this.tel = tel;
		this.codePostal = codePostal;
		
	}

	@Override
	public String toString() {
		return "Depot [id=" + id + ", nom=" + nom + ", ville=" + ville + ", email=" + email + ", tel=" + tel
				+ ", codePostal=" + codePostal + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Depot other = (Depot) obj;
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

	public Depot(Long id) {
		super();
		this.id = id;
	}
	
	
	
}
