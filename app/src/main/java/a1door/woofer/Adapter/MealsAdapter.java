package a1door.woofer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import a1door.woofer.Logic.Classes.Meal;
import a1door.woofer.R;

public class MealsAdapter extends BaseAdapter {
    private ArrayList<Meal> mealsList;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;
    private ImageView deleteMeal;
    private Context context;

    private final  String DATE_FORMAT = "dd-MM-yyyy";

    public MealsAdapter(ArrayList<Meal> meals, Context context){
        this.mealsList = meals;
        this.context = context;

    }

    @Override
    public int getCount() {
        return mealsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mealsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.meal_item,
                    parent, false);
            viewHolder = new ViewHolder();
            viewHolder.amountTextView = convertView.findViewById(R.id.amount);
            viewHolder.dateTextView =  convertView.findViewById(R.id.time_to_feed);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.amountTextView.setText(String.format("%.2f", mealsList.get(position).getAmount()));
        viewHolder.dateTextView.setText(mealsList.get(position).getDate());

        deleteMeal = convertView.findViewById(R.id.delete_meal);
        deleteMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealsList.remove(position);
                notifyDataSetChanged();
            }
        });
        convertView.setTag(viewHolder);


        return convertView;
    }
    static class ViewHolder {
        private TextView amountTextView;
        private TextView dateTextView;
    }
}
