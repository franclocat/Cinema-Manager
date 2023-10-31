# Cinema-Manager
This Java program manages a cinema ticket booking system. It allows the user to view the available seats, purchase tickets, and obtain statistics about the booking status.

Features
Initialization

The program prompts the user to enter the number of rows and seats in each row to set up the cinema grid.
Displaying the Grid

The printGrid method displays the cinema grid, showing available seats as "S" and booked seats as "B". It also labels the columns and rows.
Booking Tickets

The updatedGrid method allows users to select a specific seat. If the chosen seat is valid and available, it updates the grid with a "B" to indicate a booked seat. It also calculates and displays the ticket price based on the specified criteria.
Statistics

The program provides statistics about the booking status, including:
Number of purchased tickets.
Percentage of tickets booked.
Current income generated from booked tickets.
Total potential income based on the number of seats.
Exiting the Program

The user can choose to exit the program, which terminates the execution.
Usage
Initialization

The user is prompted to enter the number of rows and seats per row.
Menu Options

The program displays a menu with the following options:
Show the seats
Buy a ticket
Statistics
Exit
Show the seats

Displays the current booking status.
Buy a ticket

Prompts the user to select a seat to book. It checks if the selected seat is valid and available. If so, it books the seat and displays the ticket price.
Statistics

Provides various statistics about the booking status.
Exit

Terminates the program.
How to Use
Setting Up

Run the program.
Enter the number of rows and seats per row.
Menu Navigation

Choose options by entering the corresponding number.
Viewing Seats

Choose option 1 to view the current booking status.
Booking Tickets

Choose option 2 and follow the prompts to book a ticket.
Viewing Statistics

Choose option 3 to see booking statistics.
Exiting

Choose option 0 to exit the program.
Note
The program ensures that the user input is within valid ranges and handles incorrect input gracefully.
This program provides a simple and effective way to manage a cinema booking system through the console interface. It can be extended with additional features and enhanced user interfaces for real-world applications.
