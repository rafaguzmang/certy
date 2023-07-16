/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificadodedomicilio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Rafael
 */
public class EXcellFile {
    
    public EXcellFile(){}
    
    
    public void modificar(ArrayList<String> datos, String path, String [] archivos, String date, String cuen, String activa, String lat, String longi){
         
        try {
            File url = new File(path +"\\Certificado de Domicilio v1.4.xlsx");
            //System.getProperty("user.dir");
//            File url = new File("C:\\Users\\zopha\\Desktop\\pruebaEXCELL.xlsx");
             if(url.exists()==false){
                 
                JOptionPane.showMessageDialog(null, "Missing File Certificado de Domicilio v1.4.xlsx");
                System.exit(0);
            }

            FileInputStream file = new FileInputStream(url);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
//            XSSFSheet sheet2 = workbook.getSheetAt(1);
            
//            datos.add(suscriptor);
//            datos.add(telefono);
//            datos.add(calle);
//            datos.add(noEx);
//            datos.add(entreCalle);
//            datos.add(yCalle);
//            datos.add(municipio);
//            datos.add(edo);
//            datos.add(cp);

            // Inserta datos
            XSSFRow contrato = sheet.getRow(7);
            contrato.getCell(6).setCellValue(datos.get(0));
            
            XSSFRow suscriptor = sheet.getRow(9);
            suscriptor.getCell(4).setCellValue(datos.get(1));
            
            XSSFRow telefono = sheet.getRow(11);
            telefono.getCell(2).setCellValue(datos.get(2));
            
            XSSFRow telefono2 = sheet.getRow(11);
            if(!String.valueOf(telefono2.getCell(5)).equals("")){
                telefono2.getCell(5).setCellValue(datos.get(12));
            }
            
            XSSFRow calle = sheet.getRow(14);
            calle.getCell(2).setCellValue(datos.get(3));
            
            XSSFRow noEx = sheet.getRow(16);
            noEx.getCell(2).setCellValue(datos.get(4));
            
            XSSFRow entreCalle = sheet.getRow(18);
            entreCalle.getCell(2).setCellValue(datos.get(5));
            
            XSSFRow yCalle = sheet.getRow(18);
            yCalle.getCell(5).setCellValue(datos.get(6));
            
            XSSFRow municipio = sheet.getRow(22);
            municipio.getCell(3).setCellValue(datos.get(7));
            
            XSSFRow edo = sheet.getRow(22);
            edo.getCell(5).setCellValue(datos.get(8));
            
            XSSFRow cp = sheet.getRow(22);
            cp.getCell(7).setCellValue(datos.get(9));
            
            XSSFRow colonia = sheet.getRow(20);
            colonia.getCell(2).setCellValue(datos.get(10));
            
            XSSFRow noInt = sheet.getRow(16);
            noInt.getCell(5).setCellValue(datos.get(11));
            
            XSSFRow cuenta = sheet.getRow(7);
            cuenta.getCell(2).setCellValue(cuen);
            
            XSSFRow fecha = sheet.getRow(4);
             if (activa != ""){
                fecha.getCell(6).setCellValue(activa.substring(0, 2)+"/"+ activa.substring(2, 4) +"/2019");
            }else{
                fecha.getCell(6).setCellValue(activa);
            }
             
            XSSFRow latitud = sheet.getRow(66);
            latitud.getCell(7).setCellValue(lat);
            
            XSSFRow longitud = sheet.getRow(67);
            longitud.getCell(7).setCellValue(longi);
           
            
            //Inserta imagenes
            for(int x=0;x<archivos.length;x++){
                
//                System.out.println(archivos[x]);
//                System.out.println(datos.get(0)+".jpeg");
                
               
            
                if(archivos[x].contains(datos.get(0)+".jpeg")){
                    InputStream img = new FileInputStream(path +"\\"+ datos.get(0)+".jpeg");
                    byte[]bytes = IOUtils.toByteArray(img);
                    int picture = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);

                    img.close();

                    CreationHelper helper = workbook.getCreationHelper();
                    Drawing drawing = sheet.createDrawingPatriarch();
                    ClientAnchor anchor = helper.createClientAnchor();

                    anchor.setCol1(2);
                    anchor.setRow1(28);   
                    anchor.setCol2(6);
                    anchor.setRow2(42);

                    Picture pict = drawing.createPicture(anchor, picture);
                }
                
                 if(archivos[x].contains(datos.get(0)+"g.jpeg")){
                    InputStream img2 = new FileInputStream(path +"\\"+ datos.get(0)+"g.jpeg");
                    byte[]bytes2 = IOUtils.toByteArray(img2);
                    int picture2 = workbook.addPicture(bytes2, Workbook.PICTURE_TYPE_JPEG);

                    img2.close();

                    CreationHelper helper2 = workbook.getCreationHelper();
                    Drawing drawing2 = sheet.createDrawingPatriarch();
                    ClientAnchor anchor2 = helper2.createClientAnchor();

                    anchor2.setCol1(2);
                    anchor2.setRow1(44);   
                    anchor2.setCol2(8);
                    anchor2.setRow2(61);

                    Picture pict2 = drawing2.createPicture(anchor2, picture2);
                }
                
//                if(archivos[x].contains(datos.get(0)+"ID.jpeg")){
//                    InputStream img3 = new FileInputStream(path +"\\"+ datos.get(0)+"ID.jpeg");
//                    byte[]bytes3 = IOUtils.toByteArray(img3);
//                    int picture3 = workbook.addPicture(bytes3, Workbook.PICTURE_TYPE_JPEG);
//
//                    img3.close();
//
//                    CreationHelper helper3 = workbook.getCreationHelper();
//                    Drawing drawing3 = sheet2.createDrawingPatriarch();
//                    ClientAnchor anchor3 = helper3.createClientAnchor();
//
//                    anchor3.setCol1(2);
//                    anchor3.setRow1(44);   
//                    anchor3.setCol2(8);
//                    anchor3.setRow2(61);
//
//                    Picture pict3 = drawing3.createPicture(anchor3, picture3);
//                }
            
            }
            
            
            

            file.close();
            FileOutputStream output = new FileOutputStream(path +"\\"+date+ "\\"+datos.get(0)+".xlsx");
            workbook.write(output);
            output.close();
            
                


            
        } catch (IOException ex) {
            Logger.getLogger(EXcellFile.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
            
       
    
    
    }
    
    
    
    
}
