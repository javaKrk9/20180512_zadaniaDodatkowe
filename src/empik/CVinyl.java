package empik;

public class CVinyl extends CItem{

    public CVinyl(int id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public Double countPrice() {
        return getPrice();
    }
}
