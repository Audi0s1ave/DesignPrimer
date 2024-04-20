package lld.bookMyShow.service;

import lld.bookMyShow.entities.movie.BookingMetadata;
import lld.bookMyShow.entities.User;

public interface PaymentService {

    Boolean makePayment(Double price, User user, BookingMetadata metadata);



}
