package proyectozed;

import static org.junit.Assert.*;

import org.junit.Test;

public class Prueba {

	@Test
	//test para verificar si el numero ingresado esta fuera del rango de 0 a 5, si sale true entonces significa que esta fuera de esos rangos
	//sirve para la validacion espacio entre digitos
	public void AgregarDigito() {
		int espacioDigito = 6;
		assertTrue(espacioDigito <0 || espacioDigito >5);
	}
	
	//test pára verificar si lo que se ingreso fue un numero y no una letra o otra cosa
	public void verificarIngresadoANumerico(){
		char espacioDigito= 1234;
		assertTrue(Character.isDigit(espacioDigito));
	}
}