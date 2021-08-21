package controle;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.text.View;

import entidade.EPessoa;
import util.PessoaDAO;
import util.SessionContext;

@Named("pessoaMB")
@SessionScoped
public class PessoaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public PessoaMB() throws SQLException {
		if (SessionContext.getInstance().getAttribute("usuario") == null) { /*Checando se o usario está setado na seção*/
			try {
//				FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
				
				boolean respostaComprometida = FacesContext.getCurrentInstance().getExternalContext()
						.isResponseCommitted();

				if (!respostaComprometida) {
					FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			this.preencherCombo();
			this.carregarLista();
			
		}
		
		
		
	}
	
	@Inject
	private EPessoa pessoa;
	
	private String salario;
	
		
	public String getSalario() {
		return salario;
	}


	public void setSalario(String salario) {
		this.salario = salario;
	}

	private List<EPessoa> listaPessoa = new ArrayList<>();
	private List<SelectItem> listaCombo = new ArrayList<SelectItem>();
	
	MensagemMB oMsgMb = new MensagemMB();
	
	
	public EPessoa getPessoa() {
		
		
		return pessoa;
	}
	

	public void setPessoa(EPessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<EPessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<EPessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public List<SelectItem> getListaCombo() {
		return listaCombo;
	}

	public void setListaCombo(List<SelectItem> listaCombo) {
		this.listaCombo = listaCombo;
	}

	public void preencherCombo() {
		this.listaCombo.add(new SelectItem("0", "--Selecione--"));
		this.listaCombo.add(new SelectItem("1", "Sistemas de Informação"));
		this.listaCombo.add(new SelectItem("2", "Química"));
		this.listaCombo.add(new SelectItem("3", "Agronomia"));
		this.listaCombo.add(new SelectItem("4", "Zootecnia"));
	}
	
	public void salvar() { /*Tirar Duvidas sobre isso*/
		PessoaDAO.getInstance().salvar(pessoa);
		this.carregarLista();
		limpar();
	}
	
	public void carregarLista() {
		listaPessoa.clear();
		listaPessoa = PessoaDAO.getInstance().listarTodos();
		
		
	}
	
	public void excluir() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Object parametro = params.get("parametroIdent");
		pessoa.setId(Long.parseLong(parametro.toString()));
		PessoaDAO.getInstance().remover(pessoa);
		this.limpar();
		this.carregarLista();
	}
	
	public void alterar() {
		PessoaDAO.getInstance().alterar(pessoa);
		this.limpar();
		this.carregarLista();
	}

	
	public void limpar()   {
		this.pessoa =  new EPessoa();
		this.refresh();
	}
	
	public void prepararEdicao() throws ParseException{
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Object parametroId = params.get("parametroId");
		this.pessoa = PessoaDAO.getInstance().buscarPorId(Long.parseLong(parametroId.toString()));
		this.refresh();
	}
	
	public void refresh() { /* Atualizar os valores do objeto na tela após terem sido alterados*/
		FacesContext context =  FacesContext.getCurrentInstance();
		Application application =  context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot =  viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
		
	}
	
	
//	public void calcular() throws ParseException { /*Tirar Duvidas sobre isso*/
////		this.pessoa.setSalarioBruto(new BigDecimal(this.salario));
//
////		this.pessoa.calculaImposto();
//		this.listaPessoa.add(this.pessoa);
//		this.pessoa = new EPessoa();
//		this.salario = new String();
//	}
	
	
	

}
