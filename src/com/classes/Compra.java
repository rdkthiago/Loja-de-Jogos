package com.classes;

public class Compra {
	private String nickname;
	private int idJogo;
	private String data;
	private double avaliacaoDoJogo;

	    public Compra(String Nickname,int IdJogo, String Data, double AvaliacaoDoJogo){
	        this.nickname = Nickname;
	        this.idJogo = IdJogo;
	        this.data = Data;
	        this.avaliacaoDoJogo = AvaliacaoDoJogo;
	    }

	    public String getNickname(){
	        return this.nickname;
	    }

	    public void setNickname(String Nickname){
	        this.nickname = Nickname;
	    }

	    public String getData(){
	        return this.data;
	    }

	    public void setData(String Data){
	        this.data = Data;
	    }

	   
	    public int getIdJogo() {
			return this.idJogo;
		}

		public void setIdJogo(int idJogo) {
			this.idJogo = idJogo;
		}
	     
	    public double getAvaliacaoDoJogo(){
	        return avaliacaoDoJogo;
	    }
	    public String toString() {
	    	String txt = "Nickname do Comprador : " +this.nickname + " - " + "Id do Jogo : " + this.idJogo + " - " + "Data de Compra : " + this.data + " - " + "Avaliação Dada : "+  this.avaliacaoDoJogo;
	    	return txt;
	    }
}
