package chofer.com.helpers;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.FileInputStream;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import java.io.FileInputStream;
public class Impresionsftp {

    public void sessionSFTP(String nameArchive){

        String  urls = null;
        String localPath="/Users/Usuario/Desktop/sftp-testing";
        String fileName = nameArchive+".png";
        String sftpPath="/public_html";
        String sftpHost="files.000webhost.com";
        String sftpPort ="21";
        String sftpUser="portafoliobruce";
        String sftpPassword="MARVEL123b";

        //conection

        try{
            /**
             * Open session to sftp server
             */
            JSch jsch = new JSch();
            Session session = jsch.getSession(sftpUser, sftpHost, Integer.valueOf(sftpPort));
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(sftpPassword);
            session.connect();

            System.out.println("Session exitosa");

            Channel channel = session.openChannel("sftp");
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.connect();




            sftpChannel.get(sftpPath+"/"+fileName, localPath);

            imprimirDirecto("",0);

            System.out.println();

            sftpChannel.disconnect();
            session.disconnect();



        } catch(Exception e) {
            e.printStackTrace();
        }


    }

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
}
