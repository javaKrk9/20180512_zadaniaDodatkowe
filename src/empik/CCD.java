package empik;

import java.util.Date;

public class CCD extends CMultimedia {


    public CCD(int id, String name, Double price, int productionDate) {
        super(id, name, price, productionDate<1982?1982:productionDate);
    }


}
