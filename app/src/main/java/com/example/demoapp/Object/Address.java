package com.example.demoapp.Object;

public class Address {
    int id;
    String name;
    String address;
    String timeDetail;

    public Address(int id, String name, String address, String timeDetail) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.timeDetail = timeDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTimeDetail() {
        return timeDetail;
    }

    public void setTimeDetail(String timeDetail) {
        this.timeDetail = timeDetail;
    }
}
