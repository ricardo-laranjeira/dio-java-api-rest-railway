package org.santander.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tabela_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Conta conta;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Cartao cartao;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Utilidades> utilidades;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Noticias> noticias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public List<Utilidades> getUtilidades() {
		return utilidades;
	}

	public void setUtilidades(List<Utilidades> utilidades) {
		this.utilidades = utilidades;
	}

	public List<Noticias> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticias> noticias) {
		this.noticias = noticias;
	}

}
