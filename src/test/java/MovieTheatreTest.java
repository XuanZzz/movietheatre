import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTheatreTest {
    private static MovieTheatre movieTheatre;

    @BeforeEach
    void setUp() throws Exception {
        movieTheatre = new MovieTheatre(10, 20);
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
    void getSeatsTest() throws Exception {
        List<MovieTheatreSeat> seats = movieTheatre.getSeats(2);
        assertEquals(2, seats.size());
        assertEquals("F9", seats.get(0).getName());
        assertEquals("F10", seats.get(1).getName());

        assertEquals(false, movieTheatre.isSeatAvailable(5, 10));
        assertEquals(false, movieTheatre.isSeatAvailable(5, 9));

        try {
            seats = movieTheatre.getSeats(200);
            fail("Exception wasn't thrown due to not enough seats.");
        }
        catch(Exception e) {}
    }
}