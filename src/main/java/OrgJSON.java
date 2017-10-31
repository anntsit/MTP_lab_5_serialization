import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrgJSON {
    public static ArrayList<String> serialize(ArrayList<Plate> plates) {
        System.out.println("\n_____ORG.JSON SERIALIZATION______");
        Metrics.start();
        ArrayList<String> jsonStrings = new ArrayList();

        for (Plate plate : plates) {
            JSONObject object = new JSONObject(plate);
            String jsonPlate = object.toString();
            jsonStrings.add(jsonPlate);
            System.out.println("PLATE #" + (plates.indexOf(plate) + 1));
            System.out.println(jsonPlate);
        };
        Metrics.stop();

        System.out.println("SERIALIZATION METRICS");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return jsonStrings;
    }

    public static ArrayList<Plate> deserialize(ArrayList<String> jsonStrings) {
        System.out.println("\n_____ORG.JSON DESERIALIZATION______");
        Metrics.start();
        ArrayList<Plate> convertedStrings = new ArrayList();
        jsonStrings.forEach(jsonString -> {
            JSONObject obj = new JSONObject(jsonString);
            String title = obj.getString("title");
            String path = obj.getString("path");
            Plate plate = new Plate(title, path);
            plate.setRecords(parseRecordJSON(obj));

            convertedStrings.add(plate);
        });

        Metrics.stop();
        System.out.println("DESERIALIZATION METRICS");
        Metrics.getExecutionTime();
        Metrics.getUsedMemory();
        return convertedStrings;
    }

    private static Map<Integer,Record> parseRecordJSON(JSONObject object){
        JSONObject recordJson = object.getJSONObject("records");
        Map<Integer,Record> records = new HashMap<>();
        Record record = new Record();
        for (int i = 0; i < recordJson.length(); i++) {
            JSONObject recordObj = recordJson.getJSONObject(""+(i+1));
            record.setName((String)(recordObj.toMap().get("name")));
            record.setStatus((String)(recordObj.toMap().get("status")));
            record.setExecutionCount((int)(recordObj.toMap().get("executionCount")));
            records.put(record.getRecordId(), record);
        }
        return records;
    }
}
