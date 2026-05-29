package com.zosh.booking_service.dto;

public class CategoryDTO {
    private Long id;
    private String name;
    private String image;

    public CategoryDTO() {
    }

    public CategoryDTO(String name, Long id, String image) {
        this.name = name;
        this.id = id;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
