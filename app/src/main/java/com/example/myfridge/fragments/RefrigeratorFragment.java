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

    //String type;

    List<String> itemsOne;
    List<String> datesOne;
    List<String> itemsTwo;
    List<String> datesTwo;
    List<String> itemsThree;
    List<String> datesThree;
    List<String> itemsFour;
    List<String> datesFour;
    List<String> itemsFive;
    List<String> datesFive;
    List<String> itemsSix;
    List<String> datesSix;

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
                extras.putStringArrayList("items", (ArrayList<String>) itemsSix);
                extras.putStringArrayList("dates", (ArrayList<String>) datesSix);
                intent.putExtras(extras);
                startActivity(intent);
                Toast.makeText(getContext(), "Other Activity", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //TODO: Will be used to save items added through the ComposeFragment that I will create based on passed bundle
//    private File getDataFileForItem(String type){
//        if(type.equals("dairy")){
//            return new File(getActivity().getCacheDir(), "dairyItems.txt");
//        }
//        else if(type.equals("veggie")){
//            return new File(getActivity().getCacheDir(), "veggieItems.txt");
//        }
//        else if(type.equals("fruit")){
//            return new File(getActivity().getCacheDir(), "fruitItems.txt");
//        }
//        else if(type.equals("juice")){
//            return new File(getActivity().getCacheDir(), "juiceItems.txt");
//        }
//        else if(type.equals("meat")){
//            return new File(getActivity().getCacheDir(), "meatItems.txt");
//        }
//        else{
//            return new File(getActivity().getCacheDir(), "otherItems.txt");
//        }
//    }
//    private File getDataFileForDate(String type){
//        if(type.equals("dairy")){
//            return new File(getActivity().getCacheDir(), "dairyDate.txt");
//        }
//        else if(type.equals("veggie")){
//            return new File(getActivity().getCacheDir(), "veggieDate.txt");
//        }
//        else if(type.equals("fruit")){
//            return new File(getActivity().getCacheDir(), "fruitDate.txt");
//        }
//        else if(type.equals("juice")){
//            return new File(getActivity().getCacheDir(), "juiceDate.txt");
//        }
//        else if(type.equals("meat")){
//            return new File(getActivity().getCacheDir(), "meatDate.txt");
//        }
//        else{
//            return new File(getActivity().getCacheDir(), "otherDate.txt");
//        }
//    }
//
//    //function saves items by saving items on data file
//    private void saveItems(String type){
//        try {
//            if(type.equals("dairy")){
//                FileUtils.writeLines(getDataFileForItem(type), itemsOne);
//                FileUtils.writeLines(getDataFileForDate(type), datesOne);
//            }
//        } catch (IOException e) {
//            Log.e(TAG, "Error writing items", e);
//        }
//    }
}