package com.springapp.iaBiletclone.dtos;

public class CityRequestDTO {

    private String name;

    public CityRequestDTO() {
    }

    public CityRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
