package estoque.Fornecedor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	
	@Column(name = "loja_virtual")
	private String lojaVirtual;
	
	@CreationTimestamp
	@Column(name = "criado_em")
	private Date criadoEm;
	
	@UpdateTimestamp
	@Column(name = "atualizado_em")
	private Date atualizadoEm;
	
	@Column(name = "esta_ativo")
	private boolean estaAtivo = true;
	
	
	public Fornecedor(String nome, String telefone, String email, String lojaVirtual) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.lojaVirtual = lojaVirtual;
	}
	
	public Fornecedor() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLojaVirtual() {
		return lojaVirtual;
	}
	public void setLojaVirtual(String lojaVirtual) {
		this.lojaVirtual = lojaVirtual;
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
		return "Fornecedor [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", lojaVirtual=" + lojaVirtual + ", criadoEm=" + criadoEm + ", atualizadoEm=" + atualizadoEm
				+ ", deletadoEm=" + ", estaAtivo=" + estaAtivo + "]";
	}
	
	
	
}
