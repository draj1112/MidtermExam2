package com.example.jonesdanica.midtermexam2.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jonesdanica.midtermexam2.R;
import com.example.jonesdanica.midtermexam2.entities.Book;

import java.util.List;

/**
 * Created by danica12 on 2/23/2016.
 */
public class BookAdapter  extends ArrayAdapter<Book> {

        private Context mContext;
        private int         mLayoutId;
        private List<Book> mBooklist;

        public BookAdapter(Context context, int resource, List<Book> booklist) {
            super(context, resource, booklist);

            mContext = context;
            mLayoutId = resource;
            mBooklist = booklist;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                // Inflate the layout
                convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

                // create the view holder
                viewHolder = new ViewHolder();
                viewHolder.tvBookTitle = (TextView) convertView.findViewById(R.id.bookname);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            // Set the book data
            Book book = mBooklist.get(position);

            if (book != null) {
                if (viewHolder.tvBookTitle != null) {
                    if (book.isRead()) {
                        viewHolder.tvBookTitle.setText(book.getTitle());
                        viewHolder.tvBookTitle.setTextColor(Color.parseColor("#B0171F"));
                    }
                    else {
                        viewHolder.tvBookTitle.setText(book.getTitle());
                        viewHolder.tvBookTitle.setTextColor(Color.parseColor("#43bd00"));
                    }
                }
            }

            return convertView;
        }

        private static class ViewHolder {
            public TextView  tvBookTitle;
        }
}
