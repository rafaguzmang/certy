/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificadodedomicilio;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
//import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rafael
 */
public class Tabla extends JFrame{
    DefaultTableModel modelo = new DefaultTableModel();
   
    EXcellFile excel = new EXcellFile();
    ArrayList<String> datos = new ArrayList();
    
    
    
    String path;
    String []  archivos;
    String date;
    String cuen;
    String activa;
    String lat;
    String longi;
    String contrato ="";
    String carpetaDate;
    int rowSelected;
    String salto = "\n";
    
   
   
    public Tabla(){
        
        modelo = new DefaultTableModel();
        
         modelo.addColumn("Contrato");
       modelo.addColumn("Cuenta");
       modelo.addColumn("Fecha");
       modelo.addColumn("Latitud");
       modelo.addColumn("Longitud");
       modelo.addColumn("Entre Calle");
       modelo.addColumn("Y calle");
       modelo.addColumn("Suscriptor");
       modelo.addColumn("Telefono");
       modelo.addColumn("2o Telefono");
       modelo.addColumn("Calle");
       modelo.addColumn("No Exterior");
        modelo.addColumn("No Interior");
       modelo.addColumn("Municipio");
       modelo.addColumn("Estado");
       modelo.addColumn("C.P.");
       modelo.addColumn("Colonia");
        
       
        JTable tabla  = new JTable(modelo);
       
       
        
        tabla.setBounds(10, 10, 1500, 200);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setRowHeight(30);
        tabla.setForeground(Color.blue);
        tabla.setBackground( new Color(255, 255, 204));
       
        
        
       
        
        
        Font fh = new Font("Arial", Font.BOLD, 18);
        Font fc = new Font(Font.SANS_SERIF,Font.PLAIN , 14);
        JTableHeader header = tabla.getTableHeader();
        
        header.setFont(fh);
        header.setForeground(Color.BLUE);
        header.setBackground(Color.CYAN);
        tabla.setFont(fc);
        
         tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
              try{
               tabla.editCellAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
               contrato = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
               rowSelected = tabla.getSelectedRow();
              }catch(Exception ex){
                 
              }
              
               
               
            }
        });
         
         JButton agregar = new JButton("Agregar");
         agregar.setBounds(10, 220, 80, 40);
         
         JButton abrirPDF = new JButton("Agregar");
         abrirPDF.setBounds(100, 220, 80, 40);
         
          Class clazz = SplashScreen.class;
         URL url= clazz.getResource("excel.png");         
         Image imge =  new ImageIcon(url).getImage();            
         ImageIcon img = new ImageIcon(imge);
         
         abrirPDF.setIcon(img);
         
         
         agregar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
//               try {
//                   Robot robot = new Robot();
//                   robot.keyPress(KeyEvent.VK_ENTER);
////                   robot.keyRelease(KeyEvent.VK_ENTER);
//                   
//                        
//               } catch (AWTException ex) {
//                   
//               }
                
//                tabla.getSelectionModel().clearSelection();
                
                
               for(int row = 0; row < tabla.getColumnCount();row++){
                   datos.clear();
                  try{
                    cuen = tabla.getValueAt(row,1).toString();
//                    date = tabla.getValueAt(row, 2).toString();
                    lat = tabla.getValueAt(row, 3).toString();
                    longi = tabla.getValueAt(row, 4).toString();
                    activa = tabla.getValueAt(row, 2).toString();
                    
                    datos.add(tabla.getValueAt(row,0).toString());
                    datos.add(tabla.getValueAt(row,7).toString());
                    datos.add(tabla.getValueAt(row,8).toString());
                    datos.add(tabla.getValueAt(row,10).toString());
                    datos.add(tabla.getValueAt(row,11).toString());
                    datos.add(tabla.getValueAt(row,5).toString());
                    datos.add(tabla.getValueAt(row,6).toString());
                    datos.add(tabla.getValueAt(row,13).toString());
                    datos.add(tabla.getValueAt(row,14).toString());
                    datos.add(tabla.getValueAt(row,15).toString());
                    datos.add(tabla.getValueAt(row,16).toString());
                    datos.add(tabla.getValueAt(row,12).toString());
                    datos.add(tabla.getValueAt(row,9).toString());
                    
                   
                   excel.modificar(datos, path, archivos, date, cuen, activa, lat, longi);
                  }catch(Exception  ex){
                      
                  }
               }
               
               
                JOptionPane.showMessageDialog(null, "Agregado");
           }
           
           
       });
         
         
         abrirPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(contrato!= ""){
                     File desk = new File(path + "\\" + carpetaDate+"\\"+ contrato+".xlsx");
                       try {
                        Desktop.getDesktop().open(desk);
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione una fila de la Tabla");
                }
                
                 
          
                }
        });
         
         JScrollPane scroll = new JScrollPane(tabla);
         
         add(agregar);
           scroll.setBounds(10, 10, 1500, 200);
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1600,300);
        setLocationRelativeTo(null);
        setLayout(null);

        add(scroll);
        
         add(abrirPDF);       
        setVisible(true);
         
    }
    
   
    
    public void Tabla(ArrayList<String> datos, String path, String [] archivos, String date, String cuen, String activa, String lat, String longi, String demo){
        this.path = path;
        this.archivos = archivos;
        this.date = date;
        carpetaDate = demo;
         
        
        
        String [] dat = {datos.get(0), cuen, date,lat,longi,datos.get(5),datos.get(6),datos.get(1),datos.get(2),datos.get(12),
                        datos.get(3), datos.get(4),datos.get(11),datos.get(7),datos.get(8),datos.get(9),datos.get(10)};
        modelo.addRow(dat);
     
    }
    
    public void abrirTabla(){
        setVisible(true);
    }
  
}
