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
    public static final String CATEGORY_ONE = "Dairy";
    public static final String CATEGORY_TWO = "Veggie";
    public static final String CATEGORY_THREE = "Fruit";
    public static final String CATEGORY_FOUR = "Drink";
    public static final String CATEGORY_FIVE = "Meat";
    public static final String CATEGORY_SIX = "Other";


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
            String item = args.getString(ComposeFragment.ITEM);
            String date = "EXP: " + args.getString(ComposeFragment.DATE);
            String category = args.getString(ComposeFragment.CATEGORY);
            switch(category){
                case CATEGORY_ONE:
                    Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extras = new Bundle();
                    extras.putString("type", CATEGORY_ONE);
                    extras.putString("color", "#6990fa");
                    extras.putString("title", CATEGORY_ONE + " List");
                    extras.putString("added", "true");
                    extras.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extras.putString("dateAdded", date);
                    extras.putStringArrayList("items", (ArrayList<String>) itemsOne);
                    extras.putStringArrayList("dates", (ArrayList<String>) datesOne);
                    intent.putExtras(extras);
                    startActivity(intent);
                    break;
                case CATEGORY_TWO:
                    Intent intentTwo = new Intent(getActivity(), RefrigeratorActivity.class);
                    Bundle extrasTwo = new Bundle();
                    extrasTwo.putString("type", CATEGORY_TWO);
                    extrasTwo.putString("color", "#55cf87");
                    extrasTwo.putString("title", CATEGORY_TWO + " List");
                    extrasTwo.putString("added", "true");
                    extrasTwo.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasTwo.putString("dateAdded", date);
                    extrasTwo.putStringArrayList("items", (ArrayList<String>) itemsTwo);
                    extrasTwo.putStringArrayList("dates", (ArrayList<String>) datesTwo);
                    intentTwo.putExtras(extrasTwo);
                    startActivity(intentTwo);
                    break;
                case CATEGORY_THREE:
                    Intent intentThree = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extrasThree = new Bundle();
                    extrasThree.putString("color", "#ed5cd0");
                    extrasThree.putString("title", CATEGORY_THREE + " List");
                    extrasThree.putString("type", CATEGORY_THREE);
                    extrasThree.putString("added", "true");
                    extrasThree.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasThree.putString("dateAdded", date);
                    extrasThree.putStringArrayList("items", (ArrayList<String>) itemsThree);
                    extrasThree.putStringArrayList("dates", (ArrayList<String>) datesThree);
                    intentThree.putExtras(extrasThree);
                    startActivity(intentThree);
                    break;
                case CATEGORY_FOUR:
                    Intent intentFour = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extrasFour = new Bundle();
                    extrasFour.putString("color", "#56d1c1");
                    extrasFour.putString("type", CATEGORY_FOUR);
                    extrasFour.putString("title", CATEGORY_FOUR + "s List");
                    extrasFour.putString("added", "true");
                    extrasFour.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasFour.putString("dateAdded", date);
                    extrasFour.putStringArrayList("items", (ArrayList<String>) itemsFour);
                    extrasFour.putStringArrayList("dates", (ArrayList<String>) datesFour);
                    intentFour.putExtras(extrasFour);
                    startActivity(intentFour);
                    break;
                case CATEGORY_FIVE:
                    Intent intentFive = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extrasFive = new Bundle();
                    extrasFive.putString("color", "#ed5c70");
                    extrasFive.putString("title", CATEGORY_FIVE + " List");
                    extrasFive.putString("type", CATEGORY_FIVE);
                    extrasFive.putString("added", "true");
                    extrasFive.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasFive.putString("dateAdded", date);
                    extrasFive.putStringArrayList("items", (ArrayList<String>) itemsFive);
                    extrasFive.putStringArrayList("dates", (ArrayList<String>) datesFive);
                    intentFive.putExtras(extrasFive);
                    startActivity(intentFive);
                    break;
                case CATEGORY_SIX:
                default:
                    Intent intentSix = new Intent(getActivity(), RefrigeratorActivity.class);
                    //Send data of this activity through bundle
                    Bundle extrasSix = new Bundle();
                    extrasSix.putString("color", "#b681fc");
                    extrasSix.putString("title", CATEGORY_SIX + " List");
                    extrasSix.putString("type", CATEGORY_SIX);
                    extrasSix.putString("added", "true");
                    extrasSix.putString("itemAdded", item);
                    //For now, it will have this value as Expiration date until I can implement
                    //user's input
                    extrasSix.putString("dateAdded", date);
                    extrasSix.putStringArrayList("items", (ArrayList<String>) itemsSix);
                    extrasSix.putStringArrayList("dates", (ArrayList<String>) datesSix);
                    intentSix.putExtras(extrasSix);
                    startActivity(intentSix);
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
                extras.putString("type", CATEGORY_ONE);
                extras.putString("color", "#6990fa");
                extras.putString("title", CATEGORY_ONE + " List");
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsOne);
                extras.putStringArrayList("dates", (ArrayList<String>) datesOne);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        cardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#55cf87");
                extras.putString("type", CATEGORY_TWO);
                extras.putString("title", CATEGORY_TWO + " List");
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsTwo);
                extras.putStringArrayList("dates", (ArrayList<String>) datesTwo);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        cardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#ed5cd0");
                extras.putString("title", CATEGORY_THREE + " List");
                extras.putString("type", CATEGORY_THREE);
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsThree);
                extras.putStringArrayList("dates", (ArrayList<String>) datesThree);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        cardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#56d1c1");
                extras.putString("type", CATEGORY_FOUR);
                extras.putString("title", CATEGORY_FOUR + "s List");
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsFour);
                extras.putStringArrayList("dates", (ArrayList<String>) datesFour);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        cardFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#ed5c70");
                extras.putString("title", CATEGORY_FIVE + " List");
                extras.putString("type", CATEGORY_FIVE);
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsFive);
                extras.putStringArrayList("dates", (ArrayList<String>) datesFive);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        cardSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RefrigeratorActivity.class);
                Bundle extras = new Bundle();
                extras.putString("color", "#b681fc");
                extras.putString("title", CATEGORY_SIX + " List");
                extras.putString("type", CATEGORY_SIX);
                extras.putString("added", "false");
                extras.putString("itemAdded", "null");
                extras.putString("dateAdded", "null");
                extras.putStringArrayList("items", (ArrayList<String>) itemsSix);
                extras.putStringArrayList("dates", (ArrayList<String>) datesSix);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}