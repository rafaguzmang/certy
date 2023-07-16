/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificadodedomicilio;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Rafael
 */
public class SplashScreen {
     JFrame frame;
    
      public SplashScreen(){
    
    }
    
    public void Wait(){
    
         
            
            JLabel label = new JLabel();
            //Image img = new ImageIcon(new File(""));
            
            Class clazz = SplashScreen.class;
            URL url= clazz.getResource("splash.gif");
            Image imge =  new ImageIcon(url).getImage();
            
            ImageIcon img = new ImageIcon(imge);
//            ImageIcon img = new ImageIcon("C:\\Users\\zopha\\OneDrive\\Documentos\\NetBeansProjects\\Practicas\\src\\practicas\\26972939g.jpeg\n" +

            label.setIcon(img);
            label.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
            label.setBackground(Color.cyan);
           
            
            
            if (frame == null){
                frame = new JFrame();
                frame.add(label);   
                frame.setUndecorated(true);
                frame.setBackground(new Color(1.0f,1.0f,1.0f,.05f));
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(750, 50, img.getIconWidth(), 95);
//                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }else{
                frame.dispose();
                //System.out.println("pasa");
            }
            
         
    
    }
    
}
