package com.yuqs.filmticket.Manager;

import android.provider.ContactsContract;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by 46433 on 17/06/21.
 * 处理电影计划日期表格
 */

public class DateManager {
    private static Date date = Calendar.getInstance().getTime();
    private static Calendar calendar = Calendar.getInstance();

    public static List<String> getDateList() {
        SimpleDateFormat format = new SimpleDateFormat("MM.dd");
        SimpleDateFormat week = new SimpleDateFormat("E");
        calendar.setTime(date);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Date date1 = calendar.getTime();
            if (i == 0) {
                list.add("今天" + " " + format.format(date1));
            } else if (i == 1) {
                list.add("明天" + " " + format.format(date1));
            } else if (i == 2) {
                list.add("后天" + " " + format.format(date1));
            } else {
                list.add(week.format(date1) + " " + format.format(date1));
            }
            calendar.add(Calendar.DATE, 1);
        }
        return list;
    }

    public static boolean getTimeIsEnough(String playtime, String fullPlayTime) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        SimpleDateFormat fullFormat = new SimpleDateFormat("MM-dd");
        String today = fullFormat.format(date);

//        int dayLength=today.length();
//        String playDay=fullPlayTime.substring(0,dayLength);
//        String[] day1 = today.split("-");
//        String[] day2 = playDay.split("-");
        if (!fullPlayTime.contains(today)) {
            return true;
        }
        String currentTime = format.format(Calendar.getInstance().getTime());
        String[] a1 = currentTime.split(":");
        String[] a2 = playtime.split(":");
        int[] b1 = {decodeStr(a1[0]), decodeStr(a1[1])};
        int[] b2 = {decodeStr(a2[0]), decodeStr(a2[1])};
        if ((b1[0] * 60 + b1[1]) > (23 * 60 + 30)) {
            return false;
        }
        int time = (b2[0] - b1[0]) * 60 + b2[1] - b1[1];
        if (time > 30) {
            return true;
        }
        return false;
    }

    public static String getUpcomingDays(String firstShowTime) {
        //2017-05-26
        SimpleDateFormat fullFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = fullFormat.format(date);
        long betweenDays = 0;
        try {
            Date todayDate = fullFormat.parse(today);
            Date firstDate = fullFormat.parse(firstShowTime);
            betweenDays = ((firstDate.getTime() - todayDate.getTime()) / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(betweenDays);
    }

    private static int decodeStr(String str) {
        if (str.length() > 1) {
            if (str.startsWith("0")) {
                str = str.substring(1);
            }
        }
        return Integer.decode(str);
    }
}
