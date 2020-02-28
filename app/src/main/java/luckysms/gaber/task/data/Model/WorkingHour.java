package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

class WorkingHour {
    @SerializedName("id")
    private long id;
    @SerializedName("from")
    private String from;
    @SerializedName("to")
    private String to;
    @SerializedName("date")
    private Object date;

    public long getID() {
        return id;
    }

    public void setID(long value) {
        this.id = value;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String value) {
        this.from = value;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String value) {
        this.to = value;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object value) {
        this.date = value;
    }
}
