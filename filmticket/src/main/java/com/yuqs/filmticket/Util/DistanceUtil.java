package com.yuqs.filmticket.Util;

import com.yuqs.filmticket.MyApplication;

/**
 * Created by 46433 on 17/06/09.
 */
public class DistanceUtil {
    private static final double EARTH_RADIUS = 6378137.0;
    // 返回单位是米

    /**
     * 计算两个经纬度坐标之间的距离
     * @param longitude1 第一个度坐标的经
     * @param latitude1 第一个坐标的纬度
     * @param longitude2 第二个度坐标的经
     * @param latitude2 第二坐标的纬度
     * @return 两个坐标间的距离 单位（米）
     */
    public static double getDistance(double longitude1, double latitude1,
                                     double longitude2, double latitude2) {
        double Lat1 = rad(latitude1);
        double Lat2 = rad(latitude2);
        double a = Lat1 - Lat2;
        double b = rad(longitude1) - rad(longitude2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(Lat1) * Math.cos(Lat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }
    /**
     * 计算指定坐标和当前位置之间的距离
     * @param longitude 经度
     * @param latitude 纬度
     * @return 距离的默认位置的距离 单位（米）
     */
    public static double getDistance(double longitude, double latitude) {
        double Lat1 = rad(latitude);
        double Lat2 = rad(MyApplication.currentLatitude);//TODO 当前位置纬度 应该用百度地图SDK获取
        double a = Lat1 - Lat2;
        double b = rad(longitude) - rad(MyApplication.currentLongitude);//TODO 当前位置经度 应该用百度地图SDK获取
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(Lat1) * Math.cos(Lat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }
}
