package a1door.woofer.View.Activites;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import a1door.woofer.Logic.Interfaces.onMenuButtonClickListener;
import a1door.woofer.R;
import a1door.woofer.View.Fragments.CameraFragment;
import a1door.woofer.View.Fragments.DogAnalyticsFragments;
import a1door.woofer.View.Fragments.DogMealsFragment;
import a1door.woofer.View.Fragments.MenuFragment;
import a1door.woofer.View.Fragments.SettingFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,onMenuButtonClickListener.MenuBtnsClickListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private String[] toolbarTitles;
    private int CurrentFragment;
    private ActionBarDrawerToggle toggle;

    //Fragments
    private Fragment fragment;
    private MenuFragment menuFragment;
    private CameraFragment cameraFragment;
    private DogMealsFragment dogMealsFragment;
    private DogAnalyticsFragments dogAnalyticsFragments;
    private SettingFragment settingFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navView);

        Intent  intent =  getIntent();
        ((TextView) navigationView.getHeaderView(0).findViewById(R.id.userName)).setText(intent.getExtras().getString("username"));


        navigationView.setNavigationItemSelectedListener(this);

        toolbarTitles = getResources().getStringArray(R.array.nav_titles);


        //Fragments
        menuFragment = new MenuFragment();
        cameraFragment= new CameraFragment();
        dogMealsFragment = new DogMealsFragment();
        dogAnalyticsFragments = new DogAnalyticsFragments();
        settingFragment = new SettingFragment();


        menuFragment.registerMenuBtnsClickShowListeners(this);


        CurrentFragment = 0;

        SetCurrentFragment();

    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    private void SetCurrentFragment()
    {
        SetItemFocus();
        SetToolBarTitle();
        FragmentTransaction fragmentTransaction;

        switch (CurrentFragment)
        {
            case 0:
                fragment = menuFragment;
                break;

            case 1:
                fragment = cameraFragment;
                break;

            case 2:
                fragment =  dogMealsFragment;
                break;

            case 3:
                fragment = dogAnalyticsFragments ;
                break;

            case 4:
                fragment = settingFragment ;
                break;
                /*
            case 5:
                fragment = ;
                break;
            case 6:
                fragment = ;
                break;
*/
            default:
                fragment = menuFragment;

        }

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
        closeKeyBoard();
    }

    private void SetToolBarTitle()
    {
        ((TextView) findViewById(R.id.toolbarTitleText)).setText(this.toolbarTitles[CurrentFragment]);
    }

    private void SetItemFocus()
    {/*
        if (navigationView.getMenu().getItem(CurrentFragment).isChecked() == false)
        {
            navigationView.getMenu().getItem(CurrentFragment).setChecked(true);
        }
*/
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.mainMenu){
            CurrentFragment = 0 ;
            SetCurrentFragment();
        }

        else if(id == R.id.navSettings){
            CurrentFragment = 4 ;
            SetCurrentFragment();
        }
        else if(id == R.id.navExit){
            this.finishAffinity();
        }


        drawer.closeDrawer(GravityCompat.START);

        return true;


    }

    private void closeKeyBoard(){
        View view  = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    @Override
    public void onMenuBtnsClick(int whereToGo) {
        CurrentFragment = whereToGo;
        SetCurrentFragment();
    }
}
