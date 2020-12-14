package id.putraprima.mygoldtracker.screen.harga;

import android.content.ClipData;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.putraprima.mygoldtracker.api.models.AppPrice;
import id.putraprima.mygoldtracker.databinding.ItemPriceBinding;

public class HargaAdapter extends RecyclerView.Adapter<HargaAdapter.HargaViewHolder>{
    List<AppPrice> list = new ArrayList<>();

    public HargaAdapter() {
    }

    public void setList(List<AppPrice> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HargaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPriceBinding itemPriceBinding = ItemPriceBinding.inflate(layoutInflater,parent,false);
        return new HargaViewHolder(itemPriceBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HargaViewHolder holder, int position) {
        AppPrice appPrice = list.get(position);
        holder.bind(appPrice);
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }else {
            return 0;
        }
    }

    public class HargaViewHolder extends RecyclerView.ViewHolder {
        ItemPriceBinding itemPriceBinding;

        public HargaViewHolder(ItemPriceBinding itemPriceBinding) {
            super(itemPriceBinding.getRoot());
            this.itemPriceBinding = itemPriceBinding;
        }

        public void bind(AppPrice appPrice){
            itemPriceBinding.setItemPrice(appPrice);
            itemPriceBinding.executePendingBindings();
        }
    }
}
