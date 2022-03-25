import by.company.trip.BusinessTrip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {

        try{
            String url = "jdbc:mysql://localhost/trip";
            String username = "root";
            String password = "1024";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                System.out.println("Connection to Store DB successful!");
            }

        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            ex.printStackTrace();
        }


        BusinessTrip[] businessTrips =
                {new BusinessTrip("Aleksandr Ivanov", 23175, 14),
                        new BusinessTrip("Vladimir Petrov", 4625, 13),
                        null,
                        new BusinessTrip("Vladislav Gromov", 1265, 5),
                        new BusinessTrip()};

        //Method show()
        System.out.println("Using show():");

        for (BusinessTrip trip : businessTrips) {
            System.out.print(trip == null ? "" : (trip.show() + "\n"));
        }

        //The business trip with maximum cost:
        System.out.println("The business trip with maximum cost:");

        BusinessTrip businessTripMax = null;
        for (BusinessTrip trip : businessTrips) {
            if (businessTripMax == null) {
                businessTripMax = trip;
            }
            if (trip != null && trip.getTotal() > businessTripMax.getTotal()) {
                businessTripMax = trip;
            }
        }

        System.out.println(businessTripMax == null ? "" : businessTripMax.show());

        //Total duration of two persons
        System.out.println("Update the employee`s transportation expenses for the last object of the array:");
        System.out.println("Duration = " + (businessTrips[0].getDaysNumber() + businessTrips[1].getDaysNumber()));

        //add last person transportation expenses
        businessTrips[businessTrips.length - 1].setTransportationExpenses(50);
        System.out.println();

        //toString method
        System.out.println("Method toString:");
        for (BusinessTrip trip : businessTrips) {
            System.out.println(trip);
        }
    }
}
