package com.classes;
import com.estruturadedados.*;
public class JogoDigital {
	private int idJogo;
	private String nomeJogo;
	private String plataforma;
	private int anoLancamento;
	private double preco;
	private FilaCompras filaDeCompras = new FilaCompras();
	
	public JogoDigital(int idJogo, String nomeJogo , String plataforma ,int anoLancamento , double preco) {
		this.idJogo=idJogo;
		this.nomeJogo=nomeJogo;
		this.plataforma=plataforma;
		this.anoLancamento=anoLancamento;
		this.preco= preco;
	}

	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void registrarCompra(Compra compra) {
    	filaDeCompras.enfileirar(compra);
 
    }
	public double mostrarMediaDeAvaliacao() {
		return filaDeCompras.mostrarMediaDeJogo();
	}

	public String toString() {
		String jogo = "Id do Jogo : "+ idJogo + " - " + "Nome : " + nomeJogo + " - " + "Plataforma : " + plataforma + " - "+ "Ano de Lançamento : " + anoLancamento + " - " + "Preço : R$"+ preco; 
		return jogo;
	}
	
}
