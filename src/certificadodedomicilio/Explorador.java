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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class Explorador {
    
    public Explorador(){
          ArrayList<String> datos = new ArrayList<String>();  
        ArrayList<String> datosFaltantes = new ArrayList<String>(); 
        PDFreader reader = new PDFreader();
        EXcellFile excell = new EXcellFile();
        ListaPDFs lista = new ListaPDFs();
        DatosFaltantes faltantes = new DatosFaltantes();
        JFileChooser chooser = new JFileChooser();
        Tabla listadoDatos = new Tabla();
        
        
        
        int empty=0;
        String fileTxt = "";
        String cuenta="";
        String fechaAct="";
        String latitud="";
        String longitud="";
        
        Date fecha = new Date();        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateDemo = dateFormat.format(fecha);
        //System.out.println(dateDemo);
        dateDemo = dateDemo.substring(0, 2)+dateDemo.substring(3, 5)+dateDemo.substring(dateDemo.lastIndexOf("/")+1, dateDemo.length());
        System.out.println(dateDemo);
        //Abre el explorador de busqueda
        chooser.showOpenDialog(chooser);
        File path = chooser.getSelectedFile();
        String spath = path.getParent(); 
        
        File directorio = new File(spath +"\\" + dateDemo);
        directorio.mkdir();  
        //Lista con los nombres de todos lo archivos en la carpeta
        
        String [] archivosPDF = lista.Archivos(spath);
        
        for(String textFile : archivosPDF){
            if (textFile.contains(".txt")){
                fileTxt = textFile;
               
            }
        }
        
        
        
        
        //Separa los contratos de los demas archivos
        
        SplashScreen on = new SplashScreen();
       
         on.Wait();
        for(int x=0; x<archivosPDF.length;x++){
            //System.out.println(archivosPDF[x]);
            if(archivosPDF[x].contains(".pdf") && archivosPDF[x].substring(0, archivosPDF[x].lastIndexOf(".")).matches("[0-9]*") ){
                 
               
                datos = reader.reader(spath, archivosPDF[x],"");
                
                if(fileTxt != ""){
                    
                    datosFaltantes = faltantes.faltantes(spath, archivosPDF[x].substring(0, archivosPDF[x].lastIndexOf(".")), fileTxt);
                     cuenta=datosFaltantes.get(0);
                     fechaAct=datosFaltantes.get(1);
                     latitud=datosFaltantes.get(2);
                     longitud=datosFaltantes.get(3);
                }
                excell.modificar(datos, spath, archivosPDF, dateDemo, cuenta, fechaAct, latitud, longitud); 
                listadoDatos.Tabla(datos, spath, archivosPDF, dateDemo, cuenta, fechaAct, latitud, longitud, dateDemo);
                empty++;
               
            }
            
            
         
        }
        
        
        if (empty == 0){
             JOptionPane.showMessageDialog(null, "No hay contratos en la carpeta Certy!");
             System.exit(0);
        }
        
        
        on.Wait();
        
    }
}
