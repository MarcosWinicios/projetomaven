package entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pessoa")
public class EPessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "cpf_cnpj")
	private String cpf;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "curso")
	private String curso;
	
	@Column(name = "data_nasc")
	private Date data_nasc;
	
	private BigDecimal salarioBruto;
//	
//	private BigDecimal salarioLiquido;
//	
//	private BigDecimal descInss;
//	
//	private BigDecimal descIr;
	
	@Column(name = "tipoPessoa")
	private String tipoPessoa;
	
		
//	private BigDecimal calculaDescInss() {//Calcula o INSS e retorna o resultado de SALARIO - INSS
//		BigDecimal porcentagem = new BigDecimal("0.11");
//		BigDecimal desconto = this.salarioBruto.multiply(porcentagem);
//		BigDecimal salarioDescontado = this.salarioBruto.subtract(desconto);
//		this.descInss = desconto;
//		
//		return salarioDescontado;
//	}
//	
//	private void calculaDescsIr() {//Deve ser chamado para calcular todo o desconto
//		BigDecimal salarioDesc =  this.calculaDescInss();
//		BigDecimal aliquota;
//		BigDecimal desconto;
//		
//		if(this.salarioBruto.compareTo(new BigDecimal("1903.99")) == -1 ) {
//			this.descIr = new BigDecimal("0");
//			
//		}else if( this.salarioBruto.compareTo(new BigDecimal("2826.66")) == -1 ) {
//			aliquota = new BigDecimal("0.075");
//			desconto = salarioDesc.multiply(aliquota);
//			this.descIr = desconto;
//			
//		
//
//		}else if(this.salarioBruto.compareTo(new BigDecimal("3751.06")) == -1 ) {
//			aliquota = new BigDecimal("0.15");
//			desconto = salarioDesc.multiply(aliquota);
//			this.descIr = desconto;
//
//			
//		}else if(this.salarioBruto.compareTo(new BigDecimal("4664.68")) == -1 ) {
//			aliquota = new BigDecimal("0.225");
//			desconto = salarioDesc.multiply(aliquota);
//			this.descIr = desconto;
//
//		}else{
//			aliquota = new BigDecimal("0.275");
//			desconto = salarioDesc.multiply(aliquota);
//			this.descIr = desconto;
//
//		}
//		
//		
//	}
//	
//	public void calculaImposto() {
//		this.calculaDescInss();
//		this.calculaDescsIr();
//		
//		BigDecimal desconto = this.descInss.add(descIr);
//		this.salarioLiquido = this.salarioBruto.subtract(desconto);
//	}
//	
//	public String formatarSalario(BigDecimal salario) {
//		NumberFormat nf = NumberFormat.getCurrencyInstance();
//		return nf.format(salario);
//	}
//	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

//	public BigDecimal getDescInss() {
//		return descInss;
//	}
//
//	public void setDescInss(BigDecimal descInss) {
//		this.descInss = descInss;
//	}
//
//	public BigDecimal getDescIr() {
//		return descIr;
//	}
//
//	public void setDescIr(BigDecimal descIr ) {
//		this.descIr = descIr;
//	}

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

	public BigDecimal getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(BigDecimal salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
//	public BigDecimal getSalarioLiquido() {
//		return salarioLiquido;
//	}
//	
//	public void setSalarioLiquido(BigDecimal salarioLiquido) {
//		this.salarioLiquido = salarioLiquido;
//	}
//	
//	
}
