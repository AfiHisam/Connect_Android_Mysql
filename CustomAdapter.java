package com.example.afihisam.connecttomysqljsp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by AfiHisam on 6/24/2018.
 */
class Data {
    private String name;
    private String age;
    private String image;


    public Data(String name,String age, String image) {
        this.name= name;
        this.age = age;
        this.image = image;

    }

    public String getName() { return name; }
    public String getAge() { return age; }
    public String getImage() {return image;}


}
public class CustomAdapter extends ArrayAdapter<Data> { Context context;


    public class ViewHolder {
        TextView name; //sebenarnya ni dah declare nama apa pun boleh
        TextView age;
        ImageView image;
    }

    public CustomAdapter(Context context, List<Data> objects) {
        super(context, R.layout.display_margin, objects);
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        ViewHolder viewHolder;

        if(convertView == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.display_margin, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.name = (TextView) row.findViewById(R.id.bTitle);
            viewHolder.age = (TextView) row.findViewById(R.id.bAuthor);
            viewHolder.image = (ImageView) row.findViewById(R.id.picture);


            row.setTag(viewHolder);
        } else {
            row = convertView;
            viewHolder = (ViewHolder) row.getTag();
        }

        Data item = getItem(position);

        viewHolder.name.setText(item.getName());
        viewHolder.age.setText(item.getAge());

        Picasso.with(context).load(item.getImage()).into(viewHolder.image);


        return row;

    }



}

