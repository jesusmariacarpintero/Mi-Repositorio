package com.example.ejb.domain;

public class Cartas {
	private String valor;
	private String img;
	
	public Cartas(String valor, String img){
		this.valor = valor;
		this.img = img;
	}
	
	public String getC(){
		return valor;
	}
	
	public String getImg(){
		return img;
	}
}
