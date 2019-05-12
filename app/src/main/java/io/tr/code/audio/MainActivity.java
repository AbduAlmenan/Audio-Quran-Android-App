package io.tr.code.audio;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import io.tr.code.audio.UI.favorit.FavoritFragment;
import io.tr.code.audio.UI.home.HomeFragment;
import io.tr.code.audio.UI.radio.RadioFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomMenu;
    public static final String FRAGMENT_VIEWPAGER = "FRAGMENT_VIEWPAGER";
    public static final String FRAGMENT_FIRST = "FRAGMENT_FIRST";
    public static final String FRAGMENT_SECOND = "FRAGMENT_SECOND";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.audio:
                    replaceFragment(HomeFragment.newInstance(),FRAGMENT_FIRST);
                    return true;
                case R.id.radio:
                    replaceFragment(RadioFragment.newInstance(),FRAGMENT_SECOND);
                    return true;
                case R.id.favorit:
                    replaceFragment(FavoritFragment.newInstance(),FRAGMENT_VIEWPAGER);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    /**
     * Set The UI Elements
     */
    public void setupUI() {
        bottomMenu = findViewById(R.id.navigation);
        bottomMenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, HomeFragment.newInstance(), FRAGMENT_FIRST)
                .commit();
    }


    private void replaceFragment(Fragment newFragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, newFragment, tag)
                .commit();

    }
}
