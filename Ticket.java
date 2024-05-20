import java.io.FileWriter;
import java.io.IOException;
public class Ticket {
    // Private fields for row, seat, price, and person
    private char row;
    private int seat;
    private double price;
    private Person person;
    public Ticket(char row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    public char getRow() {
        return row;
    }
    public void setRow(char row) {
        this.row = row;
    }
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    // Method to print ticket information
    public void print_tickets_info() {
        System.out.println("\nTickets Information");
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
        System.out.println("Person Information");
        System.out.println("Name: " + person.getName());
        System.out.println("Surname: " + person.getSurname());
        System.out.println("Email: " + person.getEmail());
        save(); // Save ticket information to a file
    }
    // Method to save ticket information to a file
    public void save() {
        try {
            // Create a FileWriter object to write to a file
            FileWriter fileWriter = new FileWriter(row + "" + seat + ".txt");
            fileWriter.write("Ticket Information\n");
            fileWriter.write("Row: " + row + "\n");
            fileWriter.write("Seat: " + seat + "\n");
            fileWriter.write("Price: " + price + "\n");
            fileWriter.write("Person Information\n");
            fileWriter.write("Name: " + person.getName() + "\n");
            fileWriter.write("Surname: " + person.getSurname() + "\n");
            fileWriter.write("Email: " + person.getEmail() + "\n");
            fileWriter.flush();
            fileWriter.close(); // Close the file

        } catch (IOException e) {
            System.out.println("\nAn error occurred while saving the ticket.\n");
            e.printStackTrace();
        }
    }
}
