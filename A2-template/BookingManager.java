public class BookingManager {
    public static void stage1(EventToBook event){

    }
    public static void stage2(Booking booking){

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

