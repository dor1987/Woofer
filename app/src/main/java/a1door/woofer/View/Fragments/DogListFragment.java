package a1door.woofer.View.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import a1door.woofer.R;


public class DogListFragment extends Fragment implements View.OnClickListener {
    private Button Luka;
    private Button Nala;

    public DogListFragment() {
        // Required empty public constructor
    }


    public static DogListFragment newInstance(String param1, String param2) {
        DogListFragment fragment = new DogListFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dog_list, container, false);
        Luka = view.findViewById(R.id.Luka);
        Nala = view.findViewById(R.id.Nala);

        Luka.setOnClickListener(this);
        Nala.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String name;

        if(v.getId() == R.id.Luka){
        name = "Luka";
        }else{
         name = "Nala";
        }

        DogAnalyticsFragments analyticsFragments = new DogAnalyticsFragments();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("NAME",name);
        analyticsFragments.setArguments(bundle);

        transaction.addToBackStack("DogList");
        transaction.replace(R.id.frame, analyticsFragments);

        transaction.commit();
    }

    }
