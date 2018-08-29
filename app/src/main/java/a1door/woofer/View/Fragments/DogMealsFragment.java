package a1door.woofer.View.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

import a1door.woofer.Adapter.MealsAdapter;
import a1door.woofer.Logic.Classes.Meal;
import a1door.woofer.R;

public class DogMealsFragment extends android.support.v4.app.Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener, View.OnFocusChangeListener, TimePickerDialog.OnTimeSetListener {

    private ArrayList<Meal> mealsList;
    private ListView listView;
    private FloatingActionButton fAction;
    private Dialog dialog;
    private MealsAdapter mealsAdapter;
    Button submitBtn;
    Button cancelBtn;
    EditText timeEditText;
    EditText dateEditText;
    EditText amountEditText;
    DatePickerDialog.OnDateSetListener datePick;
    private String date = null;
    private String time = null;
    private double amount = 0;
    private Calendar myCalendar =Calendar.getInstance();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.meals_fragment_layout, container, false);
        listView = view.findViewById(R.id.meals_list);
        fAction = view.findViewById(R.id.add_action_bar);
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle(R.string.new_meal);
        submitBtn = dialog.findViewById(R.id.submit_btn);
        cancelBtn = dialog.findViewById(R.id.cancel_btn);
        timeEditText = dialog.findViewById(R.id.time_input);
        dateEditText = dialog.findViewById(R.id.date_input);
        amountEditText = dialog.findViewById(R.id.amount_input);
        fAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();

            }
        });
        submitBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        timeEditText.setOnFocusChangeListener(this);
        amountEditText.setOnClickListener(this);
        dateEditText.setOnFocusChangeListener(this);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createMealsList();

        mealsAdapter = new MealsAdapter(mealsList,getContext());
        listView.setAdapter(mealsAdapter);



    }

    private void createMealsList(){
        mealsList = new ArrayList<>();

        for(int i=0 ; i<20 ; i++){
            double rAmount = 10 + Math.random() * (300 - 10);
            int rDay = (int) (1 + Math.random() * (30 - 1));
            int rMonth = (int) (1 + Math.random() * (12 - 1));
            int rHour = (int) (0 + Math.random() * (23 - 0));
            int rMinute = (int) (0 + Math.random() * (59 - 0));

            mealsList.add(new Meal(rAmount, rDay + "/" + rMonth + "/" + "2018 " + rHour +":"+ rMinute));

        }

    }



    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.submit_btn:
                if(!amountEditText.getText().toString().equals("")){
                amount = Double.valueOf(amountEditText.getText().toString());
                if (date != null && time != null && amount > 0) {
                    mealsList.add(new Meal(amount, date + " " + time));
                    date = null;
                    time = null;
                    amount = 0;

                    mealsAdapter.notifyDataSetChanged();
                    dialog.cancel();
                }
                }
                break;
            case R.id.cancel_btn:
                dialog.cancel();
                break;

                    }
                }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String myFormat = "MMM dd, yyyy"; //In which you need put here
        SimpleDateFormat sdFormat = new SimpleDateFormat(myFormat, Locale.US);
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, month);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        dateEditText.setText(sdFormat.format(myCalendar.getTime()));
        date = dayOfMonth + "/" + month + "/" + year;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        switch (v.getId()) {
            case R.id.date_input:
                if(hasFocus) {
                    new DatePickerDialog(getContext(), this, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            break;
            case R.id.time_input:
                if(hasFocus){
                    int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
                    int minute = myCalendar.get(Calendar.MINUTE);
                    new TimePickerDialog(getContext(), this, hour, minute, true).show();
                }
                break;
        }

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        time = hourOfDay+ ":" + minute;
        timeEditText.setText(time);

    }
}

