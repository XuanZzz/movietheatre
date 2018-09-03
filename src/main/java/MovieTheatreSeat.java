import java.util.Comparator;

public class MovieTheatreSeat {

    public int getScore() {
        return score;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    private int score;
    private int row;
    private int col;
    private String name;
    private boolean isAvailable;

    public MovieTheatreSeat(int row, int col, int score) {
        this.row = row;
        this.col = col;
        this.score = score;
        this.isAvailable = true;
        this.name = translateSeatNumber(row, col);
    }

    private String translateSeatNumber(int i, int j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i+'A');
        stringBuilder.append(j);
        return  stringBuilder.toString();
    }

}


class SortByScore implements Comparator<MovieTheatreSeat>
{
    // Used for sorting in ascending order of score
    public int compare(MovieTheatreSeat a, MovieTheatreSeat b)
    {
        return a.getScore() - b.getScore();
    }
}
