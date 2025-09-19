import java.util.Arrays;

public class MovieTheatre {
    private int[][] seatingArea;

    //Constructor
    public MovieTheatre(int seatingRows, int seatingColumns) {
        this.seatingArea = new int[seatingRows][seatingColumns];
    }


    //Instance Methods
    @Override public String toString() throws ArrayIndexOutOfBoundsException {
        try {
            StringBuilder toString2D = new StringBuilder();

            for (int row = 0; row < this.seatingArea.length; row++) {
                toString2D.append("[ ");
                for (int column = 0; column < this.seatingArea[row].length; column++) {
                    toString2D.append("[" + this.seatingArea[row][column] + "]");
                }

                toString2D.append(" ]\n");
            }

            return toString2D.toString();
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Error: " + e;
        }
    }

    public String insertReservation(int rowSelector, int columnSelector) throws ArrayIndexOutOfBoundsException {
        try {
            int desiredSeat = this.seatingArea[rowSelector][columnSelector];

            if (desiredSeat != 1) {
                this.seatingArea[rowSelector][columnSelector] = 1;
                return "Seat reserved successfully.";
            } else {
                return "Seat already reserved.";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Error: " + e;
        }
    }

    public String removeReservation(int rowSelector, int columnSelector) throws ArrayIndexOutOfBoundsException {
        try {
            int desiredSeat = this.seatingArea[rowSelector][columnSelector];

            if (desiredSeat != 1) {
                return "Seat already has no reservation.";
            } else {
                this.seatingArea[rowSelector][columnSelector] = 0;
                return "Seat reservation successfully removed.";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Error: " + e;
        }
    }


    //Getter Methods
    public int[][] getSeatingArea() {
        return this.seatingArea;
    }


    //Setter Methods
    public void setSeatingArea(int seatingRows, int seatingColumns) {
        this.seatingArea = new int[seatingRows][seatingColumns];
    }
}