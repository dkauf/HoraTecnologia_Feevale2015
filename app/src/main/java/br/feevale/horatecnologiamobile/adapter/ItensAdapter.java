package br.feevale.horatecnologiamobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import br.feevale.horatecnologiamobile.activity.ItemActivity;
import br.feevale.horatecnologiamobile.model.Item;
import br.feevale.horatecnologiamobile.R;

/**
 * Created by dkauf on 13/05/16.
 */
public class ItensAdapter extends RecyclerView.Adapter<ItensAdapter.ViewHolders>{

    private List<Item> listItens;
    private Context context;

    public ItensAdapter(Context context, List<Item> listItens) {
        this.context = context;
        this.listItens = listItens;
    }

    @Override
    public ItensAdapter.ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main_activity, parent, false );
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(ItensAdapter.ViewHolders holder, int position) {
        final Item item = listItens.get( position );

        //todo Glide é uma biblioteca que faz o download da imagem no caminho especificado, mas verifica se ele já não possui ela em cache, daí não precisa mais baixar ela
        Glide.with(context)
                .load(item.getUrlImage())
                .asBitmap()
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageViewAdapter);

        holder.txtTitle.setText(item.getTitle());
        holder.txtPrice.setText("R$ " + String.format("%.2f", item.getPrice()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ItemActivity.class);
                intent.putExtra("item", item);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItens.size();
    }

    static class ViewHolders extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        ImageView imageViewAdapter;
        TextView txtTitle;
        TextView txtPrice;

        public ViewHolders(View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            imageViewAdapter = (ImageView) itemView.findViewById(R.id.imageViewAdapter);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
        }
    }
}
