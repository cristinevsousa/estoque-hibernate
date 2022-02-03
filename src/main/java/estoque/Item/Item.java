package estoque.Item;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int codigo;
	
	@Column(name = "und_medida")
	private String undMedida;
	
	private String nome;
	
	@Column(name = "descricao")
	private String desc;
	
	private float valor;
	
	@Column(name = "qtd_compra")
	private float qtdCompra;
	
	@Column(name = "qtd_minima")
	private float qtdMinima;
	
	@Column(name = "qtd_maxima")
	private float qtdMaxima;
	
	@Column(name = "qtd_estoque")
	private float qtdEstoque;
	
	private float validade;
	
	@CreationTimestamp
	@Column(name = "criado_em")
	private Timestamp criadoEm;
	
	@UpdateTimestamp
	@Column(name = "atualizado_em")
	private Timestamp atualizadoEm;
	
	@Column(name = "esta_ativo")
	private boolean estaAtivo;
	
	
	public Item() {
		super();
	}
	
	public Item(String undMedida, String nome, String desc, float qtdMinima, float qtdMaxima) {
		super();
		this.undMedida = undMedida;
		this.nome = nome;
		this.desc = desc;
		this.qtdMinima = qtdMinima;
		this.qtdMaxima = qtdMaxima;
	}

	public Item(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getUndMedida() {
		return undMedida;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUndMedida(String undMedida) {
		this.undMedida = undMedida;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getQtdCompra() {
		return qtdCompra;
	}

	public void setQtdCompra(float qtdCompra) {
		this.qtdCompra = qtdCompra;
	}


	public float getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(float qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public float getQtdMaxima() {
		return qtdMaxima;
	}

	public void setQtdMaxima(float qtdMaxima) {
		this.qtdMaxima = qtdMaxima;
	}
	public float getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(float qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public float getValidade() {
		return validade;
	}

	public void setValidade(float validade) {
		this.validade = validade;
	}

	public Timestamp getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Timestamp criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Timestamp getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(Timestamp atualizadoEm) {
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
		return "Item [codigo=" + codigo + ", undMedida=" + undMedida + ", nome=" + nome + ", desc=" + desc
				+ ", qtdMinima=" + qtdMinima + ", qtdMaxima=" + qtdMaxima + ", qtdEstoque=" + qtdEstoque + ", criadoEm="
				+ criadoEm + ", atualizadoEm=" + atualizadoEm + ", estaAtivo=" + estaAtivo + "]";
	}

	
}