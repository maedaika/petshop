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
@Table(name="tbl_pets")
@SequenceGenerator(name="tbl_pets_idpets_seq", sequenceName="tbl_pets_idpets_seq",initialValue=1, allocationSize=1)
@Entity
public class Pets implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//Sequence referenciando ao a chave da tabela, coluna IDPRODUTO
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tbl_pets_idpets_seq")
	@Column(name="idPets")
	private Integer idPets;
	@Column(name="nome")
	private String nome;
	@Column(name="nomeDono")
	private String nomeDono;
	@Column(name="endereco")
	private String endereco;
	@Column(name="dataNascimento")
	private Date dataNascimento;
	
	
	public Integer getIdPets() {
		return idPets;
	}
	public void setIdPets(Integer idPets) {
		this.idPets = idPets;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeDono() {
		return nomeDono;
	}
	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
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
	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pets(Integer idPets, String nome, String nomeDono, String endereco, Date dataNascimento) {
		super();
		this.idPets = idPets;
		this.nome = nome;
		this.nomeDono = nomeDono;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}
	@Override
	public String toString() {
		return "Pets [idPets=" + idPets + ", nome=" + nome + ", nomeDono=" + nomeDono + ", endereco=" + endereco
				+ ", dataNascimento=" + dataNascimento + "]";
	}
	
	

}
