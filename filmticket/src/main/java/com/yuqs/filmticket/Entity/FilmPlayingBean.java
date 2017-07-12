package com.yuqs.filmticket.Entity;

import java.util.ArrayList;

/**
 * 正在放映
 */

public class FilmPlayingBean {

    /**
     * data : [{"actorName":"克里斯·帕拉特/佐伊·索尔达娜/布莱德利·库珀/范·迪塞尔/戴夫·巴蒂斯塔/内森·菲利安","chname":"银河护卫队2","cinemaCount":7,"directorName":"詹姆斯·古恩","domainType":"2","filmColor":"#30ead6","filmID":"10184","filmScreenwriter":"詹姆斯·古恩/Dan Abnett","filmTypeId":0,"fshowtime":"2017-05-05","hasPlan":0,"likeRate":"83%","lprice":25,"onlyDescribe":"逗比护卫队，拯救银河系。","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBb1j_LBeAQmiEAAUR1X0bElI667.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBLFj_KyWAewchAAAyx9hVPgA413.jpg","planCount":158,"playTime":"2017-05-11","price":0,"score":8.5,"sellType":"2","showTimeMark":0,"typeName":"3D,IMAX3D","willDay":0},{"actorName":"阿米尔·汗/萨卡诗·泰瓦","chname":"摔跤吧！爸爸","cinemaCount":7,"directorName":"尼特什·提瓦瑞","domainType":"2","filmColor":"#30ead6","filmID":"10188","filmScreenwriter":"比于什·古普塔/施热亚·简","filmTypeId":0,"fshowtime":"2017-05-05","hasPlan":0,"likeRate":"97%","lprice":20,"onlyDescribe":"","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBb1kB-x-APKiKAAizgkDd5XQ822.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBLFkB-iGAOfHCAAAw5zghgYw053.jpg","planCount":153,"playTime":"2017-05-11","price":0,"score":8.6,"sellType":"2","showTimeMark":0,"typeName":"2D","willDay":0},{"actorName":"李立群/张伟欣/黄磊/海清/王迅","chname":"麻烦家族","cinemaCount":7,"directorName":"黄磊","domainType":"2","filmColor":"#30ead6","filmID":"10190","filmScreenwriter":"张铂雷","filmTypeId":0,"fshowtime":"2017-05-12","hasPlan":0,"likeRate":"95%","lprice":30,"onlyDescribe":"一纸协议书，麻烦惹上身。","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBb1kK07CAHth4AAfVuL2t1Lg019.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBLFkK0o2AcBOrAAA1ZT0O-rA627.jpg","planCount":69,"playTime":"2017-05-11","price":0,"score":8.3,"sellType":"1","showTimeMark":0,"typeName":"2D","willDay":0},{"actorName":"查理·汉纳姆/艾瑞克·巴纳/阿斯特丽德·伯格斯-弗瑞斯贝/裘德·洛","chname":"亚瑟王：斗兽争霸","cinemaCount":0,"directorName":"盖·里奇","domainType":"2","filmColor":"#30ead6","filmID":"10194","filmScreenwriter":"宙比·哈罗德","filmTypeId":0,"fshowtime":"2017-05-12","hasPlan":0,"likeRate":"100%","lprice":25,"onlyDescribe":"","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBLFkLGu6AJsNmAAWGUhtRaiA590.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBb1kLHBOAe7URAAAkgLPlinA369.jpg","planCount":0,"playTime":"2017-05-12","price":0,"score":8.5,"sellType":"1","showTimeMark":0,"typeName":"3D,巨幕3D","willDay":0},{"actorName":"达克雷·蒙特戈梅里/娜奥米·斯科特","chname":"超凡战队","cinemaCount":0,"directorName":"迪恩·以色列特","domainType":"2","filmColor":"#30ead6","filmID":"10198","filmScreenwriter":"伯克·夏普勒斯/马特·萨扎马","filmTypeId":0,"fshowtime":"2017-05-12","hasPlan":0,"likeRate":"100%","lprice":25,"onlyDescribe":"","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkQTAmAUAgXAAKu-T2WdZU277.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBb1kQTUSAVyLoAAAmguzFqsE077.jpg","planCount":0,"playTime":"2017-05-12","price":0,"score":7.5,"sellType":"1","showTimeMark":0,"typeName":"3D","willDay":0},{"actorName":"古天乐/刘青云/林家栋/江一燕/张晋","chname":"毒。诫","cinemaCount":0,"directorName":"刘国昌","domainType":"2","filmColor":"#30ead6","filmID":"10192","filmScreenwriter":"陈文强/林惠菊","filmTypeId":0,"fshowtime":"2017-05-12","hasPlan":0,"likeRate":"100%","lprice":25,"onlyDescribe":"","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBLFkLFAuAQpYQAAawkyOKkWQ732.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBb1kLFTCAbNUCAAAoQ6iV_nM952.jpg","planCount":0,"playTime":"2017-05-12","price":0,"score":8.3,"sellType":"1","showTimeMark":0,"typeName":"2D","willDay":0},{"actorName":"约翰尼·德普/奥兰多·布鲁姆/杰弗里·拉什/哈维尔·巴登/布兰顿·思怀兹","chname":"加勒比海盗：死无对证","cinemaCount":0,"directorName":"乔阿吉姆·罗恩尼/艾斯彭·山德伯格","domainType":"2","filmColor":"#30ead6","filmID":"10208","filmScreenwriter":"斯图尔特·比蒂/泰德·埃里奥特","filmTypeId":0,"fshowtime":"2017-05-26","hasPlan":0,"likeRate":"100%","lprice":25,"onlyDescribe":"","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkS2i-AXdp9AAkx6oMYid0365.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBb1kS23WAQqUlAAAxX2hcM3c549.jpg","planCount":0,"playTime":"2017-05-26","price":0,"score":1.5,"sellType":"1","showTimeMark":0,"typeName":"3D,IMAX3D","willDay":0},{"actorName":"刘德华/姜武/宋佳/吴卓羲/姜皓文","chname":"拆弹·专家","cinemaCount":7,"directorName":"邱礼涛","domainType":"2","filmColor":"#30ead6","filmID":"10144","filmScreenwriter":"","filmTypeId":0,"fshowtime":"2017-04-28","hasPlan":0,"likeRate":"98%","lprice":25,"onlyDescribe":"","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBb1jnKlGAaOYtAAGVie64RMI905.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBLFjnKcWAIQSkAAAnKIsA0cs609.jpg","planCount":69,"playTime":"2017-05-11","price":0,"score":7.5,"sellType":"2","showTimeMark":0,"typeName":"2D,巨幕","willDay":0},{"actorName":"范·迪塞尔/道恩·强森/杰森·斯坦森/查理兹·塞隆/米歇尔·罗德里格兹/娜塔莉·艾玛努埃尔","chname":"速度与激情8","cinemaCount":6,"directorName":"F·加里·格雷","domainType":"2","filmColor":"#30ead6","filmID":"10136","filmScreenwriter":"加里·斯科特·汤普森/克里斯·摩根","filmTypeId":0,"fshowtime":"2017-04-14","hasPlan":0,"likeRate":"95%","lprice":20,"onlyDescribe":"老大被黑化，家族崩离析。","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBb1jdyG-AaI9GAADNalyFLW0473.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBLFjdyAqAVgvoAAAoJa4FHPY632.jpg","planCount":44,"playTime":"2017-05-11","price":0,"score":7.8,"sellType":"2","showTimeMark":0,"typeName":"3D,IMAX3D","willDay":0},{"actorName":"杰克·吉伦哈尔/丽贝卡·弗格森/瑞安·雷诺兹/真田广之","chname":"异星觉醒","cinemaCount":0,"directorName":"丹尼尔·伊斯皮诺萨","domainType":"2","filmColor":"#30ead6","filmID":"10206","filmScreenwriter":"略特·里斯/保罗·韦尼克","filmTypeId":0,"fshowtime":"2017-05-19","hasPlan":0,"likeRate":"100%","lprice":20,"onlyDescribe":"宇宙微生物，血染太空舱。","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBb1kSg0CAH2ENAASbFP0R8Hs273.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkSgfyAQg-_AAAbk1yzMbw203.jpg","planCount":0,"playTime":"2017-05-19","price":0,"score":7.9,"sellType":"1","showTimeMark":0,"typeName":"2D,巨幕","willDay":0},{"actorName":"金城武/周冬雨/孙艺洲/奚梦瑶/杨祐宁","chname":"喜欢·你","cinemaCount":5,"directorName":"许宏宇","domainType":"2","filmColor":"#30ead6","filmID":"10164","filmScreenwriter":"李媛/许伊萌","filmTypeId":0,"fshowtime":"2017-04-27","hasPlan":0,"likeRate":"95%","lprice":30,"onlyDescribe":"霸道男总裁，爱上小厨娘。","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBLFj1vf-APLxEAANcl801kzc956.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBb1j1vsqAEoxIAAAuA0CysoM490.jpg","planCount":25,"playTime":"2017-05-11","price":0,"score":7.8,"sellType":"2","showTimeMark":0,"typeName":"2D","willDay":0},{"actorName":"曼迪·帕廷金雷恩·威尔森","chname":"蓝精灵：寻找神秘村","cinemaCount":1,"directorName":"凯利·阿斯博瑞","domainType":"2","filmColor":"#30ead6","filmID":"10116","filmScreenwriter":"凯利·柯克帕特里克","filmTypeId":0,"fshowtime":"2017-04-21","hasPlan":0,"likeRate":"98%","lprice":25,"onlyDescribe":"蓝精灵归来，大战格格巫。","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/00/wKgBLFjXMhmAKPy_AASxj5nKcKE422.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/00/wKgBb1jXMmKAFDf-AAAukzN-vtA065.jpg","planCount":3,"playTime":"2017-05-11","price":0,"score":7.6,"sellType":"2","showTimeMark":0,"typeName":"3D,巨幕3D","willDay":0},{"actorName":"陈玺旭/高叶/任素汐/董博","chname":"提着心，吊着胆","cinemaCount":0,"directorName":"李雨禾","domainType":"2","filmColor":"#30ead6","filmID":"10202","filmScreenwriter":"李雨禾","filmTypeId":0,"fshowtime":"2017-05-12","hasPlan":0,"likeRate":"100%","lprice":25,"onlyDescribe":"","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkQTvqAfFLGAAQourIdKY0677.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBb1kQUDWAOhC-AAAlALMg2kU368.jpg","planCount":0,"playTime":"2017-05-12","price":0,"score":1.5,"sellType":"1","showTimeMark":0,"typeName":"2D","willDay":0},{"actorName":"黄渤，徐静蕾，段奕宏，杨子姗，许玮甯","chname":"记忆大师","cinemaCount":7,"directorName":"陈正道","domainType":"2","filmColor":"#30ead6","filmID":"10168","filmScreenwriter":"任鹏","filmTypeId":0,"fshowtime":"2017-04-28","hasPlan":0,"likeRate":"85%","lprice":30,"onlyDescribe":"手术遇失误，记忆被重载。","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBb1j3QjmAQMUXAAUBBBqz9pc831.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBLFj3QWmAOaBYAAAbl0HhzwM316.jpg","planCount":46,"playTime":"2017-05-11","price":0,"score":7.8,"sellType":"2","showTimeMark":0,"typeName":"2D","willDay":0},{"actorName":"杨千嬅/余文乐","chname":"春娇救志明","cinemaCount":5,"directorName":"彭浩翔","domainType":"2","filmColor":"#30ead6","filmID":"10162","filmScreenwriter":"彭浩翔/尹志文","filmTypeId":0,"fshowtime":"2017-04-28","hasPlan":0,"likeRate":"100%","lprice":30,"onlyDescribe":"复合五年后，矛盾在出现","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBLFj1sCaAP_QNAARplfB2oSk869.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/01/wKgBb1j1sPCAWEWQAAAoxTMbQyw252.jpg","planCount":11,"playTime":"2017-05-11","price":0,"score":7.7,"sellType":"2","showTimeMark":0,"typeName":"2D","willDay":0}]
     * status : ok
     */

