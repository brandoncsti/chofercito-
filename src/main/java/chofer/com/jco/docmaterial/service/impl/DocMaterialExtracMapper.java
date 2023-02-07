package chofer.com.jco.docmaterial.service.impl;

import chofer.com.jco.docmaterial.dto.SapTableDocMaterialDTO;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;
public class DocMaterialExtracMapper {

    private JCoParameterList jCoParameterList;

    public static  DocMaterialExtracMapper newMapper(JCoParameterList exportParameterList) {
        return new  DocMaterialExtracMapper(exportParameterList);
    }

    private  DocMaterialExtracMapper(JCoParameterList jCoParameterList){
        this.jCoParameterList = jCoParameterList;
    }

    public SapTableDocMaterialDTO getSapTableDocMaterialDTOList(){
        SapTableDocMaterialDTO sapTableDocMaterialDTOList = new SapTableDocMaterialDTO();
        JCoTable table =jCoParameterList.getTable("mi_table");

        if(table!= null && !table.isEmpty()){
            sapTableDocMaterialDTOList.setDoc_material(table.getInt(""));
        }
        return  sapTableDocMaterialDTOList;
    }
}
