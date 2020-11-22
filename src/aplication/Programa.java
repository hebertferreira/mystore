package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contrato;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Trabalhador trabalhador;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre com o nome do trabalhador: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Entre com o nivel do trabalhador: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Entre com o salario base:");
		double salarioBase = sc.nextDouble();
		
		//O departamento precisa ser instaciado, pois é uma outra entidade
		trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, new Departamento(nomeDepartamento)); 
		
		System.out.println();
		System.out.print("Informe quantos contratos esse trabalhado terá:");
		int numContratos = sc.nextInt();
		
		for(int i =1; i <= numContratos;i++) {
			System.out.println("Entre a data do contrato #" + i +": ");
			System.out.print("Data DD/MM/YYYY: ");
			Date dataContrato = sdf.parse(sc.next());
			
			System.out.println("Informe o valor da hora");
			double valorPorHora = sc.nextDouble();

			System.out.print("Quantas horas ele irá trabalhar:");
			int horaContrada = sc.nextInt();
			
			Contrato contrato = new Contrato(horaContrada, valorPorHora, dataContrato);
			trabalhador.adicionarContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Entre com o mês e ano para calcular os contratos do periodo(mes/ano): ");
		String mesAno = sc.next();
		int month = Integer.parseInt(mesAno.substring(0,2));
		int year = Integer.parseInt(mesAno.substring(3));

		System.out.println("O trabalhador "+ trabalhador.getNome().toUpperCase());
		System.out.println("Departamento: "+ trabalhador.getDepartamento().getNome());
		System.out.println("Departamento: "+ trabalhador.getDepartamento().getNome());
		System.out.println(trabalhador.getNome().toUpperCase()+" no mês "+ " recebeu o montante de R$ "+String.format("%.2f",trabalhador.rendaDoMes(year, month)));
		
		
		sc.close();
	}

}
