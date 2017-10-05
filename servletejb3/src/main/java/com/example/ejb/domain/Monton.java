package com.example.ejb.domain;

import java.util.ArrayList;

public class Monton {

	private ArrayList<Cartas> monton;
	private ArrayList<Cartas> monton1;
	private ArrayList<Cartas> monton2;
	private ArrayList<Cartas> monton3;

    public Monton(){    	
    //	monton = new ArrayList<Cartas>();
    }
	
    public void inicioMonton(){
    	monton = new ArrayList<Cartas>();
    	
    	monton.add(new Cartas("C1", "asbastos.jpg"));
    	monton.add(new Cartas("C2", "ascopas.jpg"));
    	monton.add(new Cartas("C3", "asespadas.jpg"));
    	monton.add(new Cartas("C4", "tresbastos.jpg"));
    	monton.add(new Cartas("C5", "trescopas.jpg"));
    	monton.add(new Cartas("C6", "tresespada.jpg"));
    	monton.add(new Cartas("C7", "doscopas.jpg"));   	
    	monton.add(new Cartas("C8", "dosbastos.jpg"));
    	monton.add(new Cartas("C9", "dosespadas.jpg"));
    	monton.add(new Cartas("C10", "cincobastos.jpg"));
    	monton.add(new Cartas("C11", "cincocopas.jpg"));
    	monton.add(new Cartas("C12", "cincoespadas.jpg"));
    	monton.add(new Cartas("C13", "cuatrobastos.jpg"));
    	monton.add(new Cartas("C14", "cuatroespadas.jpg"));    	
    	monton.add(new Cartas("C15", "cuatrocopas.jpg"));
    	monton.add(new Cartas("C16", "sietecopas.jpg"));
    	monton.add(new Cartas("C17", "sietebastos.jpg"));
    	monton.add(new Cartas("C18", "sieteespadas.jpg"));
    	monton.add(new Cartas("C19", "seiescopas.jpg"));
    	monton.add(new Cartas("C20", "seisbastos.jpg"));
    	monton.add(new Cartas("C21", "seisespadas.jpg"));    	
    	monton.add(new Cartas("C22", "sotaespadas.jpg"));
    	monton.add(new Cartas("C23", "caballoespadas.jpg"));
    	monton.add(new Cartas("C24", "reyespadas.jpg"));
    	monton.add(new Cartas("C25", "sotacopas.jpg"));
    	monton.add(new Cartas("C26", "caballocopas.jpg"));
    	monton.add(new Cartas("C27", "reycopas.jpg"));
    	monton.add(new Cartas("C28", "sotabastos.jpg"));
    	monton.add(new Cartas("C29", "caballobastos.jpg"));
    	monton.add(new Cartas("C30", "reybastos.jpg"));    	
    	monton.add(new Cartas("C11", "asoros.jpg"));
    	monton.add(new Cartas("C32", "dosoros.jpg"));
    	monton.add(new Cartas("C33", "tresoros.jpg"));
    	monton.add(new Cartas("C34", "cuatrooros.jpg"));
    	monton.add(new Cartas("C35", "cincooros.jpg"));
    	monton.add(new Cartas("C36", "seisoros.jpg"));
    	monton.add(new Cartas("C37", "sieteoros.jpg"));
    	monton.add(new Cartas("C38", "sotaoros.jpg"));
    	monton.add(new Cartas("C39", "caballooros.jpg"));
    	monton.add(new Cartas("C40", "reyoros.jpg"));  
    }
    
    public String getMonton1(int indice){
    	return monton1.get(indice).getC();
    }
    
    public String getMonton2(int indice){
    	return monton2.get(indice).getC();
    }
    
    public String getMonton3(int indice){
    	return monton3.get(indice).getC();
    }

    public String getImg1(int indice){
    	return monton1.get(indice).getImg();
    }
    
    public String getImg2(int indice){
    	return monton2.get(indice).getImg();
    }
    
    public String getImg3(int indice){
    	return monton3.get(indice).getImg();
    }
    
    public int sizeMonton(int monton){
    	int devolver = 0;
    	
    	switch (monton) {
		case 1:
			devolver = monton1.size();
			break;
		case 2:
			devolver = monton2.size();
			break;
		case 3:
			devolver = monton3.size();
			break;

		default:
			break;
		}
    	
    	return devolver;
    }
       
