package capgemini.academy.bootcamp.movies.controller;

import capgemini.academy.bootcamp.movies.models.Movie;
import capgemini.academy.bootcamp.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/movie/")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Iterable<Movie> getAll() {
        return this.movieRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody Movie movie) {
        this.movieRepository.save(movie);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        this.movieRepository.deleteById(id);
    }

    @RequestMapping(value = "watched/{id}",method = RequestMethod.PUT)
    public void toggleWatched(@PathVariable long id){

    }
}
