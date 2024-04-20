package lld.bookMyShow.service;

import lld.bookMyShow.entities.*;
import lld.bookMyShow.entities.cinema.Cinema;
import lld.bookMyShow.entities.cinema.Seat;
import lld.bookMyShow.entities.cinema.SeatStatus;
import lld.bookMyShow.entities.cinema.Show;
import lld.bookMyShow.entities.movie.BookingMetadata;
import lld.bookMyShow.entities.movie.MovieTicket;

import java.util.ArrayList;
import java.util.List;

public class BookingServiceImpl implements BookingService{

    @Override
    public BookingMetadata book(Show show, Cinema cinema, List<Seat> seatList, User user, PaymentMode paymentMode) {

        verifyAndTakelock(seatList);

        BookingMetadata bookingMetadata = generateBookingMetadata(show, cinema, seatList, user);
        DiscountService discountService = new DiscountServiceImpl();
        discountService.getDiscount(user, paymentMode, bookingMetadata.getPrice());
        UPIService upiService = new UPIService();
        // updated price based on discount;
        Boolean paymentStatus = upiService.makePayment(bookingMetadata.getPrice(), user, bookingMetadata);

        releaseLocks(seatList, paymentStatus);
        return paymentStatus ? bookingMetadata : null;

    }

    private void verifyAndTakelock(List<Seat> seatList) {

        seatList.forEach(seat -> {
            if(seat.getSeatStatus() == SeatStatus.RESERVED || seat.getSeatStatus() == SeatStatus.LOCKED){
                throw new RuntimeException();
            }
        });

        seatList.forEach(seat -> {
            seat.setSeatStatus(SeatStatus.LOCKED);
        });
    }

    private BookingMetadata generateBookingMetadata(Show show, Cinema cinema, List<Seat> seatList, User user) {
        BookingMetadata bookingMetadata = new BookingMetadata();
        bookingMetadata.setMovieTicket(generateMovieTicket(show, cinema, seatList, user));
        return bookingMetadata;
    }

    private List<MovieTicket> generateMovieTicket(Show show, Cinema cinema, List<Seat> seatList, User user) {
        List<MovieTicket> movieTickets = new ArrayList<>();
        seatList.forEach(seat -> {
            if(seat.getSeatStatus() == SeatStatus.RESERVED || seat.getSeatStatus() == SeatStatus.LOCKED){
                throw new RuntimeException();
            }
            seat.setSeatStatus(SeatStatus.LOCKED);
            MovieTicket movieTicket = new MovieTicket();

            movieTicket.setTicketPrice(show.getSeatPrices().get(seat.getSeatId()));
            movieTickets.add(movieTicket);
        });
        return movieTickets;
    }

    private void releaseLocks(List<Seat> seatList, boolean isBooked){
        seatList.forEach(seat -> {
            seat.setSeatStatus(isBooked ? SeatStatus.RESERVED : SeatStatus.AVAILABLE);
        });
    }
}
