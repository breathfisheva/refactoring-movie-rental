package cn.xpbootcamp.refactor;

public class Rental {

    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    int getDaysRented() {
        return daysRented;
    }
    
    double getCharge() {
    	double result = 0d;
        switch (getMovie().getPriceCode()) {
        case Movie.HISTORY:
        	result += 2;
            if (getDaysRented() > 2)
            	result += (getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
        	result += getDaysRented() * 3;
            break;
        case Movie.CAMPUS:
        	result += 1.5;
            if (getDaysRented() > 3)
            	result += (getDaysRented() - 3) * 1.5;
            break;
        }
        return result;
    	
    }
}
