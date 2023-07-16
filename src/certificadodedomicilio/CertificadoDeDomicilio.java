/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificadodedomicilio;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class CertificadoDeDomicilio {
    
    
    public static void main(String[] args) {
        
      
          
        JFrame frame = new JFrame("Certy 1.4");
       JButton ejecutar = new JButton("Ejecutar");
       ejecutar.setBounds(10, 20, 135, 120);
       JButton explorador = new JButton("Abrir Explorador");
       explorador.setBounds(155,20,135,120);
       
       JButton revLista = new JButton("Listado");
       revLista.setBounds(100,145,80,20);
       revLista.setVisible(false);
       
        Class clazz = CertificadoDeDomicilio.class;
        URL url= clazz.getResource("explorador.png");
        Image imgeExp =  new ImageIcon(url).getImage();
            
        ImageIcon imgExplo = new ImageIcon(imgeExp);
        Image img2Explo = imgExplo.getImage();
        Image newImgExplor = img2Explo.getScaledInstance(110, explorador.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon img3Explo = new ImageIcon(newImgExplor);
        
        URL url2 = clazz.getResource("administration.png");
        
        Image imgeEje =  new ImageIcon(url2).getImage();
            
        ImageIcon imgEje = new ImageIcon(imgeEje);
        Image img2Eje = imgEje.getImage();
        Image newImgEje = img2Eje.getScaledInstance(110,100, Image.SCALE_DEFAULT);
        ImageIcon img3Eje = new ImageIcon(newImgEje);
        


        ejecutar.setIcon( img3Eje);
        
        ejecutar.setBounds(10, 20, 135, 120);
        
        explorador.setIcon(img3Explo);
        explorador.setBounds(155, 20, 135, 120);
//        explorador.setBackground(Color.cyan);
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(315,210);
       frame.setLocationRelativeTo(null);
       frame.setLayout(null);
       frame.add(ejecutar);
       frame.add(explorador);
       frame.add(revLista);
       frame.setVisible(true);
       
       
       
       ejecutar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             Ejecutable ejecuta = new Ejecutable();
             
           }
       });
       
       
        explorador.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              Explorador explorar = new Explorador();
              
           }
           
       });
        
         revLista.setVisible(false);
         
         revLista.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                Tabla tabla = new Tabla();
               
                
           }
       });
         
        
    }
}
