package estoque.Compra;

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


@Entity(name = "item_compra")
public class ItemCompra {
	
	@EmbeddedId
	private ItemCompraPk codigo;
	
	@MapsId("itemCodigo")
	@ManyToOne
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private Item item;
	
	@MapsId("compraCodigo")
	@ManyToOne
	@JoinColumn(name = "compra_id", insertable = false, updatable = false)
	private Compra compra;
	
	@CreationTimestamp
	@Column(name = "criado_em")
	private Date criadoEm;
	
	@UpdateTimestamp
	@Column(name = "atualizado_em")
	private Date atualizadoEm;
	
	
	public ItemCompra() {
		
	}
	
	public ItemCompra(String nome) {
		this.item = new Item();
		this.item.setNome(nome);
	}
	
	public ItemCompraPk getCodigo() {
		return codigo;
	}

	public void setCodigo(ItemCompraPk codigo) {
		this.codigo = codigo;
	}
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
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
		return "ItemCompra [codigo=" + codigo + ", item=" + item + ", compra=" + compra + ", criadoEm=" + criadoEm
				+ ", atualizadoEm=" + atualizadoEm + " ]";
	}
	
	
}
