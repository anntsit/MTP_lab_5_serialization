public class Record {
    private String name;
    private String status;
    private int executionCount;
    private int recordId;

    public Record() {
        setName("Unknown");
        setStatus("Unknown");
        setExecutionCount(0);
        setRecordId(0);
    }

    public Record(int recordId, String name, String status, int executionCount) {
        setRecordId(recordId);
        setName(name);
        setStatus(status);
        setExecutionCount(executionCount);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setExecutionCount(int executionCount) {
        this.executionCount = executionCount;
    }

    public int getExecutionCount() {
        return executionCount;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }


}
