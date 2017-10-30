import com.google.gson.Gson;

import java.util.ArrayList;

public class GSON {
    public static ArrayList<String> serialize(ArrayList<Plate> plates) {
        System.out.println("GOOGLE GSON SERIALIZATION");
        Metrics.start();
        ArrayList<String> jsonStrings = new ArrayList();
        Gson gson = new Gson();

        plates.forEach(plate -> {
            String jsonString = gson.toJson(plate);
            jsonStrings.add(jsonString);
            System.out.printf("PLATE #%d\n", plates.indexOf(plate)+1);
            System.out.println(jsonString);
        });

        System.out.println("\n_____SERIALIZATION METRICS______");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return jsonStrings;
    }

    public static ArrayList<Plate> deserialize(ArrayList<String> jsonStrings) {
        System.out.println("GOOGLE GSON DESERIALIZATION");
        Metrics.start();
        ArrayList<Plate> convertedStrings = new ArrayList();
        Gson gson = new Gson();

        jsonStrings.forEach(jsonString -> {
            Plate newPlate = gson.fromJson(jsonString, Plate.class);
            convertedStrings.add(newPlate);
        });

        System.out.println("\n_____DESERIALIZATION METRICS______");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return convertedStrings;
    }
}
