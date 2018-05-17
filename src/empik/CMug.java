package empik;

public class CMug extends CItem{

    public CMug(int id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public Double countPrice() {
        return getPrice();
    }
}
