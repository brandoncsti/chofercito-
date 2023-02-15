package chofer.com;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import java.nio.charset.Charset;

public class ImprecionC {



    public  static  void main(String[] args) throws PrintException {
        //imprimirDirecto("HOLA",0);
        imprimirSFTP("Imprimiendo desde SFTP",0);
    }

    public  static void imprimirSFTP(String contenido, int i) {

        try {
            //el archivo debe estar en la dirección del campo url
            byte[] bytes = new String(contenido).getBytes(Charset.forName("Cp858"));

            DocFlavor formato = DocFlavor.BYTE_ARRAY.AUTOSENSE;;
            Doc documento = new SimpleDoc(bytes, formato, null);

           //PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
            System.out.println("Imprimiendo...");
            //Configuración de la impresora
            //aset.add(MediaSizeName.NA_LETTER);
            //Elección tamaño de la hoja (carta o A4)
            //aset.add(MediaSizeName.ISO_A4);
            //aset.add(new Copies(1));
            //aset.add(Chromaticity.MONOCHROME);
            // aset.add(OrientationRequested.PORTRAIT);
            // Busqueda de impresoras
            PrintService[] services =
                    PrintServiceLookup.lookupPrintServices(formato,null);
            // creación de orden de impresión
            if(services.length > 0) {
                DocPrintJob pj = services[i].createPrintJob();
                try {
                    //logger.error("Ingreso");
                    pj.print(documento,null);
                } catch (PrintException pe) {}
            }


        } catch (Exception e) {

        }


    }
    /**
    public  static void imprimirSFTP() throws PrintException{
        byte[] bytes = new String("HOLA").getBytes(Charset.forName("Cp858"));
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        DocPrintJob pj = service.createPrintJob();
        Doc doc = new SimpleDoc(bytes, flavor, null);
        pj.print(doc, null);
    }
**/
}


