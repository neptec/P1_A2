public class EventToBook {
    private String title;         // Stores the title of the event
    private int quantity;         // Stores the quantity of participants for the event
    private int costPerHead;      // Stores the cost per participant for the event

    public EventToBook(String title, int quantity, int costPerHead) {
        this.title = title;                  // Set the title of the event from the parameter
        this.quantity = quantity;            // Set the quantity of participants from the parameter
        this.costPerHead = costPerHead;      // Set the cost per participant from the parameter
    }

    public String getTitle() {
        return title;         // Returns the title of the event
    }

    public int getQuantity() {
        return quantity;      // Returns the quantity of participants for the event
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;   // Updates the quantity of participants for the event
    }

    public int getCost() {
        return quantity * costPerHead;   // Calculates and returns the total cost for the event
    }

    @Override
    public String toString() {
        return "Event: " + title + ", Participants: " + quantity + ", Cost: $" + getCost();
        // Returns a string representation of the event, including title, participants, and cost
    }
}
