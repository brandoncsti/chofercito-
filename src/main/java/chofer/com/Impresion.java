package chofer.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import java.io.FileInputStream;

public class Impresion {

    public  static  void main(String[] args) {
        //System.out.println("hola mundo");
        imprimirDirecto("url",0 );
    }

    public Impresion() {
    }
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
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