package it.uniroma3.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tuto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	@Column(unique = true, nullable = false)
	private String text;
	@ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Utente owner;
	@Temporal(TemporalType.DATE)
	private Date creationtime;
	@OneToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
	private Categoria categoria;

	public Tuto(){

	}
	public Tuto(Utente owner, String text, Date creationtime){
		this.owner = owner;
		this.text = text;
		this.creationtime = creationtime;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Utente getOwner() {
		return owner;
	}
	public void setOwner(Utente owner) {
		this.owner = owner;
	}
	public Date getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}



}
