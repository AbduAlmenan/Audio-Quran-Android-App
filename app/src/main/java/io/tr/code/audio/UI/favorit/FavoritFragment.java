package io.tr.code.audio.UI.favorit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.tr.code.audio.R;

public class FavoritFragment extends Fragment {

    public FavoritFragment() {
        // Required empty public constructor
    }


    public static FavoritFragment newInstance() {
        FavoritFragment fragment = new FavoritFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorit, container, false);
    }


}
