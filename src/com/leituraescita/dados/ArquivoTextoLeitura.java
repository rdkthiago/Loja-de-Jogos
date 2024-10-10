package com.leituraescita.dados;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoTextoLeitura {
	private BufferedReader entrada;
	
	public void abrirArquivo(String nomeArquivo) {
		try {
			entrada = new BufferedReader(new FileReader(nomeArquivo));
		}
		catch(FileNotFoundException e) {
			System.out.println("Arquivo não Encontrado , erro do tipo : " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("Erro do Tipo : " + e.getMessage());
		}

		
	}
	
	public String lerArquivo() {
		StringBuilder txt = new StringBuilder();
		try {
			txt.append(entrada.readLine());
		}
		catch(EOFException e) {
			System.out.println("Erro do Tipo : " + e.getMessage());

		}
		catch(Exception e) {
			System.out.println("Erro do Tipo : " + e.getMessage());

		}
		return txt.toString();
	}
	public void fecharArquivo() {
		try {
			entrada.close();
		}
		catch(Exception e){
			System.out.println("Erro do Tipo : " + e.getMessage());
		}
	}
}
