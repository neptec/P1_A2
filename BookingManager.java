import java.util.*;

import javafx.event.Event;

public class BookingManager {
    public static void stage1(EventToBook event){
        Scanner scanner= new Scanner(System.in);
        //prompting user for title of the event
        System.out.print("Enter the title of the event: ");
        String eventTitle = scanner.nextLine();
        event.setEventTitle(eventTitle);

        //prompting user for the price per person
        System.out.print("Enter the price per person: ");
        int pricePerPerson = scanner.nextInt();
        event.setPricePerPerson(pricePerPerson);

        //prompting user for the number of participants
        System.out.print("Enter the number of participants: ");
        int numOfPeople = scanner.nextInt();
        event.setNumOfPeople(numOfPeople);

        //calculating the final costs
        int getCost = pricePerPerson*numOfPeople;
        System.out.println(eventTitle + ": " + pricePerPerson + " @ $" + numOfPeople + " = $" + getCost);
    }

    public static void stage2(Booking booking){
        Scanner scanner = new Scanner(System.in);
        //prompting for the name of customer
        System.out.println("Enter name of the customer:");
        String name = scanner.nextLine();
        booking.setCustomerName(name);
        
        //prompting for the date of event
        System.out.println("Enter the current date:");
        String date = scanner.nextLine();
        booking.setDate(date);

        //printing all the information gathered
        //booking.printTotal();

        boolean moreEvents = true;
while (moreEvents) {
    // Ask the user if they want to add more events
    System.out.println("Add more? (Y/N)");
    String answer = scanner.nextLine();
    moreEvents = answer.equalsIgnoreCase("y");

    // If the user wants to add more events, call the stage1 method
    if (moreEvents) {
        EventToBook event = new EventToBook();
        stage1(event);
        booking.addEvent(event);
    }
}

booking.printTotal();

}

    public static void stage3(Booking booking){

    }

    public static void stage4(Booking booking){

    }

    public static void main(String[] args) {
        EventToBook event = new EventToBook();
        Booking booking = new Booking();
        Booking special = new Booking();
        System.out.println("************** Stage 1 **************");
        stage1(event);
        System.out.println("************** Stage 2 **************");
        stage2(booking);
        System.out.println("************** Stage 3 **************");
        stage3(booking);
        System.out.println("************** Stage 4 **************");
        stage4(special);
    }
}

