package lld.bookMyShow.service;

import lld.bookMyShow.entities.*;
import lld.bookMyShow.entities.cinema.Cinema;
import lld.bookMyShow.entities.cinema.Seat;
import lld.bookMyShow.entities.cinema.Show;
import lld.bookMyShow.entities.movie.BookingMetadata;

import java.util.List;

public interface BookingService {

    BookingMetadata book(Show show, Cinema cinema, List<Seat> seatList, User user, PaymentMode paymentMode);


}
