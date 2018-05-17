package empik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CShoppingCart {

    ArrayList<CItem> cartContent;

    public CShoppingCart() {
        this.cartContent = new ArrayList<>();
    }

    public void addItemToCart(CItem cItem)
    {
        this.cartContent.add(cItem);
    }

    public void removeItemFromCart(int id)
    {
        this.cartContent.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
    }

    public void removeItemFromCart(CItem cItem)
    {
        this.cartContent.stream().filter(e->e.equals(cItem)).collect(Collectors.toList());
    }

    public void removeItemFromCart(String name)
    {
        this.cartContent.stream().filter(e->!e.getName().equals(name)).collect(Collectors.toList());
    }

    public String returnCartContent()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.cartContent.stream().forEach(e->stringBuilder.append(formatItemString(e)+"\n"));
        return stringBuilder.toString();
    }

    private String formatItemString(CItem cItem)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(formatLine(String.valueOf(cItem.getId()),10));
        sb.append("|");
        sb.append(formatLine(cItem.toString(),40));
        sb.append("|");
        sb.append(formatLine(String.valueOf(cItem.getPrice()), 20));
        sb.append("|");
        sb.append(formatLine(String.valueOf(cItem.countPrice()), 20));
        return sb.toString();
    }

    private String formatLine(String string, int space)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(string);
        for(int i=0; i<space-string.length()-1; i++)
        {
            sb.append(" ");
        }
        return sb.toString();
    }

    public Double countPrice()
    {
        Double sum = 0.0d;

        sum = sum + cartContent.stream()
                .filter(e->e.getClass().toString().equals("CBook"))
                .mapToDouble(e->e.countPrice()).sum();

        sum = sum + cartContent
                .stream()
                .filter(e->e.getClass().toString().equals("CCD"))
                .mapToDouble(e->e.countPrice()).sum();

        sum = sum + cartContent
                .stream()
                .filter(e->e.getClass().toString().equals("CDVD"))
                .mapToDouble(e->e.countPrice()).sum();

        sum = sum + cartContent
                .stream()
                .filter(e->e.getClass().toString().equals("CVinyl"))
                .mapToDouble(e->e.countPrice()).sum();

        sum = sum + countPostersPrice(cartContent
                .stream()
                .filter(e->e.getClass().toString().equals("CPoster"))
                .collect(Collectors.toList()));

        sum = sum + countGamesPrice(cartContent
                .stream()
                .filter(e->e.getClass().toString().equals("CGame"))
                .collect(Collectors.toList()));

        sum = sum + cartContent
                .stream()
                .filter(e->e.getClass().toString().equals("CMug"))
                .mapToDouble(e->e.countPrice()).sum();

        sum = sum + countNewspapersPrice(cartContent
                .stream()
                .filter(e->e.getClass().toString().equals("CNewspaper"))
                .collect(Collectors.toList()),(int)cartContent
                .stream()
                .filter(e->e.getClass().toString().equals("CMug"))
                .mapToDouble(e->e.countPrice()).count());

        if(sum>100.0d) sum = sum*0.95d;

        return sum;
    }

    private Double countPostersPrice(List<CItem> posterList)
    {
        if(posterList.size()<3)
        {
            return posterList
                    .stream()
                    .mapToDouble(e -> e.countPrice()).sum();
        }
        else
        {
            Collections.sort(posterList, new Comparator<CItem>() {
                public int compare(CItem cItem1, CItem cItem2) {
                    if(cItem1.getPrice()>cItem2.getPrice())
                        return 1;
                    else if (cItem1.getPrice()==cItem2.getPrice())
                        return 0;
                    else return -1;
                }
            });
            CPoster cPoster = (CPoster)posterList.get(posterList.size()-1);
            cPoster.setFor1pln(true);
            return posterList
                    .stream()
                    .mapToDouble(e -> e.countPrice()).sum();
        }
    }

    private Double countGamesPrice(List<CItem> itemsList)
    {
        if(itemsList.size()<3)
        {
            return itemsList
                    .stream()
                    .mapToDouble(e -> e.countPrice()).sum();
        }
        else
        {
            List<CGame> gamesList = itemsList.stream().map(e->(CGame)e).collect(Collectors.toList());

            Collections.sort(gamesList, new Comparator<CGame>() {
                public int compare(CGame cGame1, CGame cGame2) {
                    int res = cGame1.getProducerName().compareTo(cGame1.getProducerName());
                    if(res!=0)return res;
                    else {
                        if (cGame1.getPrice() > cGame2.getPrice())
                            return 1;
                        else if (cGame1.getPrice() == cGame2.getPrice())
                            return 0;
                        else return -1;
                    }
                }
            });

            for(int i=2; i<gamesList.size(); i++)
            {
                    if (gamesList.get(i-2).getProducerName().equals(gamesList.get(i-1).getProducerName())
                            && gamesList.get(i-1).getProducerName().equals(gamesList.get(i).getProducerName()) )
                    {
                        gamesList.get(i).setGratis(true);
                        i=i+3;
                    }
            }

            return gamesList
                    .stream()
                    .mapToDouble(e -> e.countPrice()).sum();
        }
    }

    private Double countNewspapersPrice(List<CItem> itemsList, int gratis)
    {
        if(gratis==0)
        {
            return itemsList
                    .stream()
                    .mapToDouble(e -> e.countPrice()).sum();
        }
        else
        {
            List<CNewspaper> newspapersList = itemsList.stream().map(e->(CNewspaper)e).collect(Collectors.toList());

            Collections.sort(newspapersList, new Comparator<CItem>() {
                public int compare(CItem cItem1, CItem cItem2) {
                    if(cItem1.getPrice()>cItem2.getPrice())
                        return 1;
                    else if (cItem1.getPrice()==cItem2.getPrice())
                        return 0;
                    else return -1;
                }
            });

            CNewspaper cNewspaper = (CNewspaper)newspapersList.get(newspapersList.size()-1);
            cNewspaper.setGratis(true);
            return newspapersList
                    .stream()
                    .mapToDouble(e -> e.countPrice()).sum();
        }
    }


}
