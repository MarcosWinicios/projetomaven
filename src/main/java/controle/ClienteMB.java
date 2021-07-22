package controle;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import entidade.ECliente;
import util.SessionContext;

@Named("cMB")
@SessionScoped
public class ClienteMB implements Serializable{

	private static final long serialVersionUID = 5110913467100493418L;
	
	public  ClienteMB() {
		if(SessionContext.getInstance().getAttribute("usuario") == null){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
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