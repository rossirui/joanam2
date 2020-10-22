package br.ufrpe.joanam2.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Investimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private int tipo;

	private BigDecimal montante;

	private BigDecimal valorRendimento;

	private String indice;

	private int prazoResgate;

	private LocalDate dataInvestimento;

	private BigDecimal montanteResgatado;

	private Usuario usuario;

	public Investimento() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getMontante() {
		return montante;
	}

	public void setMontante(BigDecimal montante) {
		this.montante = montante;
	}

	public BigDecimal getValorRendimento() {
		return valorRendimento;
	}

	public void setValorRendimento(BigDecimal valorRendimento) {
		this.valorRendimento = valorRendimento;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public int getPrazoResgate() {
		return prazoResgate;
	}

	public void setPrazoResgate(int prazoResgate) {
		this.prazoResgate = prazoResgate;
	}

	public LocalDate getDataInvestimento() {
		return dataInvestimento;
	}

	public void setDataInvestimento(LocalDate dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}

	public BigDecimal getMontanteResgatado() {
		return montanteResgatado;
	}

	public void setMontanteResgatado(BigDecimal montanteResgatado) {
		this.montanteResgatado = montanteResgatado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
