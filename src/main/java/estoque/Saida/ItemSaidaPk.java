package estoque.Saida;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemSaidaPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668335177892160243L;

	@Column(name = "item_id")
	private int itemCodigo;
	
	@Column(name = "saida_id")
	private int saidaCodigo;
	
	public ItemSaidaPk(int itemCodigo, int saidaCodigo) {
		super();
		this.itemCodigo = itemCodigo;
		this.saidaCodigo = saidaCodigo;
	}
	
	public ItemSaidaPk() {
		super();
	}

	public int getItemCodigo() {
		return itemCodigo;
	}
	public void setItemCodigo(int itemCodigo) {
		this.itemCodigo = itemCodigo;
	}
	public int getSaidaCodigo() {
		return saidaCodigo;
	}
	public void setSaidaCodigo(int saidaCodigo) {
		this.saidaCodigo = saidaCodigo;
	}
	
	@Override
	public int hashCode() {
		
		LocalDateTime date = LocalDateTime.now();
		int result = date.hashCode();
		
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
		ItemSaidaPk other = (ItemSaidaPk) obj;
		if (itemCodigo == 0) {
			if (other.itemCodigo != 0)
				return false;
		} else if (!(itemCodigo == other.itemCodigo))
			return false;
		return true;
	}
	
}
