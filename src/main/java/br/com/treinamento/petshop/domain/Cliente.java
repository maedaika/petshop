package br.com.treinamento.petshop.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


//sequencia criada automaticamente
@Table(name="tbl_cliente")
@SequenceGenerator(name="tbl_cliente_idcliente_seq", sequenceName="tbl_cliente_idcliente_seq",initialValue=1, allocationSize=1)
@Entity
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//Sequence referenciando ao a chave da tabela, coluna IDPRODUTO
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tbl_cliente_idcliente_seq")
	@Column(name="idCliente")
	private Integer idCliente;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="dataNascimento")
	private Date dataNascimento;
	
	@Column(name="pets")
	private Pets pets;
	
	
	public Pets getPets() {
		return pets;
	}
	public void setPets(Pets pets) {
		this.pets = pets;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Cliente(Integer idCliente, String nome, String endereco, Date dataNascimento, Pets pets) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.pets = pets;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", endereco=" + endereco + ", dataNascimento="
				+ dataNascimento + ", pets=" + pets + "]";
	}

	
	
	
}


