package com.example.questionnare.UserHome;

import android.content.Intent;
import android.os.Bundle;


import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.questionnare.MainActivity;
import com.example.questionnare.R;

public class ProfileActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Button logOutButton = view.findViewById(R.id.logout);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        //Kinyerem az Intentből az emailt és jelszót
        String email = getActivity().getIntent().getStringExtra("email");
        String password = getActivity().getIntent().getStringExtra("password");

        // Az XML nézet elemek megkeresése
        TextView emailProfileTextView = view.findViewById(R.id.emailProfile);
        TextView passwordProfileTextView = view.findViewById(R.id.passwordProfile);

        // Az adatok beállítása a TextView elemekben
        emailProfileTextView.setText("Email: " + email);
        passwordProfileTextView.setText("Password: " + password);

        return view;
    }
}