package cn.xpbootcamp.refactor;

public class Movie {

    static final int CAMPUS = 2;
    static final int HISTORY = 0;
    static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    int getPriceCode() {
        return priceCode;
    }

    String getTitle() {
        return title;
    }
}
