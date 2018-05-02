
import java.util.Scanner;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

  //Declaracion de variables
    
    String NumeroAIngresar;
    int espacioDigito;
    String opcion;
    String OpcionSi = "s";
    String OpcionNo = "n";
    String NumeroADibujar;
      
      try {

          try (Scanner lectura= new Scanner(System.in)) {
            while(true){
            	
                System.out.println("Espacio entre Digitos (0 a 5): ");
                NumeroAIngresar = lectura.next();

                // validacion para ver si el usuario ingreso un numero
                if (ImpresorLCD.isNumeric(NumeroAIngresar))  {
	                    espacioDigito = Integer.parseInt(NumeroAIngresar);
	                    
	                    // se valida que el espaciado este entre 0 y 5
	                    if(espacioDigito <0 || espacioDigito >5) {
		                       System.out.println("Error : Solo se puede ingresar valores entre 0 y 5. Intente de nuevo");
		                   continue;
	                    }
                    
                    
                } 
                else 
                {
	                	System.out.println("Error: Cadena " + NumeroAIngresar + " no es un entero");
	                    continue;
                }
                
                do
                {
	                    System.out.print("Entrada: ");
	                    Scanner entradaNumero = new Scanner(System.in);
	                    NumeroADibujar = entradaNumero.next();
	                    
	                    // se valida que la cadena ingresada no sea igual a 0,0
	                    //En caso de ingresar un caracter diferente a la coma como un ., ^, ~, etc habrÃ¡ una excepciÃ³n y terminarÃ¡ el programa
	                    if(!NumeroADibujar.equalsIgnoreCase(CADENA_FINAL))
	                    {
	                    	String[] parametros;
                    		parametros = NumeroADibujar.split(",");                    	
                    		int ParteEntera=Integer.parseInt(parametros[0]);
                    		
                    		// se valida que el caracter ingresado contenga la , y que sea un nÃºmero
	                    	if (NumeroADibujar.contains(",") && !ImpresorLCD.isNumeric(NumeroADibujar)) {
	                    		
		                    		
	                    		
		                    		System.out.println(parametros[0] + " " + parametros[1]);
		                    		
		                    		//Valida la cantidad de parametros
	                    		    if(parametros.length>2)
		                    		      {
	                    		    			System.out.println("Cadena " + NumeroAIngresar + " Se contiene mas parametros de los deseados, por favor intente de nuevo");
	                    		    			continue;
		                    		      }
	                    		        
	                    		    //Valida la cantidad de parametros
   	                    		    if(parametros.length<2)
		                    		       {
   	                    		    			System.out.println("Cadena " + NumeroAIngresar + " no contiene el size y el numero a ingresar");
   	                    		    			continue;
		                    		       }
   	                    		    //Valida que la parte entera esta entre 1 y 10 
	                    		    if(ParteEntera<1 || ParteEntera>10)
		                    		       {
	                    		    			System.out.println("El parametro size ["+ ParteEntera + "] debe estar entre 1 y 10");
	                    		    			continue;
		                    			   }
	                    			
	                    	ImpresorLCD impresorLCD = new ImpresorLCD(); 
	                    		  
	                    	//Llamado a la funcion imprimirNumero que dibujara¡ la parte decimal con su tamaño (parte entera) en la consola
	                    	impresorLCD.imprimirNumero(ParteEntera, parametros[1], espacioDigito); 
	                    	}
	                    	else{
                    		
		                    		System.out.println("Cadena " + NumeroAIngresar + " no es un numero que contiene el caracter y no se puede dibujar ");
		                    		continue;
	                    	}
	                    }
	                    else{
	                    	System.out.println("El programa ha finalizado, ¿deseas continuar la ejecucion?, presiona s si quieres continuar y n si no deseas continuar");
	                    	
	                    	do{
	                    			
									
									Scanner eleccion = new Scanner(System.in);
	                    			opcion = eleccion.next();
	                    			
	                    			//Valida que no desea continuar el programa
			                    	if(opcion.equals(OpcionNo)){
			                    		System.out.println("Gracias por utilizar el programa, hasta otra ocasion ");
			                    		System.exit(0);
			                    	}
			                    	//Validacion para el usuario para que continue el programa
			                    	else if(opcion.equals(OpcionSi)){
			                    		System.out.println("Has decidido continuar con el programa,ingresa el size y el numero a imprimir separado por una coma(solo numeros de 1 a 10");
			                    		break;
			                    	}
			                    	//En caso de ingresar mal la opcion, se reportar el mensaje de una mala opcion y volverlo a inventar
			                    	else{
			                    		System.out.println("Has ingresado mal la opcion, por favor vuelve a intentar, presiona s si quieres continuar y n si no deseas continuar ");
			                    	}
	                    	}while(!opcion.equals(OpcionNo) || !opcion.equals(OpcionSi));
	                    	
	                    }
                }while (!NumeroAIngresar.equalsIgnoreCase(CADENA_FINAL)); 
           }
        }
      } 
      //Excepcion que captura cuando se ingresa por pantalla un simbolo 
      catch (Exception ex) 
      {
            System.out.println("Error: "+ex.getMessage() + " ingresado por el usuario esta mal ingresado y ha causado conflictos en el programa, se cerrara el programa");
            System.exit(0); 
            
      }
   }
    
}
