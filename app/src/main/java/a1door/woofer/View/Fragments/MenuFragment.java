package a1door.woofer.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import a1door.woofer.Logic.Interfaces.onMenuButtonClickListener;
import a1door.woofer.R;

public class MenuFragment extends android.support.v4.app.Fragment implements onMenuButtonClickListener {
    private MenuBtnsClickListener menuBtnsClickListener;
    Button cameraBtn,mealsBtns,feedBtn,analyticsBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_layout, container, false);

        cameraBtn = (Button) view.findViewById(R.id.menuCameraButton);
        mealsBtns = (Button) view.findViewById(R.id.menuMealSchedulingButton);
        feedBtn = (Button) view.findViewById(R.id.menuFeedMyDogButton);
        analyticsBtn = (Button) view.findViewById(R.id.menuDogAnalyticsButton);

        cameraBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (menuBtnsClickListener != null)
                    menuBtnsClickListener.onMenuBtnsClick(1);
            }
        });

        mealsBtns.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (menuBtnsClickListener != null)
                    menuBtnsClickListener.onMenuBtnsClick(2);
            }
        });


        analyticsBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (menuBtnsClickListener != null)
                    menuBtnsClickListener.onMenuBtnsClick(3);
            }
        });

        feedBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(view.getContext(), "Food has been given", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    @Override
    public void registerMenuBtnsClickShowListeners(MenuBtnsClickListener listener) {
        menuBtnsClickListener = listener;
    }

    @Override
    public void deletesMenuBtnsClickShowListeners(MenuBtnsClickListener listener) {
        menuBtnsClickListener = null;
    }



}
