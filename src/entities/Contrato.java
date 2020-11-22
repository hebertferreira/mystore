package entities;

import java.util.Date;

public class Contrato {
	
	private int horasContratadas;
	private double valorHomemHora;
	private Date dataContrato;
	
	//Construtor
	public Contrato(int horasContratadas, double valorHomemHora, Date dataContrato) {
		this.horasContratadas = horasContratadas;
		this.valorHomemHora = valorHomemHora;
		this.dataContrato = dataContrato;
	}

	public int getHorasContratadas() {
		return horasContratadas;
	}

	public void setHorasContratadas(int horasContratadas) {
		this.horasContratadas = horasContratadas;
	}

	public double getValorHomemHora() {
		return valorHomemHora;
	}

	public void setValorHomemHora(double valorHomemHora) {
		this.valorHomemHora = valorHomemHora;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}
	
	public double valorTotalDoContrato() {
		
		return valorHomemHora * horasContratadas;  
	}
	

}
