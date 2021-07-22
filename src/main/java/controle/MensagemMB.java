package controle;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("mensagemMB")
@ViewScoped
public class MensagemMB implements Serializable{

	private static final long serialVersionUID = 8845235777382806022L;
	
	public void mensagemUsuarioInexistente() {
		FacesMessage mensagem = new FacesMessage("Usuário Inexistente");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void mensagemSenhaIncorreta() {
		FacesMessage mensagem = new FacesMessage("Senha Incorreta");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);	
	}
	
}