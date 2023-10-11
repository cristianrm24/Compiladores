    
package analizador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import analizador.AFD;

public class Analizador {

 public static void main(String[] args) {
     
 
     String  archivo; //"C:\\Users\\chequ\\OneDrive\\Documentos\\NetBeansProjects\\Analizador\\src\\analizador\\prueba.txt"

	 System.out.println("Introduce el path de tu documento");
	archivo=scan.nextLine();
   
     try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numeroLinea = 1;
            int errores=0;
            
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+"); 
                
             //  System.out.println("Linea " + numeroLinea + ":");
                boolean val = true;
                for (String palabra : palabras) {
              //      palabra = palabra.replaceAll("[\\{\\}\\[\\]\\;\\(\\)\\,]", ""); 
         
                    if (!palabra.isEmpty()) {
               //       System.out.println(palabra);
                        if(AFD.validador(palabra)==false){
                            val=false;
                        }
                    }
                }
                
            
                numeroLinea++;
            }
            if(errores==0){
               // System.out.println("El archivo no tiene errores");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
                  }
    
}
