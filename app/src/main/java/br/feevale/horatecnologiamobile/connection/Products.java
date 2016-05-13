package br.feevale.horatecnologiamobile.connection;

import java.util.List;

import br.feevale.horatecnologiamobile.model.Item;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by dkauf on 13/05/16.
 */
public interface Products {

    @GET("/products")
    public void getProducts(Callback<List<Item>> listItens );
}
