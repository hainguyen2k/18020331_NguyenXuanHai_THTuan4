package com.example.tiki_layout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_above#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_above extends Fragment {
    private int quantity = 0;
    SendingData sendingData;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";



    // TODO: Rename and change types of parameters

    private String mParam1;


    public fragment_above() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sendingData = (SendingData) context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.

     * @return A new instance of fragment fragment_above.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_above newInstance(String param1) {
        fragment_above fragment = new fragment_above();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_above, container, false);
        final ImageButton imagebtnAdd = view.findViewById(R.id.imgbtn_add);
        ImageButton imagebtnMinus = view.findViewById(R.id.imgbtn_minus);
        final TextView tvQuantityAbove = view.findViewById(R.id.tv_quantity);
        quantity = Integer.parseInt(tvQuantityAbove.getText().toString());
        imagebtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quantity ++;
                tvQuantityAbove.setText(String.valueOf(quantity));
                sendingData.SendData(String.valueOf(quantity*141.800));
            }
        });
        imagebtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity<=0) {
                   tvQuantityAbove.setText("0");
                } else {
                    quantity--;
                    tvQuantityAbove.setText(String.valueOf(quantity));
                    sendingData.SendData(String.valueOf(quantity * 141.800));
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}