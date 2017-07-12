package com.yuqs.filmticket.Entity;

/**
 * Created by 46433 on 17/05/11.
 */

public interface IURL {

    /*
     * 请求URL
     */
    String BOOT = "http://app.vcfilm.cn/";
    String GET_PLAYING_FILM = BOOT + "film/getHotFilmByCityId4App";
    String GET_FUTURE_FILM = BOOT + "film/getFutureFilmByPage";
    String GET_CITY = BOOT + "cinema/getTicketCity";
    String GET_FILM_INFO = BOOT + "film/viewFilmInfo";
    String GET_FILM_BY_FILM_AND_CITY = BOOT + "film/getCinemaListByCityIdAndFilmId";
    String GET_CINEMA_INFO_BY_ID = BOOT + "cinema/getCinemaInfoByID";//cinemaID=1423
    String GET_HOT_FILM_BY_CINEMA_ID = BOOT + "film/getHotFilmByCinemaId";//cinemaId=1423
    String GET_FILM_PLAN = BOOT + "cinemaPlan/getFilmPlan";//filmId=10292&cinemaID=1423&curDate=2017-06-10&mgroupId=0
    String GET_CINEMA_LIST = BOOT + "cinema/getCinemaList";//cityId=420100
    String GET_AREA_BY_CITY = BOOT + "cinema/getAreaByCity";//cityId=420100


    /*
     * 固定语句
     */
    String TOKEN = "a3e78fbef9103c6272ebd28c3fe70709";
    String KEY = "data";


    /*
     * action、参数
     */
    String ACTION_FILM_ID = "filmID";
    String ACTION_CITY_ID = "cityId";
    String ACTION_FILM_TYPE = "filmType";
    String ACTION_FILM_NAME = "filmName";
    String ACTION_LOGIN = "LOGIN";
    String ACTION_REGISTER = "REGISTER";


    int REGISTER_REQUEST_CODE = 10001;
    int FILM_TYPE_PLAYING = 0;
    int FILM_TYPE_FUTURE = 1;
    int FILM_TYPE_CHOSEN_CINEMA = 2;



    int STATE_SUCCESS =0;//成功
}
