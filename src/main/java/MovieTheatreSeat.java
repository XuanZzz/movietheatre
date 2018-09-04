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

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

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
        stringBuilder.append((char)('A'+i));
        stringBuilder.append(j);
        return  stringBuilder.toString();
    }

}


class SortByScore implements Comparator<MovieTheatreSeat>
{
    // Used for sorting in descending order of score
    public int compare(MovieTheatreSeat a, MovieTheatreSeat b)
    {
        return b.getScore() - a.getScore();
    }
}

class SortByPosition implements Comparator<MovieTheatreSeat>
{
    // Used for sorting in descending order of row and column
    public int compare(MovieTheatreSeat a, MovieTheatreSeat b)
    {
        return a.getRow() == b.getRow() ? a.getCol() - b.getCol() : a.getRow() - b.getRow();
    }
}