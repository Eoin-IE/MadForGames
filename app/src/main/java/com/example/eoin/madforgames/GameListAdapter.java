package com.example.eoin.madforgames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameListAdapter extends BaseAdapter {

    public Context context;

    public List<Game> games = new ArrayList<>();

    public GameListAdapter(Context context, List<Game> games) {
        this.context = context;
        this.games = games;
    }

    @Override
    public int getCount() {
        return games.size();
    }

    @Override
    public Object getItem(int position) {
        return games.get(position);
    }

    @Override
    public long getItemId(int position) {
        return games.get(0).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item,parent,false);
        TextView gameNameTextView = rowView.findViewById(R.id.gameName);
        RatingBar gameRatingTextView = rowView.findViewById(R.id.gameRating);
        ImageView iconView = rowView.findViewById(R.id.gameImage);
        gameNameTextView.setText(games.get(position).getName());
        gameRatingTextView.setRating(Float.parseFloat(games.get(position).getRating()));
        if(games.get(position).getIcon() != 0) {
            iconView.setImageResource(games.get(position).getIcon());
        }
        return rowView;
    }
}
