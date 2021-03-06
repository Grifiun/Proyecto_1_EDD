
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615
//----------------------------------------------------

package gramatica;

import java_cup.runtime.*;
import gramatica.sym;
import gramatica.LexerLectura;
import DAO.Token;
import arboles.*;
import nodos.*;
import matrix_dispersa.Matrix;
import listas.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\003\000\002\002\004\000\002\003" +
    "\004\000\002\003\003\000\002\014\003\000\002\014\003" +
    "\000\002\014\003\000\002\004\006\000\002\004\004\000" +
    "\002\005\005\000\002\006\004\000\002\006\003\000\002" +
    "\007\006\000\002\010\006\000\002\010\003\000\002\011" +
    "\004\000\002\011\005\000\002\012\006\000\002\012\003" +
    "\000\002\013\004\000\002\013\005\000\002\015\005\000" +
    "\002\015\003\000\002\016\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\055\000\004\004\012\001\002\000\004\006\057\001" +
    "\002\000\010\002\ufffc\004\ufffc\006\051\001\002\000\006" +
    "\002\ufffe\004\ufffe\001\002\000\010\002\ufffd\004\ufffd\006" +
    "\044\001\002\000\006\002\001\004\012\001\002\000\004" +
    "\005\032\001\002\000\006\005\uffea\010\024\001\002\000" +
    "\010\002\uffef\004\uffef\011\uffef\001\002\000\010\002\ufffb" +
    "\004\ufffb\011\020\001\002\000\010\002\ufff3\004\ufff3\006" +
    "\ufff3\001\002\000\004\002\017\001\002\000\004\002\000" +
    "\001\002\000\004\004\021\001\002\000\004\010\024\001" +
    "\002\000\004\011\023\001\002\000\010\002\ufff0\004\ufff0" +
    "\011\ufff0\001\002\000\010\002\uffee\004\025\011\uffee\001" +
    "\002\000\016\002\uffea\004\uffea\005\uffea\006\uffea\007\uffea" +
    "\011\uffea\001\002\000\014\002\uffeb\004\uffeb\006\uffeb\007" +
    "\uffeb\011\uffeb\001\002\000\012\002\uffed\004\uffed\007\030" +
    "\011\uffed\001\002\000\004\004\025\001\002\000\014\002" +
    "\uffec\004\uffec\006\uffec\007\uffec\011\uffec\001\002\000\010" +
    "\002\ufff2\004\025\006\ufff2\001\002\000\006\004\025\006" +
    "\ufff8\001\002\000\012\002\ufff1\004\ufff1\006\ufff1\007\036" +
    "\001\002\000\006\004\ufff6\006\ufff6\001\002\000\006\004" +
    "\025\012\037\001\002\000\004\011\040\001\002\000\006" +
    "\004\ufff5\006\ufff5\001\002\000\004\007\036\001\002\000" +
    "\006\004\ufff7\006\ufff7\001\002\000\006\002\uffff\004\uffff" +
    "\001\002\000\004\004\025\001\002\000\004\005\050\001" +
    "\002\000\004\006\047\001\002\000\010\002\ufffa\004\ufffa" +
    "\006\ufffa\001\002\000\004\004\025\001\002\000\004\004" +
    "\025\001\002\000\004\005\055\001\002\000\004\006\054" +
    "\001\002\000\010\002\ufff4\004\ufff4\006\ufff4\001\002\000" +
    "\006\004\025\006\ufff2\001\002\000\006\006\ufff1\007\030" +
    "\001\002\000\010\002\ufff9\004\ufff9\006\ufff9\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\055\000\026\002\015\003\007\004\006\005\003\010" +
    "\004\011\014\012\013\013\012\014\005\016\010\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\022\004\006\005\003\010\004\011\014" +
    "\012\013\013\012\014\042\016\010\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\013\021\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\015\026\016\025\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\016\030\001\001\000\002\001\001\000\012\006\032\007" +
    "\034\015\033\016\025\001\001\000\010\007\041\015\040" +
    "\016\025\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\016\030\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\005\045\016\044\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\006\032\007\034\015" +
    "\040\016\025\001\001\000\006\011\052\016\051\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\015\055\016\025\001\001\000\002\001\001\000\002" +
    "\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    ArbolAVLCapa arbolCapasAVL = new ArbolAVLCapa();
    ListaCircularImagenes listadoCircularImagenes = new ListaCircularImagenes();
    ArbolAVLUsuario arbolUsuarioAVL = new ArbolAVLUsuario();

    public String resultado = " ";

    public ArbolAVLCapa getArbolCapasAVL(){   
        return arbolCapasAVL;
    }

    public void setArbolCapasAVL(ArbolAVLCapa arbolCapasAVL){   
        this.arbolCapasAVL = arbolCapasAVL;
    }

    public ListaCircularImagenes getListaCircularImagenes(){   
        return listadoCircularImagenes;
    }

    public void setListaCircularImagenes(ListaCircularImagenes listadoCircularImagenes){   
        this.listadoCircularImagenes = listadoCircularImagenes;
    }

    public ArbolAVLUsuario getArbolUsuarioAVL(){   
        return arbolUsuarioAVL;
    }

    public void setArbolUsuarioAVL(ArbolAVLUsuario arbolUsuarioAVL){   
        this.arbolUsuarioAVL = arbolUsuarioAVL;
    }

    public parser(LexerLectura lexer){
        super(lexer);
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // s ::= carga_masiva 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("s",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= s EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // carga_masiva ::= carga_masiva lectura_general 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("carga_masiva",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // carga_masiva ::= lectura_general 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("carga_masiva",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // lectura_general ::= lectura_capa 
            {
              Object RESULT =null;
		int capaAVLleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int capaAVLright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object capaAVL = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lectura_general",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // lectura_general ::= lectura_imagen 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("lectura_general",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // lectura_general ::= lectura_usuario 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("lectura_general",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // lectura_capa ::= lectura_capa LLAVES_FIN capa LLAVES_FIN 
            {
              Object RESULT =null;
		int nodoCapaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int nodoCaparight = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		NodoAVLCapa nodoCapa = (NodoAVLCapa)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
            //El nodo capa se almacena el arbol binario de busqueda AVL
            arbolCapasAVL.insertar(nodoCapa);
            //capaAVL.insertar(nodoCapa);
            System.out.println("insertamos un nodo capa: "+nodoCapa.getId());
            //RESULT = capaAVL;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lectura_capa",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // lectura_capa ::= capa LLAVES_FIN 
            {
              Object RESULT =null;
		int nodoCapaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int nodoCaparight = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		NodoAVLCapa nodoCapa = (NodoAVLCapa)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
            //El nodo capa se almacena en un nuevo arbol binario de busqueda AVL
            //ArbolAVLCapa capaAVL = new ArbolAVLCapa();
            //capaAVL.insertar(nodoCapa);

            arbolCapasAVL.insertar(nodoCapa);

            System.out.println("insertamos un nodo capa: "+nodoCapa.getId());
            //RESULT = capaAVL;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lectura_capa",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // capa ::= numeroCadena LLAVES_INICIO bloque_capas 
            {
              NodoAVLCapa RESULT =null;
		int idCadenaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int idCadenaright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String idCadena = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int matrizCapaAuxiliarleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int matrizCapaAuxiliarright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Matrix matrizCapaAuxiliar = (Matrix)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            //Capa sin un conjunto de pixeles almacenados en una matriz dispersa
            int id = Integer.parseInt(idCadena);
            NodoAVLCapa nodoCapa = new NodoAVLCapa(id, matrizCapaAuxiliar);
            System.out.println("insertamos una matriz: ");
            RESULT = nodoCapa;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("capa",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // bloque_capas ::= bloque_capas capa_unidad 
            {
              Matrix RESULT =null;
		int matrizCapaAuxiliarleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int matrizCapaAuxiliarright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Matrix matrizCapaAuxiliar = (Matrix)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int nodoMatrixAuxiliarleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nodoMatrixAuxiliarright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		NodoMatrix nodoMatrixAuxiliar = (NodoMatrix)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            //El pixel se agrega a la matriz dispersa obtenida
            if(matrizCapaAuxiliar == null){
                matrizCapaAuxiliar = new Matrix();
            }
            matrizCapaAuxiliar.insertar(nodoMatrixAuxiliar);  
            System.out.println("insertamos un nodo matriz: "+nodoMatrixAuxiliar.getX()+","+nodoMatrixAuxiliar.getY());
            RESULT = matrizCapaAuxiliar;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bloque_capas",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // bloque_capas ::= capa_unidad 
            {
              Matrix RESULT =null;
		int nodoMatrixAuxiliarleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nodoMatrixAuxiliarright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		NodoMatrix nodoMatrixAuxiliar = (NodoMatrix)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            //El pixel se agrega a una nueva matriz dispersa   
            Matrix matrizCapaAuxiliar = new Matrix();
            matrizCapaAuxiliar.insertar(nodoMatrixAuxiliar);   
            System.out.println("insertamos un nodo matriz: "+nodoMatrixAuxiliar.getX()+","+nodoMatrixAuxiliar.getY());
            RESULT = matrizCapaAuxiliar;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bloque_capas",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // capa_unidad ::= conjunto_numeros COMA HEX PUNTO_COMA 
            {
              NodoMatrix RESULT =null;
		int numerosleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int numerosright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String numeros = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int hexTokenleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int hexTokenright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Token hexToken = (Token)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
            //Capa por si sola (NodoMatrix)
            //se crea un nodo pixel con los datos recibidos
            //System.out.println("Nujmeros: "+numeros);
            String[] numerosCadena = numeros.split(",");
            int fila = 0;
            int columna = 0;
            int colorHex = 0;
            try{
                fila = Integer.parseInt(numerosCadena[0]); 
                columna = Integer.parseInt(numerosCadena[1]); 
                colorHex = Integer.parseInt(hexToken.getLexema().replaceAll("#","").replaceAll("0x",""), 16);

            }catch(Exception ex){
                System.out.println("Error al obtener los numeros: "+ex.getMessage());
            }

            NodoMatrix nodoMatrixAuxiliar = new NodoMatrix(fila, columna, colorHex);

            
            RESULT = nodoMatrixAuxiliar;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("capa_unidad",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // lectura_imagen ::= lectura_imagen LLAVES_FIN imagen LLAVES_FIN 
            {
              Object RESULT =null;
		int nodoImagenleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int nodoImagenright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		NodoImagen nodoImagen = (NodoImagen)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
            //Una imagen nueva se almacena en una lista doblemente enlazada circular
            listadoCircularImagenes.insertarNodo(nodoImagen);//insertamos en el listado circular el nodo obtenido de imagenes
        
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lectura_imagen",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // lectura_imagen ::= imagen 
            {
              Object RESULT =null;
		int nodoImagenleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nodoImagenright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		NodoImagen nodoImagen = (NodoImagen)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            //Una imagen nueva se almacena en una lista doblemente enlazada circular
            //Una imagen posee una lista enlaza de capas
            listadoCircularImagenes.insertarNodo(nodoImagen);//insertamos en el listado circular el nodo obtenido de imagenes
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lectura_imagen",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // imagen ::= numeroCadena LLAVES_INICIO 
            {
              NodoImagen RESULT =null;
		int idCadenaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int idCadenaright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String idCadena = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
            ///Imagen sin capas
            int id = Integer.parseInt(idCadena);
            NodoImagen nodoImagen = new NodoImagen(id);//no tiene un listado de capas

            RESULT = nodoImagen;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("imagen",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // imagen ::= numeroCadena LLAVES_INICIO conjunto_numeros 
            {
              NodoImagen RESULT =null;
		int idCadenaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int idCadenaright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String idCadena = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int numerosleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int numerosright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String numeros = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            ///Imagen con capas
            //El conjunto de numeros nos debera retornar una lista simplemente enlazada de capas
            //donde la imagen apuntara al indice de esa lista
            String[] numerosCadena = numeros.split(",");//Listado de capas    
            int id = Integer.parseInt(idCadena);
            //creamos un nodo imagen
            NodoImagen nodoImagen = new NodoImagen(id);
            //creamos un listado temporal de capas
            ListaDoblementeEnlazada listadoCapasImagen = new ListaDoblementeEnlazada();

            try{
                for(int i = 0; i < numerosCadena.length; i++){
                    //obtenemos el id auxiliar del nodo
                    int idCapaAux = Integer.parseInt(numerosCadena[i]); 
                    //Buscamos el nodo
                    //NodoAVLCapa nodoCapaAux;
                    NodoAVLCapa nodoCapaAux = arbolCapasAVL.buscar(idCapaAux);
                    NodoListaCapa nodoListaCapAux = new NodoListaCapa(idCapaAux, nodoCapaAux);
                    //verificamos si es valido o no
                    if(nodoCapaAux != null){
                        //insertamos en el listado temporal de capas
                        System.out.println("Se encontro la capa con id: "+idCapaAux);
                        listadoCapasImagen.insertarNodo(nodoListaCapAux);
                    }else{
                        System.out.println("Id invalido de capa: "+idCapaAux);
                    }
                }   
            }catch(Exception ex){
                System.out.println("Error al obtener los numeros: "+ex.getMessage());
                System.out.println("Error al obtener los numeros: "+ex);

            }
            //agregamos el listado al nodo imagen
            nodoImagen.setListadoCapas(listadoCapasImagen);
            //retornamos
            RESULT = nodoImagen;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("imagen",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // lectura_usuario ::= lectura_usuario PUNTO_COMA usuario PUNTO_COMA 
            {
              Object RESULT =null;
		int nodoUsuarioAuxleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int nodoUsuarioAuxright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		NodoAVLUsuario nodoUsuarioAux = (NodoAVLUsuario)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
            //Se agrega un usuario al arbol binario de busqueda AVL
            arbolUsuarioAVL.insertar(nodoUsuarioAux);
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lectura_usuario",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // lectura_usuario ::= usuario 
            {
              Object RESULT =null;
		int nodoUsuarioAuxleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nodoUsuarioAuxright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		NodoAVLUsuario nodoUsuarioAux = (NodoAVLUsuario)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            //Un usuario debe agregarse a una nuevo arbol binario de busqueda AVL
            //cada usuario posee una lista simplemente enlazada de imagenes
            arbolUsuarioAVL.insertar(nodoUsuarioAux);
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lectura_usuario",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // usuario ::= NUMERO DOS_PUNTOS 
            {
              NodoAVLUsuario RESULT =null;
		int idCadenaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int idCadenaright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Token idCadena = (Token)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
            ///Usuario sin imagenes
            int id = Integer.parseInt(idCadena.getLexema());
            NodoAVLUsuario nodoUsuario = new NodoAVLUsuario(id, null);//se envia null porque no tiene un listado-

            RESULT = nodoUsuario;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("usuario",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // usuario ::= NUMERO DOS_PUNTOS conjunto_numeros 
            {
              NodoAVLUsuario RESULT =null;
		int idCadenaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int idCadenaright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Token idCadena = (Token)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int numerosleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int numerosright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String numeros = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            ///Usuario con imagenes
            //este conjunto de numeros debera obtener un listado simplemente enlazada de las imagenes a las cuales correspondan los id
            String[] numerosCadena = numeros.split(",");//Listado de capas 
            int id = Integer.parseInt(idCadena.getLexema());
            System.out.println("Numeros:  "+numeros);
            //creamos un listado temporal de imagenes
            ListaDoblementeEnlazada listadoImagenesUsuario = new ListaDoblementeEnlazada();
            //ListaDoblementeEnlazadaImagenes listadoImagenesUsuario = new ListaDoblementeEnlazadaImagenes();
            try{
                for(int i = 0; i < numerosCadena.length; i++){
                    //obtenemos el id auxiliar del nodo
                    int idAux = Integer.parseInt(numerosCadena[i]); 
                    //Buscamos el nodo
                    //NodoAVLCapa nodoCapaAux;
                    NodoImagen nodoAux = listadoCircularImagenes.buscarNodo(idAux);
                    NodoListaImagen nodoListaAux = new NodoListaImagen(idAux, nodoAux);
                    //verificamos si es valido o no
                    if(nodoAux != null){
                        //insertamos en el listado temporal de capas
                        System.out.println("Se encontro la imagen con id: "+idAux);
                        if(i == 0){
                            listadoImagenesUsuario.setRaiz((NodoListaEnlazada)nodoListaAux);
                        }else{
                            listadoImagenesUsuario.insertarNodo(nodoListaAux);

                        }

                    }else{
                        System.out.println("Id invalido de capa: "+idAux);
                    }
                }   
            }catch(Exception ex){
                System.out.println("Error al obtener los numeros: "+ex.getMessage());
            }
            //agregamos el listado al nodo usr            
            NodoAVLUsuario nodoUsuario = new NodoAVLUsuario(id, listadoImagenesUsuario);//se envia null porque no tiene un listado-

            RESULT = nodoUsuario;
        
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("usuario",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // conjunto_numeros ::= conjunto_numeros COMA numeroCadena 
            {
              String RESULT =null;
		int numerosleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int numerosright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String numeros = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int numleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int numright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String num = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            numeros +=  ","+num; 
            RESULT = numeros;
        
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("conjunto_numeros",11, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // conjunto_numeros ::= numeroCadena 
            {
              String RESULT =null;
		int numleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int numright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String num = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 
            String numeros =  ""+num; 
            RESULT = numeros;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("conjunto_numeros",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // numeroCadena ::= NUMERO 
            {
              String RESULT =null;
		int numeroleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int numeroright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Token numero = (Token)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
            String numeroAux = numero.getLexema();
            //System.out.println("num: "+numeroAux);
            RESULT = numeroAux;
        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("numeroCadena",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}