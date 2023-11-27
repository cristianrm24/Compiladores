
package ascendente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class main {
    static boolean err=false;
    public static void main(String[] args)throws IOException{
         ejecutarPrompt();   
    }
    public static void ejecutarPrompt()throws IOException{
        InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader reader= new BufferedReader(input);

        while(true){
            System.out.print("cadena: ");
            String cadena=reader.readLine();
            if(cadena==null) break;
            ejecutar(cadena);
            err=false;
        }
    }
    public static void ejecutar(String input){

       Scanner scanner= new Scanner(input);
        List<Token> tokens= scanner.scanTokens();
        
        ascendente parser = new ascendente(tokens);
        boolean exito = parser.parse(); 
     
        if(exito){
            System.out.println("Cadena valida");
        }
        
    }
}