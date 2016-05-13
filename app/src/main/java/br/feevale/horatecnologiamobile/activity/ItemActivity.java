package br.feevale.horatecnologiamobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import br.feevale.horatecnologiamobile.model.Item;
import br.feevale.horatecnologiamobile.R;

/**
 * Created by dkauf on 13/05/16.
 */
public class ItemActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txtTitle;
    TextView txtPrice;
    TextView txtDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens);

        imageView = (ImageView ) findViewById(R.id.imageView);
        txtTitle = ( TextView )findViewById(R.id.title);
        txtPrice = ( TextView ) findViewById(R.id.price );
        txtDescription = ( TextView ) findViewById( R.id.description );

        Intent intent = getIntent();

        Item item = (Item) intent.getSerializableExtra("item");

        Glide.with(this)
                .load(item.getUrlImage())
                .asBitmap()
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

        txtTitle.setText(item.getTitle() );
        txtPrice.setText("R$ " + String.format("%.2f", item.getPrice()));
        txtDescription.setText(item.getDescription());
    }
}
