package estoque.Saida;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import estoque.Item.Item;

@Entity(name = "item_saida")
public class ItemSaida {

	@EmbeddedId
	private ItemSaidaPk codigo;
	
	@MapsId("itemCodigo")
	@ManyToOne
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private Item item;
	
	@MapsId("saidaCodigo")
	@ManyToOne
	@JoinColumn(name = "saida_id", insertable = false, updatable = false)
	private Saida saida;
	
	@Column(name = "qtd_saida")
	private float qtdSaida;
	
	@CreationTimestamp
	@Column(name="criado_em")
	private Date criadoEm;
	
	@UpdateTimestamp
	@Column(name="atualizado_em")
	private Date atualizadoEm;
	
	@Column(name="esta_ativo")
	private boolean estaAtivo;
	
	
	public ItemSaida() {
		
	}
	
	public ItemSaida(String nome) {
		this.item.setNome(nome);
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public float getQtdSaida() {
		return qtdSaida;
	}

	public void setQtdSaida(float qtdSaida) {
		this.qtdSaida = qtdSaida;
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
	public boolean isEstaAtivo() {
		return estaAtivo;
	}
	public void setEstaAtivo(boolean estaAtivo) {
		this.estaAtivo = estaAtivo;
	}
	

	@Override
	public String toString() {
		return "ItemSaida [codigo=" + codigo + ", item=" + item + ", saida=" + saida + ", qtdSaida=" + qtdSaida
				+ ", criadoEm=" + criadoEm + ", atualizadoEm=" + atualizadoEm + ", estaAtivo=" + estaAtivo + "]";
	}
	
}
