public class Booking {
    private String customerName;        // Stores the name of the customer
    private String currentDate;         // Stores the current date
    private EventToBook[] eventArray;   // Array to store booked events
    private static final int CAPACITY = 4;  // Maximum capacity for events
    private int eventCount;             // Keeps track of the number of events booked

    public Booking() {
        customerName = "Unknown";                    // Default customer name
        currentDate = "1 May 2023";                  // Default current date
        eventArray = new EventToBook[CAPACITY];       // Initialize eventArray with capacity
        eventCount = 0;                              // Initialize eventCount to 0
    }

    public Booking(String name, String date) {
        customerName = name;                         // Set customer name from parameter
        currentDate = date;                          // Set current date from parameter
        eventArray = new EventToBook[CAPACITY];       // Initialize eventArray with capacity
        eventCount = 0;                              // Initialize eventCount to 0
    }

    // Getter and setter methods for customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name) {
        customerName = name;
    }

    // Getter and setter methods for currentDate
    public String getDate() {
        return currentDate;
    }

    public void setDate(String date) {
        currentDate = date;
    }

    public boolean addEvent(EventToBook event) {
        // Checks if the booking limit is reached
        if (eventCount >= CAPACITY) {
            System.out.println("BOOKING LIMIT IS REACHED");
            return false;
        }

        // Checks if the event already exists in the booking
        for (int i = 0; i < eventCount; i++) {
            if (eventArray[i].getTitle().equalsIgnoreCase(event.getTitle())) {
                System.out.println("EVENT ALREADY EXISTS");
                return false;
            }
        }

        // Adds the event to the eventArray and increments the eventCount
        eventArray[eventCount] = event;
        eventCount++;
        return true;
    }

    public int getTotalNumPeople() {
        int totalPeople = 0;
        // Calculates the total number of people attending all events
        for (int i = 0; i < eventCount; i++) {
            totalPeople += eventArray[i].getQuantity();
        }
        return totalPeople;
    }

    public int getTotalCost() {
        int totalCost = 0;
    
        // Calculates the total cost of all bookings
        for (int i = 0; i < eventCount; i++) {
            totalCost += eventArray[i].getCost();
        }
    
        return totalCost;
    }

    public void printTotal() {
        System.out.println("Customer: " + customerName);
        System.out.println("Date: " + currentDate);

        // Checks if there are no bookings
        if (eventCount == 0) {
            System.out.println("NO BOOKING!");
        } else {
            System.out.println("Total events participants: " + getTotalNumPeople());

            // Prints details of each booked event
            for (int i = 0; i < eventCount; i++) {
                System.out.println(eventArray[i].toString());
            }

            System.out.println("Total cost of all bookings: $" + getTotalCost());
        }
    }

    public boolean modifyEvent(String eventTitle, int quantity) {
        // Modifies the quantity of a specific event
        for (int i = 0; i < eventCount; i++) {
            if (eventArray[i].getTitle().equalsIgnoreCase(eventTitle)) {
                if (quantity > 0) {
                    eventArray[i].setQuantity(quantity);
                    return true;
                } else {
                    System.out.println("Invalid number!");
                    return false;
                }
            }
        }
        
        System.out.println(eventTitle + " not found in the booking");
        return false;
    }

    public boolean removeEvent(String eventTitle) {
        for (int i = 0; i < eventCount; i++) {
            if (eventArray[i].getTitle().equalsIgnoreCase(eventTitle)) {
                for (int j = i; j < eventCount - 1; j++) {
                    eventArray[j] = eventArray[j + 1];
                }
                eventArray[eventCount - 1] = null;
                eventCount--;
                System.out.println(eventTitle + " is removed from your booking");
                return true;
            }
        }
    
        System.out.println(eventTitle + " not found in the booking");
        return false;
    }    
    
}
