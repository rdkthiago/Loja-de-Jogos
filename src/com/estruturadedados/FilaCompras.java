package com.estruturadedados;
import com.classes.*;
public class FilaCompras {
	private ElementoCompra primeiro;
	private ElementoCompra ultimo;
	
	public FilaCompras() {
		primeiro = new ElementoCompra();
		ultimo = primeiro;
	}
	public void enfileirar(Compra compra) {
		ElementoCompra novo = new ElementoCompra();
		novo.compra = compra;
		novo.proximo =  null;
		ultimo.proximo = novo;
		ultimo = novo;
	}
	public Compra desinfileirar() {
		ElementoCompra elementoRemovido = primeiro.proximo;
		primeiro.proximo = elementoRemovido.proximo;
		elementoRemovido.proximo = null;
		Compra compraRemovido = elementoRemovido.compra;
		return compraRemovido;
	}
	public String mostrarFilaDeCommpras() {
		StringBuilder txt = new StringBuilder();
		ElementoCompra aux = primeiro.proximo;
		while(aux != null) {
			txt.append(aux.compra.toString() + "\n");
			aux = aux.proximo;
		}
		return txt.toString();
		
	}
	
	public double mostrarMediaDeJogo() {
		double media =0;
		double soma =0;
		int quantCompras =0;
		ElementoCompra aux = primeiro.proximo;

		while(aux != null) {
			soma += aux.compra.getAvaliacaoDoJogo();
			aux = aux.proximo;
			quantCompras++;
		}
		media = soma/quantCompras;
		return media;
	}

}
