package estoque.Compra;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import estoque.Fornecedor.Fornecedor;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int codigo;
	
	@Column(name = "data")
	private Date dataCompra;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	@OneToMany
	private List<ItemCompra> itens;
	
	@CreationTimestamp
	@Column(name = "criado_em")
	private Date criadoEm;
	
	@UpdateTimestamp
	@Column(name = "atualizado_em")
	private Date atualizadoEm;
	
	
	public Compra() {
		
	}
	
	public Compra(String nomeFornecedor, Date dataCompra) {
		this.fornecedor.setNome(nomeFornecedor);
		this.dataCompra = dataCompra;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<ItemCompra> getItens() {
		return itens;
	}

	public void setItens(List<ItemCompra> itens) {
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
		return "Compra [codigo=" + codigo + ", dataCompra=" + dataCompra + ", fornecedor=" + fornecedor + ", itens="
				+ itens + ", criadoEm=" + criadoEm + ", atualizadoEm=" + atualizadoEm + "]";
	}
	
}
