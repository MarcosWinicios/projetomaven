package entidade;

import java.io.Serializable;
import java.time.LocalDate;

public class EProduto implements Serializable {

	private static final long serialVersionUID = -8113046026480230569L;
	
	private String nome;
	private String descricao;
	private Double valor;
	private int qntEstoque;
	private LocalDate dataCadastro;
	
	public void gerarData() {
		this.dataCadastro =  LocalDate.now();
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public int getQntEstoque() {
		return qntEstoque;
	}
	public void setQntEstoque(int qntEstoque) {
		this.qntEstoque = qntEstoque;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	
}
