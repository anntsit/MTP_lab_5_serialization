import com.google.gson.Gson;

import java.util.ArrayList;

public class GSON {
    public static ArrayList<String> serialize(ArrayList<Plate> plates) {
        System.out.println("\n_____GOOGLE GSON SERIALIZATION______");
        Metrics.start();
        ArrayList<String> jsonStrings = new ArrayList();
        Gson gson = new Gson();

        plates.forEach(plate -> {
            String jsonString = gson.toJson(plate);
            jsonStrings.add(jsonString);
            System.out.printf("PLATE #%d\n", plates.indexOf(plate)+1);
            System.out.println(jsonString);
        });

        Metrics.stop();
        System.out.println("SERIALIZATION METRICS");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return jsonStrings;
    }

    public static ArrayList<Plate> deserialize(ArrayList<String> jsonStrings) {
        System.out.println("\n_____GOOGLE GSON DESERIALIZATION______");
        Metrics.start();
        ArrayList<Plate> convertedStrings = new ArrayList();
        Gson gson = new Gson();

        jsonStrings.forEach(jsonString -> {
            Plate newPlate = gson.fromJson(jsonString, Plate.class);
            convertedStrings.add(newPlate);
        });

        Metrics.stop();
        System.out.println("DESERIALIZATION METRICS");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return convertedStrings;
    }
}
