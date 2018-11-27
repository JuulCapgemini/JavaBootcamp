package capgemini.academy.bootcamp.movies.controller;

import capgemini.academy.bootcamp.movies.models.Movie;
import capgemini.academy.bootcamp.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movie/")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Iterable<Movie> getAll() {
        return this.movieRepository.findAll();
    }
}
