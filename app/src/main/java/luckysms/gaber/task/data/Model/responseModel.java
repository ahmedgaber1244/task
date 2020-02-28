package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

public class responseModel {
    @SerializedName("status_code")
    private long statusCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private dataModel data;

    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(long statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public dataModel getData() {
        return data;
    }

    public void setData(dataModel data) {
        this.data = data;
    }
}
