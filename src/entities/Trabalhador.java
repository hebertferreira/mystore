package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private double salarioBase;
	
	private Departamento departamento;	
	private List<Contrato> contratos = new ArrayList<>(); 
	
	public Trabalhador() {
	}
	
	//CONSTRUTOR
	public Trabalhador(String nome, NivelTrabalhador nivel, double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}	
	
	public void adicionarContrato(Contrato contrato) {
		contratos.add(contrato);
	}

	public void removerContrato(Contrato contrato) {
		contratos.remove(contrato);
	}
	
	public double rendaDoMes(int ano, int mes) {
		
		double soma = salarioBase;
		Calendar calInstanciado = Calendar.getInstance();
		
		for(Contrato c : contratos ){   //Como se ler essa expressão: Para cada CONTRATO da listinha C
			calInstanciado.setTime(c.getDataContrato()); 
			int c_ano = calInstanciado.get(Calendar.YEAR);
			int c_mes = 1 + calInstanciado.get(Calendar.MONTH);
			
			if( ano == c_ano && mes == c_mes){ 
				 soma = soma + c.valorTotalDoContrato();
			 }
		}
		return soma;
	}
}
