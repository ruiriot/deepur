package com.ruiriot.deepur.adapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.storage.FirebaseStorage;
import com.ruiriot.deepur.R;
import com.ruiriot.deepur.fragment.CategoriesFragment.OnListFragmentInteractionListener;
import com.ruiriot.deepur.model.Category;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CategoriesAdapter extends BaseAdapter {

    final List<Category> mValues;
    final OnListFragmentInteractionListener mListener;
    Context context;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    public CategoriesAdapter(List<Category> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_categories_item, parent, false);
        context = view.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int position) {
        final ViewHolder holder = (ViewHolder) h;
        holder.mItem = mValues.get(position);
        holder.categoryName.setText(holder.mItem.description);

        Uri uriCategoryImage = Uri.parse(mValues.get(position).image);
        InputStream image_stream = null;
        try {
            image_stream = context.getContentResolver().openInputStream(uriCategoryImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(image_stream);
        holder.categoryImage.setImageBitmap(bitmap);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView categoryName;
        final ImageView categoryImage;
        Category mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            categoryName = view.findViewById(R.id.fragment_categories_name);
            categoryImage = view.findViewById(R.id.fragment_categories_image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + categoryName.getText() + "'";
        }
    }
}
