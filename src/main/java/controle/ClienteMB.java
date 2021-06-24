package controle;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidade.ECliente;

@Named("cMB")
@SessionScoped
public class ClienteMB implements Serializable{

	private static final long serialVersionUID = 5110913467100493418L;
	
	@Inject
	ECliente cliente;
	
	public ECliente getCliente() {	
		return cliente;
	}
	
	public void setCliente(ECliente cliente) {
		this.cliente = cliente;
	}
	
	public void concatenar() {
		cliente.setConcatenado(cliente.getCpf().concat(cliente.getNome().concat(cliente.getDescricao())));
	}
	
	public void limparCliente() {
		cliente =  new ECliente();
	}
	
}