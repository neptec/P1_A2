public class EventToBook {
    private String eventTitle;
    private int pricePerPerson;
    private int numOfPeople;

    public EventToBook() {
        this.eventTitle = "none";
        this.pricePerPerson = 0;
        this.numOfPeople = 0;
    }

    public EventToBook(String title, int price, int quantity) {
        this.eventTitle = title;
        this.pricePerPerson = price;
        this.numOfPeople = quantity;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public int getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(int pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public int getCost() {
        return pricePerPerson * numOfPeople;
    }

    @Override
    public String toString() {
        String paddedTitle = String.format("%-20s", eventTitle);
        int totalCost = getCost();
        return paddedTitle + ": " + numOfPeople + " @ $" + pricePerPerson + " = $" + totalCost;
    }
}
