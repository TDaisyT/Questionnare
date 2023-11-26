package com.example.questionnare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.questionnare.AdminHome.StatisticActivity;
import com.example.questionnare.UserHome.QuestionsActivity;

public class Qlist extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_questions, container, false);
        ListView listView = rootView.findViewById(R.id.list_items);


        // place holder items in the list
        String[] data = new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        // ezzel tölti fel a listview-t elemekkel, azt se tudom honnan jön a simple_list_item_1
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        //controlálja a kérdőívre való kattintás utáni képernyőt
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;
                String userEmail = getActivity().getIntent().getStringExtra("email");

                // Check if user is an admin or a regular user
                /*for some god forsaken reason this shit keeps crashing idk why
                if (userEmail != null && userEmail.equals("admin@gmail.com")) {
                    intent = new Intent(requireActivity(), StatisticActivity.class);
                } else {*/
                    intent = new Intent(requireActivity(), QuestionsActivity.class);

                    // Pass the email as an extra to QuestionsActivity
                    intent.putExtra("email", userEmail);


                startActivity(intent);
            }
        });

        return rootView;
    }
}