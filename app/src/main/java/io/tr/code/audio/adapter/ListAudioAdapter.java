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
import io.tr.code.audio.Models.FileModel;
import io.tr.code.audio.R;
import io.tr.code.audio.UI.player.Player;

public class ListAudioAdapter extends RecyclerView.Adapter<ListAudioAdapter.ListAudioAdapterHolder> {

    private List<FileModel> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;
    private String dir;

    public ListAudioAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void setList(List<FileModel> list, String dir) {
        this.dir = dir;
        this.list = list;
    }

    @NonNull
    @Override
    public ListAudioAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.item_play_list,parent,false);
        return new ListAudioAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAudioAdapterHolder holder, int position) {
        holder.title.setText(list.get(position).getName());
        holder.cardView.setOnClickListener((view) -> {
            Intent intent = new Intent(context, Player.class);
            intent.putExtra("from","simple");
            intent.putExtra("name",list.get(position).getName());
            intent.putExtra("dir",dir);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListAudioAdapterHolder extends RecyclerView.ViewHolder {
        TextView title;
        CardView cardView;
        public ListAudioAdapterHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.id_text_title);
            cardView = itemView.findViewById(R.id.id_card_item);
        }
    }
 }
