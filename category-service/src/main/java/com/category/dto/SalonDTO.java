package com.category.dto;

import java.time.LocalTime;
import java.util.List;

public class SalonDTO {
    private Long id;

    private String name;

    private String email;

    private List<String> images;

    private String phone;

    private String address;

    private String city;

    private LocalTime open;
    private LocalTime close;
    private Long ownerId;
    public SalonDTO() {
    }


    public SalonDTO(Long id, String name, String email,
                    List<String> images, String phone,
                    String address, LocalTime open,
                    String city, LocalTime close, Long ownerId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.images = images;
        this.phone = phone;
        this.address = address;
        this.open = open;
        this.city = city;
        this.close = close;
        this.ownerId = ownerId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getOpen() {
        return open;
    }

    public void setOpen(LocalTime open) {
        this.open = open;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalTime getClose() {
        return close;
    }

    public void setClose(LocalTime close) {
        this.close = close;
    }
}
