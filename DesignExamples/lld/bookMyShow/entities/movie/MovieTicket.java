package lld.bookMyShow.entities.movie;

import lld.bookMyShow.entities.cinema.Cinema;
import lld.bookMyShow.entities.cinema.Seat;
import lld.bookMyShow.entities.cinema.Show;

public class MovieTicket {
    private Movie movie;
    private Show show;
    private Cinema cinema;
    private Double ticketPrice;
    private String ticketId;
    private Seat seat;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
