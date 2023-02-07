package chofer.com.jco.docmaterial.service.impl;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.atomic.AtomicBoolean;

public class JCODocumentoMaterialServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AtomicBoolean daProcessing = new AtomicBoolean(false);

    @Value("${my_destination}")
    private String destinationProfit;

    //modificar





    private void mapFilters(JCoFunction function, String parametro1, String parametro2, boolean extraccionUnicoDocumento) {
        JCoParameterList paramList = function.getImportParameterList();

        if(extraccionUnicoDocumento){
            JCoTable jcoTableEBELN = paramList.getTable("my_table");

            if (parametro1 != null && !parametro1.isEmpty()) {
                jcoTableEBELN.appendRow();
                jcoTableEBELN.setRow(0);
                jcoTableEBELN.setValue("SIGN", "I");
                jcoTableEBELN.setValue("OPTION", "EQ");
                jcoTableEBELN.setValue("LOW", parametro1); // parametro numero orden compra a la cual se extraera sus doc aceptacion
                jcoTableEBELN.setValue("HIGH", "");
            }
        }
        else {
            if (parametro1 != null && !parametro1.isEmpty())
                paramList.setValue("I_CPUDTI", parametro1); // parametro fecha inicio desde la cual se extraera los doc aceptacion

            if (parametro2 != null && !parametro2.isEmpty())
                paramList.setValue("I_CPUDTF", parametro2); // parametro fecha fin hasta la cual se extraera los doc aceptacion
        }
    }

}
