import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Principal {
    static boolean HayError=false;
    public static void main(String[] args)throws IOException{
        if(args.length>1){
            System.out.println("Uso correcto: interprete [archivo.txt]");
            System.exit(64);
        }else if(args.length==1){
            leerArchivo(args[0]);
        }else{
            leerString(); 
        }
          
    }
    private static void leerArchivo(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        ejecutar(new String(bytes, Charset.defaultCharset()));
        if(HayError) System.exit(65);
    }
    public static void leerString()throws IOException{
        InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader reader= new BufferedReader(input);

        do{
            System.out.print(">>>");
            String linea=reader.readLine();
            if(linea==null) break;
            ejecutar(linea);
            HayError=false;
        }while(true);
    }
    static void error(int linea, String mensaje){
        reportar(linea, "", mensaje);
    }
    private static void reportar(int nlinea, String lugar, String mensaje){
        System.err.println(
                "linea: " + nlinea + ", Error " + lugar + ": " + mensaje
        );
        /*Seteamos error en verdadero*/
        HayError = true;
    }


    public static void ejecutar(String source){

       Scanner scanner= new Scanner(source);
       
       List<Token> tokens= scanner.scanTokens();
           
        Parser parser = new AST(tokens);
        List <Statement> arbol=parser.parse();
        if(arbol!=null){
            System.out.println("No hay errores de analisis");
        }else{
            System.out.println("Existen errores");
        }
         
    }
}