package com.revature.cats.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(schema = "cat", name = "cats")
public class Cat {
	
	@Id
	@Column(name = "cat_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catId;
	@Column(name = "name")
	private String name;
	@Column(name = "cuteness")
	private Double cuteness;
	
	@JoinColumn(name = "owner")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"cats"})
	private User owner;
	
	
	public Cat() {
		super();
	}
	
	public Cat(Integer catId, String name, Double cuteness) {
		super();
		this.catId = catId;
		this.name = name;
		this.cuteness = cuteness;
	}
	
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCuteness() {
		return cuteness;
	}
	public void setCuteness(Double cuteness) {
		this.cuteness = cuteness;
	}
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Cat [catId=" + catId + ", name=" + name + ", cuteness=" + cuteness + "]";
	}
	
}
