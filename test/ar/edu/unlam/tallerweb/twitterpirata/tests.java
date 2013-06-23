package ar.edu.unlam.tallerweb.twitterpirata;

import java.awt.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ago
 * 
 */

public class tests {

/*
	1. Como usuario 
	quiero ingresar al sistema 
	para acceder al servicio */
	@Test
	public void queUsuarioPuedaIngresarAlServicio() {
		Sesion pepe = new Sesion("pass");
		boolean online = pepe.entrar();
		
		Assert.assertEquals(
				"Al crear una nueva sesion y entrar el usuario debe estar ingresado en el servicio",
				true, online);
		
	}
	
	/*2. Como usuario 
	quiero salir del sistema 
	para poder hacer otras cosas */
	@Test
	public void queUsuarioPuedaSalirDelServicioYHacerOtrasCosas() {
		Sesion pepe = new Sesion("pass");
		pepe.entrar();		
		boolean online = pepe.salir();
		
		Assert.assertEquals(
				"Al crear una nueva sesion y entrar el usuario debe estar poder abandonar el servicio",
				false, online);
		
	}
	/*3. Como usuario 
	quiero escribir mensajes de hasta 140 caracteres 
	para comunicarme con mis seguidores y el mundo */
	@Test
	public void queUsuarioPuedaEscribirMensajes() {
		
		Sesion pepe = new Sesion("pass");
		pepe.entrar();
		pepe.escribirMensaje("Roberto dejame en paz. Arrrgh!");
		
		List mensajes = (List) pepe.misImproperios();
		
		Assert.assertEquals(
				"Al escribir un mensaje, debe guardarse mi mensaje que dice Roberto dejame en paz.",
				"Roberto dejame en paz. Arrrgh!", mensajes);
		
	}
	/*4. Como usuario 
	quiero ver los tweets de quienes sigo 
	para enterarme de lo que hablan 
	6. Como usuario 
	quiero seguir a otros usuarios 
	para leer sus tweets en mi pantalla principal*/
	@Test
	public void queUsuarioPuedaSeguirAGenteYVerlosEnSuFeed() {
		
		Sesion pepe = new Sesion("pass");
		Sesion roberto = new Sesion("pass");
		pepe.entrar();
		roberto.entrar();
		
		pepe.escribirMensaje("Roberto dejame en paz. Arrrgh!");
		
		roberto.seguir(pepe);
		
		List mensajes = (List) roberto.improperios();
		
		Assert.assertEquals(
				"Al suscribirme al feed de roberto tengo que poder ver sus mensajes.",
				"Roberto dejame en paz. Arrrgh!", mensajes);
		
	}
	
	/*5. Como usuario 
	quiero poder visualizar el perfil de otros
	para observar detalles de otros usuarios*/
		
	/*7. Como usuario 
	quiero poder dejar de seguir a otros 
	para dejar de leer las cosas que dicen*/
	
	
}
