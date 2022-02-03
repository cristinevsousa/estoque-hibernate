package estoque.Compra;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemCompraPk implements Serializable {

	private static final long serialVersionUID = -4901887693664336613L;

	@Column(name = "item_id")
	private int itemCodigo;
	
	@Column(name = "compra_id")
	private int compraCodigo;
	
	public ItemCompraPk() {
		super();
	}

	public ItemCompraPk(int itemCodigo, int compraCodigo) {
		super();
		this.itemCodigo = itemCodigo;
		this.compraCodigo = compraCodigo;
	}

	public int getItemCodigo() {
		return itemCodigo;
	}

	public void setItemCodigo(int itemCodigo) {
		this.itemCodigo = itemCodigo;
	}

	public int getCompraCodigo() {
		return compraCodigo;
	}

	public void setCompraCodigo(int compraCodigo) {
		this.compraCodigo = compraCodigo;
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
		
		ItemCompraPk other = (ItemCompraPk) obj;
		
		if (itemCodigo == 0) {
			
			if (other.itemCodigo != 0)
				return false;
			
		} else if (!(itemCodigo == other.itemCodigo))
			return false;
		
		return true;
	}
	
}
