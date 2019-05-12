package io.tr.code.audio.UI.radio;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.tr.code.audio.Models.RadioModel;
import io.tr.code.audio.R;
import io.tr.code.audio.adapter.RadioFragmentAdapter;
import io.tr.code.audio.utils.Utils;


public class RadioFragment extends Fragment {

    private  RecyclerView recyclerView;
    private RadioFragmentAdapter radioFragmentAdapter;

    public RadioFragment() {
        // Required empty public constructor
    }


    public static RadioFragment newInstance() {
        RadioFragment fragment = new RadioFragment();
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
        View view =inflater.inflate(R.layout.fragment_radio, container, false);
        recyclerView = view.findViewById(R.id.recycle);
        radioFragmentAdapter = new RadioFragmentAdapter(getContext());
        List<RadioModel> radioModels = Utils.getListRadio(getContext());
        radioFragmentAdapter.setList(radioModels);
        recyclerView.setAdapter(radioFragmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }


}
