<<<<<<< HEAD
package com.mycompany.analsql;
import java.util.List;
import java.util.Stack;
public class ASLR {
    
    public boolean Error=false;
    
    public int i=0;//contador de nuestra cadena en SQL
    
    
    public void tabla(){
        Stack<String> pila = new Stack<>();//crea pila
        pila.push("EOF");
        pila.push("Q");//Inicializamos la pila con los valores $,Q
        
        String ap=pila.peek();//asignamos al apuntador al tope de la pila
        
        while(!"EOF".equals(ap)){//mientras la pila sea diferente del elemento vacio procedemos con la logica
            //para llenar el bucle hacemos uso de nuestra tabla previamente creada
            if(ap.equals("Q")){
                //intercambiamos por su equivalente
                pila.pop();
                pila.push("T");
                pila.push("FROM");
                pila.push("D");
                pila.push("SELECT");
                ap=pila.peek();
            }else if(ap.equals("D")){//A diferencia de la Q, esta consta de 3 casos posibles
                                     //por ende aplicamos 3 ifs.
                if(ap=="DISTINCT"){
                    pila.pop();
                    pila.push("P");
                    pila.push("DISTINCT");
                    ap=pila.peek();
               }
               else if(ap=="IDENTIFICADOR"||ap=="ASTERISCO"){
                    pila.pop();
                    pila.push("P");
                    ap=pila.peek();
               }
               else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
                
            }else if(ap.equals("P")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("A")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("A1")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("A2")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("A3")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("T")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("T1")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("T2")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("T3")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }
                
        }
    }
    
    
}
=======
package com.mycompany.analsql;
import java.util.List;
import java.util.Stack;
public class ASLR {
    
    public boolean Error=false;
    
    public int i=0;//contador de nuestra cadena en SQL
    
    
    public void tabla(){
        Stack<String> pila = new Stack<>();//crea pila
        pila.push("EOF");
        pila.push("Q");//Inicializamos la pila con los valores $,Q
        
        String ap=pila.peek();//asignamos al apuntador al tope de la pila
        
        while(!"EOF".equals(ap)){//mientras la pila sea diferente del elemento vacio procedemos con la logica
            //para llenar el bucle hacemos uso de nuestra tabla previamente creada
            if(ap.equals("Q")){
                //intercambiamos por su equivalente
                pila.pop();
                pila.push("T");
                pila.push("FROM");
                pila.push("D");
                pila.push("SELECT");
                ap=pila.peek();
            }else if(ap.equals("D")){//A diferencia de la Q, esta consta de 3 casos posibles
                                     //por ende aplicamos 3 ifs.
                if(ap=="DISTINCT"){
                    pila.pop();
                    pila.push("P");
                    pila.push("DISTINCT");
                    ap=pila.peek();
               }
               else if(ap=="IDENTIFICADOR"||ap=="ASTERISCO"){
                    pila.pop();
                    pila.push("P");
                    ap=pila.peek();
               }
               else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
                
            }else if(ap.equals("P")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("A")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("A1")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("A2")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("A3")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("T")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("T1")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("T2")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }else if(ap.equals("T3")){
                if(ap==""){
                    
                }else if(ap==""){
                    
                }
                else{
                System.out.println("Error, no cumples con als condiciones de la tabla");
                Error = true; // Marca que se ha encontrado un error
                break;
               }
            }
                
        }
    }
    
    
}
>>>>>>> 8631d0def4be6b26699a9653fbed0358d40ad3b1
