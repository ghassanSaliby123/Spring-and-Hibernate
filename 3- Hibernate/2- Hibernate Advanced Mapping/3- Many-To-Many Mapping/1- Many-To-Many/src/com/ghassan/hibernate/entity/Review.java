package com.ghassan.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "comment")
	private String comment;
	
	
	
	public Review() {
		
	}
	public Review(String coment) {
		this.comment = coment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComent() {
		return comment;
	}
	public void setComent(String coment) {
		this.comment = coment;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", coment=" + comment+"]";
	}
	
	
	

}
