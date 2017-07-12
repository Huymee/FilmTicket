package com.yuqs.filmticket.Entity;

import java.util.List;

/**
 * Created by 46433 on 17/06/23.
 */

public class CityAreaBean {
    /**
     * areas : [{"areaName":"蔡甸区","cinemaNum":0,"id":420114},{"areaName":"汉阳区","cinemaNum":0,"id":420105},{"areaName":"黄陂区","cinemaNum":0,"id":420116},{"areaName":"江夏区","cinemaNum":0,"id":420115},{"areaName":"武昌区","cinemaNum":0,"id":420106}]
     * status : ok
     */

    private String status;
    private List<Area> areas;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public static class Area {
        /**
         * areaName : 蔡甸区
         * cinemaNum : 0
         * id : 420114
         */

        private String areaName;
        private int cinemaNum;
        private int id;

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public int getCinemaNum() {
            return cinemaNum;
        }

        public void setCinemaNum(int cinemaNum) {
            this.cinemaNum = cinemaNum;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
