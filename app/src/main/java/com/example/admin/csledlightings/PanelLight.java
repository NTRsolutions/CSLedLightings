package com.example.admin.csledlightings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PanelLight.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PanelLight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PanelLight extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView listView;

    private OnFragmentInteractionListener mListener;

    public PanelLight() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PanelLight.
     */
    // TODO: Rename and change types and number of parameters
    public static PanelLight newInstance(String param1, String param2) {
        PanelLight fragment = new PanelLight();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_panel_light, container, false);

        final ArrayList<Integer> image;
        final ArrayList<String> title,desc,price;

        listView=(ListView)view.findViewById(R.id.listviewpanel);

        image=new ArrayList<>();
        price=new ArrayList<>();
        desc=new ArrayList<>();
        title=new ArrayList<>();

        image.add(R.drawable.panellightround);
        image.add(R.drawable.ledpanel);
        image.add(R.drawable.ledpanel3);

        title.add("LED Round Panel Light ");
        title.add("LED Square Panel Light");
        title.add("LED Slim Panel Light");

        price.add("₹180");
        price.add("₹160");
        price.add("₹160");

        desc.add("CS-CP 24,36,45Watt");
        desc.add("CS-CP 24,36,45Watt");
        desc.add("CS-CP 24,36,45Watt");

        listView.setAdapter(new ListCustomAdapter(getContext(),image,title,price,desc));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), Main4Activity.class);
                intent.putExtra("image",image.get(i));
                intent.putExtra("text",title.get(i));
                intent.putExtra("price",price.get(i));
                intent.putExtra("desc","Brand                 CS LED Lightings\n" +
                        "Lighting Color       Cool White\n" +
                        "Body Material        Ceramic\n" +
                        "Operating Life       50000 Hours\n" +
                        "Body Colour          White");
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
