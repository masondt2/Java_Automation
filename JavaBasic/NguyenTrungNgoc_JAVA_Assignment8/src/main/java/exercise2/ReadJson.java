package exercise2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadJson {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON file and parse it
            JsonNode root = mapper.readTree(new File("jobs.json"));

            // Extract and print job details
            extractNode(root);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void extractNode(JsonNode root) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Iterate over jobs array
        JsonNode jobs = root.get("jobs");
        for (JsonNode job : jobs) {
            String employer = job.get("employer").asText();
            String title = job.get("title").asText();
            String description = job.get("description").asText();

            // Parse duration start and end dates
            Date startDate = dateFormat.parse(job.get("duration").get("start").asText());
            Date endDate = dateFormat.parse(job.get("duration").get("end").asText());

            // Print extracted information
            System.out.println("Employer: " + employer);
            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
            System.out.println("Start Date: " + dateFormat.format(startDate));
            System.out.println("End Date: " + dateFormat.format(endDate));
            System.out.println();
        }
    }
}