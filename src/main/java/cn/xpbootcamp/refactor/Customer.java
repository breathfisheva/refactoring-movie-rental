package cn.xpbootcamp.refactor;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }
    
    private double amountFor(Rental arental) {
    	double result = 0d;
        switch (arental.getMovie().getPriceCode()) {
        case Movie.HISTORY:
        	result += 2;
            if (arental.getDaysRented() > 2)
            	result += (arental.getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
        	result += arental.getDaysRented() * 3;
            break;
        case Movie.CAMPUS:
        	result += 1.5;
            if (arental.getDaysRented() > 3)
            	result += (arental.getDaysRented() - 3) * 1.5;
            break;
        }
        return result;
    	
    }

    String statement() {
        double totalAmount = 0d;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            //show figures for this rental
            //determine amounts for each line
            double thisAmount = 0d;
            thisAmount = amountFor(each);
           
            //add frequent renter points
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            //show figures for this rental
            result.append("\t")
                  .append(each.getMovie().getTitle())
                  .append("\t")
                  .append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}
