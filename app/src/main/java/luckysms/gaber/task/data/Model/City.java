package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

class City {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }

    public Object getZoom() {
        return zoom;
    }

    public void setZoom(Object zoom) {
        this.zoom = zoom;
    }
}
