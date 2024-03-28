package com.java.Java8Features.StreamAPI.StreamIntermediate;

public record Seat(char rowMarker, int seatNumber, double price) {
    public Seat(char rowMarker, int seatNumber) {

        // for seat marker D,E,F ... and for seat number 1,2 or 9,10
        // make the price 50 else 75
        this(rowMarker, seatNumber,
                rowMarker > 'C' && (seatNumber <= 2 || seatNumber >= 9) ? 50 : 75);
    }

    @Override
    public String toString() {
        // A001 75
        return "%c%03d %.0f".formatted(rowMarker, seatNumber, price);
    }
}
