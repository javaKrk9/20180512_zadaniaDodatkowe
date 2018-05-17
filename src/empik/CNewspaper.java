package empik;

public class CNewspaper extends CItem{

    private boolean gratis = false;

    public CNewspaper(int id, String name, Double price)
    {
        super(id, name, price);
    }

    public boolean isGratis() {
        return gratis;
    }

    public void setGratis(boolean gratis) {
        this.gratis = gratis;
    }

    @Override
    public Double countPrice()
    {
        if(gratis) return 0.0d;
        else return this.getPrice();
    }
}
