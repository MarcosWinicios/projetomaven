package entidade;

import java.io.Serializable;
import java.util.Date;

public class EPessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	private String nome;
	
	private String sexo;
	
	private String email;
	
	private String observacao;

	private String curso;
	
	private Date data_nasc;
	
	private double salarioBruto;
	
	private double salarioLiquido;
	
	private double descInss;
	
	private double descIr;
	
	private String tipoPessoa;
	
		
	
	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	private double calculaDescInss() {
		double desconto =  0.11 / this.salarioBruto;
		double salarioDescontado = this.salarioBruto - desconto;
		this.descInss = desconto;
		return salarioDescontado;
	}
	
	public double calculaDescsIr() {//Deve ser chamado para calcular todo o desconto
		double salarioDesc =  this.calculaDescInss();
		double desconto;
		double total;

		if(this.salarioBruto <= 1903.98) {
			this.descIr = 0;
			return salarioDesc;
		}else if(this.salarioBruto >= 1903.99 && this.salarioBruto <= 2826.65) {
			desconto = 0.075 / this.salarioBruto;
			total = salarioDesc - desconto;
			this.descIr = desconto;
			
			return total;

		}else if(this.salarioBruto >= 2826.66 && this.salarioBruto <= 3751.05) {
			desconto = 0.15 / this.salarioBruto;
			total = salarioDesc - desconto;
			this.descIr = desconto;

			return total;

		}else if(this.salarioBruto >= 3751.06 && this.salarioBruto < 4664.68) {
			desconto = 0.225 / this.salarioBruto;
			total = salarioDesc - desconto;
			this.descIr = desconto;

			return total;

		}else{
			desconto = 0.225 / this.salarioBruto;
			total = salarioDesc - desconto;
			this.descIr = desconto;

			return total;
		}
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getDescInss() {
		return descInss;
	}

	public void setDescInss(double descInss) {
		this.descInss = descInss;
	}

	public double getDescIr() {
		return descIr;
	}

	public void setDescIr(double descIr) {
		this.descIr = descIr;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salario) {
		this.salarioBruto = salario;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
}
