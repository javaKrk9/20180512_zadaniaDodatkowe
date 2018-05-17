package empik;

import java.util.Date;

public abstract class CMultimedia extends CItem{

    private int productionDate;

    public CMultimedia(int id, String name, Double price, int productionDate) {
        super(id, name, price);
        this.productionDate = productionDate;
    }

    public int getProductionDate() {
        return productionDate;
    }

    @Override
    public Double countPrice() {
        Date now = new Date();
        float discount = (float)(100 - (now.getYear()-productionDate));
        return this.getPrice()*discount;
    }

    @Override
    public String toString() {
        return super.toString() +", " + productionDate;
    }
}
