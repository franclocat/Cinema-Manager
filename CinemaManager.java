//package cinema;
import java.util.*;

public class CinemaManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //number of rows for the grid
        System.out.println("Enter the number of rows:");
        final int numberOfRows = scanner.nextInt();
        //number of columns for the grid
        System.out.println("Enter the number of seats in each row:");
        final int numberOfColumns = scanner.nextInt();

        final int totalSeats = numberOfRows * numberOfColumns;
        int ticketPrice = 10;
        String[][] cinemaGrid = new String[numberOfRows][numberOfColumns];
        //make the startig grid with S
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                cinemaGrid[i][j] = "S";
            }
        }
        /*****************************************************************/
        for(;;) {
            boolean end = false;
            System.out.print("""
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                    """);

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    printGrid(cinemaGrid, numberOfRows, numberOfColumns);
                    break;
                case 2:
                    updatedGrid(cinemaGrid, numberOfColumns, numberOfRows, totalSeats);
                    break;
                case 3:
                    //showStatistics(cinemaGrid, totalSeats, numberOfRows, numberOfColumns, purchasedTickets, totalIncome);
                    System.out.println("Number of purchased tickets: " + getPurchasedTickets(cinemaGrid, numberOfRows, numberOfColumns));
                    System.out.println("Percentage: " + String.format("%.2f", getPercentageOfTickets(totalSeats, getPurchasedTickets(cinemaGrid, numberOfRows, numberOfColumns))) + "%");
                    System.out.println("Current income: " + "$" + getCurrentIncome(cinemaGrid, totalSeats, numberOfRows, numberOfColumns));
                    System.out.println("Total income: " + "$" + getTotalIncome(numberOfRows, numberOfColumns, totalSeats) + "\n");
                    break;
                case 0:
                    end = true;
                    break;
            }
            if (end) {
                break;
            }
        }
        /*****************************************************************/
    }

    public static void printGrid(String[][] cinemaGrid, int numberOfRows, int numberOfColumns) {

        System.out.print("Cinema:\n  ");
        for (int i = 0; i < numberOfColumns; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.print("\n");

        for (int i = 0; i < numberOfRows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print(" " + cinemaGrid[i][j]);
            }
            System.out.println();
        }
        System.out.println(); 
    }
    
    public static void updatedGrid(String[][] cinemaGrid,int numberOfRows, int numberOfColumns, int totalSeats) {
        Scanner scanner = new Scanner(System.in);
        int ticketPrice = 10;

        for (;;) {
            System.out.println("Enter a row number:");
            int wantedRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int wantedSeat = scanner.nextInt();
        
            if (wantedRow > numberOfRows || wantedSeat > numberOfColumns) {
                System.out.println("Wrong input!");
                continue;
            } else if (cinemaGrid[wantedRow - 1][wantedSeat - 1].equals("B")) {
                System.out.println("That ticket has already been purchased!");
                continue;
            } else {
                cinemaGrid[wantedRow - 1][wantedSeat - 1] = "B";
                if (totalSeats <= 60) {
                    System.out.println("Ticket price: " + "$" + ticketPrice + "\n");
                } else {
                    if (wantedRow > numberOfRows / 2) {
                        ticketPrice = 8;
                        System.out.println("Ticket price: " + "$" + ticketPrice + "\n");  
                    } else {
                        System.out.println("Ticket price: " + "$" + ticketPrice + "\n");
                    }
                }
                break;
            }
        }
    }

    public static int getTotalIncome(int numberOfRows, int numberOfColumns, int totalSeats) {
        int firstHalf = (numberOfRows / 2) * numberOfColumns;
        int total = 0;
        if (totalSeats <= 60) {
            total = totalSeats * 10;
        } else {
            if (numberOfRows % 2 != 0) {
                int secondHalf = (numberOfRows / 2 + 1) * numberOfColumns;
                total = firstHalf * 10 + secondHalf * 8;
            }
        }
        return total;
    }

    public static int getPurchasedTickets(String[][] cinemaGrid, int numberOfRows, int numberOfColumns) {
        int purchasedTickets = 0;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j< numberOfColumns; j++) {
                if (cinemaGrid[i][j].equals("B")) {
                    purchasedTickets++;
                }
            }
        }
        return purchasedTickets;
    }

    public static double getPercentageOfTickets(int totalSeats, int purchasedTickets) {
        return (100.000 / totalSeats) * purchasedTickets;
    }

    public static int getCurrentIncome(String[][] cinemGrid, int totalSeats, int numberOfRows, int numberOfColumns) {
        int ticketPrice = 0;
        int currentIncome = 0;

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (totalSeats <= 60) {
                    ticketPrice = 10;
                    if (cinemGrid[i][j].equals("B")) {
                        currentIncome += ticketPrice;
                    }
                } else {
                    if (cinemGrid[i][j].equals("B") && i < numberOfRows / 2) {
                        ticketPrice = 10;
                        currentIncome += ticketPrice;
                    } else if (cinemGrid[i][j].equals("B") && i >= numberOfRows / 2) {
                        ticketPrice = 8;
                        currentIncome += ticketPrice;
                    }
                }  
            }
        }
        return currentIncome;     
    }
}
