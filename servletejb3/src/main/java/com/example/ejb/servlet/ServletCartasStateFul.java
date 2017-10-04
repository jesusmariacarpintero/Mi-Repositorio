package com.example.ejb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.ejb.bussines.OrdenarCartas;
import com.example.ejb.domain.ParceToInteger;

/**
 * Servlet implementation class ServletCartasStateFul
 */
@WebServlet("/ServletCartasStateFul")
public class ServletCartasStateFul extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STATEFUL_CLICK_BEAN_KEY = "click_bean";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Integer monton = null;
		 
		 monton = ParceToInteger.parceToFloat(request.getParameter("monton"));		
		 OrdenarCartas cartas = getStatefulOrdenarCartas(request); 
         		 		
		 cartas.doPaso();
		 /*
		  * La variable counter me servirá para saber en que paso estoy
		  * counter =   1 	Estoy en inicio del juego el usuario no ha cliqueado todavía me tiene que decir el montón de la
		  * 				carta elegida
		  * 			2 	El usuario a cliqueado una vez (counter -1) y me tiene que dar el dato del nuevo montón de la 
		  * 				carta elejida. Le muestros los montones nuevos.
		  * 			3 	El usuario a cliqueado dos veces (counter -1) y me tiene que dar el último nuevo montón de la 
		  * 				carta elejida. Le muestros los montones nuevos.
		  * 			4 	El usuario a cliqueado tres veces (counter -1) y le digo que carta ha elegido
		  * 				Se muestra el botón Repetir. Le muestros los montones nuevos.
		  */	
		 int paso = cartas.getPaso();
		 String monton1 = null;
		 String monton2 = null;
		 String monton3 = null;
		 String datos = null;
		 String addResult = null;
		 
		 if(paso==1){
			 cartas.startGame();
		 }
		 
		 // Si no estamos en el paso 1 y el usuario no ha informado del montón
		 // O el montón es un número mayor que 3	 
		 if((monton==null && paso!= 1) || (monton !=null && (monton <= 0 || monton > 3))){
			if(monton==null){
				datos = "<h1>No ha introducido el número del Montón</h1>"; 
			}else{
				datos = "<h1>El número informado por usted del Montón no existe</h1>";			
			}
			cartas.subPaso();
			paso = cartas.getPaso();
		 }	
		 
		 if (paso==1){
			 addResult = "<h3>Elija una carta y dígame el número del Montón en que está:</h3>" +
		                 "<input type='number' step='any' name='monton' value=''>" +
		          		 "<input type='submit' value='Click'>";
		
		 }else{
			 addResult = "<h3>Ahora la carta en que número del Montón está:</h3>" +
		                 "<input type='number' step='any' name='monton' value=''>" +
	          			 "<input type='submit' value='Click'>";			 
		 }		 
		 
		 if(datos==null){
			 datos = addResult;			 
		 }else{
			 datos = datos + addResult;
		 }

		 /*
		  * La variable counter me servirá para saber en que paso estoy
		  * counter =   1 	Estoy en inicio del juego el usuario no ha cliqueado todavía me tiene que decir el montón de la
		  * 				carta elegida
		  * 			2 	El usuario a cliqueado una vez (counter -1) y me tiene que dar el dato del nuevo montón de la 
		  * 				carta elejida. Le muestros los montones nuevos.
		  * 			3 	El usuario a cliqueado dos veces (counter -1) y me tiene que dar el último nuevo montón de la 
		  * 				carta elejida. Le muestros los montones nuevos.
		  * 			4 	El usuario a cliqueado tres veces (counter -1) y le digo que carta ha elegido
		  * 				Se muestra el botón Repetir. Le muestros los montones nuevos.
		  */
		 switch (paso) {
			case 1:
				// Se muestra el form al usuario			
				break;
			case 2:
				 if(monton!=null && (monton > 0 && monton < 4)){
					 cartas.ponerMedio(monton);
				 }
				break;
			case 3:
				 if(monton!=null && (monton > 0 && monton < 4)){
					 cartas.ponerMedio(monton);
				 }				
				break;
			case 4:
				if(monton!=null && (monton > 0 && monton < 4)){
					cartas.ponerMedio(monton);
				}
				datos = "<h1>La Carta elegida es: </h1>" +
						"<img src='../img/" + cartas.getImg2(3) + "' alt='c8' height='100' width='100'>" +
					 	"<br></br>" +
				        "<input type='submit' value='Repetir'>";
				cartas.inicioPaso();
				cartas.subPaso();
				break;
	
			default:
				cartas.ponerMedio(1);
				cartas.inicioPaso();
				paso = cartas.getPaso();
				break;
		}
		 
		 /*  
		  * Muestro los datos de los montones.
		  * Bien mostrará lo que salga de cartas.inicioMontones() o de cartas.ponerMedio(monton).
		  * Se podría hacer con un 'for' pero queda más claro así   
		  */
		 monton1 = "<img src='../img/" + cartas.getImg1(0) + "' alt='c1' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg1(1) + "' alt='c2' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg1(2) + "' alt='c3' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg1(3) + "' alt='c4' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg1(4) + "' alt='c5' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg1(5) + "' alt='c6' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg1(6) + "' alt='c7' height='100' width='100'>";

		 monton2 = "<img src='../img/" + cartas.getImg2(0) + "' alt='c8' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg2(1) + "' alt='c9' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg2(2) + "' alt='c10' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg2(3) + "' alt='c11' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg2(4) + "' alt='c12' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg2(5) + "' alt='c13' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg2(6) + "' alt='c14' height='100' width='100'>";

		 monton3 = "<img src='../img/" + cartas.getImg3(0) + "' alt='c15' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg3(1) + "' alt='c16' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg3(2) + "' alt='c17' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg3(3) + "' alt='c18' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg3(4) + "' alt='c19' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg3(5) + "' alt='c20' height='100' width='100'>" +
				   "<img src='../img/" + cartas.getImg3(6) + "' alt='c21' height='100' width='100'>";		 
				 
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();  

		 out.println("<html>"); 
		 out.println("<head>");
		 out.println("<title>Adivino 1 Carta de 21</title>");
		 out.println("</head>");

		 out.println("<body>");
		 out.println("<h1>Adivino 1 Carta de 21 en 3 Cliks</h1>");
		 out.println("<form action='/servletejb3/servlet/cartasmagia' method='post'>");
		 out.println("<h3>Montón 1</h3>");
		 out.println(monton1);
		 out.println("</br>");
		 out.println("<h3>Montón 2</h3>");
		 out.println(monton2);
		 out.println("</br>");
		 out.println("<h3>Montón 3</h3>");
		 out.println(monton3);
		 out.println("</br>");
		 // Muestra la petición de datos según se necesite
		 out.println(datos);
		 // Resto uno a counter para que el usario sepa cuantas veces ha cliqueado
		 out.println("<h3> Ha realizado " + (paso - 1) +" clicks correctos</h3>");
		 out.println("</form>");
		 	
		 out.println("</body>");

		 out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	     
		doGet(request, response);
	}	
	
	private  OrdenarCartas getStatefulOrdenarCartas(HttpServletRequest request)
	         throws ServletException {
		
	    // Guardamos la sesión 
		HttpSession httpSession = request.getSession(true);
	     OrdenarCartas statefulTestBean = 
	             (OrdenarCartas) httpSession.getAttribute(STATEFUL_CLICK_BEAN_KEY);
	     
	     // Veo si tengo referencia a mi Bean
	     // Si está guardado no retorna null
	     if (statefulTestBean == null) {
	         try {
	        	 
	             InitialContext ic = new InitialContext();
	             // tecnología que utilizamos JNDI
	             statefulTestBean =   (OrdenarCartas) ic.lookup("java:module/OrdenarCartas");
	             // Tengo que declarar la constante STATEFUL_CLICK_BEAN_KEY ver arriba
	             httpSession.setAttribute(STATEFUL_CLICK_BEAN_KEY, statefulTestBean);	          	       
	         } catch (NamingException e) {
	             throw new ServletException(e);
	         }
	     }
	     return statefulTestBean;
	 }
	
}
