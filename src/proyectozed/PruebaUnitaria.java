package proyectozed;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebaUnitaria {

	@Test
	public void VerificarRango0a5() {
		int numero =4;
		   if(numero <0 || numero >5)
           {
			   assertEquals(numero,false);
	}
	}
}
