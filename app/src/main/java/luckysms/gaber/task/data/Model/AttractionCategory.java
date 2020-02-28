package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

class AttractionCategory {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("ar_name")
    private Object arName;
    @SerializedName("icon_image_url")
    private String iconImageURL;
    @SerializedName("cover_image_url")
    private String coverImageURL;

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

    public Object getArName() {
        return arName;
    }

    public void setArName(Object value) {
        this.arName = value;
    }

    public String getIconImageURL() {
        return iconImageURL;
    }

    public void setIconImageURL(String value) {
        this.iconImageURL = value;
    }

    public String getCoverImageURL() {
        return coverImageURL;
    }

    public void setCoverImageURL(String value) {
        this.coverImageURL = value;
    }

}
