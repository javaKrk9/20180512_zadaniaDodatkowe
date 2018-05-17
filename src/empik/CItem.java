package empik;

public abstract class CItem {

    private int id;
    private String name;
    private Double price;

    public CItem(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public abstract Double countPrice();

    @Override
    public String toString() {
        return name;
    }
}
