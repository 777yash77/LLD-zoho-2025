import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class main {
    static HashMap<String, movieTickets> tickets = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n🎟️  Welcome to KGS CINE Ticket Booking");
            System.out.println("Enter 1️⃣ to Book Tickets");
            System.out.println("Enter 2️⃣ to See Status");
            System.out.println("Enter 3️⃣ to Cancel Ticket");
            System.out.println("Enter 4️⃣ to See Available Seats");
            System.out.println("Enter 0️⃣ to Quit");
            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    bookTickets();
                    break;
                case 2:
                    seeStatus();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    showAvaTickets();
                    break;
                case 0:
                    System.out.println("🎬 Thank you for using KGS CINE!");
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    public static void bookTickets() {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of tickets: ");
        int ticketso = sc.nextInt();

        if (movieTickets.totalTickets > 0 && movieTickets.totalTickets >= ticketso) {
            int price = 120 * ticketso;
            String seats = "";

            for (int i = 0; i < ticketso; i++) {
                seats += r.nextInt(100) + " KGS CINE | ";
            }

            int ac = r.nextInt(1000);
            System.out.println("Book " + ticketso + " tickets for ₹" + price + "? Press 1 to confirm");
            int confirm = sc.nextInt();
            sc.nextLine(); // clear newline

            if (confirm == 1) {
                movieTickets.totalTickets -= ticketso;
                movieTickets m = new movieTickets(name, ticketso, price, true, seats, ac);
                tickets.put(name, m);
                System.out.println("✅ Tickets booked successfully!");
                System.out.println("Seats: " + seats);
                System.out.println("Ack No: " + ac);
            } else {
                System.out.println("❌ Ticket booking cancelled.");
            }
        } else {
            System.out.println("❌ Not enough tickets available.");
        }
    }

    public static void seeStatus() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your booking name: ");
        String name = sc.nextLine();

        if (tickets.containsKey(name)) {
            tickets.get(name).display();
        } else {
            System.out.println("❌ No booking found for " + name);
        }
    }

    public static void cancelTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your booking name to cancel: ");
        String name = sc.nextLine();

        if (tickets.containsKey(name)) {
            tickets.get(name).display();
            System.out.println("Are you sure to cancel? Press 3 to confirm:");
            int conf = sc.nextInt();

            if (conf == 3) {
                movieTickets.totalTickets += tickets.get(name).ticketBooked();
                tickets.remove(name);
                System.out.println("✅ Tickets cancelled successfully.");
            } else {
                System.out.println("❌ Cancellation aborted.");
            }
        } else {
            System.out.println("❌ No ticket found with that name.");
        }
    }

    public static void showAvaTickets() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many tickets do you want to check availability for? ");
        int need = sc.nextInt();

        if (need <= movieTickets.totalTickets) {
            System.out.println("✅ Tickets Available: " + movieTickets.totalTickets + " remaining.");
            System.out.println("Press 1️⃣ to Book Now");
            int c = sc.nextInt();
            if (c == 1) {
                bookTickets();
            }
        } else {
            System.out.println("❌ Only " + movieTickets.totalTickets + " tickets left.");
        }
    }
}
