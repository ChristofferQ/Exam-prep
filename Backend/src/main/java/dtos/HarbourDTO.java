package dtos;

import entities.Harbour;

public class HarbourDTO {

    private int Id;
    private String name;
    private String address;
    private int  capacity;

    public HarbourDTO(Harbour h) {
        this.Id = h.getId();
        this.name = h.getName();
        this.address = h.getAddress();
        this.capacity = h.getCapacity();
    }

    public HarbourDTO(int id, String name, String address, int capacity) {
        Id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
