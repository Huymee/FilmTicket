package com.yuqs.filmticket.Entity;

import java.util.List;

/**
 * Created by 46433 on 17/06/06.
 */

public class FilmInfoBean {

    /**
     * filmInfo : {"actorName":"约翰尼·德普/奥兰多·布鲁姆/杰弗里·拉什/哈维尔·巴登/布兰顿·思怀兹","country":"美国","detailPicture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkS2lOABeauAAIMuGc_L_4748.jpg","directorName":"乔阿吉姆·罗恩尼/艾斯彭·山德伯格","domainType":2,"fileType":"2D,3D,IMAX3D,巨幕3D","filmColor":"#30ead6","filmId":10208,"filmName":"加勒比海盗：死无对证","filmScreenwriter":"斯图尔特·比蒂/泰德·埃里奥特","filmTypeId":0,"fshowtime":"2017-05-26","gutdescipty":"杰克船长（约翰尼·德普饰）发现令人闻风丧胆的萨拉查船长 （哈维尔·巴登饰）竟率领着一众夺命亡灵水手逃出了百慕大三角区。他们扬言要杀尽世上所有的海盗，头号目标就是杰克船长。要想改写命运，杰克船长唯一的希望就是找到传说中海神波塞冬的三叉戟，拥有它就能拥有统治整个海洋的力量。为了寻获这件神器，杰克船长被迫和聪明美丽的天文学家卡琳娜·史密斯（卡雅·斯考达里奥饰）以及固执的年轻皇家海军亨利（布兰顿·思怀兹饰）联手出击。航行着他那破破烂烂的\u201c死海鸥\u201d号，杰克船长不但决心要改变自己的厄运，同时也力求能从史上最狠毒可怕的敌人那里捡回一条命。","isEggs":0,"language":"英语，国语","levelOnePrice":0,"levelThreePrice":0,"levelTwoPrice":0,"likeRate":"92%","onlyDescribe":"","picture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkS2i-AXdp9AAkx6oMYid0365.jpg","pictureThumb":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBb1kS23WAQqUlAAAxX2hcM3c549.jpg","pixlength":129,"pixtype":"动作,奇幻,冒险","score":8.1}
     * picList : [{"domainType":2,"filmId":10208,"filmTypeId":0,"isEggs":0,"levelOnePrice":0,"levelThreePrice":0,"levelTwoPrice":0,"picture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkS2g2Ac2AsAANd4PLCdzA614.jpg","pixlength":0},{"domainType":2,"filmId":10208,"filmTypeId":0,"isEggs":0,"levelOnePrice":0,"levelThreePrice":0,"levelTwoPrice":0,"picture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkS2hKAOfH7AAIMuGc_L_4412.jpg","pixlength":0},{"domainType":2,"filmId":10208,"filmTypeId":0,"isEggs":0,"levelOnePrice":0,"levelThreePrice":0,"levelTwoPrice":0,"picture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBb1kS22mAG15vAAPbxB-SshY409.jpg","pixlength":0},{"domainType":2,"filmId":10208,"filmTypeId":0,"isEggs":0,"levelOnePrice":0,"levelThreePrice":0,"levelTwoPrice":0,"picture":"http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBb1kS24OABXWsAAHq8WJR3u4227.jpg","pixlength":0}]
     * status : ok
     */

    private FilmInfo filmInfo;
    private String status;
    private List<PicListBean> picList;

