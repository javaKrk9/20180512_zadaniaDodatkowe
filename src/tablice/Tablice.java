package tablice;

public class Tablice {

    public static void main(String[] args)
    {
        int[] integers = new int[]{1, 3, 5, 2, 5, 6, 7, 4, 9, 7};

        System.out.println("All numbers");
        a_printAllNumbers(integers);
        System.out.println();

        System.out.println("First 6 numbers");
        b_print6FirstNumbers(integers);
        System.out.println();

        System.out.println("Last 6 numbers");
        c_print6LastNumbers(integers);
        System.out.println();

        System.out.println("Last odd numbers");
        d_printOddNumbers(integers);
        System.out.println();

        System.out.println("Even Indexed numbers");
        e_printEvenIndexedNumbers(integers);
        System.out.println();

        System.out.println("Backward All numbers");
        f_printBackwardAllNumbers(integers);
        System.out.println();

        System.out.println("All Numbers Except 5");
        g_printAllNumbersExcept5(integers);
        System.out.println();

        System.out.println("All Numbers Under 8");
        h_printAllNumbersUnder8(integers);
        System.out.println();

        System.out.println("All Numbers Divided By 3");
        i_printAllNumbersDividedBy3(integers);
        System.out.println();

        System.out.println("Sum Of All Numbers");
        j_printSumOfAllNumbers(integers);
        System.out.println();

        System.out.println("Sum Of All Numbers Over 4");
        k_printSumOfAllNumbersOver4(integers);
        System.out.println();

        System.out.println("Min And Max Number");
        l_printMinAndMaxNumber(integers);
        System.out.println();
    }

    private static void a_printAllNumbers(int[] integers)
    {
        for (int integer: integers)
        {
            System.out.println(integer);
        }
    }

    private static void b_print6FirstNumbers(int[] integers)
    {
        for (int i=0; i<6; i++)
        {
            System.out.println(integers[i]);
        }
    }

    private static void c_print6LastNumbers(int[] integers)
    {
        for (int i=integers.length-6; i<integers.length; i++)
        {
            System.out.println(integers[i]);
        }
    }

    private static void d_printOddNumbers(int[] integers)
    {
        for (int i=0; i<integers.length; i++)
        {
            if(integers[i]%2==0)
            System.out.println(integers[i]);
        }
    }

    private static void e_printEvenIndexedNumbers(int[] integers)
    {
        for (int i=0; i<integers.length; i++)
        {
            if(i%2==1)
                System.out.println(integers[i]);
        }
    }

    private static void f_printBackwardAllNumbers(int[] integers)
    {
        for (int i=integers.length-1; i>=0; i--)
        {
             System.out.println(integers[i]);
        }
    }

    private static void g_printAllNumbersExcept5(int[] integers)
    {
        for (int i=0; i<integers.length; i++)
        {
            if(integers[i]!=5)
            System.out.println(integers[i]);
        }
    }

    private static void h_printAllNumbersUnder8(int[] integers)
    {
        for (int i=0; i<integers.length; i++)
        {
            if(integers[i]<=7)
                System.out.println(integers[i]);
        }
    }

    private static void i_printAllNumbersDividedBy3(int[] integers)
    {
        for (int i=0; i<integers.length; i++)
        {
            if(integers[i]%3==0)
                System.out.println(integers[i]);
        }
    }

    private static void j_printSumOfAllNumbers(int[] integers)
    {
        int sum=0;
        for (int i=0; i<integers.length; i++)
        {
            sum+=integers[i];
        }
        System.out.println(sum);
    }

    private static void k_printSumOfAllNumbersOver4(int[] integers)
    {
        int sum=0;
        for (int i=0; i<integers.length; i++)
        {
            if(integers[i]>=4)
            sum+=integers[i];
        }
        System.out.println(sum);
    }

    private static void l_printMinAndMaxNumber(int[] integers)
    {
        int min=integers[0],max=integers[0];
        for (int i=1; i<integers.length; i++)
        {
            min=min<integers[i]?min:integers[i];
            max=max>integers[i]?max:integers[i];

        }
        System.out.println("Min= "+min+", Max="+max);
    }

}

//    Przy użyciu jednej z pętli, napisz fragment kodu, który wypisze:
//        a. wszystkie cyfry
//        b. 6 pierwszych cyfr
//        c. 6 ostatnich cyfr
//        d. wszystkie parzyste cyfry
//        e. wszystkie cyfry na nieparzystych indeksach
//        f. wszystkie cyfry od tyłu
//        g. wszystkie cyfry oprócz cyfry 5
//        h. wszystkie cyfry do cyfry 7 włącznie
//        i. wszystkie cyfry podzielne przez 3
//        j. sumę wszystkich cyfr
//        k. sumę cyfr większych lub równych 4
//        l. najmniejszą i największą liczbę