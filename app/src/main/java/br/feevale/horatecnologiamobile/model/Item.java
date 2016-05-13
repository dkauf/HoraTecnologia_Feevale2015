package br.feevale.horatecnologiamobile.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dkauf on 13/05/16.
 */
public class Item implements Serializable {

    @SerializedName("url")
    private String urlImage;

    @SerializedName("descricao")
    private String description;

    @SerializedName("valor")
    private double price;

    @SerializedName("nome")
    private String title;


    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
