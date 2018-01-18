package com.example.admin.csledlightings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lights.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lights#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lights extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView listView;
    ViewPager viewPager;

    private OnFragmentInteractionListener mListener;

    public Lights() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lights.
     */
    // TODO: Rename and change types and number of parameters
    public static Lights newInstance(String param1, String param2) {
        Lights fragment = new Lights();
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
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_lights, container, false);

        listView=(ListView)view.findViewById(R.id.listviewbulb);

        final ArrayList<Integer> image;
        final ArrayList<String> title,desc,price;

        image=new ArrayList<>();
        price=new ArrayList<>();
        desc=new ArrayList<>();
        title=new ArrayList<>();

        image.add(R.drawable.ledbulb);
        image.add(R.drawable.ledcolour);

        title.add("LED Bulbs");
        title.add("Electric LED Bulbs");

        price.add("₹55");
        price.add("₹55");

        desc.add("CS-BU 0.5,5,7,9,12,15Watt");
        desc.add("CS-BU 0.5,5,7,9,12,15Watt");

        listView.setAdapter(new ListCustomAdapter(getContext(),image,title,price,desc));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), Main4Activity.class);
                intent.putExtra("image",image.get(i));
                intent.putExtra("text",title.get(i));
                intent.putExtra("price",price.get(i));
                intent.putExtra("desc","Brand                 CS LED Lightings\n" +
                        "Usage                Home and office\n" +
                        "Operating Life     50000 Hours\n" +
                        "Voltage            90-300V");
                intent.putExtra("totalimages","1");
                startActivity(intent);
            }
        });

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
