//SeyClock Code

import java.util.Scanner;

public class EmployeeClockInSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for employee email and password
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Authenticate employee
        Employee employee = authenticateEmployee(email, password);
        if (employee == null) {
            System.out.println("Invalid email or password. Please try again.");
            return;
        }

        // Ask employee to clock in or out
        System.out.print("Enter 'in' to clock in, 'out' to clock out: ");
        String clockInOrOut = scanner.nextLine();

        if (clockInOrOut.equalsIgnoreCase("in")) {
            // Check if employee is on premise using geo-location
            boolean isOnPremise = checkGeoLocation(employee);
            if (!isOnPremise) {
                System.out.println("You are not on premise. Please come to the office to clock in.");
                return;
            }

            // Clock in employee
            boolean isClockedIn = clockIn(employee);
            if (isClockedIn) {
                System.out.println("You are now clocked in.");
            } else {
                System.out.println("Unable to clock in. Please try again later.");
            }
        } else if (clockInOrOut.equalsIgnoreCase("out")) {
            // Clock out employee
            boolean isClockedOut = clockOut(employee);
            if (isClockedOut) {
                System.out.println("You are now clocked out.");
            } else {
                System.out.println("Unable to clock out. Please try again later.");
            }
        } else {
            System.out.println("Invalid input. Please enter 'in' or 'out'.");
        }
    }

    // Authenticate employee based on email and password
    private static Employee authenticateEmployee(String email, String password) {
        // TODO: Implement authentication logic
        // Example code:
        if (email.equals("rayford@oc.com") && password.equals("password123")) {
            return new Employee("Rayford", "Ocansey", "rayford@oc.com");
        }
        return null;
    }

    // Check if employee is on premise using geo-location
    private static boolean checkGeoLocation(Employee employee) {
        // TODO: Implement geo-location logic
        // Example code:
        double latitude = 37.7749;  // Oklahoma latitude
        double longitude = -122.4194;  // Oklahoma longitude
        double employeeLatitude = employee.getLatitude();
        double employeeLongitude = employee.getLongitude();
        double radius = 100;  // Radius in meters

        double distance = Math.sqrt(Math.pow(latitude - employeeLatitude, 2) + Math.pow(longitude - employeeLongitude, 2));
        return distance <= radius;
    }

    // Clock in employee
    private static boolean clockIn(Employee employee) {
        // TODO: Implement clock-in logic
        // Example code:
        if (!employee.isClockedIn()) {
            employee.setClockedIn(true);
            return true;
        }
        return false;
    }

    // Clock out employee
    private static boolean clockOut(Employee employee) {
        // TODO: Implement clock-out logic
        // Example code:
        if (employee.isClockedIn()) {
            employee.setClockedIn(false);
            return true;
        }
        return false;
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private double latitude;
    private double longitude;
    private boolean isClockedIn;

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isClockedIn() {
        return isClockedIn;
    }

    public void setClockedIn(boolean clockedIn) {
        isClockedIn = clockedIn;
    }

    // Clock in employee
    public boolean clockIn() {
        // TODO: Implement clock-in logic
        // Example code:
        if (!isClockedIn()) {
            setClockedIn(true);
            return true;
        }
        return false;
    }

    // Clock out employee
    public boolean clockOut() {
        // TODO: Implement clock-out logic
        // Example code:
        if (isClockedIn()) {
            setClockedIn(false);
            return true;
        }
        return false;
    }
}