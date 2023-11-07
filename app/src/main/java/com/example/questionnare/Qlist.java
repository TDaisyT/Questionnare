package com.example.questionnare;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Qlist extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = rootView.findViewById(R.id.list_items);

        String[] data = new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);

        return rootView;
    }
}