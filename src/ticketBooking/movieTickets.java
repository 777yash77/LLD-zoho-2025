public class movieTickets {
    public static int totalTickets = 100;

    String name = "";
    int noOfTickets;
    int price;
    boolean PayInfo = false;
    int Ack_no;
    String Seat_no = "";

    public movieTickets(String name, int no_of_tickets, int cost, boolean paid, String seats, int ack) {
        this.noOfTickets = no_of_tickets;
        this.name = name;
        this.price = cost;
        this.PayInfo = paid;
        this.Ack_no = ack;
        this.Seat_no = seats;
    }

    public int ticketBooked() {
        return noOfTickets;
    }

    public void display() {
        System.out.println("\nName : " + name);
        System.out.println("Number of Tickets : " + noOfTickets + " tickets");
        System.out.println("Cash Paid : ₹" + price);
        System.out.println("Ack_no : " + Ack_no);
        System.out.println("Seats Occupied : " + Seat_no);
    }
}
