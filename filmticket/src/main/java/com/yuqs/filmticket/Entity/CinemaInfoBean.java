package com.yuqs.filmticket.Entity;

/**
 * Created by 46433 on 17/06/14.
 */

public class CinemaInfoBean {

    /**
     * cinema : {"activityCount":0,"address":"安庆市大观区安徽省安庆市大观区纺织南 路80号1号楼第4层","areaId":340803,"areaName":"大观区","cinemaGroup":0,"cinemacode":"34081501","cinemanumber":"20003023","cityId":340800,"cityName":"安庆市","closeTime":"1970-01-01T00:00:00","cname":"安庆比高电影城（华茂店）","company":1,"contactName":"陈亚玲","ctype":10,"descript":"安庆比高电影城位于安徽省安庆市纺织南路80号新地城四楼（家乐福楼上）。影城共设6厅，其中五个3D厅，总座位数为1447个，荧幕的设计上也采用国内高端的金属荧幕且荧幕为112平尺寸的荧幕面积，在设计上按照五星级标准的规范设计，1米2的排距也使观众倍感舒适，影城已于2014年1月8日正式开业,影城内还配有咖啡吧，给您带来更多的观影选择。","dockingFlag":1,"domainType":"1","enname":"","gainCardStatus":0,"id":4366,"isGrade":0,"isGradient":2,"isSale":4,"latitude":30.548843,"logo":"http://img.vcfilm.cn:8080/resource//mycinema/20160719/201607191456500a6e2fa60c.png","longitude":117.069408,"lprice":0,"memberGroupId":0,"memberId":0,"memberSystype":0,"mobile":"","mtimeCode":"4683","offlineMember":2,"offlineRecharge":1,"openIntegral":0,"openMemberGrade":0,"openProduct":0,"openServicePrice":0,"openSign":0,"openTime":"1970-01-01T10:00:00","provinceId":340000,"provinceName":"安徽省","ptel":"","regionId":2,"regionName":"华北大区","rwlineId":7,"rwlineName":"时代华夏今典电影院线","sellTopTime":15,"servicePrice":0,"tel":"0556-0556-5290606","telCode":"0556","type":4,"unionType":0,"wechatThemeId":1,"wechatThemeTemp":0}
     * status : ok
     */

    private CinemaInfo cinema;
    private String status;

    public CinemaInfo getCinema() {
        return cinema;
    }

