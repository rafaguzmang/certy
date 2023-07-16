/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificadodedomicilio;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class Ejecutable {
    
    public Ejecutable(){
        
         ArrayList<String> datos = new ArrayList<String>();   
        ArrayList<String> datosFaltantes = new ArrayList<String>(); 
        CertificadoDeDomicilio lectorDatos = new CertificadoDeDomicilio();        
        int empty =0;   
        DatosFaltantes faltantes = new DatosFaltantes();
        String distribuidor="";
        Tabla listadoDatos = new Tabla();
        
        String clase = "CertyDemo.jar";
        String filePath = CertificadoDeDomicilio.class.getProtectionDomain().getCodeSource().getLocation().toString();
        filePath = filePath.substring(filePath.indexOf(":/")+2, filePath.length()- clase.length());
        //System.out.println(filePath);
        JOptionPane.showMessageDialog(null, filePath);
        
        PDFreader reader = new PDFreader();
        EXcellFile excell = new EXcellFile();
        ListaPDFs lista = new ListaPDFs();
        //JFileChooser chooser = new JFileChooser();
        
        String fileTxt = "";
        String cuenta="";
        String fechaAct="";
        String latitud="";
        String longitud="";
        
        Date fecha = new Date();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateDemo = dateFormat.format(fecha);
        dateDemo = dateDemo.substring(0, 2)+dateDemo.substring(3, 5)+dateDemo.substring(dateDemo.lastIndexOf("/")+1, dateDemo.length());
        
        
         File directorio = new File(filePath +"\\" + dateDemo);
        directorio.mkdir();     
        
        //Lista con los nombres de todos lo archivos en la carpeta
        
        String [] archivosPDF = lista.Archivos(filePath);
        
         for(String textFile : archivosPDF){
            if (textFile.contains(".txt")){
                fileTxt = textFile;
               
            }
        }
         
        SplashScreen on = new SplashScreen();
        //Separa los contratos de los demas archivos
        
        on.Wait();
        for(int x=0; x<archivosPDF.length;x++){
            //System.out.println(archivosPDF[x]);
             //JOptionPane.showMessageDialog(null,archivosPDF[x] );
            if(archivosPDF[x].contains(".pdf") && archivosPDF[x].substring(0, archivosPDF[x].lastIndexOf(".")).matches("[0-9]*") ){
                
             empty++;   
                
                datos = reader.reader(filePath, archivosPDF[x], distribuidor);
                if(fileTxt != ""){
                    
                    datosFaltantes = faltantes.faltantes(filePath, archivosPDF[x].substring(0, archivosPDF[x].lastIndexOf(".")), fileTxt);
                     cuenta=datosFaltantes.get(0);
                     fechaAct=datosFaltantes.get(1);
                     latitud=datosFaltantes.get(2);
                     longitud=datosFaltantes.get(3);
                }
                excell.modificar(datos, filePath, archivosPDF, dateDemo, cuenta, fechaAct, latitud, longitud); 
                listadoDatos.Tabla(datos, filePath, archivosPDF, dateDemo, cuenta, fechaAct, latitud, longitud, dateDemo);
                
            }
         
        }
        
        
        if (empty == 0){
             JOptionPane.showMessageDialog(null, "No hay contratos en la carpeta Certy!");
             System.exit(0);
        }
        
        on.Wait();
        
        System.exit(0);
        
    }
}
