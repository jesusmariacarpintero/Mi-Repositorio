package servletejb3;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.example.ejb.domain.Cartas;
import com.example.ejb.domain.Monton;


public class TestOrdenarCartas {

	@Test
	public void testOrdenarCartas(){
		ArrayList<Cartas> expected1 = new ArrayList<>();
		ArrayList<Cartas> expected2 = new ArrayList<>();
		ArrayList<Cartas> expected3 = new ArrayList<>();
		
		/*
		 *  Si partimos de que las cartas al inicio están
		 *  monton1 = C1 C2 C3 C4 C5 C6 C7 
		 *  monton2 = C8 C9 C10 C11 C12 C13 C14
		 *  monton3 = C15 C16 C17 C18 C19 C20 C21
		 *  y se escoje una carta del monton 1 los
		 *  montones tienen que quedar ordenados de la siguiente manera
		 *  Cambios
		 */
		expected1.add(new Cartas("C8", "dosbastos.jpg"));		
		expected1.add(new Cartas("C11", "cuatroespadas.jpg"));
		expected1.add(new Cartas("C14", "asespadas.jpg"));
		expected1.add(new Cartas("C3", "tresespada.jpg"));
		expected1.add(new Cartas("C6", "sietecopas.jpg"));
		expected1.add(new Cartas("C16", "seiescopas.jpg"));
		expected1.add(new Cartas("C19", "seiescopas.jpg"));
		
		expected2.add(new Cartas("C9", "dosespadas.jpg"));
		expected2.add(new Cartas("C12", "cincoespadas.jpg"));
		expected2.add(new Cartas("C1", "asbastos.jpg"));
		expected2.add(new Cartas("C4", "tresbastos.jpg"));
		expected2.add(new Cartas("C7", "doscopas.jpg"));
		expected2.add(new Cartas("C17", "sietebastos.jpg"));
		expected2.add(new Cartas("C20", "seisespadas.jpg"));
		
		expected3.add(new Cartas("C10", "cincobastos.jpg"));
		expected3.add(new Cartas("C13", "cuatrobastos.jpg"));
		expected3.add(new Cartas("C2", "ascopas.jpg"));
		expected3.add(new Cartas("C5", "trescopas.jpg"));
		expected3.add(new Cartas("C15", "cuatrocopas.jpg"));
		expected3.add(new Cartas("C18", "sieteespadas.jpg"));
		expected3.add(new Cartas("C21", "seisespadas.jpg"));
			
		Monton monton = new Monton();
		/*
		 *  Partimos de 
		 *  monton1 = C1 C2 C3 C4 C5 C6 C7 
		 *  monton2 = C8 C9 C10 C11 C12 C13 C14
		 *  monton3 = C15 C16 C17 C18 C19 C20 C21
		 */
		monton.inicioTest();
		// Se escoje una carta del monton 1
		monton.ponerMedio(1);
		
		/*
		 *  En el montón 1
		 */
		for(int i=0; i < monton.sizeMonton(1); i++){			
			Assert.assertEquals(expected1.get(i).getC(), monton.getMonton1(i));
		}

		
		/*
		 *  En el montón 2
		 */
		for(int i=0; i < monton.sizeMonton(2); i++){
			Assert.assertEquals(expected2.get(i).getC(), monton.getMonton2(i));
		}
		
		/*
		 *  En el montón 3
		 */
		for(int i=0; i < monton.sizeMonton(3); i++){
			Assert.assertEquals(expected3.get(i).getC(), monton.getMonton3(i));
		}
						
	}
	
}
