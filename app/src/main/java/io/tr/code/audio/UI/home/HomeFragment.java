package io.tr.code.audio.UI.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.tr.code.audio.Models.MainModel;
import io.tr.code.audio.R;
import io.tr.code.audio.adapter.HomeFragmetAdapter;
import io.tr.code.audio.utils.Utils;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    public HomeFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance( ) {
        HomeFragment fragment = new HomeFragment();
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
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView  = view.findViewById(R.id.recycleAudio);
        HomeFragmetAdapter homeFragmetAdapter = new HomeFragmetAdapter(getContext());
        try {
            List<MainModel> mainModels = Utils.getListAudio(getContext());
            homeFragmetAdapter.setList(mainModels);
            recyclerView.setAdapter(homeFragmetAdapter);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        }catch (Exception e) {

        }


        return view;
    }

}
