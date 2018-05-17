package empik;

public class CGame extends CItem{

    private String producerName;
    private boolean gratis = false;

    public CGame(int id, String name, Double price, String producerName) {
        super(id, name, price);
        this.producerName = producerName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public boolean isGratis() {
        return gratis;
    }

    public void setGratis(boolean gratis) {
        this.gratis = gratis;
    }

    @Override
    public Double countPrice() {
        if(isGratis()) return 0.0d;
        else return this.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() +", " + producerName;
    }
}
