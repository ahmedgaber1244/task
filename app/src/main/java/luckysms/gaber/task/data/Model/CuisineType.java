package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

class CuisineType {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;

    public long getID() {
        return id;
    }

    public void setID(long value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
