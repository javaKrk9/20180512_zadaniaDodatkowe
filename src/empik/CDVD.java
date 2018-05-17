package empik;

public class CDVD extends CMultimedia{


    public CDVD(int id, String name, Double price, int productionDate) {
        super(id, name, price, productionDate<1995?1995:productionDate);
    }

    @Override
    public Double countPrice() {
        return null;
    }
}
