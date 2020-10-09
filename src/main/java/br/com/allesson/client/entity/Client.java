package br.com.allesson.client.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "num_cpf", columnDefinition = "character")
	private String cpf;
	
	@Column(name = "nome_completo", columnDefinition = "character")
	private String nome;
	
	@Column(name = "nome_reduzido", columnDefinition = "character")
	private String nomeReduzido;
	
	@Column(name = "sexo", columnDefinition = "character")
	private String sexo;
	
	@Column(name = "email", columnDefinition = "character")
	private String email;
	
	@Column(name ="telefone", columnDefinition = "character")
	private String telefone;
	
	public Client(String cpf, String nome, String nomeReduzido, String sexo, String email, String telefone) {
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
