package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

class Feature {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("arabic_name")
    private String arabicName;

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

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String value) {
        this.arabicName = value;
    }
}
