
package estoque.Saida;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Saida {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int codigo;
	
	@Column(name = "data")
	private Date dataSaida;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<ItemSaida> itens;
	
	@CreationTimestamp
	@Column(name = "criado_em")
	private Date criadoEm;
	
	@UpdateTimestamp
	@Column(name = "atualizado_em")
	private Date atualizadoEm;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public List<ItemSaida> getItens() {
		return itens;
	}
	public void setItens(List<ItemSaida> itens) {
		this.itens = itens;
	}
	public Date getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}
	public Date getAtualizadoEm() {
		return atualizadoEm;
	}
	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}
	
	@Override
	public String toString() {
		return "Saida [codigo=" + codigo + ", dataSaida=" + dataSaida + ", itens=" + itens + ", criadoEm=" + criadoEm
				+ ", atualizadoEm=" + atualizadoEm + "]";
	}
	
	
}
