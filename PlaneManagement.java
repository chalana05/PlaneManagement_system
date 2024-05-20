import java.util.Scanner;

public class PlaneManagement {
    private static final Scanner scanner = new Scanner(System.in);

    // 2D array the seating plan
    private static char[][] seatingPlan;

    // Array to store Ticket
    private static Ticket[] tickets = new Ticket[52];

    // ticket count
    static int ticketCount = 0;

    // Main method
    public static void main(String[] args) {
        initializeSeats(); // Initialize seating plan
        initializeTickets(); // Initialize ticket array
        displayMenu(); // Display menu options
    }

    // initialize the seating plan
    private static void initializeSeats() {
        seatingPlan = new char[4][];
        seatingPlan[0] = new char[14]; // Row A
        seatingPlan[1] = new char[12]; // Row B
        seatingPlan[2] = new char[12]; // Row C
        seatingPlan[3] = new char[14]; // Row D

        for (int i = 0; i < seatingPlan.length; i++) {
            for (int j = 0; j < seatingPlan[i].length; j++) {
                seatingPlan[i][j] = 'O';
            }
        }
    }

    //  initialize the ticket array
    private static void initializeTickets() {
        tickets = new Ticket[52]; // Total number of seats
    }

    // display menu
    private static void displayMenu() {
        System.out.println("\nWelcome to the Plane Management application");
        while (true) {
            System.out.println("\n*******************************************\n*              MENU OPTIONS               *\n*******************************************");
            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first available seat");
            System.out.println("4) Show seating plan");
            System.out.println("5) Print tickets information and total sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Quit");
            System.out.println("********************************************\n");
            System.out.print("Please select an option: ");

            // Take user input for menu choice
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("\nInvalid choice. Please enter a number.\n");
                scanner.nextLine();
                continue;
            }

            // Perform action based on user choice
            switch (choice) {
                case 0:
                    System.out.println("\nExiting program...");
                    return;
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket();
                    break;
                default:
                    System.out.println("\nInvalid choice. Please select a valid option.\n");
            }
        }
    }

    // Method to buy a seat
    private static void buy_seat() {
        System.out.print("Please enter row letter(A-D): ");
        char row = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Please enter seat number: ");
        int seatNumber = scanner.nextInt();

        int rowIndex = row - 'A';
        int seatIndex = seatNumber - 1;

        if (isValidSeat(row, seatNumber)) {
            if (seatingPlan[rowIndex][seatIndex] == 'O') {
                seatingPlan[rowIndex][seatIndex] = 'X';
                System.out.println("\nSeat " + row + seatNumber + " has been sold successfully.");

                System.out.println("\nPlease enter person information");
                System.out.print("Enter name: ");
                String name = scanner.next();
                System.out.print("Enter surname: ");
                String surname = scanner.next();
                System.out.print("Enter email: ");
                String email = scanner.next();

                Person person = new Person(name, surname, email);

                person.setName(name);
                person.setSurname(surname);
                person.setEmail(email);

                // Calculate ticket price based on seat number
                double price;
                if (seatNumber >= 0 && seatNumber <= 4) {
                    price = 200.0;
                } else if (seatNumber >= 5 && seatNumber <= 8) {
                    price = 150.0;
                } else if (seatNumber >= 9 && seatNumber <= 13) {
                    price = 180.0;
                } else {
                    return;
                }

                Ticket ticket = new Ticket(row, seatNumber, price, person);

                tickets[ticketCount++] = ticket;
            } else {
                System.out.println("\nSeat " + row + seatNumber + " is already sold.");
            }
        } else {
            System.out.println("\nInvalid row or seat number.");
        }
    }

    // Method to cancel a seat
    private static void cancel_seat() {
        System.out.print("Please enter row letter(A-D): ");
        char row = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Please enter seat number: ");
        int seatNumber = scanner.nextInt();

            int rowIndex = row - 'A';
            int seatIndex = seatNumber - 1;

            if (isValidSeat(row, seatNumber)) {
                if (seatingPlan[rowIndex][seatIndex] == 'X') {
                    seatingPlan[rowIndex][seatIndex] = 'O';
                    System.out.println("\nSeat " + row + seatNumber + " has been cancelled successfully.");
                } else {
                    System.out.println("\nSeat " + row + seatNumber + " is already available.");
                }
            } else {
                System.out.println("\nInvalid row or seat number.");
            }
    }


    // Method to find the first available seat
    private static void find_first_available() {
        for (int i = 0; i < seatingPlan.length; i++) {
            for (int j = 0; j < seatingPlan[i].length; j++) {
                if (seatingPlan[i][j] == 'O') {
                    char rowLetter = (char) ('A' + i);
                    int seatNumber = j + 1;
                    System.out.println("\nFirst available seat is " + rowLetter + seatNumber);
                    return;
                }
            }
        }System.out.println("\nNo available seats found.");
    }

    // Method to show the seating plan
    private static void show_seating_plan() {
        System.out.println("\nSeating Plan:\n");
        for (int i = 0; i < seatingPlan.length; i++) {
            char rowLetter = (char) ('A' + i);
            System.out.print(rowLetter + ": ");
            for (int j = 0; j < seatingPlan[i].length; j++) {
                System.out.print(seatingPlan[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to check if a seat is valid
    private static boolean isValidSeat(char row, int seatNumber) {
        int rowIndex = row - 'A';
        int seatIndex = seatNumber - 1;
        return rowIndex >= 0 && rowIndex < seatingPlan.length && seatIndex >= 0 && seatIndex < seatingPlan[0].length;
    }

    // Method to print tickets information and total sales
    private static void print_tickets_info() {
        int totalAmount = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                ticket.print_tickets_info();
                totalAmount += (int) ticket.getPrice();
            }
        }
        System.out.println("\nTotal amount: £" + totalAmount);
    }

    // Method to search for a ticket
    private static void search_ticket() {
        System.out.print("Please enter row letter(A-D): ");
        char row = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Please enter seat number: ");
        int seatNumber = scanner.nextInt();

        boolean found = false;

        for (Ticket ticket : tickets) {
            if ((ticket != null) && ticket.getRow() == row && (ticket.getSeat() == seatNumber)) {
                System.out.println("\nThis seat is already sold.");
                ticket.print_tickets_info();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nThis seat is available.");
        }
    }
}
