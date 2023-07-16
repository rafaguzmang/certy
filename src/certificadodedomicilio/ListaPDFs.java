/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificadodedomicilio;

import java.io.File;

/**
 *
 * @author Rafael
 */
public class ListaPDFs {
    
    public ListaPDFs(){
    
    }
    
    public String[] Archivos (String ruta){
        
        File folder = new File (ruta);
        String listaDir [] = folder.list();
//      System.out.println(ruta);
       
        
        for(String archivo : listaDir){
            
            
            
            if(archivo.contains(".JPG")||archivo.contains(".jpg") ){
                File file = new File(ruta+"\\"+archivo);
                File newFile = new File(ruta+"\\"+ archivo.substring(0, archivo.length()-4)+".jpeg");
                file.renameTo(newFile);
//                 System.out.println(archivo.toString());
            }
           
            
        }
        
        
        
        File dir = new File(ruta);
        String [] lista = dir.list();        
        return lista;
    }
    
}
