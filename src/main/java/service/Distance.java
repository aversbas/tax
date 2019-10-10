package service;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;
import entyties.Street;
import entyties.TaxiRide;

/**
 * Created by alexm on 24.08.2019.
 */
public class Distance {

    //system заменить на логгер

    private static final String API_KEY = "AIzaSyB4thTQGEr7ZBTzZQIJRJdSyFG9KMY8Kh8";
    private static final GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
    private static final Double PRICE_BY_TRIP_METER = 0.10;
    private static Double resultPrice = null;
    private static final Double TREE_PERCENT_DISCOUNT = resultPrice * 3 / 100;
    private static final Double FIVE_PERCENT_DISCOUNT = resultPrice * 5 / 100;
    private static final Double SEVEN_PERCENT_DISCOUNT = resultPrice * 7 / 100;
    private static final Double TEN_PERCENT_DISCOUNT = resultPrice * 10 / 100;

    public void calculate(TaxiRide start, TaxiRide end) throws Exception {

        Street addressStart = start.getStartAddress();
        Street addressEnd = end.getEndAddress();

        DirectionsResult result = DirectionsApi.newRequest(context)
                .origin(String.valueOf(addressStart)).destination(String.valueOf(addressEnd))
                .mode(TravelMode.DRIVING).await();
        for (DirectionsRoute route : result.routes) {
            long distanceInMeters = route.legs[0].distance.inMeters;
            System.out.println(distanceInMeters);

        }
    }


    public Double price(TaxiRide start, TaxiRide end) throws Exception {

        Street addressStart = start.getStartAddress();
        Street addressEnd = end.getEndAddress();

        DirectionsResult result = DirectionsApi
                .newRequest(context)
                .origin(String.valueOf(addressStart))
                .destination(String.valueOf(addressEnd))
                .mode(TravelMode.DRIVING)
                .await();

        for (DirectionsRoute route : result.routes) {
            System.out.println(resultPrice = route.legs[0].distance.inMeters * PRICE_BY_TRIP_METER);
        }

        return resultPrice;
    }

    public void discountTrip() {

        if (resultPrice >= 500 && resultPrice <= 1000) {
            double result = resultPrice - TREE_PERCENT_DISCOUNT;
            System.out.println(result);
        }

        if (resultPrice >= 1000 && resultPrice <= 1500) {
            double result = resultPrice - FIVE_PERCENT_DISCOUNT;
            System.out.println(result);
        }

        if (resultPrice >= 1500 && resultPrice <= 2000) {
            double result = resultPrice - SEVEN_PERCENT_DISCOUNT;
            System.out.println(result);
        }

        if (resultPrice >= 2000 && resultPrice <= 2500) {
            double result = resultPrice - TEN_PERCENT_DISCOUNT;
            System.out.println(result);
        }

    }
}





