package com.yuqs.filmticket.Entity;

import java.util.List;

/**
 * Created by 46433 on 17/06/21.
 */

public class FilmPlanBean {
    /**
     * data : {"planPromotion":[],"cityPrice":0,"list":[{"cinemaId":1423,"cstate":0,"endtime":"21:46","filmClassifyId":10352,"filmCode":"051200582017","filmId":10292,"filmLanguage":"EN","fullPlayTime":"2017-06-21T20:00:00","hallCode":"3","hallId":155452,"hallName":"3号厅","hasPromotion":false,"isSale":0,"lPrice":25,"planCode":"24172","planId":51731562,"playTimeLimit":0,"playTimeShow":3,"playtime":"20:00","price":40,"promotionId":0,"promotionPrice":0,"sprice":26,"typeName":"3D","vcSPrice":0},{"cinemaId":1423,"cstate":0,"endtime":"23:46","filmClassifyId":10352,"filmCode":"051200582017","filmId":10292,"filmLanguage":"EN","fullPlayTime":"2017-06-21T22:00:00","hallCode":"3","hallId":155452,"hallName":"3号厅","hasPromotion":false,"isSale":0,"lPrice":25,"planCode":"24173","planId":51731564,"playTimeLimit":0,"playTimeShow":0,"playtime":"22:00","price":40,"promotionId":0,"promotionPrice":0,"sprice":26,"typeName":"3D","vcSPrice":0}]}
     * cinemaMrId : 0
     * status : ok
     */

    private DataBean data;
    private int cinemaMrId;
    private String status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCinemaMrId() {
        return cinemaMrId;
    }

