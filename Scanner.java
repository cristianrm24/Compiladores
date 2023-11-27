package ascendente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {
    private final String source;
    private final List<Token> tokens= new ArrayList<>();
    private static final Map<String, Token.tipoToken> reservadas;
    
  
    public boolean esTerminal(char c){
        String caracteres=",.*";
        return caracteres.indexOf(c)!=-1;
    }


    Scanner(String source){
        this.source=source+" ";
    }


    List<Token> scanTokens(){
        String lex="";
        int estado=0;
        char c;
        for(int i=0; i<source.length(); i++){
            c=source.charAt(i);
            switch (estado) {
                case 0:
                    if(esTerminal(c)){
                        i--;
                        estado=1;
                    }
                    else if(Character.isLetter(c)||Character.isDigit(c)){
                        lex+=c;
                        estado=2;
                    }
                    break;
                    case 1:
                        if(c=='*'){
                            lex+=c;
                            Token t=new Token(Token.tipoToken.ASTERISCO, lex);
                            estado=0;
                            lex="";
                            tokens.add(t);
                        }
                        else if (c=='.') {
                            lex+=c;
                            Token t=new Token(Token.tipoToken.PUNTO, lex);
                            estado=0;
                            lex="";
                            tokens.add(t);
                        }
                        else if (c==',') {
                            lex+=c;
                            Token t=new Token(Token.tipoToken.COMA, lex);
                            estado=0;
                            lex="";
                            tokens.add(t);
                        }
                        break;
                    case 2:
                        if(Character.isLetter(c)||Character.isDigit(c)){
                            estado=2;
                            lex+=c;
                        }
                        else{
                            Token.tipoToken tt=reservadas.get(lex);
                            if(tt==null){
                                Token t=new Token(Token.tipoToken.IDENTIFICADOR, lex);
                                tokens.add(t);
                            }
                            else{
                                Token t=new Token(tt, lex);
                                tokens.add(t);
                            }
                            estado=0;
                            lex="";
                            i--;
                        }
                        break;
            }
        }
        tokens.add(new Token(Token.tipoToken.EOF, lex));
        return tokens;
    }
 
      static {
        reservadas = new HashMap<>();


        reservadas.put("select", Token.tipoToken.SELECT);
        reservadas.put("from", Token.tipoToken.FROM);
        reservadas.put("distinct", Token.tipoToken.DISTINCT);
        reservadas.put("*",Token.tipoToken.ASTERISCO);
        reservadas.put(",",Token.tipoToken.COMA);
        reservadas.put(".",Token.tipoToken.PUNTO);

        
    }
    
}