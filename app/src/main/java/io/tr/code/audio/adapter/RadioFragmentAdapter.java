package io.tr.code.audio.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import io.tr.code.audio.Models.RadioModel;
import io.tr.code.audio.R;
import io.tr.code.audio.UI.player.Player;

public class RadioFragmentAdapter extends RecyclerView.Adapter<RadioFragmentAdapter.RadioFragmentViewHolder>{

    private List<RadioModel> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public RadioFragmentAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void setList(List<RadioModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RadioFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_radio_layout, parent,false);
        return new RadioFragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RadioFragmentViewHolder holder, int position) {
        holder.title.setText(list.get(position).getName());
        holder.cardView.setOnClickListener((view) -> {
            Intent intent = new Intent(context, Player.class);
            intent.putExtra("from","radio");
            intent.putExtra("name",list.get(position).getName());
            intent.putExtra("url",list.get(position).getRadio_url());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RadioFragmentViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        CardView cardView;
        public RadioFragmentViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.id_text_title);
            cardView = itemView.findViewById(R.id.id_card_item);
        }
    }
}
