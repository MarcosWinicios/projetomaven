package entidade;

import java.io.Serializable;

public class ECliente implements Serializable {

	private static final long serialVersionUID = -2119942449036410942L;
	
	private String cpf;
	private String nome;
	private String descricao;
	private String concatenado;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getConcatenado() {
		return concatenado;
	}
	public void setConcatenado(String contatenado) {
		this.concatenado = contatenado;
	}
	
}
