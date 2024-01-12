package org.example.bms.Exceptions;

public class SeatNotAvailableException extends Exception{
    public SeatNotAvailableException() {
        super("Seat not available");
    }
}
