package com.example.ejb.domain;

public class ParceToInteger {
	public static Integer parceToFloat(String strMonton){
		Integer monton = null; 
		
		try{
			monton = Integer.valueOf(strMonton);
		}catch(RuntimeException e){
			 e.printStackTrace(); 
		}
		return monton; 
	} 
}
