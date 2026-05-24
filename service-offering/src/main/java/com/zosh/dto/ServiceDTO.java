package com.zosh.dto;

import jakarta.persistence.Column;

public class ServiceDTO {
    private Long id;
    private String name;
    private String image;
    private String description;
    private int price;
    private int duration;
    private Long salonId;
    private Long categoryId;

    public ServiceDTO(Long id) {
        this.id = id;
    }

    public ServiceDTO(Long categoryId, Long salonId,
                      int duration, int price,
                      String description, String image, String name, Long id) {
        this.categoryId = categoryId;
        this.salonId = salonId;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.image = image;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Long getSalonId() {
        return salonId;
    }

    public void setSalonId(Long salonId) {
        this.salonId = salonId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
