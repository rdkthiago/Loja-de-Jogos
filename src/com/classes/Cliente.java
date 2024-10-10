package com.classes;
import com.estruturadedados.*;
public class Cliente {
    private String nomeCliente;
    private String nickCliente;
    private FilaCompras filaDeCompras = new FilaCompras();
    
    public Cliente(String nome, String nickname){
        this.nomeCliente = nome;
        this.nickCliente = nickname;

    }

    public String getnomeCliente(){
        return this.nomeCliente;
    }

    public void setnomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    public String getnickCliente(){
        return this.nickCliente;
    }

    public void setnickCliente(String nickCliente){
        this.nickCliente = nickCliente;
    }

    public String toString() {
    	StringBuilder txt = new StringBuilder();
    	txt.append(this.nomeCliente + " - " + this.nickCliente);
    	return txt.toString();
    }
    public void registrarCompra(Compra compra) {
    	filaDeCompras.enfileirar(compra);
    }
    public String mostrarFilaDeCompras() {
    	StringBuilder compras = new StringBuilder();
    	compras.append(filaDeCompras.mostrarFilaDeCommpras());
    	return compras.toString();
    }

}
