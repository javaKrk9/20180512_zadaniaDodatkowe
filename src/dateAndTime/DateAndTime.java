package dateAndTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateAndTime {

    public static void main(String[] args)
    {
        // write your code here

        Calendar mydate = new GregorianCalendar();
        String mystring = "October 26, 1987";
        Date thedate = null;
        try {
            thedate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mystring);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mydate.setTime(thedate);

        System.out.println(mydate.getTimeInMillis());

        Date now = new Date();
        System.out.println(getDateDiff(thedate,now, TimeUnit.DAYS));
        System.out.println(getDateDiff(thedate,now, TimeUnit.DAYS));
        System.out.println(getDateDiff(thedate,now, TimeUnit.HOURS));
        System.out.println(getDateDiff(thedate,now, TimeUnit.MINUTES));
        System.out.println(getDateDiff(thedate,now, TimeUnit.MILLISECONDS));
        System.out.println();

        Calendar c = Calendar.getInstance();
        c.setTime(thedate);
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.WEEK_OF_YEAR));
        //System.out.println(c.get(Calendar.));


    }

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }


}
