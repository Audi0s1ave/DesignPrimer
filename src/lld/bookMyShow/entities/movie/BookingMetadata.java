package lld.bookMyShow.entities.movie;

import lld.bookMyShow.entities.cinema.Show;
import lld.bookMyShow.entities.User;
import lld.bookMyShow.entities.cinema.Cinema;
import lld.bookMyShow.entities.cinema.Seat;

import java.util.List;

public class BookingMetadata {

    private Double price;
    private String bookingId;
    private Show show;
    private Cinema cinema;
    private List<Seat> seatList;
    private List<MovieTicket> movieTicket;
    private User user;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public List<MovieTicket> getMovieTicket() {
        return movieTicket;
    }

    public void setMovieTicket(List<MovieTicket> movieTicket) {
        this.movieTicket = movieTicket;
    }
}
