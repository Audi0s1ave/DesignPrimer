package lld.bookMyShow.entities.cinema;

import lld.bookMyShow.entities.City;

import java.util.List;

public class Cinema {

    private City city;
    private String address;
    private List<Show> showList;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }
}
