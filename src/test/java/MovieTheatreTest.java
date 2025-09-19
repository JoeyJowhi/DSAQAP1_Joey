import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieTheatreTest {
    @Test public void TestInsertReservation() {
        MovieTheatre movieTheatreSubject = new MovieTheatre(4, 4);

        movieTheatreSubject.insertReservation(0, 0);

        Assertions.assertEquals(1, movieTheatreSubject.getSeatingArea()[0][0]);
    }

    @Test public void TestRemoveReservation() {
        MovieTheatre movieTheatreSubject = new MovieTheatre(4, 4);

        movieTheatreSubject.insertReservation(0, 0);
        Assertions.assertEquals(1, movieTheatreSubject.getSeatingArea()[0][0]);


        movieTheatreSubject.removeReservation(0, 0);
        Assertions.assertEquals(0, movieTheatreSubject.getSeatingArea()[0][0]);
    }
}