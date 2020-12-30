package com.example.myfridge.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myfridge.R;
import com.example.myfridge.adapters.FridgeItemsAdapter;
import com.example.myfridge.cardActivities.RefrigeratorActivity;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RefrigeratorFragment extends Fragment {
    public static final String TAG = "Refrigerator Fragment";

    CardView cardOne;
    CardView cardTwo;
    CardView cardThree;
    CardView cardFour;
    CardView cardFive;
    CardView cardSix;


    //Each item and date List corresponds to a category
    List<String> itemsOne = new ArrayList<>();
    List<String> datesOne = new ArrayList<>();

    List<String> itemsTwo = new ArrayList<>();
    List<String> datesTwo = new ArrayList<>();

    List<String> itemsThree = new ArrayList<>();
    List<String> datesThree = new ArrayList<>();

    List<String> itemsFour = new ArrayList<>();
    List<String> datesFour = new ArrayList<>();

    List<String> itemsFive = new ArrayList<>();
    List<String> datesFive = new ArrayList<>();

    List<String> itemsSix = new ArrayList<>();
    List<String> datesSix = new ArrayList<>();

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

        //Get Arguments of Compose Fragment and Opens particular Card View based on user's category
        Bundle args = getArguments();
        if(args != null){
            String item = args.getString("item");
            String category = args.getString("category");
            switch(category){
                case "Dairy":
                    Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extras = new Bundle();
                    extras.putString("type", "dairy");
                    extras.putString("color", "#4287f5");
                    extras.putString("title", "Dairy List");
                    extras.putString("added", "true");
                    extras.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extras.putString("dateAdded", "EXP: 12/20/20");
                    extras.putStringArrayList("items", (ArrayList<String>) itemsOne);
                    extras.putStringArrayList("dates", (ArrayList<String>) datesOne);
                    intent.putExtras(extras);
                    startActivity(intent);
                    Toast.makeText(getContext(), "Dairy Activity", Toast.LENGTH_SHORT).show();
                    break;
                case "Veggie":
                    Intent intentTwo = new Intent(getActivity(), RefrigeratorActivity.class);
                    Bundle extrasTwo = new Bundle();
                    extrasTwo.putString("type", "veggie");
                    extrasTwo.putString("color", "#78de95");
                    extrasTwo.putString("title", "Veggie List");
                    extrasTwo.putString("added", "true");
                    extrasTwo.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasTwo.putString("dateAdded", "EXP: 12/20/20");
                    extrasTwo.putStringArrayList("items", (ArrayList<String>) itemsTwo);
                    extrasTwo.putStringArrayList("dates", (ArrayList<String>) datesTwo);
                    intentTwo.putExtras(extrasTwo);
                    startActivity(intentTwo);
                    Toast.makeText(getContext(), "Veggie Activity", Toast.LENGTH_SHORT).show();
                    break;
                case "Fruit":
                    Intent intentThree = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extrasThree = new Bundle();
                    extrasThree.putString("color", "#f384f5");
                    extrasThree.putString("title", "Fruit List");
                    extrasThree.putString("type", "fruit");
                    extrasThree.putString("added", "true");
                    extrasThree.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasThree.putString("dateAdded", "EXP: 12/20/20");
                    extrasThree.putStringArrayList("items", (ArrayList<String>) itemsThree);
                    extrasThree.putStringArrayList("dates", (ArrayList<String>) datesThree);
                    intentThree.putExtras(extrasThree);
                    startActivity(intentThree);
                    Toast.makeText(getContext(), "Veggie Activity", Toast.LENGTH_SHORT).show();
                    break;
                case "Juice":
                    Intent intentFour = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extrasFour = new Bundle();
                    extrasFour.putString("color", "#f7ab40");
                    extrasFour.putString("type", "juice");
                    extrasFour.putString("title", "Juice List");
                    extrasFour.putString("added", "true");
                    extrasFour.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasFour.putString("dateAdded", "EXP: 12/20/20");
                    extrasFour.putStringArrayList("items", (ArrayList<String>) itemsFour);
                    extrasFour.putStringArrayList("dates", (ArrayList<String>) datesFour);
                    intentFour.putExtras(extrasFour);
                    startActivity(intentFour);
                    Toast.makeText(getContext(), "Veggie Activity", Toast.LENGTH_SHORT).show();
                    break;
                case "Meat":
                    Intent intentFive = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extrasFive = new Bundle();
                    extrasFive.putString("color", "#fa6964");
                    extrasFive.putString("title", "Meat List");
                    extrasFive.putString("type", "meat");
                    extrasFive.putString("added", "true");
                    extrasFive.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasFive.putString("dateAdded", "EXP: 12/20/20");
                    extrasFive.putStringArrayList("items", (ArrayList<String>) itemsFive);
                    extrasFive.putStringArrayList("dates", (ArrayList<String>) datesFive);
                    intentFive.putExtras(extrasFive);
                    startActivity(intentFive);
                    Toast.makeText(getContext(), "Veggie Activity", Toast.LENGTH_SHORT).show();
                    break;
                case "Other":
                default:
                    Intent intentSix = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extrasSix = new Bundle();
                    extrasSix.putString("color", "#b696fa");
                    extrasSix.putString("title", "Other List");
                    extrasSix.putString("type", "other");
                    extrasSix.putString("added", "true");
                    extrasSix.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasSix.putString("dateAdded", "EXP: 12/20/20");
                    extrasSix.putStringArrayList("items", (ArrayList<String>) itemsSix);
                    extrasSix.putStringArrayList("dates", (ArrayList<String>) datesSix);
                    intentSix.putExtras(extrasSix);
                    startActivity(intentSix);
                    Toast.makeText(getContext(), "Veggie Activity", Toast.LENGTH_SHORT).show();
            }
        }

        //Each card has a click listener to open activity and pass bundle of information
        cardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opens Refrigerator Activity
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                //Send data of this activity through bundle
                Bundle extras = new Bundle();
                extras.putString("type", "dairy");
                extras.putString("color", "#4287f5");
                extras.putString("title", "Dairy List");
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsOne);
                extras.putStringArrayList("dates", (ArrayList<String>) datesOne);
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
                extras.putString("type", "veggie");
                extras.putString("title", "Veggie List");
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsTwo);
                extras.putStringArrayList("dates", (ArrayList<String>) datesTwo);
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
                extras.putString("type", "fruit");
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsThree);
                extras.putStringArrayList("dates", (ArrayList<String>) datesThree);
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
                extras.putString("type", "juice");
                extras.putString("title", "Juice List");
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsFour);
                extras.putStringArrayList("dates", (ArrayList<String>) datesFour);
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
                extras.putString("type", "meat");
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsFive);
                extras.putStringArrayList("dates", (ArrayList<String>) datesFive);
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
                extras.putString("type", "other");
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsSix);
                extras.putStringArrayList("dates", (ArrayList<String>) datesSix);
                intent.putExtras(extras);
                startActivity(intent);
                Toast.makeText(getContext(), "Other Activity", Toast.LENGTH_SHORT).show();
            }
        });
    }
}