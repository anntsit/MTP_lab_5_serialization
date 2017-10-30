import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class Jackson {
    public static ArrayList<String> serialize(ArrayList<Plate> plates) throws JsonGenerationException, JsonMappingException {
        System.out.println("JACKSON SERIALIZATION");
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

        System.out.println("\n_____SERIALIZATION METRICS______");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return jsonStrings;
    }

    public static ArrayList<Plate> deserialize(ArrayList<String> jsonStrings) {
        System.out.println("JACKSON DESERIALIZATION");
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

        System.out.println("\n_____DESERIALIZATION METRICS______");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return convertedStrings;
    }
}
