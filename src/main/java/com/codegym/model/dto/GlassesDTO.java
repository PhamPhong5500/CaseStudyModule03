package com.codegym.model.dto;

public class GlassesDTO {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String brand;
    public GlassesDTO(){
    }
    public GlassesDTO( String name, double price, int quantity, String brand){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
    }
    public GlassesDTO(int id, String name, double price, int quantity, String brand){
        this.id = id ;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
    }
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public String toString() {
        return "GlassesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", brand='" + brand + '\'' +
                '}';
    }

}
