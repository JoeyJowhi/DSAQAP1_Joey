import java.util.InputMismatchException;
import java.util.Scanner;

public class BookSeating {
    public static void main(String[] args) {
        int seatingRows = 4;
        int seatingColumns = 4;
        MovieTheatre movieTheatre = new MovieTheatre(seatingRows, seatingColumns);

        Scanner userInput = new Scanner(System.in);

        boolean running = true;
        while(running) {
            System.out.print("\nLegend:\n   0 = Available.\n   1 = Reserved.\n");
            System.out.println(movieTheatre);

            System.out.print("Options:\n=========================\n");
            System.out.print("1. Reserve a seat.\n2. Remove a reservation.\n3. Exit.\n");
            System.out.println("=========================");
            System.out.print("Choose an option: ");
            int userChoice = userInput.nextInt();
            userInput.nextLine();


            switch(userChoice) {
                case 1:
                    System.out.print("\nNOTE: Use the diagram above the menu as a reference.\nWhen counting rows and columns, keep in mind to begin at 0 instead of 1 like you normally would.\n");

                    while(true) {
                        try {
                            System.out.print("\nWhich row would you like to be in?: ");
                            int userRow = userInput.nextInt();
                            userInput.nextLine();

                            System.out.print("\nWhich column would you like to be in?: ");
                            int userColumn = userInput.nextInt();
                            userInput.nextLine();

                            if (userRow > seatingRows || userColumn > seatingColumns) {
                                throw new ArrayIndexOutOfBoundsException();
                            }

                            System.out.println(movieTheatre.insertReservation(userRow, userColumn));
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("   Error: Input must be an integer.\n");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("   Error: You entered an integer greater than the number of rows/columns. Remember to count from 0 instead of 1.");
                        }
                    }

                    System.out.print("\nPress 'Enter' to return to the menu: ");
                    userInput.nextLine();
                    break;
                case 2:
                    System.out.print("\nNOTE: Use the diagram above the menu as a reference.\nWhen counting rows and columns, keep in mind to begin at 0 instead of 1 like you normally would.\n");

                    while(true) {
                        try {
                            System.out.print("\nWhich row is the reservation in?: ");
                            int userRow = userInput.nextInt();
                            userInput.nextLine();

                            System.out.print("\nWhich column is the reservation in?: ");
                            int userColumn = userInput.nextInt();
                            userInput.nextLine();

                            if (userRow > seatingRows || userColumn > seatingColumns) {
                                throw new ArrayIndexOutOfBoundsException();
                            }

                            System.out.println(movieTheatre.removeReservation(userRow, userColumn));
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("   Error: Input must be an integer.\n");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("   Error: You entered an integer greater than the number of rows/columns. Remember to count from 0 instead of 1.");
                        }
                    }

                    System.out.print("\nPress 'Enter' to return to the menu: ");
                    userInput.nextLine();
                    break;
                case 3:
                    System.out.println("Goodbye, have an excellent day!");
                    running = false;
                    break;
                default:
                    System.out.println("   Error: You chose an invalid option.");
                    System.out.print("\nPress 'Enter' to return to the menu: ");
                    userInput.nextLine();
            }
        }
    }
}