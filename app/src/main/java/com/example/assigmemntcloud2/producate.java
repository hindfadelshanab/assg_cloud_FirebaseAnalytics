package com.example.assigmemntcloud2;

public class producate {
    String id ;
    String name ;
    String descritpion ;
    String price ;
    int image;

    public producate(String id, String name, String descritpion, String price, int image) {
        this.id = id;
        this.name = name;
        this.descritpion = descritpion;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
