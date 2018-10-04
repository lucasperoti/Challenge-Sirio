package com.example.grupocommit.healthcontrol;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    //Constructor
    public SliderAdapter(Context context){
        this.context = context;
    }

    //Arrays
    public int[] slide_images = {
            R.drawable.eat_icon,
            R.drawable.user_pc,
            R.drawable.sleepy_owl
    };

    public String[] slide_headings = {
            "BEM-VINDO",
            "CODE",
            "DORMIR"
    };

    public String [] slide_descs = {
            "Lorem ipsum in donec nulla vel urna ornare integer, ac quis donec pretium taciti sem eleifend integer hac, cubilia rutrum lacus scelerisque ut curabitur volutpat. litora donec justo",
            "Lorem ipsum in donec nulla vel urna ornare integer, ac quis donec pretium taciti sem eleifend integer hac, cubilia rutrum lacus scelerisque ut curabitur volutpat. litora donec justo ",
            "Lorem ipsum in donec nulla vel urna ornare integer, ac quis donec pretium taciti sem eleifend integer hac, cubilia rutrum lacus scelerisque ut curabitur volutpat. litora donec justo"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideTextView = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideTextDesc = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideTextView.setText(slide_headings[position]);
        slideTextDesc.setText(slide_descs[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout)object);
    }
}
