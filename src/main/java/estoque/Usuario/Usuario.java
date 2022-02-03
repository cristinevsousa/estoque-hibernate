package estoque.Usuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int codigo;
	
	private String nome;
	
	private String senha;
	
	private boolean admin;
	
	@CreationTimestamp
	@Column(name = "criado_em")
	private Date criadoEm;
	
	@UpdateTimestamp
	@Column(name = "atualizado_em")
	private Date atualizadoEm;
	
	@Column(name = "esta_ativo")
	private boolean estaAtivo;

	
	public Usuario(int codigo, String nome, String senha) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario(String nome, String senha, boolean admin) {
		super();
		this.setNome(nome);
		this.setSenha(senha);
		this.setAdmin(admin);
	}
	
	public Usuario() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
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
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", senha=" + senha + ", admin=" + admin + ", criadoEm="
				+ criadoEm + ", atualizadoEm=" + atualizadoEm + ", estaAtivo=" + estaAtivo + "]";
	}
	
}
