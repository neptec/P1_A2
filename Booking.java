public class Booking {

    private static final int CAPACITY = 4;
    private String customerName;
    private String currentDate;
    private EventToBook[] eventArray;
    private int eventCount;

    public Booking() {
        this.customerName = "Unknown";
        this.currentDate = "1 May 2023";
        this.eventArray = new EventToBook[CAPACITY];
        this.eventCount = 0;
    }

    public Booking(String name, String date) {
        this.customerName = name;
        this.currentDate = date;
        this.eventArray = new EventToBook[CAPACITY];
        this.eventCount = 0;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public String getDate() {
        return this.currentDate;
    }

    public void setDate(String date) {
        this.currentDate = date;
    }

    public boolean addEvent(EventToBook event) {
        if (this.eventCount >= CAPACITY) {
            System.out.println("BOOKING LIMIT IS REACHED");
            return false;
        }
        for (int i = 0; i < this.eventCount; i++) {
            if (this.eventArray[i].getEventTitle().equals(event.getEventTitle())) {
                System.out.println("EVENT ALREADY EXISTS");
                return false;
            }
        }
        this.eventArray[this.eventCount++] = event;
        return true;
    }

    public int getTotalNumPeople() {
        int total = 0;
        for (int i = 0; i < this.eventCount; i++) {
            total += this.eventArray[i].getNumOfPeople();
        }
        return total;
    }

    public double getTotalCost() {
        double total = 0;
        for (int i = 0; i < this.eventCount; i++) {
            total += this.eventArray[i].getCost();
        }
        return total;
    }

    public void printTotal() {
        System.out.println("Booking Details:");
        System.out.println(this.customerName + " - " + this.currentDate);
        if (this.eventCount == 0) {
            System.out.println("NO BOOKING!");
        } else {
            System.out.println("Total number of participants: " + this.getTotalNumPeople());
            System.out.println("Event Details:");
            for (int i = 0; i < this.eventCount; i++) {
                EventToBook event = this.eventArray[i];
                System.out.println("- " + event.getEventTitle() + ", " + event.getNumOfPeople() + " people, $" + event.getCost());
            }
            System.out.println("Total cost: $" + this.getTotalCost());
        }
    }
}
