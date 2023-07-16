/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificadodedomicilio;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 *
 * @author Rafael
 */
public class VeTv {
    
    public VeTv(){
    
    }
    
    public ArrayList<String> VeTv(String pdfFileInText, String NoContrato){
        
       ArrayList<String> datos = new ArrayList<String>();
    String contrato = NoContrato;
    String suscriptor="";
    String telefono="";
    String calle="";
    String noEx="";
    
    String entreCalle="";
    String yCalle="";
    String municipio="";
    String edo="";
    String cp="";
    
    String colonia="";
    
    
    
    try{
            
            
             
             pdfFileInText = pdfFileInText.substring(pdfFileInText.indexOf("Cargo por cambio de paquete: $ _________ Cargo adicionales (cableado, serv. adicionales, etc.): $ ________ Cargo por reactivación: $____________350.00 149.00 N/A") , 
                            pdfFileInText.indexOf("AUTORIZACIÓN PARA SOLICITAR REPORTES DE CRÉDITO"));
             
             
             String lines[] = pdfFileInText.split("\\r?\\n");
//             contrato = URL.substring(URL.lastIndexOf("\\") +1, URL.indexOf(".pdf"));
             int sus=-1;
             int no=0;
             int cont =0;
             int ref =0;
             int contra =0;
             int buscaX=0;
             int callef=0;
             int habilitar=0;
             int entrecalles=0;
             int materno =0;
             int mat=0;
             int lada=0;
            
             
             
             for (String line : lines){
                // System.out.println(no++ + " "+ line);
                 no++;
                 
//                 if(line.contains("DI003228")||line.contains("DI03228")||line.contains("DI00003228")){
//                      habilitar ++;
//                      
//                 } 

                if(line.contains("DI18090731")||line.contains("DI18090651")||line.contains("DI14040441")||line.contains("DI18020161")||line.contains("DI11080341")
                    ||line.contains("DI18020161")||line.contains("DI19080091")||line.contains("DI18020331")||line.contains("DI15090351")||line.contains("DI18090501")
                    ||line.contains("DI15030411")||line.contains("DI15090211")||line.contains("DI14010361")||line.contains("DI00708189")||line.contains("DI18120151")
                    ||line.contains("DI11010131")||line.contains("DI18090861")||line.contains("DI15090241")||line.contains("DI00600932")||line.contains("DI14050331")
                    ||line.contains("DI16031231")||line.contains("DI10060191")||line.contains("DI18120141")||line.contains("DI18120031")||line.contains("DI15090051")
                    ||line.contains("DI14110261")||line.contains("DI10060231") ||line.contains("DI10100101")||line.contains("DI19050051")||line.contains("DI18090231")
                    ||line.contains("DI18090451")||line.contains("DI19080071")||line.contains("DI00084764")||line.contains("DI19010111")||line.contains("DI19010031")
                    ||line.contains("DI18090231")||line.contains("DI16031001")||line.contains("DI18090591")||line.contains("DI00098947")||line.contains("DI20030131")
                    ||line.contains("DI20030181")||line.contains("DI20030351")||line.contains("DI20031131")||line.contains("DI20031191")||line.contains("DI20031261")
                    ||line.contains("DI20030631")||line.contains("DI20030991")||line.contains("DI20031031")||line.contains("DI20030131")||line.contains("DI20031231")
                    ||line.contains("DI20030601")||line.contains("DI20060081")){
                      habilitar ++;
                      
                 } 
                 if(line.equals(contrato)){
                      sus = no;
                      
                 } 
                 
                  if (line.equals("X") && buscaX ==0){
                     entrecalles = no;
                     buscaX = 1;
                     
                 }
                 
                 if (line.equals("X") && buscaX ==1){
                     callef = no;
                     buscaX = 1;
                     
                 }
                 
                if(cont ==0){
                     if(line.equals("Amigo/a") || line.equals("Hijo/a")|| line.equals("Abuelo/a") || line.equals("Asistente")|| line.equals("Caseta")
                             || line.equals("Concu?o/a")|| line.equals("Cunado/a")|| line.equals("Empleado/a")|| line.equals("Esposo/a")|| line.equals("Hermano/a")
                             || line.equals("Madrastra")|| line.equals("Madre")|| line.equals("Nieto/a")|| line.equals("Nuera")|| line.equals("Padre")
                             || line.equals("Primo/a")|| line.equals("Representante Legal")|| line.equals("Sobrino/a")|| line.equals("Suegro/a")|| line.equals("Tecnico")
                             || line.equals("Tio/a")|| line.equals("Vecino/a")|| line.equals("Yerno")){
                      ref = no;
                      cont++;
                 }
                    
                }
                 
                 if(line.contains("*"+contrato.substring(0, contrato.length()-3)) ){
                      contra = no;
                      
                 }
                 
                  if(line.equals(contrato) ){
                      lada = no;
                      
                 }
                 
                if(line.contains("CHIH.")){
                      edo = "Chihuahua";
                      
                  }
                  if(line.contains("B.C.")){
                      edo = "Baja California";
                      
                  }
                  if(line.contains("SIN.")){
                      edo = "Sinaloa";
                      
                  }
                  if(line.contains("S.L.P.")){
                      edo = "San Luis Potosí";
                      
                  }
                  if(line.contains("VER.")){
                      edo = "Veracruz";
                      
                  }
                  if(line.contains("HGO.")){
                      edo = "Hidalgo";
                      
                  }
                  if(line.contains("DGO.")){
                      edo = "Durango";
                      
                  }
                  if(line.contains("TAMPS.")){
                      edo = "Tamaulipas";
                      
                  }
                  if(line.contains("SON.")){
                      edo = "Sonora";
                      
                  }
                  if(line.contains("N.L.")){
                      edo = "Nuevo León";
                      
                  }
                  
                   if(line.contains("NAY.")){
                      edo = "Nayarit";
                      
                  }
                  if(line.contains("COAH.")){
                      edo = "Coahuila";
                      
                  }
               
               
                 
                 
             }  
             
             if(habilitar==0){
                JOptionPane.showMessageDialog(null,"Proceso no autorizado","Advertencia",JOptionPane.ERROR_MESSAGE);
               
                 System.exit(0);
             }
             
               
//               System.out.println(sus);
                
               
               
               //--------------------
               
              suscriptor = lines[contra];
              suscriptor = suscriptor.toUpperCase();
               telefono = lines[lada-5] + " "+lines[1];
               calle = lines[callef -3];
               noEx = lines[ref-2];
//               noInt = lines[];

               String calles = lines[entrecalles];
               
               
                entreCalle = JOptionPane.showInputDialog("Entre calle No1:", calles);               
               yCalle = calles.substring(0,calles.indexOf(entreCalle));            
              
               municipio = lines[contra + 2];
               
               
               //edo = lines[edos];
               cp = lines[callef-2];
               colonia = lines[callef];
               
               


            datos.add(contrato);
            datos.add(suscriptor);
            datos.add(telefono);
            datos.add(calle);
            datos.add(noEx);
            datos.add(entreCalle);
            datos.add(yCalle);
            datos.add(municipio);
            datos.add(edo);
            datos.add(cp);
            datos.add(colonia);
//            datos.add(noInt);
//            datos.add(telefono2);

            datos.add("");
            datos.add("");
            
        }catch(Exception e){
            e.printStackTrace();
        } 
         
         return datos;
    
    }
    
}
