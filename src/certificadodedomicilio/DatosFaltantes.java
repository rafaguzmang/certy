/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificadodedomicilio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class DatosFaltantes {
    
    public DatosFaltantes(){
        
    }
    
    public ArrayList<String> faltantes (String ruta, String contrato, String txtFile){
        ArrayList<String> datos = new ArrayList<String>();
        File file = new File(ruta + "\\"+txtFile);        
        String line="";
        String content="";
        String cuenta="";
        String fecha="";
        String latitud="";
        String longitud="";
        
       try{
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
//          content = br.readLine();
            while((line =br.readLine())!= null){
                if(line.contains(contrato)){
                   
                    content = line.substring(contrato.length());
//                     System.out.println(content);
                     
                    for(int c = 0; c < content.length(); c++){
                        if(!content.substring(c, c+1).equals(" ")){
                            cuenta = cuenta + content.substring(c, c+1);                            
                        }
                        if(content.substring(c, c+1).equals(" ") && !cuenta.equals("")){
                            break;                           
                        }
                    }
                    
                    content = content.substring(cuenta.length()+1);
                    
                    for(int c = 0; c < content.length(); c++){
                        if(!content.substring(c, c+1).equals(" ")){
                            fecha = fecha + content.substring(c, c+1);                            
                        }
                        if(content.substring(c, c+1).equals(" ") && !fecha.equals("")){
                            break;                           
                        }
                    }
                    
                    content = content.substring(fecha.length()+1);
                    
                    for(int c = 0; c < content.length(); c++){
                        if(!content.substring(c, c+1).equals(" ")){
                            latitud = latitud + content.substring(c, c+1);                            
                        }
                        if(content.substring(c, c+1).equals(" ") && !latitud.equals("")){
                            break;                           
                        }
                    }
                    
                    content = content.substring(latitud.length()+1);
                    
                    for(int c = 0; c < content.length(); c++){
                        if(!content.substring(c, c+1).equals(" ")){
                            longitud = longitud + content.substring(c, c+1);                            
                        }
                        if(content.substring(c, c+1).equals(" ") && !longitud.equals("")){
                            break;                           
                        }
                    }
                    
                }
                
            }
            
            br.close();            
        }catch(IOException ex){
            ex.printStackTrace();
        }
       
       datos.add(cuenta);
       datos.add(fecha);
       datos.add(latitud);
       datos.add(longitud);
       datos.add(longitud);
       
       
        System.out.println("cuenta: "+cuenta);
        System.out.println("fecha: "+fecha);
        System.out.println("latitud: "+latitud);
        System.out.println("longitud: "+longitud);
    
    
        return datos;
    }
    
}
