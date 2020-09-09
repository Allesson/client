package br.com.allesson.client.vo;

import java.io.Serializable;


public class ClientVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	private String nome;
	
	private String nomeReduzido;
	
	private String sexo;
	
	private String email;
	
	private String telefone;

	public ClientVO() {
	}

	public ClientVO(String cpf, String nome, String nomeReduzido, String sexo, String email, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.nomeReduzido = nomeReduzido;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeReduzido() {
		return nomeReduzido;
	}

	public void setNomeReduzido(String nomeReduzido) {
		this.nomeReduzido = nomeReduzido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
