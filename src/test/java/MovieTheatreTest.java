import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTheatreTest {
    private MovieTheatre movieTheatre;

    @Test
    void MovieTheatreTest() {
        try {
            movieTheatre = new MovieTheatre(10, 20);
        }
        catch (Exception e) {
            fail("Unknown error during instantiation.");
        }
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
}