package com.main;
import com.classes.*;
import com.estruturadedados.*;

import java.util.Scanner;

import com.aplicativo.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aplicativo app = new Aplicativo();
		Scanner in = new Scanner(System.in);
		app.initialize();
		int entrada = 0;
		while(entrada != 4) {
			String menu ="1 - Criação e Controle de Jogos \n" +
	                 "2 - Criação e Controle de Clientes \n" +
				     "3 - Loja de Jogos \n" + 
	                 "4 - Finalizar Programa \n";
			System.out.println(menu);
			entrada = in.nextInt(); 
			app.menuAplicativo(entrada);
		}
	}

}
