package com.leituraescita.dados;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoTextoEscrita {
	private BufferedWriter saida ;
	
	public void criarArquivo(String nomeArquivo) {
		try {
			saida = new BufferedWriter(new FileWriter(nomeArquivo));
		}
		catch (IOException e){
			System.out.println("Erro do Tipo : " + e.getMessage());
		}
	}
	public void escrever(String texto) {
		try {
			saida.write(texto);
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não Encontrado " + e.getMessage());

		}
		catch(Exception e) {
			System.out.println("Erro do Tipo : " + e.getMessage());

		}
	}

	public void fecharArquivo() {
		try {
			saida.close();
		}
		catch(Exception e ) {
			System.out.println("Erro do Tipo : " + e.getMessage());

		}
	}
}
