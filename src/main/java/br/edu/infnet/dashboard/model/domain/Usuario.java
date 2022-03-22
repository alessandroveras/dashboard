package br.edu.infnet.dashboard.model.domain;

import java.util.List;

public class Usuario {

	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private boolean admin;

	private Endereco endereco;	

	private List<Professor> professors;

	private List<Atividade> atividades;

	private List<Aula> aulas;
	
	public Usuario() {
	}
	
	@Override
	public String toString() {
		return String.format("Olá, %s (%s) %s", this.nome, this.email, this.admin ? "*" : "");
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Professor> getSolicitantes() {
		return professors;
	}

	public void setSolicitantes(List<Professor> professors) {
		this.professors = professors;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Atividade> getProdutos() {
		return atividades;
	}

	public void setProdutos(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public List<Aula> getPedidos() {
		return aulas;
	}

	public void setPedidos(List<Aula> aulas) {
		this.aulas = aulas;
	}
}