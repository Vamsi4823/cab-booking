import java.util.Scanner;

abstract class UserProfile {
    String name;
    int age;
    long number;

    UserProfile(String name, int age, long number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public abstract void viewAccount();
}

interface CabService {
    void bookCab();
    void makePayment();
    void giveFeedback();
}

class CabBooking extends UserProfile implements CabService {
    Scanner sc = new Scanner(System.in);
    float kms;
    int paymentAmount;
    int rating;

    CabBooking(String name, int age, long number) {
        super(name, age, number);
    }

    public void bookCab() {
        System.out.print("Enter pickup location: ");
        String source = sc.nextLine();
        System.out.print("Enter drop location: ");
        String destination = sc.nextLine();
        System.out.print("Enter distance in kms: ");
        kms = sc.nextFloat();
        sc.nextLine();  // Clear newline
        paymentAmount = (int)(kms * 12); // assume ₹12/km
        System.out.println("Cab booked from " + source + " to " + destination);
        System.out.println("Estimated fare: ₹" + paymentAmount);
    }

    public void makePayment() {
        System.out.println("Proceed to pay ₹" + paymentAmount);
        System.out.print("Enter amount: ");
        int paid = sc.nextInt();
        while (paid != paymentAmount) {
            System.out.println("Incorrect amount. Please try again.");
            System.out.print("Enter amount: ");
            paid = sc.nextInt();
        }
        System.out.println("Payment successful!");
    }

    public void giveFeedback() {
        System.out.println("Rate your ride (1-5 stars): ");
        rating = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.println("Thank you for your " + rating + "-star rating.");
    }

    public void viewAccount() {
        System.out.println("=== User Profile ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Mobile: " + number);
        System.out.println("Last Ride Distance: " + kms + " kms");
        System.out.println("Last Ride Fare: ₹" + paymentAmount);
        System.out.println("Last Rating: " + rating + " stars");
    }
}

public class CabBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Cab Booking System");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter your mobile number: ");
        long number = sc.nextLong();
        sc.nextLine(); // Clear buffer

        CabBooking user = new CabBooking(name, age, number);

        while (true) {
            System.out.println("\n1. Book a Cab");
            System.out.println("2. Make Payment");
            System.out.println("3. Give Feedback");
            System.out.println("4. View Profile");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    user.bookCab();
                    break;
                case 2:
                    user.makePayment();
                    break;
                case 3:
                    user.giveFeedback();
                    break;
                case 4:
                    user.viewAccount();
                    break;
                case 5:
                    System.out.println("Thank you for using our Cab Service!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}