    public void startGame(){
    	inicioMonton();
    	monton1 = new ArrayList<Cartas>();
    	monton2 = new ArrayList<Cartas>();
    	monton3 = new ArrayList<Cartas>();
    	
    	int numero = 0;
    	for(int i=0; i<7 ; i++){
    		numero = (int) Math.floor(Math.random() * monton.size());
    		monton1.add(monton.get(numero));
    		monton.remove(numero);
    		numero = (int) Math.floor(Math.random() * monton.size());
    		monton2.add(monton.get(numero));
    		monton.remove(numero);
    		numero = (int) Math.floor(Math.random() * monton.size());
    		monton3.add(monton.get(numero));
    		monton.remove(numero);
    	}
    }
    
    public void ponerMedio(int numeroMonton){   	
    	ArrayList<Cartas> listIntermedio = new ArrayList<>();
    	// Solo re-ordeno montones si el montón elegido es diferente al del medio (el 2) 
    	if(numeroMonton == 1){
    		listIntermedio.addAll(monton1);
    		monton1 = new ArrayList<Cartas>();
    		monton1.addAll(monton2);
    		monton2 = new ArrayList<Cartas>();
    		monton2.addAll(listIntermedio);
    	}
    	if(numeroMonton == 3){
    		listIntermedio.addAll(monton3);
    		monton3 = new ArrayList<Cartas>();
    		monton3.addAll(monton2);
    		monton2 = new ArrayList<Cartas>();
    		monton2.addAll(listIntermedio);
    	}
    	
    	//Introduzco en un solo Montón y lo voy repartiendo por montones
    	ArrayList<Cartas> montonGrande = new ArrayList<>();
    	montonGrande.addAll(monton1);
    	montonGrande.addAll(monton2);
    	montonGrande.addAll(monton3);
    	    	
    	int indice = 0;
 
    	for(int i=0; i<21; i+=3){
    		monton1.set(indice, montonGrande.get(i));
    		monton2.set(indice, montonGrande.get(i+1));
    		monton3.set(indice, montonGrande.get(i+2));
    		
    		indice += 1;
    	}
    	 
    }
   
    /*
     * Para poder hacer la prueba en test tengo que partir de una situación inicial
     */
	public void inicioTest(){;
		monton1 = new ArrayList<Cartas>();
		monton2 = new ArrayList<Cartas>();
		monton3 = new ArrayList<Cartas>();
		
    	monton1.add(new Cartas("C1", "asbastos.jpg"));
    	monton1.add(new Cartas("C2", "ascopas.jpg"));
    	monton1.add(new Cartas("C3", "asespadas.jpg"));
    	monton1.add(new Cartas("C4", "tresbastos.jpg"));
    	monton1.add(new Cartas("C5", "trescopas.jpg"));
    	monton1.add(new Cartas("C6", "tresespada.jpg"));
    	monton1.add(new Cartas("C7", "doscopas.jpg"));   	
    	monton2.add(new Cartas("C8", "dosbastos.jpg"));
    	monton2.add(new Cartas("C9", "dosespadas.jpg"));
    	monton2.add(new Cartas("C10", "cincobastos.jpg"));
    	monton2.add(new Cartas("C11", "cincocopas.jpg"));
    	monton2.add(new Cartas("C12", "cincoespadas.jpg"));
    	monton2.add(new Cartas("C13", "cuatrobastos.jpg"));
    	monton2.add(new Cartas("C14", "cuatroespadas.jpg"));    	
    	monton3.add(new Cartas("C15", "cuatrocopas.jpg"));
    	monton3.add(new Cartas("C16", "sietecopas.jpg"));
    	monton3.add(new Cartas("C17", "sietebastos.jpg"));
    	monton3.add(new Cartas("C18", "sieteespadas.jpg"));
    	monton3.add(new Cartas("C19", "seiescopas.jpg"));
    	monton3.add(new Cartas("C20", "seisbastos.jpg"));
    	monton3.add(new Cartas("C21", "seisespadas.jpg"));		
	}    
    
}
