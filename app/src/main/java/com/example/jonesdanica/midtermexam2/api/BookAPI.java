package com.example.jonesdanica.midtermexam2.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.jonesdanica.midtermexam2.entities.Book;
import com.example.jonesdanica.midtermexam2.utils.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by danica12 on 2/23/2016.
 */
public class BookAPI {
    public static final String BASE_URL     = "http://joseniandroid.herokuapp.com";
    //public static final String IMG_BASE_URL = "http://openweathermap.org/img/w/";

    public static final int SUCCESS_CODE = 200;

    private static final String TAG_TITLE        = "title";
    private static final String TAG_ISREAD   = "isRead";

    public static ArrayList<Book> getBook(Uri uri, @NonNull String requestMethod) {
        ArrayList<Book> booklist = new ArrayList<>();

        String json = HttpUtils.getResponse(uri, requestMethod);

        if (TextUtils.isEmpty(json)) {
            return null;
        }


        try {
            // 1) Convert the json string response into an actual JSON Object
            JSONArray jsonArr = new JSONArray(json);

            int arrSize = jsonArr.length();

            for (int i = 0; i < arrSize; i++) {
                JSONObject jsonObject = jsonArr.getJSONObject(i);
                String title = jsonObject.getString(TAG_TITLE);
                boolean isRead = jsonObject.getBoolean(TAG_ISREAD);
                booklist.add(new Book(title, isRead));
            }

                return booklist;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
