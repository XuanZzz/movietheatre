import java.util.ArrayList;
import java.util.List;

public class MovieTheatre {
    private List<List<Boolean>> seats;
    private List<List<Integer>> scores;
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
        return seats.get(i).get(j);
    }

    private int availableSeats;

    // initialize scores for different seats in the theatre
    private void initScores() {
        scores = new ArrayList<List<Integer>>();
        // center seats: 100, decrease by distance from center seats
        int midRow = ROWS / 2;
        int diffRow = 100 / ROWS;
        int midCol = COLS / 2;
        int diffCol = 100 / COLS;
        // set scores for each row, then add to scores matrix
        for(int i = 0; i < ROWS; ++i) {
            List<Integer> currRow = new ArrayList<Integer>();
            // base score for the leftmost seats in current row
            int baseScore = 100 - (Math.abs(i - midRow) * diffRow) - midCol * diffCol;
            for(int j = 0; j < COLS; ++j) {
                currRow.add(baseScore);
                // before reach the middle seat, add score, after, decrease score
                baseScore += j < midCol ? diffCol : -diffCol;
            }
            scores.add(currRow);
        }
    }

    public MovieTheatre(int rows, int cols) throws Exception {
        if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Illegal number of rows and/or columns!");
        }

        ROWS = rows;
        COLS = cols;
        CAPACITY = ROWS * COLS;
        availableSeats = 0;

        seats = new ArrayList<List<Boolean>>();
        for(int i=0; i<ROWS; ++i) {
            List<Boolean> currRow = new ArrayList<Boolean>(COLS);
            seats.add(currRow);
        }
        initScores();
    }

    private String translateSeatNumber(int i, int j) {
        if(i < 0 || i >= ROWS || j < 0 || j >= COLS) {
            throw  new IllegalArgumentException("Illegal query parameters: row/column number!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i+'A');
        stringBuilder.append(j);
        return  stringBuilder.toString();
    }

    public List<List<String>> getSeats(int numSeats) throws Exception {
        if(numSeats > availableSeats) {
            throw new IllegalArgumentException("Illegal number of seats requested!");
        }
        List<List<String>> res = new ArrayList<List<String>>();
        return res;
    }
}
