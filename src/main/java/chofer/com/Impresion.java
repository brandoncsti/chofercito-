package chofer.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.*;
import com.jcraft.jsch.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import java.io.FileInputStream;

public class Impresion {

    public  static  void main(String[] args) {

        String localPath="/Users/Usuario/Desktop/sftp-testing";
        String fileName = "prueba";
        String sftpPath="/public_html";
        String sftpHost="files.000webhost.com";
        String sftpPort ="21";
        String sftpUser="portafoliobruce";
        String sftpPassword="MARVEL123m";

        try{
            /**
             * Open session to sftp server
             */
            JSch jsch = new JSch();
            Session session = jsch.getSession(sftpUser, sftpHost, Integer.valueOf(sftpPort));
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(sftpPassword);
            System.out.println("Connecting------");
            session.connect();
            System.out.println("Established Session");

            Channel channel = session.openChannel("sftp");
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.connect();

            System.out.println("Opened sftp Channel");

            /**
             * Do everything you need in sftp
             */
            System.out.println("Copying file to Host");
            sftpChannel.put(localPath+"/"+fileName, sftpPath);
            System.out.println("Copied file to Host");



            sftpChannel.disconnect();
            session.disconnect();

            System.out.println("Disconnected from sftp");

        } catch(Exception e) {
            e.printStackTrace();
        }

        //System.out.println("hola mundo");
        //imprimirDirecto("url",0 );
    }


    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     public  static void imprimirDirecto(String url, int i) {
     FileInputStream archivo;

     // logger.error("mis parametror url: {}",url);
     //logger.error("mis parametror i: {}",i);
     try {
     //el archivo debe estar en la dirección del campo url
     archivo =new FileInputStream(url);
     DocFlavor formato = DocFlavor.INPUT_STREAM.PNG;
     Doc documento = new SimpleDoc(archivo, formato, null);
     PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

     //Configuración de la impresora
     aset.add(MediaSizeName.NA_LETTER);
     //Elección tamaño de la hoja (carta o A4)
     //aset.add(MediaSizeName.ISO_A4);
     aset.add(new Copies(1));
     //aset.add(Chromaticity.MONOCHROME);
     // aset.add(OrientationRequested.PORTRAIT);
     // Busqueda de impresoras
     PrintService[] services =
     PrintServiceLookup.lookupPrintServices(formato, aset);
     // creación de orden de impresión
     if (services.length > 0) {
     DocPrintJob job = services[i].createPrintJob();
     try {
     //logger.error("Ingreso");
     job.print(documento, aset);
     } catch (PrintException pe) {}
     }
     }catch(Exception e){

     }
     }
     **/




}