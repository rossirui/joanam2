package br.ufrpe.joanam2.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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

	private Date dataInvestimento;

	private BigDecimal montanteResgatado;

	private Usuario usuario;

	public Investimento() {

	}
	
	public Investimento(Integer id, int tipo, BigDecimal montante, BigDecimal valorRendimento, String indice,
			int prazoResgate, Date dataInvestimento, BigDecimal montanteResgatado) {
		this.id = id;
		this.tipo = tipo;
		this.montante = montante;
		this.valorRendimento = valorRendimento;
		this.indice = indice;
		this.prazoResgate = prazoResgate;
		this.dataInvestimento = dataInvestimento;
		this.montanteResgatado = montanteResgatado;
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

	public Date getDataInvestimento() {
		return dataInvestimento;
	}

	public void setDataInvestimento(Date dataInvestimento) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investimento other = (Investimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
