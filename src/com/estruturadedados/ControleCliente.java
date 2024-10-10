package com.estruturadedados;
import com.classes.*;
public class ControleCliente {
	private int posicao;
	private int quantClientes;
	private Cliente clientes[];
	
	public ControleCliente() {
		
	}
	public ControleCliente(int quantClientes) {
		this.quantClientes = quantClientes;
		clientes = new Cliente[quantClientes];
		this.posicao=-1;
	}
	public void adicionarCliente(String nomeCliente , String nickname) {
		if(posicao < quantClientes) {
			++posicao;
			clientes [posicao] = new Cliente(nomeCliente , nickname);
		}
	}
	public void adicionarCliente(Cliente cliente) {
		if(posicao < quantClientes) {
			++posicao;
			clientes [posicao] = cliente;
		}
	}
	public Cliente retornarCliente(String nickName) {
		Cliente auxCliente;
		for(int i =0; i <= posicao; ++i) {
			if(clientes[i].getnickCliente().equals(nickName)){
				auxCliente = clientes[i];
				
				return auxCliente;
			}
		}
		return null;
	}
	public Cliente excluirCliente(String nomeCliente) {
		Cliente auxCliente;
		for(int i =0; i <= posicao; ++i) {
			if(clientes[i].getnomeCliente().equals(nomeCliente)){
				auxCliente = clientes[i];
				clientes[i] = null;
				realocarVetor(i);
				posicao--;
				return auxCliente;
			}
		}
		return null;
	}
	public int getTamanhoClientes() {
		return this.posicao;
	}
	public String mostrarClientes() {
		StringBuilder txt = new StringBuilder();
		for(int i =0; i <= posicao; ++i){
			txt.append(clientes[i].toString() + "\n");
		}
		return txt.toString();
	}
	private void realocarVetor(int indice) {
		for(int i = indice ; i < posicao; ++i){
			clientes[i] = clientes[i+1];
		}
	}
	public String mostrarFilaDeCompras() {
		StringBuilder filaDeCompras = new StringBuilder();
		for(int i =0; i<= posicao; ++i) {
			filaDeCompras.append("Fila de Compras de : " + clientes[i].getnomeCliente() + "\n" + clientes[i].mostrarFilaDeCompras() + "\n");
			
		}
		return filaDeCompras.toString();
	}
}
