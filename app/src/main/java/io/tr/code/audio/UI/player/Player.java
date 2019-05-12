package io.tr.code.audio.UI.player;

import androidx.appcompat.app.AppCompatActivity;
import io.tr.code.audio.R;
import io.tr.code.audio.utils.Utils;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import java.util.ArrayList;
import java.util.Objects;

public class Player extends AppCompatActivity {

    private JcPlayerView jcplayerView;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener((view) -> {
            onBackPressed();
        });

        jcplayerView = (JcPlayerView) findViewById(R.id.jcplayer);
        ArrayList<JcAudio> jcAudios = new ArrayList<>();

        // get name
        String from = Objects.requireNonNull(getIntent().getExtras()).getString("from");
        assert from != null;
        if (from.equals("radio")) {
            String name = Objects.requireNonNull(getIntent().getExtras()).getString("name");
            String url = Objects.requireNonNull(getIntent().getExtras()).getString("url");
            assert url != null;
            assert name != null;
            jcAudios.add(JcAudio.createFromURL(name, url));
            jcplayerView.initPlaylist(jcAudios, null);
        }else {

            String name = Objects.requireNonNull(getIntent().getExtras()).getString("name");
            String dir = Objects.requireNonNull(getIntent().getExtras()).getString("dir");
            jcAudios.add(JcAudio.createFromURL(name, Utils.END_POINT_URL+dir+"/"+name));
            jcplayerView.initPlaylist(jcAudios, null);
        }


    }
}
