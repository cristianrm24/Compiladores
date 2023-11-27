package ascendente;
public class Token {
    final tipoToken tipo;
    final String lexema;
    final int posicion;

    public Token(tipoToken tipo, String lexema, int posicion){
        this.tipo=tipo;
        this.lexema=lexema;
        this.posicion=posicion;
    }

    public Token(tipoToken tipo, String lexema){
        this.tipo=tipo;
        this.lexema=lexema;
        this.posicion=0;
    }
    @Override
    public boolean equals(Object cadena) {
        if (!(cadena instanceof Token)) {
            return false;
        }

        if(this.tipo == ((Token)cadena).tipo){
            return true;
        }

        return false;
    }

    public enum tipoToken {
    IDENTIFICADOR,

    //PALABRAS RESERVADAS
    SELECT, FROM, DISTINCT,

    //CARACTERES
    COMA, PUNTO, ASTERISCO,

    //FINAL DE CADENA
    EOF
}
    
  
}