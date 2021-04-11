/*Primera seccion, librerias */
package gramatica;
import java_cup.runtime.*;
import static gramatica.sym.*;
import DAO.Token;
import DAO.TokenError;
import java.util.ArrayList;

/*Segunda seccion, config*/
%%
%class LexerLectura
%cup
%cupdebug
%unicode
%line
%public
%column


%{
    //Creamos un listado de llos errores lexicos
    ArrayList<TokenError> listadoErroresLexicos = new ArrayList();

%}

%{
    //Funciones
    //retorna un simbolo despues de crear un nuevo token y agregarlo al listado
    private Symbol retornarSimbolo(int tipo, String tipoToken, String lexema, int fila, int columna){
        //creamos un  token auxiliar
        Token tokenAux = new Token(tipoToken, lexema, fila, columna);
        System.out.println("Fila: "+fila+" Columa: "+columna+" Token: "+tipoToken+ " Lexema: "+lexema);
        //retornamos el token aux como simbolo
        return new Symbol(tipo, tokenAux);
    }
    
    //Agregamos un token al array list de errores lexicos
    private void addErrorLexico(String tipoToken, String lexema, String msgError, int fila, int columna){
        //creamos un  token auxiliar
        TokenError tokenErrorAux = new TokenError(tipoToken, lexema, msgError, fila, columna);
        //Agregamos al listado
        listadoErroresLexicos.add(tokenErrorAux);
    }

    //Obtenemos el arrLust de los errores lexicos
    public ArrayList<TokenError> obtenerListadoErroresLexicos(){
        return listadoErroresLexicos;
    }
%}


SEPARADORES = [ \r\t\b\f\n]
NUMERO =  [[:digit:]]+ ("." [[:digit:]]+)?
LLAVES_INICIO = "{"
LLAVES_FIN = "}"
COMA = ","
DOS_PUNTOS = ":"
PUNTO_COMA = ";"
HEX = ("#" | "0x") [a-zA-Z0-9]+

%%

/*Tercera accion, expresiones*/
<YYINITIAL>{
    {NUMERO}	    { return retornarSimbolo(NUMERO, "NUMERO" , yytext(), yyline + 1, yycolumn + 1); }
    {LLAVES_INICIO}	{ return retornarSimbolo(LLAVES_INICIO, "LLAVES_INICIO" , yytext(), yyline + 1, yycolumn + 1); }
    {LLAVES_FIN}	{ return retornarSimbolo(LLAVES_FIN, "LLAVES_FIN" , yytext(), yyline + 1, yycolumn + 1); }
    {COMA}	        { return retornarSimbolo(COMA, "COMA" , yytext(), yyline + 1, yycolumn + 1); }
    {DOS_PUNTOS}	{ return retornarSimbolo(DOS_PUNTOS, "DOS_PUNTOS" , yytext(), yyline + 1, yycolumn + 1); }
    {PUNTO_COMA}	{ return retornarSimbolo(PUNTO_COMA, "PUNTO_COMA" , yytext(), yyline + 1, yycolumn + 1); }
    {HEX}           { return retornarSimbolo(HEX, "HEX" , yytext(), yyline + 1, yycolumn + 1); }

    {SEPARADORES}   {/*  */}
}

[^] { addErrorLexico ("LEXICO", yytext(), "Token no valido",yyline + 1, yycolumn + 1);}

