package luckysms.gaber.task.data.Model;

public class response_model {
    private long status_code;
    private String message;
    private dataModel data;

    public long getStatusCode() {
        return status_code;
    }

    public void setStatusCode(long value) {
        this.status_code = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public dataModel getData() {
        return data;
    }

    public void setData(dataModel value) {
        this.data = value;
    }
}
