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
    
    private double getTotalCharge() {
    	double result = 0;
    	Enumeration<Rental> rentals = this.rentals.elements();
    	
    	while(rentals.hasMoreElements()) {
    		Rental each = rentals.nextElement();
    		result += each.getCharge();
    	}
    	return result;
    	
    }
    

    String statement() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");
       
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            //show figures for this rental
           
            //add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();

            //show figures for this rental
            result.append("\t")
                  .append(each.getMovie().getTitle())
                  .append("\t")
                  .append(each.getCharge()).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}