    private String status;
    private ArrayList<PlayingFilm> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<PlayingFilm> getData() {
        return data;
    }

    public void setData(ArrayList<PlayingFilm> data) {
        this.data = data;
    }

    public static class PlayingFilm{
        /**
         * actorName : 克里斯·帕拉特/佐伊·索尔达娜/布莱德利·库珀/范·迪塞尔/戴夫·巴蒂斯塔/内森·菲利安
         * chname : 银河护卫队2
         * cinemaCount : 7
         * directorName : 詹姆斯·古恩
         * domainType : 2
         * filmColor : #30ead6
         * filmID : 10184
         * filmScreenwriter : 詹姆斯·古恩/Dan Abnett
         * filmTypeId : 0
         * fshowtime : 2017-05-05
         * hasPlan : 0
         * likeRate : 83%
         * lprice : 25.0
         * onlyDescribe : 逗比护卫队，拯救银河系。
         * picture : http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBb1j_LBeAQmiEAAUR1X0bElI667.jpg
         * pictureThumb : http://newimg.vcfilm.cn//vcimg/M00/00/02/wKgBLFj_KyWAewchAAAyx9hVPgA413.jpg
         * planCount : 158
         * playTime : 2017-05-11
         * price : 0.0
         * score : 8.5
         * sellType : 2
         * showTimeMark : 0
         * typeName : 3D,IMAX3D
         * willDay : 0
         */

