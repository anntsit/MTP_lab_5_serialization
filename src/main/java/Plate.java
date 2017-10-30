import java.util.*;

public class Plate {
    private String title;
    private String path;
    private Map<Integer,Record> records;

    public Plate(){
        records = new HashMap<>();
    }

    public Plate(String title, String path) {
        this();
        setTitle(title);
        setPath(path);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addRecord(Record record) {
        records.put(record.getRecordId(), record);
    }

    public void setRecords(Map<Integer,Record> records) {
        this.records = records;
    }

    public Map<Integer,Record> getRecords() {
        return records;
    }
}
