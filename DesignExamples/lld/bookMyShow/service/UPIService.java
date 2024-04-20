package lld.bookMyShow.service;

import lld.bookMyShow.entities.movie.BookingMetadata;
import lld.bookMyShow.entities.User;

public class UPIService implements PaymentService{
    @Override
    public Boolean makePayment(Double price, User user, BookingMetadata metadata) {
       // BL
        return Boolean.TRUE;
    }
}