        private String actorName;
        private String chname;
        private int cinemaCount;
        private String directorName;
        private String domainType;
        private String filmColor;
        private String filmID;
        private String filmScreenwriter;
        private int filmTypeId;
        private String fshowtime;
        private int hasPlan;
        private String likeRate;
        private double lprice;
        private String onlyDescribe;
        private String picture;
        private String pictureThumb;
        private int planCount;
        private String playTime;
        private double price;
        private double score;
        private String sellType;
        private int showTimeMark;
        private String typeName;
        private int willDay;

        public String getActorName() {
            return actorName;
        }

        public void setActorName(String actorName) {
            this.actorName = actorName;
        }

        public String getChname() {
            return chname;
        }

        public void setChname(String chname) {
            this.chname = chname;
        }

        public int getCinemaCount() {
            return cinemaCount;
        }

        public void setCinemaCount(int cinemaCount) {
            this.cinemaCount = cinemaCount;
        }

        public String getDirectorName() {
            return directorName;
        }

        public void setDirectorName(String directorName) {
            this.directorName = directorName;
        }

        public String getDomainType() {
            return domainType;
        }

        public void setDomainType(String domainType) {
            this.domainType = domainType;
        }

        public String getFilmColor() {
            return filmColor;
        }

        public void setFilmColor(String filmColor) {
            this.filmColor = filmColor;
        }

