package lld.bookMyShow.service;

import lld.bookMyShow.entities.City;
import lld.bookMyShow.entities.movie.Movie;

import java.time.LocalDateTime;
import java.util.List;

public interface SearchService {

    List<Movie> searchByTitle(String title);
    List<Movie> searchByGenre(String genre);
    List<Movie> searchByDate(LocalDateTime releaseDate);
    List<Movie> searchByCity(City city);

}
