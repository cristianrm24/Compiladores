/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AFD {
    private static Map<String, Map<String, String>> transiciones;

    static {
        transiciones = new HashMap<>();

         // Estado q0
        Map<String, String> q0Transiciones = new HashMap<>();
        q0Transiciones.put("0", "q4");
        q0Transiciones.put("1-9", "C0");
        q0Transiciones.put("(+,-)", "q1");
        q0Transiciones.put("a-z", "C8");
        q0Transiciones.put("A-Z", "C8");
        q0Transiciones.put("/", "q2");
        q0Transiciones.put("comp", "C5");
        q0Transiciones.put("Arit", "C6");
        q0Transiciones.put("\"","C8");
        q0Transiciones.put(",","C8");
  
        transiciones.put("q0", q0Transiciones);

        // Estado q1
        Map<String, String> q1Transiciones = new HashMap<>();
        q1Transiciones.put("1-9", "C0");
        q1Transiciones.put("0", "q4");
        transiciones.put("q1", q1Transiciones);

        // Estado q2
        Map<String, String> q2Transiciones = new HashMap<>();
        q2Transiciones.put("/", "C9");
        q2Transiciones.put("*", "q10");
        transiciones.put("q2", q2Transiciones);

        // Estado q3
        Map<String, String> q3Transiciones = new HashMap<>();
        q3Transiciones.put("0-9", "C3");
        transiciones.put("q3", q3Transiciones);

        // Estado q4
        Map<String, String> q4Transiciones = new HashMap<>();
        q4Transiciones.put(".", "q3");
        q4Transiciones.put("0-7", "C2");
        q4Transiciones.put("x", "q5");
        transiciones.put("q4", q4Transiciones);

        // Estado q5
        Map<String, String> q5Transiciones = new HashMap<>();
        q5Transiciones.put("A-F", "C1");
        q5Transiciones.put("0-9", "C1");
        transiciones.put("q5", q5Transiciones);
        
           // Estado q6
        Map<String, String> q6Transiciones = new HashMap<>();
        q6Transiciones.put("/", "C9");
        transiciones.put("q6", q6Transiciones);

        // Estado q7
        Map<String, String> q7Transiciones = new HashMap<>();
        q7Transiciones.put("(+,-)", "q8");
        q7Transiciones.put("0-9", "q9");
        transiciones.put("q7", q7Transiciones);

        // Estado q8
        Map<String, String> q8Transiciones = new HashMap<>();
        q8Transiciones.put("0-9", "q9");
        transiciones.put("q8", q8Transiciones);

        // Estado q9
        Map<String, String> q9Transiciones = new HashMap<>();
        q9Transiciones.put("0-9", "C4");
        transiciones.put("q9", q9Transiciones);

        // Estado q10
        Map<String, String> q10Transiciones = new HashMap<>();
        q10Transiciones.put("*", "q6");
        q10Transiciones.put("A-Z", "q10");
        q10Transiciones.put("a-z", "q10");
        q10Transiciones.put("0-9", "q10");
        q10Transiciones.put("Arit", "q10");
        q10Transiciones.put("Beta", "q10");
         q10Transiciones.put("_", "q10");
        transiciones.put("q10", q10Transiciones);

        // Estado C0
        Map<String, String> c0Transiciones = new HashMap<>();
        c0Transiciones.put("0-9", "C0");
        c0Transiciones.put(".", "q3");
        transiciones.put("C0", c0Transiciones);

        // Estado C1
        Map<String, String> c1Transiciones = new HashMap<>();
        c1Transiciones.put("0-9", "C1");
        c1Transiciones.put("A-F", "C1");
        transiciones.put("C1", c1Transiciones);

        // Estado C2
        Map<String, String> c2Transiciones = new HashMap<>();
        c2Transiciones.put("0-7", "C2");
        transiciones.put("C2", c2Transiciones);

        // Estado C3
        Map<String, String> c3Transiciones = new HashMap<>();
        c3Transiciones.put("0-9", "C3");
        c3Transiciones.put("E", "q7");
        transiciones.put("C3", c3Transiciones);

       // Estado C4
        Map<String, String> c4Transiciones = new HashMap<>();
        transiciones.put("C4", c4Transiciones);

        // Estado C5
        Map<String, String> c5Transiciones = new HashMap<>();
        c5Transiciones.put("comp", "C5");
        transiciones.put("C5", c5Transiciones);

        // Estado C6
        Map<String, String> c6Transiciones = new HashMap<>();
        transiciones.put("C6", c6Transiciones);

        // Estado C7
        Map<String, String> c7Transiciones = new HashMap<>();
        transiciones.put("C7", c7Transiciones);

        // Estado C8
        Map<String, String> c8Transiciones = new HashMap<>();
        c8Transiciones.put("a-z", "C8");
        c8Transiciones.put("A-Z", "C8");
        c8Transiciones.put("0-9", "C8");
        c8Transiciones.put("_", "C8");
        c8Transiciones.put("\"", "C8");
        c8Transiciones.put(",","C8");
        transiciones.put("C8", c8Transiciones);

        // Estado C9
        Map<String, String> c9Transiciones = new HashMap<>();
        c9Transiciones.put("A-Z", "C9");
        c9Transiciones.put("a-z", "C9");
        c9Transiciones.put("0-9", "C9");
        c9Transiciones.put("Arit", "C9");
        c9Transiciones.put("Beta", "C9");
        c9Transiciones.put("_", "C9");
        transiciones.put("C9", c9Transiciones);
    }

  
    public static boolean validador(String cadena){
    
        String estadoActual = "q0";
        String token = null;
        

    for (char c : cadena.toCharArray()) {
    String categoria = obtenerCategoria(c,estadoActual, cadena);
    Map<String, String> transicionesEstadoActual = transiciones.get(estadoActual);
    

    if (transicionesEstadoActual != null && transicionesEstadoActual.containsKey(categoria)) {
        estadoActual = transicionesEstadoActual.get(categoria);
    } else {
        //System.out.println("Error: No hay una transición definida para la categoría " + categoria + " en el estado " + estadoActual);
        estadoActual = "q0";
        break;
    }
}
        if(esPalabraReservada(cadena)){
                estadoActual="C7";
            }
        if (    estadoActual.equals("C0") || estadoActual.equals("C1") || estadoActual.equals("C2") || estadoActual.equals("C3")
                || estadoActual.equals("C4") || estadoActual.equals("C5") || estadoActual.equals("C6")
                || estadoActual.equals("C7") || estadoActual.equals("C8") || estadoActual.equals("C9")) {
            if(esPalabraReservada(cadena)){
                estadoActual="C7";
            }
            if(estadoActual=="C0" | estadoActual=="C1" | estadoActual=="C2" | estadoActual=="C3" | estadoActual=="C4" ){
                token= "NUMBER";
            }else if(estadoActual=="C5" | estadoActual=="C6"){
                                            if("!".equals(cadena)){
                           token = "BANG";
                       } else if("!=".equals(cadena)){
                           token = "BANG_EQUAL";
                       } else if("=".equals(cadena)){
                           token = "EQUAL";
                       } else if("==".equals(cadena)){
                           token = "EQUAL_EQUAL";
                       } else if(">".equals(cadena)){
                           token = "GREATER";
                       }else
                     if(cadena.equals(">=")){
                         token="GREATER_EQUAL";
                         }else
                     if(cadena.equals("<")){
                         token="LESS";
                         }else
                     if(cadena.equals("<=")){
                         token="LESS_EQUAL";
                         }else 
                        if ("-".equals(cadena)) {
                            token = "MINUS";
                        } else if ("+".equals(cadena)) {
                            token = "PLUS";
                        } else if (";".equals(cadena)) {
                            token = "SEMICOLON";
                        } else if ("/".equals(cadena)) {
                            token = "SLASH";
                        } else if ("*".equals(cadena)) {
                            token = "STAR";
                        }         
                   
            }else if(estadoActual == "C7"){
                token = "PALABRA CLAVE";
                 if(cadena=="and"){
                    token="AND";
                    }else
                if(cadena=="else"){
                    token="ELSE";
                    }else
                if(cadena=="false"){
                    token="FALSE";
                    }else
                if(cadena=="fun"){
                    token="FUN";
                    }else
                if(cadena=="for"){
                    token="FOR";
                    }else
                if(cadena=="if"){
                    token="IF";
                    }else
                if(cadena=="null"){
                    token="NULL";
                    }else
                if(cadena=="or"){
                    token="OR";
                    }else
                if(cadena=="print"){
                    token="PRINT";
                    }else
                if(cadena=="return"){
                    token="RETURN";
                    }else
                if(cadena=="true"){
                    token="TRUE";
                    }else
                if(cadena=="var"){
                    token="VAR";
                    }else
                if(cadena=="while"){
                    token="WHILE";
                    }
            }else if(estadoActual == "C8"){
                if(cadena.contains("\"")){
                    token="STRING";
                }else{
                     token = "IDENTIFIER";
                }
                
if ("(".equals(cadena)) {
    token = "LEFT_PAREN";
} else if (")".equals(cadena)) {
    token = "RIGHT_PAREN";
} else if ("{".equals(cadena)) {
    token = "LEFT_BRACE";
} else if ("}".equals(cadena)) {
    token = "RIGHT_BRACE";
}else if (",".equals(cadena)) {
    token = "COMMA";
} else if (".".equals(cadena)) {
    token = "DOT";
}else if(";".equals(cadena)){
    token = "EOF";
}else if("\0".equals(cadena)){
    token = "EOF";
}   
            }else if(estadoActual == "C9"){
                 token = "COMMENT";
            }
            System.out.println("La cadena "+cadena+ " es aceptada con token "+token);
          return true;
        } else {
                System.out.println("La cadena "+cadena+" no es aceptada "+estadoActual);
           return false;
         
          
           
        }
    }

    private static String obtenerCategoria(char c, String estadoActual, String cadena) {
    if(estadoActual == "q0"){
          if (c >= '1' && c <= '9') {
            return "1-9";
        }else if(c=='0'){
             return "0";
        }else  if (esOperador(cadena)) {
            return "comp";
        } else if (c == '+' || c == '-') {
            return "(+,-)";
        } else if(c=='"'){
            return "\"";
        }else if(c=='(' | c==')'| c=='{'| c=='}'| c==')'| c=='.'| c==','| c=='/' |  c==';'){
         return ",";
     }
    }else if (estadoActual == "C8"){
     if(c=='"'){
         return "\"";
     }
       if(c=='(' | c==')'| c=='{'| c=='}'| c==')'| c=='.'| c==','| c=='/' |  c=='/'){
         return ",";
     }
     
    }else if(estadoActual == "q1"){
         if (c >= '1' && c <= '9') {
            return "1-9";
         } else if (c == '0') {
            return "0";
         }  
    } else if(estadoActual == "C0"){
        if (Character.isDigit(c)) {
            return "0-9";
        }
    }else if(estadoActual == "q4"){
        if ( c>= '0' && c <= '7') {
            return "0-7";
        }else if (c == 'x') {
            return "x";
        }else if (c == '.') {
            return ".";
        }
    }else if(estadoActual == "C2"){
        if ( c>= '0' && c <= '7') {
            return "0-7";
        }
    }else if(estadoActual == "C9"){
       if (Character.isDigit(c)) {
            return "0-9";
        }
    }else if(estadoActual == "q10"){
       if (Character.isDigit(c)) {
            return "0-9";
        }  else if (c == '*') {
            return "*";
        }
    } else if(estadoActual == "q3"){
     if (Character.isDigit(c)) {
            return "0-9";
        } 
    }else if(estadoActual == "C3"){
     if (Character.isDigit(c)) {
            return "0-9";
        } else if (c == 'E') {
            return "E";
        }
    } else if(estadoActual == "q8"){
     if (Character.isDigit(c)) {
            return "0-9";
        } 
    }else if(estadoActual == "q9"){
     if (Character.isDigit(c)) {
            return "0-9";
        } 
    }else if(estadoActual == "q5"){
     if (Character.isDigit(c)) {
            return "0-9";
        }else if (c >= 'A' && c <= 'F') {
            return "A-F";
        }  
    }else if(estadoActual == "C1"){
     if (Character.isDigit(c)) {
            return "0-9";
        }else if (c >= 'A' && c <= 'F') {
            return "A-F";
        } 
    }else if(estadoActual == "C5"){
     if (esOperador(cadena)) {
            return "comp";
        }
    }else if(estadoActual == "q7"){
     if (c == '+' || c == '-') {
            return "(+,-)";
        } else if (Character.isDigit(c)) {
            return "0-9";
        }
    } else if(estadoActual == "q2"){
    if (c == '/') {
            return "/";
        } else if (c == '*') {
            return "*";
        }
    } 
    
    
    
    
    
         if (c == '0') {
            return "0";
        } else if (c >= '1' && c <= '9') {
            return "1-9";
        } else if (Character.isDigit(c)) {
            return "0-9";
        }  else if(c >= '0' && c <= '7') {
            return "0-7";
        } else if (Character.isLowerCase(c) ) {
            return "a-z";
        } else if (Character.isUpperCase(c)) {
            return "A-Z";
        } else if (c == 'E') {
            return "E";
        } else if (isAritmetico(c)) {
            return "Arit";
        }  else if (c == '+' || c == '-') {
            return "(+,-)";
        } else if (c == '/') {
            return "/";
        } else if (c == '*') {
            return "*";
        }else if (c == '_') {
            return "_";
        } else if (c == '.') {
            return ".";
        } else if (c == 'x') {
            return "x";
        } else if (c >= 'A' && c <= 'F') {
            return "A-F";
        } else {
            return "Beta";
        }
        
       
        
    }
    
    

    private static boolean isAritmetico(char c) {
        return c == '+' || c == '-' || c == '*' || c == '%';
    }
    public static boolean esOperador(String cadena) {
    if (cadena.length() < 1 || cadena.length() > 2) {
        return false;
    }

    String[] operadores = {"<", ">", "=", ">=", "<=", "==", "!=","!"};

    for (String operador : operadores) {
        if (operador.equals(cadena)) {
            return true;
        }
    }

    return false;
}
private static boolean esPalabraReservada(String cadena) {
    String[] reservadas = {
        "and", "else", "false", "for","fun","if","null","or","print","return","true","var","while"
    };

    
    for (String reservada : reservadas) {
        if (reservada.equals(cadena)) {
            return true;
        }
    }

    return false;
}
}