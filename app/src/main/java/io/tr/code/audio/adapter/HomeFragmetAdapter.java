package io.tr.code.audio.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import io.tr.code.audio.Models.MainModel;
import io.tr.code.audio.R;
import io.tr.code.audio.UI.playlistAudio.PlayListAudio;
import io.tr.code.audio.utils.Utils;


public class HomeFragmetAdapter extends RecyclerView.Adapter<HomeFragmetAdapter.HomeFragmentHolder> {

    private List<MainModel> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;


    public HomeFragmetAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void setList(List<MainModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public HomeFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_play_list_grid,parent,false);
        return new HomeFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFragmentHolder holder, int position) {
        holder.imageView.setImageDrawable(Utils.getRandomImage(context));
        holder.title.setText(list.get(position).getTitle());
        holder.cardView.setOnClickListener((view) -> {
            Intent intent = new Intent(context, PlayListAudio.class);
            intent.putExtra("id", list.get(position).getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeFragmentHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        CardView cardView;

        public HomeFragmentHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.id_image_below_card);
            title = itemView.findViewById(R.id.id_text_title_card_playlist);
            cardView = itemView.findViewById(R.id.card_item);
        }
    }


}
