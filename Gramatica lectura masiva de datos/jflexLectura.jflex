/*Primera seccion, librerias */
package gramatica;
import java_cup.runtime.*;
import static com.example.gramatica.sym.*;
import DAO.Token;

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
        //Agregamos al listado
        listadoOperadoresInvocados.add(tokenAux);
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
HEX = "#" [a-zA-Z0-9]+

%%

/*Tercera accion, expresiones*/
<YYINITIAL>{
    {NUMERO}	    { return new Symbol(NUMERO,         new Token(yytext(), yyline + 1, yycolumn + 1)); }
    {LLAVES_INICIO}	{ return new Symbol(LLAVES_INICIO,  new Token(yytext(), yyline + 1, yycolumn + 1)); }
    {LLAVES_FIN}	{ return new Symbol(LLAVES_FIN,     new Token(yytext(), yyline + 1, yycolumn + 1)); }
    {COMA}	        { return new Symbol(COMA,           new Token(yytext(), yyline + 1, yycolumn + 1)); }
    {DOS_PUNTOS}	{ return new Symbol(DOS_PUNTOS,     new Token(yytext(), yyline + 1, yycolumn + 1)); }
    {PUNTO_COMA}	{ return new Symbol(PUNTO_COMA,     new Token(yytext(), yyline + 1, yycolumn + 1)); }
    {HEX}           { return new Symbol(HEX,            new Token(yytext(), yyline + 1, yycolumn + 1)); }

    {SEPARADORES}   {/*  */}
}

[^] { addErrorLexico ("LEXICO", yytext(), "Token no valido",yyline + 1, yycolumn + 1);}

