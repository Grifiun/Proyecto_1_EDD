/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import arboles.ArbolAVLCapa;
import arboles.ArbolAVLUsuario;
import gramatica.LexerLectura;
import gramatica.parser;
import graphviz.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import listas.FuncionesGenerarImagenesListaCapasImagen;
import listas.ListaCircularImagenes;
import nodos.Nodo;
import nodos.NodoAVLCapa;
import nodos.NodoAVLUsuario;
import nodos.NodoImagen;

/**
 *
 * @author grifiun
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    ArbolAVLCapa arbolCapas;
    ListaCircularImagenes listadoImagenes;
    ArbolAVLUsuario arbolUsuarioAVL;
    
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        lienzo.setLayout(null);
        lienzo.setBackground(new java.awt.Color(255, 255, 255));
        lienzo.setBounds(10, 10, 840, 840);
        this.add(lienzo);
        lienzo.removeAll();
        lienzo.updateUI();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new javax.swing.JPanel();
        panelOpciones = new javax.swing.JPanel();
        btnCargar = new javax.swing.JButton();
        btnBuscarArchivo = new javax.swing.JButton();
        txtNombreArchivo = new javax.swing.JTextField();
        boxImagenes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        boxUsuarios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxGeneracionImagen = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnColor = new javax.swing.JButton();
        btnGenerarImagen = new javax.swing.JButton();
        boxCapas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        boxUsuariosImagenes = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setResizable(false);

        lienzo.setBackground(new java.awt.Color(255, 255, 255));
        lienzo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lienzo.setPreferredSize(new java.awt.Dimension(841, 840));
        lienzo.setLayout(null);

        panelOpciones.setMaximumSize(new java.awt.Dimension(249, 565));
        panelOpciones.setMinimumSize(new java.awt.Dimension(249, 565));

        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnBuscarArchivo.setText("Buscar");
        btnBuscarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArchivoActionPerformed(evt);
            }
        });

        jLabel1.setText("Listado Imagenes");

        boxUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUsuariosActionPerformed(evt);
            }
        });

        jLabel2.setText("Imagenes Usuario");

        jLabel3.setText("Tipo generacion imagen");

        boxGeneracionImagen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capa InOrden", "Capa preOrden", "Capa postOrden", "Por Capa (lista)", "Por imagen (lista)", "Por imagen de usuario" }));

        jLabel4.setText("Carga masiva de archivos");

        btnColor.setText("color");
        btnColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorActionPerformed(evt);
            }
        });

        btnGenerarImagen.setText("GENERAR IMAGEN");
        btnGenerarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarImagenActionPerformed(evt);
            }
        });

        jLabel5.setText("Listado Capas");

        jLabel6.setText("Listado Usuarios");

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelOpcionesLayout.createSequentialGroup()
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                                        .addComponent(btnBuscarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGenerarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombreArchivo)))
                            .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxImagenes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxUsuariosImagenes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxCapas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelOpcionesLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnColor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boxGeneracionImagen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarArchivo)
                    .addComponent(btnCargar))
                .addGap(99, 99, 99)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxCapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(boxImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxUsuariosImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxGeneracionImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnGenerarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnColor, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArchivoActionPerformed
        txtNombreArchivo.setText(elegirArchivo());
        
    }//GEN-LAST:event_btnBuscarArchivoActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        String texto = txtNombreArchivo.getText();
        if(texto.equals("")){
            JOptionPane.showMessageDialog(null, "seleccione un archivo primero");
        }else{
            //obtenemos el texto del archivo
            String contenidoArchivo = leerArchivo(texto);
            String extensionArchivo = texto.substring(texto.indexOf("."), texto.length());
            System.out.println("Extension: "+extensionArchivo);
            System.out.println("El contenido del archivo es: "+contenidoArchivo);
            
            try{
                
                StringReader sr = new StringReader(contenidoArchivo);
                LexerLectura lexer = new LexerLectura(sr);
                parser pars = new parser(lexer);                                            

                try{                        
                    if(arbolCapas != null){//tiene valores
                        pars.setArbolCapasAVL(arbolCapas);//seteamos el valor
                        System.out.println("El arbol de capas no es nulo, se settea el del parser");
                    }
                    if(listadoImagenes != null){
                        pars.setListaCircularImagenes(listadoImagenes);//seteamos el valor
                    }
                    if(arbolUsuarioAVL != null){
                        pars.setArbolUsuarioAVL(arbolUsuarioAVL);
                    }
                    pars.parse();                    
                    
                    if(extensionArchivo.contains(".cap")){//es un archivo de capas.cap
                        arbolCapas = pars.getArbolCapasAVL();
                        //Setteamos el valor del arbol AVL                     
                        //generamos las graficas de matrices
                        arbolCapas.generarGraficasMatrices(arbolCapas.getRaiz());   
                        
                        //Graficamos el arbol AVL
                        GenerarGraficaArbolAVL graficador = new GenerarGraficaArbolAVL(arbolCapas.getRaiz());
                        ////le agregamos el id de la capa
                        graficador.graficar("Capas"); 
                        
                        
                        boxCapas.removeAllItems();
                        arbolCapas.agregarCapasComboBox(boxCapas);
                    }else if(extensionArchivo.contains(".im")){//imagenes
                        this.listadoImagenes = pars.getListaCircularImagenes();
                        GenerarGraficaListadoCircularImagenes graficarImagenes = new GenerarGraficaListadoCircularImagenes(listadoImagenes.getRaiz());
                        //GenerarGraficaListadoCircularImagenes graficarImagenes = new GenerarGraficaListadoCircularImagenes(null);
                        graficarImagenes.graficar("Imagenes");
                        
                        //REcargamos el cbox de imagenes
                        boxImagenes.removeAllItems();
                        listadoImagenes.agregarImagenesComboBox(boxImagenes);
                        
                    }else{//usuarios
                        this.arbolUsuarioAVL = pars.getArbolUsuarioAVL();
                        GenerarGraficaArbolAVLUsuario graficarImagenes = new GenerarGraficaArbolAVLUsuario(arbolUsuarioAVL.getRaiz());
                        //GenerarGraficaListadoCircularImagenes graficarImagenes = new GenerarGraficaListadoCircularImagenes(null);
                        graficarImagenes.graficar("Usuarios_con_imagenes");
                        
                        GenerarGraficaArbolAVL graficador = new GenerarGraficaArbolAVL(arbolUsuarioAVL.getRaiz());
                        ////le agregamos el id de la capa
                        graficador.graficar("Usuarios");  
                        
                        //Agregamos al box
                        boxUsuarios.removeAll();
                        arbolUsuarioAVL.agregarUsuariosComboBox(boxUsuarios);
                        //Agregamos el segundo box
                        //boxUsuariosImagenes.removeAll();
                        //((NodoAVLUsuario)arbolUsuarioAVL.getRaiz()).getListadoImagenesUsuario().agregarImagenesComboBox(boxUsuariosImagenes);
                        
                    }                          
                }catch(Exception ex){
                    System.out.println("Error en la entrada de datos");
                }  
                
            }catch(Exception ex){
                System.out.println("Error en la ejecucion de la gramatica de lectura: "+ex.getMessage());
            } 
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorActionPerformed
        // TODO add your handling code here:
        JColorChooser colorSelector = new JColorChooser();
        Color color = colorSelector.showDialog(null, "Seleccione un Color", Color.BLUE);
        String hex = "#"+Integer.toHexString(color.getRGB()).substring(2);
        System.out.println("Color: "+hex);
        
        
    }//GEN-LAST:event_btnColorActionPerformed

    private void btnGenerarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarImagenActionPerformed
        // TODO add your handling code here:
        lienzo.removeAll();
        //lienzo.updateUI();
        int tipoGeneracion = boxGeneracionImagen.getSelectedIndex();
        /*
            0. Capa InOrden
            1. Capa preOrden
            2. Capa postOrden
            3. Por capa (arbol avl)
            4. Por imagen (lista)
            5. Por imagen de usuario
        */
        switch(tipoGeneracion){
            case 0:
                if(arbolCapas != null){
                    arbolCapas.graficarInOrden(arbolCapas.getRaiz(), lienzo);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Cargue primero las capas");
                }
                break;
            case 1:
                if(arbolCapas != null){
                    arbolCapas.graficarPreOrden(arbolCapas.getRaiz(), lienzo);
                }else{
                    JOptionPane.showMessageDialog(null, "Cargue primero las capas");
                }
                break;
            case 2:                
                if(arbolCapas != null){
                    arbolCapas.graficarPostOrden(arbolCapas.getRaiz(), lienzo);
                }else{
                    JOptionPane.showMessageDialog(null, "Cargue primero las capas");
                }
                break;
            case 3:
                if(arbolCapas != null){
                    int capaId = Integer.parseInt(boxCapas.getSelectedItem().toString());
                    //NodoAVLCapa nodoCapa = arbolCapas.buscar(capaId);
                    arbolCapas.graficarCapaId(capaId, lienzo);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Cargue primero las capas");
                }
                break;
            case 4:
                if(listadoImagenes != null){
                    int imagenId = Integer.parseInt(boxImagenes.getSelectedItem().toString());
                    NodoImagen imagenAux = listadoImagenes.buscarNodo(imagenId);
                    if(imagenAux != null){
                        FuncionesGenerarImagenesListaCapasImagen generarImagenes = new FuncionesGenerarImagenesListaCapasImagen();
                        generarImagenes.graficar(lienzo, imagenAux.getListadoCapas().getRaiz());
                        
                    }else{
                        System.out.println("Imagen no hallada");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Cargue primero las imagenes");
                }
                break;
            case 5:
                break;
            
        }
        //actualizamos el lienzo
        lienzo.updateUI();
    }//GEN-LAST:event_btnGenerarImagenActionPerformed

    private void boxUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUsuariosActionPerformed
        // TODO add your handling code here:
        System.out.println("Seleccion: "+boxUsuariosImagenes.getSelectedItem().toString());
    }//GEN-LAST:event_boxUsuariosActionPerformed

    public String leerArchivo(String direccion){
        String aux = "";
        String contenidoArchivo = "";
        
        try{///se lee el archivo
            FileReader fr = new FileReader(direccion);
            BufferedReader br = new BufferedReader(fr);

            //Leemos y analizamos todaas las lineas de texto del archivo (linea por linea)
            while(aux != null){//cuando el auxiliar no sea nulo el while sigue, sera nulo cuando se termine de leer el archivo
                contenidoArchivo += aux + "\n";//agregamos la linea a una var
                aux = br.readLine();//con el ReadLine procedemos a leer la siguiente linea            
                                
            }
            //substring(0, auxMat.length() - 1) hace que se remueva el ultimo caracter agregado, que seria un "*"
           
            
        }catch(Exception e){            
            JOptionPane.showMessageDialog(null, "Archivo inexistente");
            
        } 
    
        return contenidoArchivo;
    }
    
    /**
     * Metodo que muestra un file chooser
     * @return 
     */
    private String elegirArchivo(){
        JFileChooser buscador = new JFileChooser();    
        //Agregamos un filtro al file Choser
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("TEXT FILES", "cap", "im", "usr");
        buscador.setFileFilter(filtro);
        buscador.showOpenDialog(this);
        File file;
        String archivo;
        file = buscador.getSelectedFile();
        if(file == null){
            archivo="";        
        }else{
            archivo = buscador.getSelectedFile().getAbsolutePath();  
        }
        return archivo;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCapas;
    private javax.swing.JComboBox<String> boxGeneracionImagen;
    private javax.swing.JComboBox<String> boxImagenes;
    private javax.swing.JComboBox<String> boxUsuarios;
    private javax.swing.JComboBox<String> boxUsuariosImagenes;
    private javax.swing.JButton btnBuscarArchivo;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnColor;
    private javax.swing.JButton btnGenerarImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel lienzo;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTextField txtNombreArchivo;
    // End of variables declaration//GEN-END:variables
}