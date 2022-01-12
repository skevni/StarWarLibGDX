package com.star.app.screen.utils;

public class Statistics {
    private static int score;
    private static int money;

    private Statistics(){}

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Statistics.score = score;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Statistics.money = money;
    }
}
