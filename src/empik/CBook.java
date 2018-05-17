package empik;

public class CBook extends CItem{

    private int pageNumber;

    public CBook(int id, String name, Double price, int pageNumber)
    {
        super(id, name, price);
        this.pageNumber = pageNumber;
    }

    public int getPageNumber()
    {
        return pageNumber;
    }

    @Override
    public Double countPrice()
    {
        int discount = (pageNumber/100)*10>40?40:(pageNumber/100)*10;
        return this.getPrice()*(float)((100-discount)/100);
    }

    @Override
    public String toString()
    {
        return super.toString()+", "+pageNumber;
    }
}
