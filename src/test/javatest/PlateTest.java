import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PlateTest {
    @Test
    public void setPath() throws NoSuchFieldException, IllegalAccessException {
        final Plate plate = new Plate();
        String path = "Classic";
        plate.setPath(path);
        final Field field = plate.getClass().getDeclaredField("path");
        field.setAccessible(true);
        assertEquals(field.get(plate), path);
    }

    @Test
    public void getPath() throws NoSuchFieldException, IllegalAccessException {
        final Plate plate = new Plate();
        final Field field = plate.getClass().getDeclaredField("path");
        field.setAccessible(true);
        String path = "Classic";
        field.set(plate, path);
        assertEquals(path, plate.getPath());
    }

    @Test
    public void setTitle() throws NoSuchFieldException, IllegalAccessException {
        final Plate plate = new Plate();
        String title = "Classic";
        plate.setTitle(title);
        final Field field = plate.getClass().getDeclaredField("title");
        field.setAccessible(true);
        assertEquals(field.get(plate), title);
    }

    @Test
    public void getTitle() throws NoSuchFieldException, IllegalAccessException {
        final Plate plate = new Plate();
        final Field field = plate.getClass().getDeclaredField("title");
        field.setAccessible(true);
        String title = "Classic";
        field.set(plate, title);
        assertEquals(title, plate.getTitle());
    }

    @Test
    public void addRecord() throws NoSuchFieldException, IllegalAccessException {
        final Plate plate = new Plate();
        Record testRecord = new Record(1, "Summer", "repeat", 2);
        plate.addRecord(testRecord);
        assertEquals(plate.getRecords().get(1), testRecord);
    }

    @Test
    public void setRecords() throws NoSuchFieldException, IllegalAccessException {
        final Plate plate = new Plate();
        Map<Integer,Record> records = new HashMap<>();
        records.put(1,new Record(1, "Summer", "repeat", 2));
        plate.setRecords(records);
        final Field field = plate.getClass().getDeclaredField("records");
        field.setAccessible(true);
        assertEquals(field.get(plate), records);
    }

    @Test
    public void getRecords() throws NoSuchFieldException, IllegalAccessException {
        final Plate plate = new Plate();
        final Field field = plate.getClass().getDeclaredField("records");
        field.setAccessible(true);
        Map<Integer,Record> records = new HashMap<>();
        records.put(1,new Record(1, "Summer", "repeat", 2));
        field.set(plate, records);
        assertEquals(records, plate.getRecords());
    }

}