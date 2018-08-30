package com.example.eoin.madforgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView gamelist=findViewById(R.id.game_list);
        final List<Game> listofgames=new ArrayList<>();
        listofgames.add(new Game("Monster Hunter","10", R.drawable.mh));
        Game pubgMobile = new Game("PUBG Mobile","9",R.drawable.pubg);
        pubgMobile.setId(95340);
        listofgames.add(pubgMobile);
        listofgames.add(new Game("Minecraft Switch Edition","8", R.drawable.mc));
        listofgames.add(new Game("Team Fortress 2", "10", R.drawable.tf));
        listofgames.add(new Game("Fallout 76", "1", R.drawable.f));
        listofgames.add(new Game("Call of duty WWII", "7", R.drawable.cod));
        listofgames.add(new Game("Zelda breath of the wild", "6", R.drawable.zelda));
        listofgames.add(new Game("World of Warcraft", "8", R.drawable.warcraft));
        listofgames.add(new Game("Splatoon 2", "6", R.drawable.splatoon));
        listofgames.add(new Game("fortnite", "0", R.drawable.fortnite));
        listofgames.add(new Game("Asassins Creed", "2", R.drawable.acreed));
        GameListAdapter adapter = new GameListAdapter(this,listofgames);
        gamelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(MainActivity.this, GameDetailsActivity.class);
                detailIntent.putExtra("gameId", listofgames.get(position).getId());
                startActivity(detailIntent);
            }
        });
        gamelist.setAdapter(adapter);
    }
}
