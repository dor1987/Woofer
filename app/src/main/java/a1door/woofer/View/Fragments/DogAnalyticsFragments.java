package a1door.woofer.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import a1door.woofer.Adapter.ImageAdapter;
import a1door.woofer.R;

public class DogAnalyticsFragments extends android.support.v4.app.Fragment {

    private String name;
    private TextView title;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.analytics_fragment_layout, container, false);
        title = view.findViewById(R.id.analytic_tile);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewPager viewPager = getActivity().findViewById(R.id.view_pager);

        ImageAdapter adapter = new ImageAdapter(getContext());

        viewPager.setAdapter(adapter);

       name = getArguments().getString("NAME");

        title.setText(name+"'s"+ " Analytics");


    }
}