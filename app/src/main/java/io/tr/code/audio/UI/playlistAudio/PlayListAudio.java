package io.tr.code.audio.UI.playlistAudio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.tr.code.audio.API.ClientAPI;
import io.tr.code.audio.API.RetrofitClientInstance;
import io.tr.code.audio.Models.ApiModel;
import io.tr.code.audio.Models.FileModel;
import io.tr.code.audio.R;
import io.tr.code.audio.adapter.ListAudioAdapter;
import io.tr.code.audio.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlayListAudio extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAudioAdapter listAudioAdapter;
    private ImageView backBtn;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list_audio);
        progressBar= findViewById(R.id.progressBar);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener((view) -> {
            onBackPressed();
        });

        
        recyclerView = findViewById(R.id.recycle_play_list);
        listAudioAdapter = new ListAudioAdapter(this);
        recyclerView.setAdapter(listAudioAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        // call fetch data

        Intent intent = (Intent) getIntent();
        String id = Objects.requireNonNull(intent.getExtras()).getString("id");
        fetchData(id);
    }


    public void fetchData(String id){
        ClientAPI service = RetrofitClientInstance.getRetrofitInstance().create(ClientAPI.class);
        Call<ApiModel> call = service.getPlayListById(id);
        call.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(@Nullable Call<ApiModel> call,@Nullable Response<ApiModel> response) {
                assert response != null;
                List<FileModel> fileModels = new ArrayList<>();
                assert response.body() != null;
                fileModels = (response.body().getFiles());
                Log.e("ssss",fileModels.get(0).getName());
                String dir = response.body().getDir();
                Log.e("dir",response.body().getDir());
                listAudioAdapter.setList(Utils.filterList((ArrayList<FileModel>) response.body().getFiles()),dir);
               // listAudioAdapter.setList(fileModels,dir);
                listAudioAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(@Nullable Call<ApiModel> call, Throwable t) {
                Log.e("error", t.getMessage());
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(PlayListAudio.this, "Problem Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