        public String getFilmID() {
            return filmID;
        }

        public void setFilmID(String filmID) {
            this.filmID = filmID;
        }

        public String getFilmScreenwriter() {
            return filmScreenwriter;
        }

        public void setFilmScreenwriter(String filmScreenwriter) {
            this.filmScreenwriter = filmScreenwriter;
        }

        public int getFilmTypeId() {
            return filmTypeId;
        }

        public void setFilmTypeId(int filmTypeId) {
            this.filmTypeId = filmTypeId;
        }

        public String getFshowtime() {
            return fshowtime;
        }

        public void setFshowtime(String fshowtime) {
            this.fshowtime = fshowtime;
        }

        public int getHasPlan() {
            return hasPlan;
        }

        public void setHasPlan(int hasPlan) {
            this.hasPlan = hasPlan;
        }

        public String getLikeRate() {
            return likeRate;
        }

        public void setLikeRate(String likeRate) {
            this.likeRate = likeRate;
        }

        public double getLprice() {
            return lprice;
        }

        public void setLprice(double lprice) {
            this.lprice = lprice;
        }

        public String getOnlyDescribe() {
            return onlyDescribe;
        }

        public void setOnlyDescribe(String onlyDescribe) {
            this.onlyDescribe = onlyDescribe;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getPictureThumb() {
            return pictureThumb;
        }

        public void setPictureThumb(String pictureThumb) {
            this.pictureThumb = pictureThumb;
        }

        public int getPlanCount() {
            return planCount;
        }

        public void setPlanCount(int planCount) {
            this.planCount = planCount;
        }

        public String getPlayTime() {
            return playTime;
        }

        public void setPlayTime(String playTime) {
            this.playTime = playTime;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getSellType() {
            return sellType;
        }

        public void setSellType(String sellType) {
            this.sellType = sellType;
        }

        public int getShowTimeMark() {
            return showTimeMark;
        }

        public void setShowTimeMark(int showTimeMark) {
            this.showTimeMark = showTimeMark;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getWillDay() {
            return willDay;
        }

        public void setWillDay(int willDay) {
            this.willDay = willDay;
        }
    }
}
