package service;

import entyties.TaxiRide;

/**
 * Created by alexm on 26.08.2019.
 */
public class Price {

    Distance distance;
    TaxiRide taxiRide;
   private double price;

    public Distance getDistance() {
        return distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
