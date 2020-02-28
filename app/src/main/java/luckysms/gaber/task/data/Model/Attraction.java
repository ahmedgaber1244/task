package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attraction {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("is_active")
    private Long isActive;
    @SerializedName("description")
    private String description;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("arabic_name")
    private String arabicName;
    @SerializedName("arabic_description")
    private String arabicDescription;
    @SerializedName("facebook")
    private Object facebook;
    @SerializedName("twitter")
    private Object twitter;
    @SerializedName("instagram")
    private Object instagram;
    @SerializedName("working_hours")
    private List<WorkingHour> workingHours;
    @SerializedName("photos")
    private List<String> photos;
    @SerializedName("categories")
    private List<AttractionCategory> categories;
    @SerializedName("features")
    private List<Feature> features;
    @SerializedName("offers")
    private List<Object> offers;
    @SerializedName("tryps_id")
    private String trypsID;
    @SerializedName("markup")
    private Long markup;
    @SerializedName("duration")
    private String duration;
    @SerializedName("duration_unit")
    private String durationUnit;
    @SerializedName("general_terms")
    private String generalTerms;
    @SerializedName("terms")
    private String terms;
    @SerializedName("exlcude")
    private String exlcude;
    @SerializedName("city")
    private City city;


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

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(String arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public Object getFacebook() {
        return facebook;
    }

    public void setFacebook(Object facebook) {
        this.facebook = facebook;
    }

    public Object getTwitter() {
        return twitter;
    }

    public void setTwitter(Object twitter) {
        this.twitter = twitter;
    }

    public Object getInstagram() {
        return instagram;
    }

    public void setInstagram(Object instagram) {
        this.instagram = instagram;
    }

    public List<WorkingHour> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<WorkingHour> workingHours) {
        this.workingHours = workingHours;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<AttractionCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<AttractionCategory> categories) {
        this.categories = categories;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    public String getTrypsID() {
        return trypsID;
    }

    public void setTrypsID(String trypsID) {
        this.trypsID = trypsID;
    }

    public Long getMarkup() {
        return markup;
    }

    public void setMarkup(Long markup) {
        this.markup = markup;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public String getGeneralTerms() {
        return generalTerms;
    }

    public void setGeneralTerms(String generalTerms) {
        this.generalTerms = generalTerms;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getExlcude() {
        return exlcude;
    }

    public void setExlcude(String exlcude) {
        this.exlcude = exlcude;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
