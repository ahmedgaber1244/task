package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

class HotSpotCategory {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("order")
    private Long order;
    @SerializedName("ar_name")
    private Object arName;

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

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long value) {
        this.order = value;
    }

    public Object getArName() {
        return arName;
    }

    public void setArName(Object value) {
        this.arName = value;
    }
}