    public void setCinema(CinemaInfo cinema) {
        this.cinema = cinema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class CinemaInfo {
        /**
         * activityCount : 0
         * address : 安庆市大观区安徽省安庆市大观区纺织南 路80号1号楼第4层
         * areaId : 340803
         * areaName : 大观区
         * cinemaGroup : 0
         * cinemacode : 34081501
         * cinemanumber : 20003023
         * cityId : 340800
         * cityName : 安庆市
         * closeTime : 1970-01-01T00:00:00
         * cname : 安庆比高电影城（华茂店）
         * company : 1
         * contactName : 陈亚玲
         * ctype : 10
         * descript : 安庆比高电影城位于安徽省安庆市纺织南路80号新地城四楼（家乐福楼上）。影城共设6厅，其中五个3D厅，总座位数为1447个，荧幕的设计上也采用国内高端的金属荧幕且荧幕为112平尺寸的荧幕面积，在设计上按照五星级标准的规范设计，1米2的排距也使观众倍感舒适，影城已于2014年1月8日正式开业,影城内还配有咖啡吧，给您带来更多的观影选择。
         * dockingFlag : 1
         * domainType : 1
         * enname :
         * gainCardStatus : 0
         * id : 4366
         * isGrade : 0
         * isGradient : 2
         * isSale : 4
         * latitude : 30.548843
         * logo : http://img.vcfilm.cn:8080/resource//mycinema/20160719/201607191456500a6e2fa60c.png
         * longitude : 117.069408
         * lprice : 0.0
         * memberGroupId : 0
         * memberId : 0
         * memberSystype : 0
         * mobile :
         * mtimeCode : 4683
         * offlineMember : 2
         * offlineRecharge : 1
         * openIntegral : 0
         * openMemberGrade : 0
         * openProduct : 0
         * openServicePrice : 0
         * openSign : 0
         * openTime : 1970-01-01T10:00:00
         * provinceId : 340000
         * provinceName : 安徽省
         * ptel :
         * regionId : 2
         * regionName : 华北大区
         * rwlineId : 7
         * rwlineName : 时代华夏今典电影院线
         * sellTopTime : 15
         * servicePrice : 0.0
         * tel : 0556-0556-5290606
         * telCode : 0556
         * type : 4
         * unionType : 0
         * wechatThemeId : 1
         * wechatThemeTemp : 0
         */

        private int activityCount;
        private String address;
        private int areaId;
        private String areaName;
        private int cinemaGroup;
        private String cinemacode;
        private String cinemanumber;
        private int cityId;
        private String cityName;
        private String closeTime;
        private String cname;
        private int company;
        private String contactName;
        private int ctype;
        private String descript;
        private int dockingFlag;
        private String domainType;
        private String enname;
        private int gainCardStatus;
        private int id;
        private int isGrade;
        private int isGradient;
        private int isSale;
        private double latitude;
        private String logo;
        private double longitude;
        private double lprice;
        private int memberGroupId;
        private int memberId;
        private int memberSystype;
        private String mobile;
        private String mtimeCode;
        private int offlineMember;
        private int offlineRecharge;
        private int openIntegral;
        private int openMemberGrade;
        private int openProduct;
        private int openServicePrice;
        private int openSign;
        private String openTime;
        private int provinceId;
        private String provinceName;
        private String ptel;
        private int regionId;
        private String regionName;
        private int rwlineId;
        private String rwlineName;
        private int sellTopTime;
        private double servicePrice;
        private String tel;
        private String telCode;
        private int type;
        private int unionType;
        private int wechatThemeId;
        private int wechatThemeTemp;

        public int getActivityCount() {
            return activityCount;
        }

        public void setActivityCount(int activityCount) {
            this.activityCount = activityCount;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public int getCinemaGroup() {
            return cinemaGroup;
        }

        public void setCinemaGroup(int cinemaGroup) {
            this.cinemaGroup = cinemaGroup;
        }

        public String getCinemacode() {
            return cinemacode;
        }

        public void setCinemacode(String cinemacode) {
            this.cinemacode = cinemacode;
        }

        public String getCinemanumber() {
            return cinemanumber;
        }

        public void setCinemanumber(String cinemanumber) {
            this.cinemanumber = cinemanumber;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCloseTime() {
            return closeTime;
        }

        public void setCloseTime(String closeTime) {
            this.closeTime = closeTime;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public int getCompany() {
            return company;
        }

        public void setCompany(int company) {
            this.company = company;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public int getCtype() {
            return ctype;
        }

        public void setCtype(int ctype) {
            this.ctype = ctype;
        }

        public String getDescript() {
            return descript;
        }

        public void setDescript(String descript) {
            this.descript = descript;
        }

        public int getDockingFlag() {
            return dockingFlag;
        }

        public void setDockingFlag(int dockingFlag) {
            this.dockingFlag = dockingFlag;
        }

        public String getDomainType() {
            return domainType;
        }

        public void setDomainType(String domainType) {
            this.domainType = domainType;
        }

        public String getEnname() {
            return enname;
        }

        public void setEnname(String enname) {
            this.enname = enname;
        }

        public int getGainCardStatus() {
            return gainCardStatus;
        }

        public void setGainCardStatus(int gainCardStatus) {
            this.gainCardStatus = gainCardStatus;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsGrade() {
            return isGrade;
        }

        public void setIsGrade(int isGrade) {
            this.isGrade = isGrade;
        }

        public int getIsGradient() {
            return isGradient;
        }

        public void setIsGradient(int isGradient) {
            this.isGradient = isGradient;
        }

        public int getIsSale() {
            return isSale;
        }

        public void setIsSale(int isSale) {
            this.isSale = isSale;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLprice() {
            return lprice;
        }

        public void setLprice(double lprice) {
            this.lprice = lprice;
        }

        public int getMemberGroupId() {
            return memberGroupId;
        }

        public void setMemberGroupId(int memberGroupId) {
            this.memberGroupId = memberGroupId;
        }

        public int getMemberId() {
            return memberId;
        }

        public void setMemberId(int memberId) {
            this.memberId = memberId;
        }

        public int getMemberSystype() {
            return memberSystype;
        }

        public void setMemberSystype(int memberSystype) {
            this.memberSystype = memberSystype;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getMtimeCode() {
            return mtimeCode;
        }

        public void setMtimeCode(String mtimeCode) {
            this.mtimeCode = mtimeCode;
        }

        public int getOfflineMember() {
            return offlineMember;
        }

        public void setOfflineMember(int offlineMember) {
            this.offlineMember = offlineMember;
        }

        public int getOfflineRecharge() {
            return offlineRecharge;
        }

        public void setOfflineRecharge(int offlineRecharge) {
            this.offlineRecharge = offlineRecharge;
        }

        public int getOpenIntegral() {
            return openIntegral;
        }

        public void setOpenIntegral(int openIntegral) {
            this.openIntegral = openIntegral;
        }

        public int getOpenMemberGrade() {
            return openMemberGrade;
        }

        public void setOpenMemberGrade(int openMemberGrade) {
            this.openMemberGrade = openMemberGrade;
        }

        public int getOpenProduct() {
            return openProduct;
        }

        public void setOpenProduct(int openProduct) {
            this.openProduct = openProduct;
        }

        public int getOpenServicePrice() {
            return openServicePrice;
        }

        public void setOpenServicePrice(int openServicePrice) {
            this.openServicePrice = openServicePrice;
        }

        public int getOpenSign() {
            return openSign;
        }

        public void setOpenSign(int openSign) {
            this.openSign = openSign;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getPtel() {
            return ptel;
        }

        public void setPtel(String ptel) {
            this.ptel = ptel;
        }

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        public int getRwlineId() {
            return rwlineId;
        }

        public void setRwlineId(int rwlineId) {
            this.rwlineId = rwlineId;
        }

        public String getRwlineName() {
            return rwlineName;
        }

        public void setRwlineName(String rwlineName) {
            this.rwlineName = rwlineName;
        }

        public int getSellTopTime() {
            return sellTopTime;
        }

        public void setSellTopTime(int sellTopTime) {
            this.sellTopTime = sellTopTime;
        }

        public double getServicePrice() {
            return servicePrice;
        }

        public void setServicePrice(double servicePrice) {
            this.servicePrice = servicePrice;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getTelCode() {
            return telCode;
        }

        public void setTelCode(String telCode) {
            this.telCode = telCode;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUnionType() {
            return unionType;
        }

        public void setUnionType(int unionType) {
            this.unionType = unionType;
        }

        public int getWechatThemeId() {
            return wechatThemeId;
        }

        public void setWechatThemeId(int wechatThemeId) {
            this.wechatThemeId = wechatThemeId;
        }

        public int getWechatThemeTemp() {
            return wechatThemeTemp;
        }

        public void setWechatThemeTemp(int wechatThemeTemp) {
            this.wechatThemeTemp = wechatThemeTemp;
        }
    }
}
