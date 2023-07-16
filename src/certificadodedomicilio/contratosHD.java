/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificadodedomicilio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class contratosHD {
    
    public contratosHD(){
        
    }
    
     public ArrayList<String> contratosHD(String pdfFileInText, String NoContrato){
        
    ArrayList<String> datos = new ArrayList<String>();
    String contrato = NoContrato;
    String suscriptor="";
    String telefono;
    String telefono2="";
    String calle;
    String noEx;
    String noInt="";
    String entreCalle;
    String yCalle;
    String municipio;
    String edo="";
    String cp;
    String referencia;
    String colonia;
        
         try{
            
            
               pdfFileInText = pdfFileInText.substring(pdfFileInText.indexOf("$ 259.00 $ 500.00 $ 125.00")+26 , 
                            pdfFileInText.indexOf("Para “Servicio a Clientes” marcar al 55 51 69 00 00. Consulta el aviso de privacidad en www.sky.com.mx    V1-2019"));
             
             
            String formato[] = pdfFileInText.split("\\r?\\n");
            for(int lin = 0; lin<4;lin++){
                 
                 //System.out.println(formato[lin]);
                 if (formato[lin].equals("X") ){
                     pdfFileInText = pdfFileInText.substring(pdfFileInText.indexOf("X")+1, pdfFileInText.length());
                     
                 }
             
             }
            
             
             
             String lines[] = pdfFileInText.split("\\r?\\n");
            
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
             int lada=0;
             int tel2=0;
            
             
             
             for (String line : lines){
                 System.out.println(no++ + " "+ line);
                 
                 
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


            
                if (line.equals("X") && buscaX ==1){
                     callef = no;
                     buscaX ++;
                     
                 }
                  
                  
                 if (line.equals("X") && buscaX ==0){
                     entrecalles = no;
                     buscaX ++;
                     
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
                      tel2 = no;
                  }
                  if(line.contains("B.C.")){
                      edo = "Baja California";
                      tel2 = no;
                  }
                  if(line.contains("SIN.")){
                      edo = "Sinaloa";
                      tel2 = no;
                  }
                  if(line.contains("S.L.P.")){
                      edo = "San Luis Potosí";
                      tel2 = no;
                  }
                  if(line.contains("VER.")){
                      edo = "Veracruz";
                      tel2 = no;
                  }
                  if(line.contains("HGO.")){
                      edo = "Hidalgo";
                      tel2 = no;
                  }
                  if(line.contains("DGO.")){
                      edo = "Durango";
                      tel2 = no;
                  }
                  if(line.contains("TAMPS.")){
                      edo = "Tamaulipas";
                      tel2 = no;
                  }
                  if(line.contains("SON.")){
                      edo = "Sonora";
                      tel2 = no;
                  }
                  if(line.contains("N.L.")){
                      edo = "Nuevo León";
                      tel2 = no;
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
             
               suscriptor = lines[contra];
               if(lines[1].contains("@")){
                   telefono = lines[contra+1] + " "+lines[1].substring(0, lines[1].indexOf(" "));
               }else{
                   telefono = lines[contra+1] + " "+lines[1];
               }
               calle = lines[callef -2];
               noEx = lines[ref-3];
//               noInt = lines[];

               String calles = lines[30];
               
//               JOptionPane
               entreCalle = JOptionPane.showInputDialog("Entre calle No1:", calles);               
               yCalle = calles.substring(0,calles.indexOf(entreCalle));             
              
               municipio = lines[contra + 2];
               
               
//               edo = lines[edos];
               cp = lines[callef];
               colonia = lines[lines.length-2];
                
                suscriptor= suscriptor.toUpperCase();
             
             
             System.out.println("Contrato: "+contrato);
             System.out.println("Suscriptor: "+suscriptor);
             System.out.println("Telefono: "+telefono);
             System.out.println("Calle: "+calle);
             System.out.println("No exterior: "+noEx);
 //            System.out.println(noInt);
             System.out.println("Entre calle: "+entreCalle);
             System.out.println("Y calle: "+yCalle);
             System.out.println("Municipio: "+municipio);
             System.out.println("Estado: "+edo);
             System.out.println("Codigo postal: "+cp);
//             System.out.println(referencia);

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
            datos.add(noInt);
            datos.add(telefono2);
            
            
        }catch(Exception e){
            e.printStackTrace();
        } 
         
         return datos;
    }
}
