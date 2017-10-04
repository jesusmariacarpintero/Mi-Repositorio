package com.example.ejb.bussines;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import com.example.ejb.domain.Monton;

/**
 * Session Bean implementation class OrdenarCartas
 */
@Stateful
@LocalBean
public class OrdenarCartas {

	private int paso;
	private Monton monton = new Monton();
	
    /**
     * Default constructor. 
     */
    public OrdenarCartas() {
        // TODO Auto-generated constructor stub
        System.out.println("Constructor OrdenarCartas");
    }
    
    public void inicioPaso(){
    	paso = 1;
    }
    
    public void doPaso(){
    	paso++;
    }
    
    public void subPaso(){
    	paso--;
    }
    
    public int getPaso(){
    	return paso;
    }
 
    public void startGame(){
    	monton.startGame();
    }    
    
    public String getMonton1(int indice){
    	return monton.getMonton1(indice);
    }
    
    public String getMonton2(int indice){
    	return monton.getMonton2(indice);
    }
    
    public String getMonton3(int indice){
    	return monton.getMonton3(indice);
    }
    
    public String getImg1(int indice){
    	return monton.getImg1(indice);
    }
    
    public String getImg2(int indice){
    	return monton.getImg2(indice);
    }
    
    public String getImg3(int indice){
    	return monton.getImg3(indice);
    }
    
    public void ponerMedio(int numeroMonton){
        // Pasarlo a la clase Monton
    	monton.ponerMedio(numeroMonton);
    } 

}
