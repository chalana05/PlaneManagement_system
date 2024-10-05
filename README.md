# PlaneSeat - Plane Management System

## Description
PlaneSeat is a Java program that simulates a plane reservation system for a commercial airline.

## Objective
The objective is to manage airplane seats, allowing users (airline staff) to:
- Sell seats to passengers
- Cancel seat reservations
- Find available seats
- View the current seating plan
- Print ticket information and total sales
- Search for a specific seat reservation

## Gameplay (Interaction)
The program presents a menu-driven interface where users select actions using a numbered list. There are no points or levels to "win."

## Getting Started
1. Run the program.
2. A menu appears with options for managing plane seats.

## Actions

### 1. Buy a Seat (`buy_seat`)
- User enters desired row and seat number.
- System checks availability and validates seat choice.
- If available, user enters passenger information (name, surname, email).
- Ticket price is calculated based on seat location.
- System reserves the seat and creates a ticket with passenger details.

### 2. Cancel a Seat (`cancel_seat`)
- User enters row and seat number of the reservation to cancel.
- System verifies if the seat is booked and cancels the reservation if valid.

### 3. Find the First Available Seat (`find_first_available`)
- System searches the seating plan and displays the row and seat number of the first unoccupied seat.

### 4. Displaying the Seating Plan (`show_seating_plan`)
- System displays a representation of the plane's seating layout, indicating occupied and available seats.

### 5. Printing Ticket Information and Total Sales (`print_tickets_info`)
- System displays details of all booked tickets, including passenger information and price.
- Calculates and displays the total sales amount from all tickets sold.

### 6. Searching for a Ticket (`search_ticket`)
- User enters row and seat number of a reservation.
- System searches for the ticket and displays passenger information if found.
- Otherwise, indicates the seat is available.

## End Game
The program doesn't have an ending as it's designed for ongoing seat management. Users can keep interacting with the menu until they choose to exit.

## Additional Notes
- The program uses a 2D character array to represent the seating plan.
- It stores ticket information in individual text files for each reservation.
- Error handling can be implemented to address invalid user input or file operations.

## Requirements
- Java Development Kit (JDK)
- An IDE or text editor for Java programming

## How to Run
1. Clone the repository or download the source code.
2. Open the project in your preferred IDE.
3. Compile and run the `PlaneSeat.java` file.
4. Follow the on-screen instructions to manage plane reservations.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- Inspired by real-world airline reservation systems.
- Special thanks to all contributors and the open-source community.
