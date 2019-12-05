package com.worldhosteling.go.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
public class Hostel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    @NotEmpty(message = "Must include a country.")
    private String country;

    @Column(nullable = false)
    @NotEmpty(message = "Must include a city.")
    private String city;

    private String region;

    @Column(nullable = false)
    @NotEmpty(message = "Must include a description.")
    private String description;

    private double latitude;

    private double longitude;

    @Column(nullable = false)
    @NotEmpty(message = "Must include a price.")
    private double price;

    private Integer rating;

    private String bannerImage;

    @Column(nullable = false)
    @NotEmpty(message = "Must include a hostel name.")
    private String name;

    @ElementCollection(targetClass=String.class)
    private List<String> hostelPictureList;

    @ElementCollection(targetClass=String.class)
    private List<String> freeList;

    @ElementCollection(targetClass=String.class)
    private List<String> generalList;

    @ElementCollection(targetClass=String.class)
    private List<String> servicesList;

    @ElementCollection(targetClass=String.class)
    private List<String> foodDrinkList;

    @ElementCollection(targetClass=String.class)
    private List<String> entertainmentList;

    public Hostel() {}

    public Hostel(String country, String city, String description, String name) {
        this.country = country;
        this.city = city;
        this.description = description;
        this.name = name;
    }

    public Hostel(String country, String city, String region, String description, double latitude, double longitude, String bannerImage, String name, List<String> hostelPictureList, List<String> freeList, List<String> generalList, List<String> servicesList, List<String> foodDrinkList, List<String> entertainmentList) {
        this.country = country;
        this.city = city;
        this.region = region;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bannerImage = bannerImage;
        this.name = name;
        this.hostelPictureList = hostelPictureList;
        this.freeList = freeList;
        this.generalList = generalList;
        this.servicesList = servicesList;
        this.foodDrinkList = foodDrinkList;
        this.entertainmentList = entertainmentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHostelPictureList() {
        return hostelPictureList;
    }

    public void setHostelPictureList(List<String> hostelPictureList) {
        this.hostelPictureList = hostelPictureList;
    }

    public List<String> getFreeList() {
        return freeList;
    }

    public void setFreeList(List<String> freeList) {
        this.freeList = freeList;
    }

    public List<String> getGeneralList() {
        return generalList;
    }

    public void setGeneralList(List<String> generalList) {
        this.generalList = generalList;
    }

    public List<String> getServicesList() {
        return servicesList;
    }

    public void setServicesList(List<String> servicesList) {
        this.servicesList = servicesList;
    }

    public List<String> getFoodDrinkList() {
        return foodDrinkList;
    }

    public void setFoodDrinkList(List<String> foodDrinkList) {
        this.foodDrinkList = foodDrinkList;
    }

    public List<String> getEntertainmentList() {
        return entertainmentList;
    }

    public void setEntertainmentList(List<String> entertainmentList) {
        this.entertainmentList = entertainmentList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", bannerImage='" + bannerImage + '\'' +
                ", name='" + name + '\'' +
                ", hostelPictureList=" + hostelPictureList +
                ", freeList=" + freeList +
                ", generalList=" + generalList +
                ", servicesList=" + servicesList +
                ", foodDrinkList=" + foodDrinkList +
                ", entertainmentList=" + entertainmentList +
                '}';
    }

}
