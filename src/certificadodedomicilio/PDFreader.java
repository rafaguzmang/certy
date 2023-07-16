
package certificadodedomicilio;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;


public class PDFreader {
    
    public PDFreader(){
    
    }
    
    public ArrayList<String> reader(String url,String archivo,String distribuidor){
     
    VeTv leerContrato = new VeTv(); 
    Basico leerBasico = new Basico();
    contratosHD leerContratoHD = new contratosHD();
    ArrayList<String> datos = new ArrayList<String>();
    String contrato;

    
    String texto = "No. Registro PROFECO: _253/2019. Fecha 27/08/19";
    String texto2 = "COMBO BASICO";
        
         try{
            
            String URL = url+"\\" + archivo;
            File file = new File(URL);
            
            PDDocument pd = PDDocument.load(file);
            
            pd.getClass();
            
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);
            
             PDFTextStripper tsStripper =  new PDFTextStripper();
             
             String pdfFileInText = tsStripper.getText(pd);
             
             contrato = URL.substring(URL.lastIndexOf("\\") +1, URL.indexOf(".pdf"));
             if(pdfFileInText.contains(texto)){
             
                datos = leerContrato.VeTv(pdfFileInText, contrato);
             }else if(pdfFileInText.contains(texto2)){
             
                datos = leerBasico.basico(pdfFileInText, contrato);
                
             }else{
             
                 datos = leerContratoHD.contratosHD(pdfFileInText, contrato);
             
             
             }
        }catch(Exception e){
            e.printStackTrace();
        } 
         
         return datos;
    }
}
