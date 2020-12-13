package id.putraprima.mygoldtracker.screen.tabungan;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.putraprima.mygoldtracker.databinding.ItemTabunganBinding;
import id.putraprima.mygoldtracker.db.models.Tabungan;

public class TabunganAdapter extends RecyclerView.Adapter<TabunganAdapter.TabunganViewHolder>{

    List<Tabungan> list;

    public TabunganAdapter() {
    }

    public void setList(List<Tabungan> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TabunganViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemTabunganBinding itemTabunganBinding = ItemTabunganBinding.inflate(layoutInflater,parent,false);
        return new TabunganAdapter.TabunganViewHolder(itemTabunganBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TabunganViewHolder holder, int position) {
        Tabungan tabungan = list.get(position);
        holder.bind(tabungan);
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }else{
            return 0;
        }
    }

    public class TabunganViewHolder extends RecyclerView.ViewHolder {
        ItemTabunganBinding binding;
        public TabunganViewHolder(ItemTabunganBinding itemTabunganBinding) {
            super(itemTabunganBinding.getRoot());
            binding = itemTabunganBinding;
        }

        public void bind(Tabungan item){
            binding.setItemTabungan(item);
            binding.executePendingBindings();
        }
    }
}
