package lld.bookMyShow.entities.cinema;

import lld.bookMyShow.entities.movie.Movie;

import java.util.Map;

public class Show {
    private Movie movie;
    private Slot slot;
    private Map<Integer, Double> seatPrices;
    private CinemaHall cinemaHall;

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Map<Integer, Double> getSeatPrices() {
        return seatPrices;
    }
    public void setSeatPrices(Map<Integer, Double> seatPrices) {
        this.seatPrices = seatPrices;
    }
}
