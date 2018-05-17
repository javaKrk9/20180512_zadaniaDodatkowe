package empik;

public class CPoster extends CItem{

    boolean for1pln = false;

    public CPoster(int id, String name, Double price) {
        super(id, name, price);
    }

    public boolean isFor1pln() {
        return for1pln;
    }

    public void setFor1pln(boolean for1pln) {
        this.for1pln = for1pln;
    }

    @Override
    public Double countPrice()
    {
        if (isFor1pln())return 1.0d;
        else return this.getPrice();
    }
}
