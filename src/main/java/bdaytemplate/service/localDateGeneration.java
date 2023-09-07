package bdaytemplate.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class localDateGeneration {
    public static String getLocalDateGeneration(){
//        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.now();

        // Create a custom date format (month and day)
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MMMM dd");

        // Format the date using the custom format
        String dateSubstring = date.format(customFormatter);

        System.out.println("Date and Month: " + dateSubstring);
        return dateSubstring;
    }

}
