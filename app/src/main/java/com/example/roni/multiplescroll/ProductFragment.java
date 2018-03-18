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

/**
 * Created by roni on 26/02/18.
 */


public class ProductFragment extends Fragment {
    private ArrayList<String> productNameList;
    private RecyclerView productNameRecyclerView;
    private SingleTextAdapter adapter;

    /**
     * Create a new instance of this class, passing the object to be used
     *
     * @return an instance of this fragment
     */
    public static ProductFragment newInstance() {
        ProductFragment fragment = new ProductFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_fragment, container, false);
        productNameRecyclerView = view.findViewById(R.id.rv_product);
        productNameRecyclerView.setLayoutManager( new LinearLayoutManager(this.getActivity()));
        productNameList = createMockArray();
        adapter = new SingleTextAdapter(getActivity(), productNameList);
        productNameRecyclerView.setAdapter(adapter);
        productNameRecyclerView.setNestedScrollingEnabled(false);
        return view;
    }

    private ArrayList<String> createMockArray(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Orange");
        arrayList.add("Banana");
        arrayList.add("Strawberry");
        arrayList.add("Apple");
        arrayList.add("Lemon");
        arrayList.add("Pineapple");
        arrayList.add("Avocado");
        arrayList.add("BlueBerry");
        arrayList.add("Pear");
        arrayList.add("Grape");
        arrayList.add("------");
        arrayList.add("Orange");
        arrayList.add("Banana");
        arrayList.add("Strawberry");
        arrayList.add("Apple");
        arrayList.add("Lemon");
        arrayList.add("Pineapple");
        arrayList.add("Avocado");
        arrayList.add("BlueBerry");
        arrayList.add("Pear");
        arrayList.add("Grape");
        return arrayList;
    }
}