    public void setCinemaMrId(int cinemaMrId) {
        this.cinemaMrId = cinemaMrId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * planPromotion : []
         * cityPrice : 0.0
         * list : [{"cinemaId":1423,"cstate":0,"endtime":"21:46","filmClassifyId":10352,"filmCode":"051200582017","filmId":10292,"filmLanguage":"EN","fullPlayTime":"2017-06-21T20:00:00","hallCode":"3","hallId":155452,"hallName":"3号厅","hasPromotion":false,"isSale":0,"lPrice":25,"planCode":"24172","planId":51731562,"playTimeLimit":0,"playTimeShow":3,"playtime":"20:00","price":40,"promotionId":0,"promotionPrice":0,"sprice":26,"typeName":"3D","vcSPrice":0},{"cinemaId":1423,"cstate":0,"endtime":"23:46","filmClassifyId":10352,"filmCode":"051200582017","filmId":10292,"filmLanguage":"EN","fullPlayTime":"2017-06-21T22:00:00","hallCode":"3","hallId":155452,"hallName":"3号厅","hasPromotion":false,"isSale":0,"lPrice":25,"planCode":"24173","planId":51731564,"playTimeLimit":0,"playTimeShow":0,"playtime":"22:00","price":40,"promotionId":0,"promotionPrice":0,"sprice":26,"typeName":"3D","vcSPrice":0}]
         */

        private double cityPrice;
        private List<?> planPromotion;
        private List<FilmPlan> list;

        public double getCityPrice() {
            return cityPrice;
        }

        public void setCityPrice(double cityPrice) {
            this.cityPrice = cityPrice;
        }

        public List<?> getPlanPromotion() {
            return planPromotion;
        }

        public void setPlanPromotion(List<?> planPromotion) {
            this.planPromotion = planPromotion;
        }

        public List<FilmPlan> getList() {
            return list;
        }

        public void setList(List<FilmPlan> list) {
            this.list = list;
        }

        public static class FilmPlan {
            /**
             * cinemaId : 1423
             * cstate : 0
             * endtime : 21:46
             * filmClassifyId : 10352
             * filmCode : 051200582017
             * filmId : 10292
             * filmLanguage : EN
             * fullPlayTime : 2017-06-21T20:00:00
             * hallCode : 3
             * hallId : 155452
             * hallName : 3号厅
             * hasPromotion : false
             * isSale : 0
             * lPrice : 25.0
             * planCode : 24172
             * planId : 51731562
             * playTimeLimit : 0
             * playTimeShow : 3
             * playtime : 20:00
             * price : 40.0
             * promotionId : 0
             * promotionPrice : 0.0
             * sprice : 26.0
             * typeName : 3D
             * vcSPrice : 0.0
             */

            private int cinemaId;
            private int cstate;
            private String endtime;
            private int filmClassifyId;
            private String filmCode;
            private int filmId;
            private String filmLanguage;
            private String fullPlayTime;
            private String hallCode;
            private int hallId;
            private String hallName;
            private boolean hasPromotion;
            private int isSale;
            private double lPrice;
            private String planCode;
            private int planId;
            private int playTimeLimit;
            private int playTimeShow;
            private String playtime;
            private double price;
            private int promotionId;
            private double promotionPrice;
            private double sprice;
            private String typeName;
            private double vcSPrice;

            public int getCinemaId() {
                return cinemaId;
            }

            public void setCinemaId(int cinemaId) {
                this.cinemaId = cinemaId;
            }

            public int getCstate() {
                return cstate;
            }

            public void setCstate(int cstate) {
                this.cstate = cstate;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public int getFilmClassifyId() {
                return filmClassifyId;
            }

            public void setFilmClassifyId(int filmClassifyId) {
                this.filmClassifyId = filmClassifyId;
            }

            public String getFilmCode() {
                return filmCode;
            }

            public void setFilmCode(String filmCode) {
                this.filmCode = filmCode;
            }

            public int getFilmId() {
                return filmId;
            }

            public void setFilmId(int filmId) {
                this.filmId = filmId;
            }

            public String getFilmLanguage() {
                return filmLanguage;
            }

            public void setFilmLanguage(String filmLanguage) {
                this.filmLanguage = filmLanguage;
            }

            public String getFullPlayTime() {
                return fullPlayTime;
            }

            public void setFullPlayTime(String fullPlayTime) {
                this.fullPlayTime = fullPlayTime;
            }

            public String getHallCode() {
                return hallCode;
            }

            public void setHallCode(String hallCode) {
                this.hallCode = hallCode;
            }

            public int getHallId() {
                return hallId;
            }

            public void setHallId(int hallId) {
                this.hallId = hallId;
            }

            public String getHallName() {
                return hallName;
            }

            public void setHallName(String hallName) {
                this.hallName = hallName;
            }

            public boolean isHasPromotion() {
                return hasPromotion;
            }

            public void setHasPromotion(boolean hasPromotion) {
                this.hasPromotion = hasPromotion;
            }

            public int getIsSale() {
                return isSale;
            }

            public void setIsSale(int isSale) {
                this.isSale = isSale;
            }

            public double getLPrice() {
                return lPrice;
            }

            public void setLPrice(double lPrice) {
                this.lPrice = lPrice;
            }

            public String getPlanCode() {
                return planCode;
            }

            public void setPlanCode(String planCode) {
                this.planCode = planCode;
            }

            public int getPlanId() {
                return planId;
            }

            public void setPlanId(int planId) {
                this.planId = planId;
            }

            public int getPlayTimeLimit() {
                return playTimeLimit;
            }

            public void setPlayTimeLimit(int playTimeLimit) {
                this.playTimeLimit = playTimeLimit;
            }

            public int getPlayTimeShow() {
                return playTimeShow;
            }

            public void setPlayTimeShow(int playTimeShow) {
                this.playTimeShow = playTimeShow;
            }

            public String getPlaytime() {
                return playtime;
            }

            public void setPlaytime(String playtime) {
                this.playtime = playtime;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPromotionId() {
                return promotionId;
            }

            public void setPromotionId(int promotionId) {
                this.promotionId = promotionId;
            }

            public double getPromotionPrice() {
                return promotionPrice;
            }

            public void setPromotionPrice(double promotionPrice) {
                this.promotionPrice = promotionPrice;
            }

            public double getSprice() {
                return sprice;
            }

            public void setSprice(double sprice) {
                this.sprice = sprice;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public double getVcSPrice() {
                return vcSPrice;
            }

            public void setVcSPrice(double vcSPrice) {
                this.vcSPrice = vcSPrice;
            }
        }
    }
}
