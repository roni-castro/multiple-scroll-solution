package com.example.roni.multiplescroll;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roni on 26/02/18.
 */

public class StoreNameFragment extends Fragment {
    private ArrayList<String> storeNameList, storeNameList2;
    @BindView(R.id.rv_store_name_1) RecyclerView storeNameRecyclerView;
    @BindView(R.id.rv_store_name_2) RecyclerView storeNameRecyclerView2;

    private SingleTextAdapter adapter, adapter2;

    /**
     * Create a new instance of this class, passing the object to be used
     *
     * @return an instance of this fragment
     */
    public static StoreNameFragment newInstance() {
        StoreNameFragment fragment = new StoreNameFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store_name_fragment, container, false);
        ButterKnife.bind(this, view);
        createRecyclerView1();
        createRecyclerView2();

        return view;
    }

    private void createRecyclerView1(){
        storeNameList = createMockArray();
        adapter = new SingleTextAdapter(getActivity(), storeNameList);
        storeNameRecyclerView.setAdapter(adapter);
        storeNameRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Disable the vertical scroll of the recycler view to fix the conflict of scrolls
        storeNameRecyclerView.setNestedScrollingEnabled(false);
    }

    private void createRecyclerView2(){
        storeNameList2 = createMockArray2();
        adapter2 = new SingleTextAdapter(getActivity(), storeNameList2);
        storeNameRecyclerView2.setAdapter(adapter2);
        storeNameRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Disable the vertical scroll of the recycler view to fix the conflict of scrolls
        storeNameRecyclerView2.setNestedScrollingEnabled(false);
    }

    private ArrayList<String> createMockArray(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Amazon");
        arrayList.add("Carrefour");
        arrayList.add("Wall Mart");
        arrayList.add("Sonda");
        arrayList.add("Market");
        arrayList.add("PW");
        arrayList.add("CheapMarket");
        arrayList.add("----------");
        arrayList.add("Amazon");
        arrayList.add("Carrefour");
        arrayList.add("Wall Mart");
        arrayList.add("Sonda");
        arrayList.add("Market");
        arrayList.add("PW");
        arrayList.add("CheapMarket");
        arrayList.add("----------");
        arrayList.add("Amazon");
        arrayList.add("Carrefour");
        arrayList.add("Wall Mart");
        arrayList.add("Sonda");
        arrayList.add("Market");
        arrayList.add("PW");
        arrayList.add("CheapMarket");
        return arrayList;
    }

    private ArrayList<String> createMockArray2(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("=====SECOND LIST=====");
        arrayList.add("Pink Amazon");
        arrayList.add("Pink Carrefour");
        arrayList.add("Pink Wall Mart");
        arrayList.add("Pink Sonda");
        arrayList.add("Pink Market");
        arrayList.add("Pink PW");
        arrayList.add("Pink CheapMarket");
        return arrayList;
    }
}