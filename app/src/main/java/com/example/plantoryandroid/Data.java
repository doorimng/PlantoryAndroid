package com.example.plantoryandroid;

public class Data {

    public static int score = 70 ;
    public static int condition ;

    public static int clothes ;

    public static int[][] chracterID = {
        { R.drawable.angry, R.drawable.angry_food, R.drawable.angry_umbrella, R.drawable.angry_hawaiian, R.drawable.angry_hairclip, R.drawable.angry_eyemask, R.drawable.angry_dirty, R.drawable.angry_sunglass },
        { R.drawable.soso, R.drawable.soso_food, R.drawable.soso_umbrella, R.drawable.soso_hawaiian, R.drawable.soso_hairclip, R.drawable.soso_eyemask, R.drawable.soso_dirty, R.drawable.soso_sunglass },
        { R.drawable.happy, R.drawable.happy_food, R.drawable.happy_umbrella, R.drawable.happy_hawaiian, R.drawable.happy_hairclip, R.drawable.happy_eyemask, R.drawable.happy_dirty, R.drawable.happy_sunglass }
    } ;

    /* [퀘스트 열람 시스템]
     * 0 - 도전과제 달성 ; 아이템 해금 가능
     * 1 - 아이템 이미 해금됨
     * 2 - 아이템 잠금
     */
    public static int[] questList = {1, 2, 2, 2, 2, 2, 2, 2} ;

    public static int nutrition = 3 ; //  영양제 3번
    public static int water = 0 ; // 물 5번
    public static int flower = 1 ; // 꽃 핌
    public static int fruit = 0 ; // 열매 열림
    public static int ventilation = 1 ; // 환기 팬 작동
    public static int reset = 1 ; // reset버튼 누름
    public static int goodDay = 0 ; // 7일 연속 기분 좋음

}
