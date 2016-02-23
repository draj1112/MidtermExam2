package com.example.jonesdanica.midtermexam2;

import android.app.ListActivity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.jonesdanica.midtermexam2.adapters.BookAdapter;
import com.example.jonesdanica.midtermexam2.api.BookAPI;
import com.example.jonesdanica.midtermexam2.entities.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        new FetchBookTask().execute();
    }

    public class FetchBookTask extends AsyncTask<String, Void, ArrayList<Book>> {


        private static final String TAG_NAME = "BookName";

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected  ArrayList<Book> doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            String city = params[0];

            Uri builtUri = Uri.parse(BookAPI.BASE_URL).buildUpon()
                    .appendEncodedPath("api")
                    .appendEncodedPath("books")
                    .build();

            return BookAPI.getBook(builtUri, "GET");
        }

        @Override
        protected void onPostExecute( ArrayList<Book> booklist) {

            BookAdapter adapter = new BookAdapter(
                    MainActivity.this,
                    R.layout.list_item, booklist);

            listView.setAdapter(adapter);


        }
    }
}


