package com.example.ankit.assignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    ArrayList<Feeds> feeds = new ArrayList<>();
    Bitmap bitmap;
    FeedsAdapter itemsAdapter;
    RecyclerView recyclerView;
    Feeds fd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.macros);
        feeds.add(new Feeds("Ankit Kumar", "a day ago", "In general, the APIs in the v7 mediarouter library provide a means of controlling the routing of media channels and streams from the current device to external screens, speakers, and other destination devices. The library includes APIs for publishing app-specific media route providers, for discovering and selecting destination devices, for checking media status, and more.", 2, 3, R.drawable.circle, bitmap));
        feeds.add(new Feeds("Deepak", "24 hrs ago", "In general, the APIs in the v7 mediarouter library provide a means of controlling the routing of media channels and streams from the current device to external screens, speakers, and other destination devices. The library includes APIs for publishing app-specific media route providers, for discovering and selecting destination devices.", 1, 4, R.drawable.circle, bitmap));
        feeds.add(new Feeds("ABCD", "10 mins ago", "In general, the APIs in the v7 mediarouter library provide a means of controlling the routing of media channels and streams from the current device to external screens, speakers, and other destination devices. The library includes APIs for publishing app-specific media route providers.", 5, 10, R.drawable.circle, null));
        feeds.add(new Feeds("XYZW", "a min ago", "The library includes APIs for publishing app-specific media route providers, for discovering and selecting destination devices, for checking media status, and more.", 50, 7, R.drawable.circle, null));
        feeds.add(new Feeds("QWERTY", "50 secs ago", "This is a sample text for a feed.", 6, 11, R.drawable.circle, bitmap));
        System.out.println("asdf987kjhg");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView pay = findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Checkoutaction.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Newsfeed.class);
                startActivity(i);
            }
        });


        itemsAdapter = new FeedsAdapter(feeds);

        recyclerView = findViewById(R.id.rview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        ((LinearLayoutManager) mLayoutManager).setReverseLayout(true);
        ((LinearLayoutManager) mLayoutManager).setStackFromEnd(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemsAdapter);
        feeds.add(fd);
        recyclerView.getAdapter().notifyItemInserted(feeds.size());
        System.out.println("asdf" + recyclerView.getAdapter());
        recyclerView.smoothScrollToPosition(feeds.size());
        //getFeeds();
    }
    /*private void getFeeds() {
        final String BASE_URL = "https://apis.myinstapass.com/api/v1/news_feed/all";
        String token = "";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(interc).build();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();


                Request request = original.newBuilder()
                        .header("Authorization", token)
                        .build();

                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Geretro api = retrofit.create(Geretro.class);

        Call<List<Feeds>> call = api.getFeeds();

        call.enqueue(new Callback<List<Feeds>>() {
            @Override
            public void onResponse(Call<List<Feeds>> call, Response<List<Feeds>> response) {
                List<Feeds> FeedList = response.body();

                String[] fs = new String[FeedList.size()];

                for (int i = 0; i < FeedList.size(); i++) {
                    fs[i] = FeedList.get(i).getName();
                    System.out.println(fs[i]);
                }
            }

            @Override
            public void onFailure(Call<List<Feeds>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}


