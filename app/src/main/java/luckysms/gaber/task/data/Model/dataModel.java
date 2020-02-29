package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class dataModel {
    @SerializedName("attractions")
    private List<Attraction> attractions;
    @SerializedName("events")
    private List<Object> events;
    @SerializedName("hot_spots")
    private List<HotSpot> hotSpots;

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Object> getEvents() {
        return events;
    }

    public void setEvents(List<Object> events) {
        this.events = events;
    }

    public List<HotSpot> getHotSpots() {
        return hotSpots;
    }

    public void setHotSpots(List<HotSpot> hotSpots) {
        this.hotSpots = hotSpots;
    }
}
