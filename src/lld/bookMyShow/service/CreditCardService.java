package lld.bookMyShow.service;

import lld.bookMyShow.entities.movie.BookingMetadata;
import lld.bookMyShow.entities.User;

public class CreditCardService implements PaymentService{
    @Override
    public Boolean makePayment(Double price, User user, BookingMetadata metadata) {
        return Boolean.TRUE;
    }


}
