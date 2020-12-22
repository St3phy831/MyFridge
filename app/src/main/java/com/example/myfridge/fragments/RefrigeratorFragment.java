package com.example.myfridge.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myfridge.R;
import com.example.myfridge.cardActivities.RefrigeratorActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RefrigeratorFragment extends Fragment {

    private static final String TAG = "Refrigerator Fragment";

    CardView cardOne;
    CardView cardTwo;
    CardView cardThree;
    CardView cardFour;
    CardView cardFive;
    CardView cardSix;

    public RefrigeratorFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_refrigerator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardOne = view.findViewById(R.id.dairyCard);
        cardTwo = view.findViewById(R.id.veggieCard);
        cardThree = view.findViewById(R.id.fruitCard);
        cardFour = view.findViewById(R.id.juicesCard);
        cardFive = view.findViewById(R.id.meatCard);
        cardSix = view.findViewById(R.id.otherCard);

        cardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opens Refrigerator Activity
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                //Send data of this activity through bundle
                Bundle extras = new Bundle();
                extras.putString("color", "#4287f5");
                extras.putString("title", "Dairy List");
                intent.putExtras(extras);
                startActivity(intent);
                Toast.makeText(getContext(), "Dairy Activity", Toast.LENGTH_SHORT).show();
            }
        });
        cardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#78de95");
                extras.putString("title", "Veggie List");
                intent.putExtras(extras);
                startActivity(intent);
                Toast.makeText(getContext(), "Veggie Activity", Toast.LENGTH_SHORT).show();
            }
        });
        cardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#f384f5");
                extras.putString("title", "Fruit List");
                intent.putExtras(extras);
                startActivity(intent);
                Toast.makeText(getContext(), "Fruit Activity", Toast.LENGTH_SHORT).show();
            }
        });
        cardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#f7ab40");
                extras.putString("title", "Juice List");
                intent.putExtras(extras);
                startActivity(intent);
                Toast.makeText(getContext(), "Juices Activity", Toast.LENGTH_SHORT).show();
            }
        });
        cardFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#fa6964");
                extras.putString("title", "Meat List");
                intent.putExtras(extras);
                startActivity(intent);
                Toast.makeText(getContext(), "Meat Activity", Toast.LENGTH_SHORT).show();
            }
        });
        cardSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#b696fa");
                extras.putString("title", "Other List");
                intent.putExtras(extras);
                startActivity(intent);
                Toast.makeText(getContext(), "Other Activity", Toast.LENGTH_SHORT).show();
            }
        });
    }
}