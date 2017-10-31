import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class Jackson {
    public static ArrayList<String> serialize(ArrayList<Plate> plates)  {
        System.out.println("\n_____JACKSON SERIALIZATION______");
        Metrics.start();
        ArrayList<String> jsonStrings = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();

        plates.forEach(plate -> {
            try {
                String jsonString = mapper.writeValueAsString(plate);
                jsonStrings.add(jsonString);
                System.out.printf("PLATE #%d\n", plates.indexOf(plate) + 1);
                System.out.println(jsonString);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Metrics.stop();
        System.out.println("SERIALIZATION METRICS");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return jsonStrings;
    }

    public static ArrayList<Plate> deserialize(ArrayList<String> jsonStrings) {
        System.out.println("\n_____JACKSON DESERIALIZATION______");
        Metrics.start();
        ArrayList<Plate> convertedStrings = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();
        jsonStrings.forEach(jsonString -> {
            Plate newBook = null;
            try {
                newBook = mapper.readValue(jsonString, Plate.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            convertedStrings.add(newBook);
        });

        Metrics.stop();
        System.out.println("DESERIALIZATION METRICS");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return convertedStrings;
    }
}
