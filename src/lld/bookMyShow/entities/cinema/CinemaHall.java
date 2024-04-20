package lld.bookMyShow.entities.cinema;

import lld.bookMyShow.entities.cinema.Seat;
import lld.bookMyShow.entities.cinema.SeatStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CinemaHall {
    private Map<Integer, Seat> seatList;
    private Integer cinemaHallId;
    public Integer getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Integer cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public Map<Integer, Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(Map<Integer, Seat> seatList) {
        this.seatList = seatList;
    }

    public SeatStatus checkStatus(Integer seatId){
        return seatList.get(seatId).getSeatStatus();
    }

    public List<Integer> getAvailableSeats(){
        return new ArrayList<>(seatList.keySet());
    }

}
