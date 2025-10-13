import java.util.*;

// Base class: Room
class Room {
    protected int roomNumber;
    protected double basePrice;
    protected boolean isBooked;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.isBooked = false;
    }

    public boolean isAvailable() {
        return !isBooked;
    }

    public void bookRoom() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Room " + roomNumber + " booked successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    // Polymorphic method (can be overridden)
    public double calculateBill(int nights, String season) {
        double discount = getSeasonalDiscount(season);
        double total = basePrice * nights * (1 - discount);
        return total;
    }

    protected double getSeasonalDiscount(String season) {
        // Default discount (no discount)
        return 0.0;
    }

    public String toString() {
        return "Room " + roomNumber + " | Price per night: ₹" + basePrice + 
               " | Booked: " + (isBooked ? "Yes" : "No");
    }
}

// Derived class: Deluxe Room
class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    protected double getSeasonalDiscount(String season) {
        switch (season.toLowerCase()) {
            case "summer": return 0.10; // 10% discount
            case "winter": return 0.15; // 15% discount
            case "monsoon": return 0.20; // 20% discount
            default: return 0.0;
        }
    }
}

// Derived class: Suite Room
class SuiteRoom extends Room {
    public SuiteRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    protected double getSeasonalDiscount(String season) {
        switch (season.toLowerCase()) {
            case "summer": return 0.20; // 20% discount
            case "winter": return 0.25; // 25% discount
            case "monsoon": return 0.30; // 30% discount
            default: return 0.0;
        }
    }
}

// Main Class: HotelBookingSystem
public class HotelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create some rooms
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new DeluxeRoom(101, 3000));
        rooms.add(new DeluxeRoom(102, 3200));
        rooms.add(new SuiteRoom(201, 6000));
        rooms.add(new SuiteRoom(202, 6500));

        int choice;
        do {
            System.out.println("\n===== HOTEL ROOM BOOKING SYSTEM =====");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Calculate Bill");
            System.out.println("4.cancel the booking");
            System.out.println("5. exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Available Rooms ---");
                    for (Room room : rooms) {
                        if (room.isAvailable())
                            System.out.println(room);
                    }
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNo = sc.nextInt();
                    boolean found = false;
                    for (Room room : rooms) {
                        if (room.roomNumber == roomNo) {
                            found = true;
                            room.bookRoom();
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Room not found!");
                    break;

                case 3:
                    System.out.print("Enter room number: ");
                    int rNo = sc.nextInt();
                    Room selectedRoom = null;
                    for (Room room : rooms) {
                        if (room.roomNumber == rNo) {
                            selectedRoom = room;
                            break;
                        }
                    }
                    if (selectedRoom == null) {
                        System.out.println("Invalid room number!");
                        break;
                    }
                    System.out.print("Enter number of nights: ");
                    int nights = sc.nextInt();
                    System.out.print("Enter season (Summer/Winter/Monsoon/Other): ");
                    String season = sc.next();

                    double total = selectedRoom.calculateBill(nights, season);
                    System.out.println("Total bill for Room " + rNo + ": ₹" + total);
                    break;

                 case 4:
                    System.out.println("cancellation confirm");
                    break;

                case 5:
                    System.out.println("Thank you for using the Hotel Booking System!");
                    break;

                

                        default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}