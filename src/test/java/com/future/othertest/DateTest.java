package com.future.othertest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    @Test
    public void testDateFormat() {
        String a = "2021-05-14T23:30:35+08:00";
        String start = "2022-01-01 10:10:10";
        String end = "2022-10-25 10:10:10";

        String c = "2022-10-25T10:41:14+0800";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
//            Date date1 = sdf.parse(a);
//            String dateString = sdf2.format(date1);

            Date d1 = sdf.parse(c);
            String d11 = sdf2.format(d1);
            System.out.println(d11);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}


