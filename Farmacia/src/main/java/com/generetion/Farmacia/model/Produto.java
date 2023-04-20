package com.generetion.Farmacia.model;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // --> isso que determina que essa classe é uma model
@Table(name = "tb_produto") // --> Aqui criamos uma tabela e demos o nome de tb_produto
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // -->
	private Long id;

	@NotBlank(message = "Atributo produto é Obrigatorio")
	@Size(min = 5, max = 100, message = "O nome deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome;

	@NotNull(message = "O valor do produto é Obrigatorio")
	@DecimalMin(value = "0.01", message = "O preço do produto deve ser um múmero decimal positivo, a partir de R$0.01")
	private BigDecimal preco;

	@UpdateTimestamp
	private LocalDateTime data;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;


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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
