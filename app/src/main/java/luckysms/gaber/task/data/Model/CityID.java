package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

public class CityID {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("lat")
    private Object lat;
    @SerializedName("lng")
    private Object lng;
    @SerializedName("zoom")
    private Object zoom;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("arabic_name")
    private Object arabicName;
    @SerializedName("city_id")
    private Long cityID;

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

    public Object getLat() {
        return lat;
    }

    public void setLat(Object value) {
        this.lat = value;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object value) {
        this.lng = value;
    }

    public Object getZoom() {
        return zoom;
    }

    public void setZoom(Object value) {
        this.zoom = value;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String value) {
        this.createdAt = value;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String value) {
        this.updatedAt = value;
    }

    public Object getArabicName() {
        return arabicName;
    }

    public void setArabicName(Object value) {
        this.arabicName = value;
    }

    public Long getCityID() {
        return cityID;
    }

    public void setCityID(Long value) {
        this.cityID = value;
    }
}
