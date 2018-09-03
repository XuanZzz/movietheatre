import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MovieTheatre {
    private MovieTheatreSeat[][] seats; // true as occupied
    private PriorityQueue<MovieTheatreSeat> pq; // store scores of seats for getting best seats
    private final int ROWS;
    private final int COLS;
    private final int CAPACITY;

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean isSeatAvailable(int i, int j) {
        if(i < 0 || i >= ROWS || j < 0 || j >= COLS) {
            throw  new IllegalArgumentException("Illegal query parameters: row/column number!");
        }
        return seats[i][j].isAvailable();
    }

    private int availableSeats;

    // initialize scores for different seats in the theatre
    private void initSeats() {
        pq = new PriorityQueue<MovieTheatreSeat>(CAPACITY, new SortByScore());

        // center seats: 100, decrease by distance from center seats
        int midRow = ROWS / 2;
        int diffRow = 100 / ROWS;
        int midCol = COLS / 2;
        int diffCol = 100 / COLS;
        // set scores for each row, then add to scores matrix
        for(int i = 0; i < ROWS; ++i) {
            // base score for the leftmost seats in current row
            int baseScore = 100 - (Math.abs(i - midRow) * diffRow) - midCol * diffCol;
            for(int j = 0; j < COLS; ++j) {
                MovieTheatreSeat currSeat = new MovieTheatreSeat(i, j, baseScore);
                seats[i][j] = currSeat;
                pq.add(currSeat);
                // before reach the middle seat, add score, after, decrease score
                baseScore += j < midCol ? diffCol : -diffCol;
            }
        }

    }


    public MovieTheatre(int rows, int cols) throws Exception {
        if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Illegal number of rows and/or columns!");
        }

        ROWS = rows;
        COLS = cols;
        CAPACITY = ROWS * COLS;
        availableSeats = CAPACITY;

        seats = new MovieTheatreSeat[ROWS][COLS];
        initSeats();
    }


    private void getNeighbourSeats(MovieTheatreSeat seat, int targetNum) {

    }

    public List<MovieTheatreSeat> getSeats(int numSeats) throws Exception {
        if(numSeats > availableSeats) {
            throw new IllegalArgumentException("Illegal number of seats requested!");
        }
        List<MovieTheatreSeat> res = new ArrayList<MovieTheatreSeat>();

        MovieTheatreSeat bestSeat = pq.poll();


        getNeighbourSeats(bestSeat, numSeats - 1);

        return res;
    }
}
