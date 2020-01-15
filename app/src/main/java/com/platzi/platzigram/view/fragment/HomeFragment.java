package com.platzi.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.platzigram.R;
import com.platzi.platzigram.adapter.PictureAdapterRecycclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home),false,view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecycclerView pictureAdapterRecycclerView = new PictureAdapterRecycclerView(buidPictures(), R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecycclerView);
        return view;
    }

    public ArrayList<com.platzi.platzigram.model.Picture> buidPictures(){
        ArrayList<com.platzi.platzigram.model.Picture> pictures = new ArrayList<>();
        pictures.add(new com.platzi.platzigram.model.Picture("https://square.github.io/picasso/static/sample.png","Kevin de Jesús", "10 dias", "10 me gusta"));
        pictures.add(new com.platzi.platzigram.model.Picture("https://image.shutterstock.com/z/stock-photo-hong-kong-january-american-heavy-metal-band-metallica-show-vocalist-james-hetfield-605599298.jpg","Mynor García", "5 dias", "50 me gusta"));
        pictures.add(new com.platzi.platzigram.model.Picture("https://image.shutterstock.com/z/stock-vector-rocks-54030280.jpg","Rockerito Hermoso", "15 dias", "4 me gusta"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
