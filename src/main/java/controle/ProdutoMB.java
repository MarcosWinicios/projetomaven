package controle;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidade.EProduto;

@Named("pMB")
@SessionScoped
public class ProdutoMB implements Serializable {

	private static final long serialVersionUID = 6667574492052227400L;
	
	@Inject
	EProduto produto;
	
	String data;
	
	public String getData() {
		return this.data;
	}
	
	public EProduto getProduto() {
		return produto;
	}
	
	public void setProduto(EProduto produto) {
		this.produto = produto;
	}
	
	public void gravar() {
		this.produto.gerarData();
		this.formatarData();
	}
	
	public void formatarData(){
		DateTimeFormatter formatadorTraco = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.data = this.produto.getDataCadastro().format(formatadorTraco);
	}
	
	public void limpar() {
		this.produto =  new EProduto();
	}
	
	
}
