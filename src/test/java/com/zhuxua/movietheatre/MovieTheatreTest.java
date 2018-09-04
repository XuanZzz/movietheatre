package com.zhuxua.movietheatre;

import com.zhuxua.movietheatre.MovieTheatreSeat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTheatreTest {
    private static MovieTheatre movieTheatre;

    @BeforeEach
    void setUp() throws Exception {
        movieTheatre = new MovieTheatre(10, 20, "Mission Impossible: Fallout");
    }

    @Test
    void MovieTheatreExceptionTest() {
        try {
            movieTheatre = new MovieTheatre(-10, 0);
            fail("Exception of illegal input arguments not thrown.");
        }
        catch (Exception e) {}
    }

    @Test
    void isSeatAvailableTest() {
        try {
            movieTheatre = new MovieTheatre(10, 20);
            assertTrue(movieTheatre.isSeatAvailable(0, 0));
            movieTheatre.isSeatAvailable(-1, 0);
            fail("Exception of illegal input arguments not thrown.");
        }
        catch(Exception e) {}

    }

    @Test
    void getAvailableSeatsTest() {
        assertEquals(200, movieTheatre.getAvailableSeats());
    }

    @Test
    void getMovieNameTest() {
        movieTheatre.setMovieName("Avengers: Infinity War");
        assertEquals("Avengers: Infinity War", movieTheatre.getMovieName());
    }

    @Test
    void getSeatsTest() throws Exception {
        List<MovieTheatreSeat> seats = movieTheatre.getSeats(2);
        assertEquals(2, seats.size());
        assertEquals("F10", seats.get(0).getName());
        assertEquals("F11", seats.get(1).getName());

        assertEquals(198, movieTheatre.getAvailableSeats());
        assertEquals(false, movieTheatre.isSeatAvailable(5, 10));
        assertEquals(false, movieTheatre.isSeatAvailable(5, 9));

        try {
            movieTheatre.getSeats(200);
            fail("Exception wasn't thrown due to not enough seats.");
        }
        catch(Exception e) {}
    }
}