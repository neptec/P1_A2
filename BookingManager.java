import java.util.Scanner;

public class BookingManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static EventToBook promptToBook() {
        // Prompting user for the title of the event
        System.out.print("Enter the title of the event: ");
        String eventTitle = scanner.nextLine();

        // Prompting user for the price per person
        System.out.print("Enter the price per person: ");
        int pricePerPerson = scanner.nextInt();

        // Prompting user for the number of participants
        System.out.print("Enter the number of participants: ");
        int numOfPeople = scanner.nextInt();

        scanner.nextLine(); // Consume newline character

        return new EventToBook(eventTitle, pricePerPerson, numOfPeople);
    }

    public static void stage1(EventToBook event) {
        System.out.println(event);
    }

    public static void stage2(Booking booking) {
        // Prompting for the name of the customer
        System.out.print("Enter name of the customer: ");
        String name = scanner.nextLine();
        booking.setCustomerName(name);

        // Prompting for the date of the event
        System.out.print("Enter the current date: ");
        String date = scanner.nextLine();
        booking.setDate(date);

        String moreEvents;
        do {
            System.out.print("Add more events? (yes/no): ");
            moreEvents = scanner.nextLine().toLowerCase();

            if (moreEvents.equals("yes")) {
                EventToBook event = promptToBook();
                boolean added = booking.addEvent(event);

                if (added) {
                    System.out.println("Event added successfully.");
                } else {
                    System.out.println("Failed to add event.");
                }
            }
        } while (moreEvents.equals("yes"));

        System.out.println("Booking updated:");
        booking.printTotal();
    }

    public static void stage3(Booking booking) {
            // Prompt the user for an event name to be removed
            System.out.print("Enter the event name to be removed: ");
            String eventTitle = scanner.nextLine();
        
            boolean removed = booking.removeEvent(eventTitle);
            if (removed) {
                System.out.println(eventTitle + " is removed from your booking.");
            } else {
                System.out.println(eventTitle + " not found in the booking.");
            }
        
            // Print the summary of the booking
            booking.printTotal();
        
            // Prompt the user for an event to be modified and the new number of participants
            System.out.print("Enter the event name to be modified: ");
            eventTitle = scanner.nextLine();
        
            System.out.print("Please enter the new number of participants: ");
            int quantity = scanner.nextInt();
        
            boolean modified = booking.modifyEvent(eventTitle, quantity);
            if (modified) {
                System.out.println("Event modified successfully.");
            } else {
                System.out.println(eventTitle + " not found in the booking or invalid number!");
            }
        
            // Print the updated booking
            booking.printTotal();
        }
        

    public static void stage4(Booking booking) {
        // TODO: Implement Stage 4 functionality
    }
    public static void main(String[] args) {
        EventToBook event = promptToBook();
        Booking booking = new Booking();
        Booking special = new Booking();

        System.out.println("************** Stage 1 **************");
        stage1(event);

        System.out.println("************** Stage 2 **************");
        stage2(booking);

        System.out.println("************** Stage 3 **************");
        stage3(booking);

    }
}

