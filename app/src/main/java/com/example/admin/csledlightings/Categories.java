package com.example.admin.csledlightings;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Categories.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Categories#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Categories extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GridView gridView;
    ViewPager viewPager;
    ArrayList<Integer> image;
    ArrayList<String> title;
    ArrayList<String> price;

    private OnFragmentInteractionListener mListener;

    public Categories() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Categories.
     */
    // TODO: Rename and change types and number of parameters
    public static Categories newInstance(String param1, String param2) {
        Categories fragment = new Categories();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        image=new ArrayList<Integer>();
        title=new ArrayList<String>();
        price=new ArrayList<String>();

        image.add(R.drawable.ledbulb);
        title.add("LED Bulbs");
        price.add("₹55");

        image.add(R.drawable.ledtube);
        price.add("₹220");
        title.add("Led Tubelight");

        image.add(R.drawable.ledpanel);
        title.add("LED Ceiling Panel Lights");
        price.add("₹180");

        image.add(R.drawable.downlight);
        title.add("Down Lights");
        price.add("₹150");

        image.add(R.drawable.coblight);
        title.add("LED Cob Lights");
        price.add("₹195");

        image.add(R.drawable.surfacelight);
        title.add("LED Surface Lights");
        price.add("₹180");

        image.add(R.drawable.concealed);
        title.add("LED Concealed Lights");
        price.add("₹120");

        image.add(R.drawable.traillight);
        title.add("LED Trail Lights");
        price.add("₹900");

        image.add(R.drawable.floodlight);
        title.add("Flood Lights");
        price.add("₹900");

        image.add(R.drawable.ledstreetlight);
        title.add("LED Street & Solar Lights");
        price.add("₹900");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_categories, container, false);
        gridView=(GridView)view.findViewById(R.id.gridview);

        gridView.setAdapter(new CustomAdpter(getContext(),image,title,price));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viewPager=(ViewPager)getActivity().findViewById(R.id.viewpager);
                viewPager.setCurrentItem(i+1);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
