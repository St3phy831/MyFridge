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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RefrigeratorFragment extends Fragment {
    //These Public Strings are referenced outside of class
    public static final String CATEGORY_ONE = "Dairy";
    public static final String CATEGORY_TWO = "Veggie";
    public static final String CATEGORY_THREE = "Fruit";
    public static final String CATEGORY_FOUR = "Drink";
    public static final String CATEGORY_FIVE = "Meat";
    public static final String CATEGORY_SIX = "Other";

    public static final String TYPE = "type";
    public static final String COLOR = "color";
    public static final String TITLE = "title";
    public static final String ADDED = "added";
    public static final String ITEM_ADDED = "itemAdded";
    public static final String DATE_ADDED = "dateAdded";
    public static final String ITEMS = "items";
    public static final String DATES = "dates";

    public static final Boolean WAS_ADDED = true;


    CardView cardOne;
    CardView cardTwo;
    CardView cardThree;
    CardView cardFour;
    CardView cardFive;
    CardView cardSix;


    String dairyColor = "#6990fa";
    String veggieColor = "#55cf87";
    String fruitColor = "#ed5cd0";
    String drinkColor = "#56d1c1";
    String meatColor = "#ed5c70";
    String otherColor = "#b681fc";

    Boolean notAdded = false;
    String noItemOrDate = "null";

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
            String item = args.getString(ComposeFragment.ITEM);
            String date = "EXP: " + args.getString(ComposeFragment.DATE);
            String category = args.getString(ComposeFragment.CATEGORY);
            switch(category){
                case CATEGORY_ONE:
                    goToActivity(CATEGORY_ONE, dairyColor, WAS_ADDED, item, date, itemsOne, datesOne);
                    break;
                case CATEGORY_TWO:
                    goToActivity(CATEGORY_TWO, veggieColor, WAS_ADDED, item, date, itemsTwo, datesTwo);
                    break;
                case CATEGORY_THREE:
                    goToActivity(CATEGORY_THREE, fruitColor, WAS_ADDED, item, date, itemsThree, datesThree);
                    break;
                case CATEGORY_FOUR:
                    goToActivity(CATEGORY_FOUR, drinkColor, WAS_ADDED, item, date, itemsFour, datesFour);
                    break;
                case CATEGORY_FIVE:
                    goToActivity(CATEGORY_FIVE, meatColor, WAS_ADDED, item, date, itemsFive, datesFive);
                    break;
                case CATEGORY_SIX:
                default:
                    goToActivity(CATEGORY_SIX, otherColor, WAS_ADDED, item, date, itemsSix, datesSix);
            }
        }

        //Each card has a click listener to open activity and pass bundle of information
        cardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(CATEGORY_ONE, dairyColor, notAdded, noItemOrDate, noItemOrDate, itemsOne, datesOne);
            }
        });
        cardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(CATEGORY_TWO, veggieColor, notAdded, noItemOrDate, noItemOrDate, itemsTwo, datesTwo);
            }
        });
        cardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(CATEGORY_THREE, fruitColor, notAdded, noItemOrDate, noItemOrDate, itemsThree, datesThree);
            }
        });
        cardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(CATEGORY_FOUR, drinkColor, notAdded, noItemOrDate, noItemOrDate, itemsFour, datesFive);
            }
        });
        cardFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(CATEGORY_FIVE, meatColor, notAdded, noItemOrDate, noItemOrDate, itemsFive, datesFive);
            }
        });
        cardSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(CATEGORY_SIX, otherColor, notAdded, noItemOrDate, noItemOrDate, itemsSix, datesSix);
            }
        });
    }
    private void goToActivity(String category, String color, Boolean isAdded, String item, String date, List<String> items, List<String> dates){
        //Opens Refrigerator Activity
        Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
        //Send data of this activity through bundle
        Bundle extras = new Bundle();
        extras.putString(COLOR, color);
        extras.putString(TITLE, category + " List");
        extras.putString(TYPE, category);
        extras.putBoolean(ADDED, isAdded);
        extras.putString(ITEM_ADDED, item);
        extras.putString(DATE_ADDED, date);
        extras.putStringArrayList(ITEMS, (ArrayList<String>) items);
        extras.putStringArrayList(DATES, (ArrayList<String>) dates);
        intent.putExtras(extras);
        startActivity(intent);
    }
}