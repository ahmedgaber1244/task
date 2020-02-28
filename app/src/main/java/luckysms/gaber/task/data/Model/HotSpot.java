package luckysms.gaber.task.data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotSpot {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("short_description")
    private String shortDescription;
    @SerializedName("price_of_two")
    private String priceOfTwo;
    @SerializedName("arabic_name")
    private String arabicName;
    @SerializedName("arabic_short_description")
    private String arabicShortDescription;
    @SerializedName("arabic_description")
    private String arabicDescription;
    @SerializedName("city_id")
    private CityID cityID;
    @SerializedName("neighborhood")
    private Object neighborhood;
    @SerializedName("address")
    private String address;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("facebook")
    private String facebook;
    @SerializedName("twitter")
    private String twitter;
    @SerializedName("instagram")
    private String instagram;
    @SerializedName("website")
    private String website;
    @SerializedName("views")
    private long views;
    @SerializedName("facebook_id")
    private String facebookID;
    @SerializedName("facebook_image")
    private String facebookImage;
    @SerializedName("phone")
    private String phone;
    @SerializedName("photos")
    private List<String> photos;
    @SerializedName("profile_photo")
    private String profilePhoto;
    @SerializedName("city")
    private City city;
    @SerializedName("categories")
    private List<HotSpotCategory> categories;
    @SerializedName("features")
    private List<Feature> features;
    @SerializedName("cuisineTypes")
    private List<CuisineType> cuisineTypes;
    @SerializedName("offers")
    private List<Object> offers;
    @SerializedName("external_rating")
    private List<Object> externalRating;
    @SerializedName("video")
    private String video;
    @SerializedName("menus")
    private List<String> menus;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPriceOfTwo() {
        return priceOfTwo;
    }

    public void setPriceOfTwo(String priceOfTwo) {
        this.priceOfTwo = priceOfTwo;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicShortDescription() {
        return arabicShortDescription;
    }

    public void setArabicShortDescription(String arabicShortDescription) {
        this.arabicShortDescription = arabicShortDescription;
    }

    public String getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(String arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public CityID getCityID() {
        return cityID;
    }

    public void setCityID(CityID cityID) {
        this.cityID = cityID;
    }

    public Object getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Object neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getFacebookImage() {
        return facebookImage;
    }

    public void setFacebookImage(String facebookImage) {
        this.facebookImage = facebookImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<HotSpotCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<HotSpotCategory> categories) {
        this.categories = categories;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<CuisineType> getCuisineTypes() {
        return cuisineTypes;
    }

    public void setCuisineTypes(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    public List<Object> getExternalRating() {
        return externalRating;
    }

    public void setExternalRating(List<Object> externalRating) {
        this.externalRating = externalRating;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }
}
