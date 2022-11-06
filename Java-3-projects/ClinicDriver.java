import java.io.FileNotFoundException;

/**
 * Driver class to demonstrate a Clinic treating various patients
 */
public class ClinicDriver {

    public static void main(String[] args) {
        Clinic clinic = new Clinic("Patients.csv");
        String dayOneReport = "";
        String dayTwoReport = "";
        String dayThreeReport = "";
        try {
            dayOneReport = clinic.nextDay("Appointments.csv");
            dayTwoReport = clinic.nextDay("AppointmentsDay2.csv");
            dayThreeReport = clinic.nextDay("AppointmentsDay3.csv");
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        String[] dayOneAppointments = dayOneReport.split("\\n");
        String[] dayTwoAppointments = dayTwoReport.split("\\n");
        String[] dayThreeAppointments = dayThreeReport.split("\\n");
        for (String appointment : dayOneAppointments) {
            if (!clinic.addToFile(appointment)) {
                System.out.println("Appointment could not be added to file!");
            }
        }
        for (String appointment : dayTwoAppointments) {
            if (!clinic.addToFile(appointment)) {
                System.out.println("Appointment could not be added to file!");
            }
        }
        for (String appointment : dayThreeAppointments) {
            if (!clinic.addToFile(appointment)) {
                System.out.println("Appointment could not be added to file!");
            }
        }
    }
}
