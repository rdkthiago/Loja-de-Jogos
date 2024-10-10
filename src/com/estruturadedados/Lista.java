package com.estruturadedados;
import com.classes.*;
import com.ordenacao.Ordenacao;
import com.aplicativo.*;
public class Lista {
	private Elemento primeiro;
	private Elemento ultimo;
	private int quantJogos;
	
	public Lista() {
		primeiro = new Elemento();
		ultimo = primeiro;
		quantJogos =0;
	}
	public void adicionarNoInicio(JogoDigital jogo) {
		Elemento novo = new Elemento();
		novo.jogo = jogo;
		Elemento elementoAlterado = primeiro.proximo;
		novo.proximo = elementoAlterado;
		novo.anterior = primeiro;
		elementoAlterado.anterior = novo;
		primeiro.proximo = novo;
	}
	public JogoDigital removerInicio() {
		Elemento elementoRemovido = primeiro.proximo;
		Elemento elementoAnterior = primeiro;
		Elemento proximoElemento = elementoRemovido.proximo;
		JogoDigital jogoRemovido = elementoRemovido.jogo;
		elementoAnterior.proximo =  proximoElemento;
		proximoElemento.anterior = elementoAnterior;
		elementoRemovido.anterior = null;
		elementoRemovido.proximo = null;
		quantJogos--;
		return jogoRemovido;
	}
	
	public void adicionar(JogoDigital jogo) {
		Elemento novo = new Elemento();
		novo.jogo = jogo;
		novo.proximo = null;
		novo.anterior = ultimo;
		ultimo.proximo = novo;
		ultimo = novo;
		quantJogos++;
	}

	public JogoDigital remover(String nome) {
		Elemento elementoRemovido = buscarElemento(nome);
		if(elementoRemovido != null) {
			
			if(elementoRemovido.proximo== null) {
				Elemento elementoAnterior = elementoRemovido.anterior;
				elementoAnterior.proximo = null;
				ultimo = elementoAnterior;

			}
			else {
				Elemento elementoAnterior = elementoRemovido.anterior;
				Elemento proximoElemento = elementoRemovido.proximo;
				elementoAnterior.proximo = proximoElemento;
				proximoElemento.anterior  = elementoAnterior;
			}
			JogoDigital jogoRemovido = elementoRemovido.jogo;
			elementoRemovido.anterior = null;
			elementoRemovido.proximo = null;
			quantJogos--;
			return jogoRemovido; 
		}
		else {
			return null;
		}
	
	}
	public JogoDigital removerFinal() {
		
		Elemento elementoRemovido = ultimo;
		Elemento elementoAnterior = ultimo.anterior;
		JogoDigital jogoRemovido = elementoRemovido.jogo;
		elementoAnterior.proximo = null;
		ultimo = elementoAnterior;
		elementoRemovido.anterior= null;
		elementoRemovido.proximo = null;
		quantJogos--;
		return jogoRemovido;
	}
	private Elemento buscarElemento(String nome) {
		String nomeComparacao;
		Elemento elementoBuscado  = primeiro.proximo;
		nomeComparacao = elementoBuscado.jogo.getNomeJogo();
		boolean condition = false;
		
		while(elementoBuscado != null) {
			
			if(!nomeComparacao.equals(nome)) {
				elementoBuscado = elementoBuscado.proximo;
				if(elementoBuscado != null) {
					nomeComparacao = elementoBuscado.jogo.getNomeJogo();
				}
				else {
					break;
				}
				
			}
		else if(nomeComparacao.equals(nome)) {
				return elementoBuscado;
			}
		
		}
	return null;
	}
	public JogoDigital mostrarJogo(int id) {
		Elemento elementoBuscado = buscarElemento(id);
		if(elementoBuscado != null) {
			JogoDigital jogoBuscado = elementoBuscado.jogo;
			return jogoBuscado;
		}
		else {
			return null;
		}
	}
	
	private Elemento buscarElemento(int id) {
		int idComparacao;
		Elemento elementoBuscado  = primeiro.proximo;
		idComparacao = elementoBuscado.jogo.getIdJogo();
		boolean condition = false;
		
		while(elementoBuscado != null) {
			
			if(idComparacao != id) {
				elementoBuscado = elementoBuscado.proximo;
				if(elementoBuscado != null) {
					idComparacao = elementoBuscado.jogo.getIdJogo();
				}
				else {
					break;
				}
				
			}
		else if(idComparacao == id) {
				return elementoBuscado;
			}
		
		}
	return null;
	}
	public JogoDigital mostrarJogo(String valor) {
		Elemento elementoBuscado = buscarElemento(valor);
		if(elementoBuscado != null) {
			JogoDigital jogoBuscado = elementoBuscado.jogo;
			return jogoBuscado;
		}
		else {
			return null;
		}
	}
	public String mostrarLista() {
		StringBuilder txt = new StringBuilder();
		Elemento aux = primeiro.proximo;
		while(aux!= null) {
			txt.append(aux.jogo.toString() + "\n");
			aux = aux.proximo;
		}
		return txt.toString();
	}
	public String mostrarListaOrdenada() {
		StringBuilder txt = new StringBuilder();
		JogoDigital jogos[] = new JogoDigital[quantJogos];
		Elemento aux = primeiro.proximo;
		int i=0;
		while(aux!= null) {
			jogos[i] = aux.jogo;
			aux = aux.proximo;
			++i;
		}
		Ordenacao ordenar = new Ordenacao();
		 ordenar.quicksort(jogos, 0, jogos.length-1);
		for(int x =0; x < jogos.length; ++x) {
			txt.append(jogos[x].toString() + "\n");
		}
		return txt.toString();
		
	

}
}