import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JsonMappingException, JsonGenerationException{
        ArrayList<Plate> plates = generatePlates();
        gsonSerialize(plates);
        jacksonSerialize(plates);
        orgJsonSerialize(plates);
    }

    public static ArrayList<Plate> generatePlates() {
        ArrayList<Plate> plates = new ArrayList();
        Plate p1= new Plate("Classic", "c:/");
        Record r1= new Record(1, "Summer", "repeat", 2);
        p1.addRecord(r1);
        plates.add(p1);

        Plate p2= new Plate("Disco", "d:/");
        Record r2= new Record(2, "Club", "repeat", 3);
        p1.addRecord(r2);
        plates.add(p2);

        return plates;
    }

    private static void gsonSerialize (ArrayList<Plate> plates) {
        ArrayList<String> serializedPlates = GSON.serialize(plates);
        GSON.deserialize(serializedPlates);
    }

    private static void jacksonSerialize(ArrayList<Plate> plates) throws JsonMappingException,
            JsonGenerationException {
        ArrayList<String> serializedPlates = Jackson.serialize(plates);
        Jackson.deserialize(serializedPlates);
    }

    private static void orgJsonSerialize(ArrayList<Plate> plates) throws JsonMappingException,
            JsonGenerationException {
        ArrayList<String> serializedPlates = OrgJSON.serialize(plates);
        OrgJSON.deserialize(serializedPlates);
    }
}
