package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad on 4/10/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList pWords,int ColorResourceId) {
        super(context,0, pWords);
        mColorResourceId=ColorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }
        Word local_word = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokTextView);
        miwokTextView.setText(local_word.getmMiwokTrans());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.englishTextView);
        defaultTextView.setText(local_word.getmDefaultTrans());

        ImageView imageView=(ImageView) listItemView.findViewById(R.id.image);
        if (local_word.has_image()){
            imageView.setImageResource(local_word.getmImageResourceId());
        }
        else {
            imageView.setVisibility(View.GONE);
        }
        View textContainer=listItemView.findViewById(R.id.text_Container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);



        return listItemView;
        //return super.getView(position, convertView, parent);
    }
}