    public FilmInfo getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(FilmInfo filmInfo) {
        this.filmInfo = filmInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PicListBean> getPicList() {
        return picList;
    }

    public void setPicList(List<PicListBean> picList) {
        this.picList = picList;
    }

    public static class FilmInfo {
        /**
         * actorName : 约翰尼·德普/奥兰多·布鲁姆/杰弗里·拉什/哈维尔·巴登/布兰顿·思怀兹
         * country : 美国
         * detailPicture : http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkS2lOABeauAAIMuGc_L_4748.jpg
         * directorName : 乔阿吉姆·罗恩尼/艾斯彭·山德伯格
         * domainType : 2
         * fileType : 2D,3D,IMAX3D,巨幕3D
         * filmColor : #30ead6
         * filmId : 10208
         * filmName : 加勒比海盗：死无对证
         * filmScreenwriter : 斯图尔特·比蒂/泰德·埃里奥特
         * filmTypeId : 0
         * fshowtime : 2017-05-26
         * gutdescipty : 杰克船长（约翰尼·德普饰）发现令人闻风丧胆的萨拉查船长 （哈维尔·巴登饰）竟率领着一众夺命亡灵水手逃出了百慕大三角区。他们扬言要杀尽世上所有的海盗，头号目标就是杰克船长。要想改写命运，杰克船长唯一的希望就是找到传说中海神波塞冬的三叉戟，拥有它就能拥有统治整个海洋的力量。为了寻获这件神器，杰克船长被迫和聪明美丽的天文学家卡琳娜·史密斯（卡雅·斯考达里奥饰）以及固执的年轻皇家海军亨利（布兰顿·思怀兹饰）联手出击。航行着他那破破烂烂的“死海鸥”号，杰克船长不但决心要改变自己的厄运，同时也力求能从史上最狠毒可怕的敌人那里捡回一条命。
         * isEggs : 0
         * language : 英语，国语
         * levelOnePrice : 0.0
         * levelThreePrice : 0.0
         * levelTwoPrice : 0.0
         * likeRate : 92%
         * onlyDescribe :
         * picture : http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkS2i-AXdp9AAkx6oMYid0365.jpg
         * pictureThumb : http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBb1kS23WAQqUlAAAxX2hcM3c549.jpg
         * pixlength : 129
         * pixtype : 动作,奇幻,冒险
         * score : 8.1
         */

        private String actorName;
        private String country;
        private String detailPicture;
        private String directorName;
        private int domainType;
        private String fileType;
        private String filmColor;
        private int filmId;
        private String filmName;
        private String filmScreenwriter;
        private int filmTypeId;
        private String fshowtime;
        private String gutdescipty;
        private int isEggs;
        private String language;
        private double levelOnePrice;
        private double levelThreePrice;
        private double levelTwoPrice;
        private String likeRate;
        private String onlyDescribe;
        private String picture;
        private String pictureThumb;
        private int pixlength;
        private String pixtype;
        private double score;

        public String getActorName() {
            return actorName;
        }

        public void setActorName(String actorName) {
            this.actorName = actorName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDetailPicture() {
            return detailPicture;
        }

        public void setDetailPicture(String detailPicture) {
            this.detailPicture = detailPicture;
        }

        public String getDirectorName() {
            return directorName;
        }

        public void setDirectorName(String directorName) {
            this.directorName = directorName;
        }

        public int getDomainType() {
            return domainType;
        }

        public void setDomainType(int domainType) {
            this.domainType = domainType;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getFilmColor() {
            return filmColor;
        }

        public void setFilmColor(String filmColor) {
            this.filmColor = filmColor;
        }

        public int getFilmId() {
            return filmId;
        }

        public void setFilmId(int filmId) {
            this.filmId = filmId;
        }

        public String getFilmName() {
            return filmName;
        }

        public void setFilmName(String filmName) {
            this.filmName = filmName;
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

        public String getGutdescipty() {
            return gutdescipty;
        }

        public void setGutdescipty(String gutdescipty) {
            this.gutdescipty = gutdescipty;
        }

        public int getIsEggs() {
            return isEggs;
        }

        public void setIsEggs(int isEggs) {
            this.isEggs = isEggs;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public double getLevelOnePrice() {
            return levelOnePrice;
        }

        public void setLevelOnePrice(double levelOnePrice) {
            this.levelOnePrice = levelOnePrice;
        }

        public double getLevelThreePrice() {
            return levelThreePrice;
        }

        public void setLevelThreePrice(double levelThreePrice) {
            this.levelThreePrice = levelThreePrice;
        }

        public double getLevelTwoPrice() {
            return levelTwoPrice;
        }

        public void setLevelTwoPrice(double levelTwoPrice) {
            this.levelTwoPrice = levelTwoPrice;
        }

        public String getLikeRate() {
            return likeRate;
        }

        public void setLikeRate(String likeRate) {
            this.likeRate = likeRate;
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

        public int getPixlength() {
            return pixlength;
        }

        public void setPixlength(int pixlength) {
            this.pixlength = pixlength;
        }

        public String getPixtype() {
            return pixtype;
        }

        public void setPixtype(String pixtype) {
            this.pixtype = pixtype;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    public static class PicListBean {
        /**
         * domainType : 2
         * filmId : 10208
         * filmTypeId : 0
         * isEggs : 0
         * levelOnePrice : 0.0
         * levelThreePrice : 0.0
         * levelTwoPrice : 0.0
         * picture : http://newimg.vcfilm.cn//vcimg/M00/00/03/wKgBLFkS2g2Ac2AsAANd4PLCdzA614.jpg
         * pixlength : 0
         */

        private int domainType;
        private int filmId;
        private int filmTypeId;
        private int isEggs;
        private double levelOnePrice;
        private double levelThreePrice;
        private double levelTwoPrice;
        private String picture;
        private int pixlength;

        public int getDomainType() {
            return domainType;
        }

        public void setDomainType(int domainType) {
            this.domainType = domainType;
        }

        public int getFilmId() {
            return filmId;
        }

        public void setFilmId(int filmId) {
            this.filmId = filmId;
        }

        public int getFilmTypeId() {
            return filmTypeId;
        }

        public void setFilmTypeId(int filmTypeId) {
            this.filmTypeId = filmTypeId;
        }

        public int getIsEggs() {
            return isEggs;
        }

        public void setIsEggs(int isEggs) {
            this.isEggs = isEggs;
        }

        public double getLevelOnePrice() {
            return levelOnePrice;
        }

        public void setLevelOnePrice(double levelOnePrice) {
            this.levelOnePrice = levelOnePrice;
        }

        public double getLevelThreePrice() {
            return levelThreePrice;
        }

        public void setLevelThreePrice(double levelThreePrice) {
            this.levelThreePrice = levelThreePrice;
        }

        public double getLevelTwoPrice() {
            return levelTwoPrice;
        }

        public void setLevelTwoPrice(double levelTwoPrice) {
            this.levelTwoPrice = levelTwoPrice;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getPixlength() {
            return pixlength;
        }

        public void setPixlength(int pixlength) {
            this.pixlength = pixlength;
        }
    }
}
