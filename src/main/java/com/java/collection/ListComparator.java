package com.java.collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 类ListComparator.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月16日 下午4:31:24
 * @version 1.0.0
 */
public class ListComparator {
    public static void sortList(List list) {
        Collections.sort(list, new Comparator<Date>() {

            @Override
            public int compare(Date o1, Date o2) {
                if (o1.compareTo(o2) > 0) {
                    return 0;
                } else {
                    return 1;
                }

            }

        });
    }

    public static void main(String[] args) throws ParseException {
        String date = "2015-10-09 12:44:01";
        String date1 = "2015-10-10 04:08:04";
        String date2 = "2015-10-15 04:08:04";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Date> list = new ArrayList<Date>();
        list.add(format.parse(date));
        list.add(format.parse(date1));
        list.add(format.parse(date2));
        System.out.println(list);
        System.out.println("---------------after--------------");
        sortList(list);
        System.out.println(list);

    }
}
