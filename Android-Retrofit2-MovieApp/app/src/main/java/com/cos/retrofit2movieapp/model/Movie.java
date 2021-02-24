package com.cos.retrofit2movieapp.model;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.cos.retrofit2movieapp.R;
import com.google.gson.annotations.SerializedName;
import com.makeramen.roundedimageview.RoundedImageView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    private static final String TAG = "Movie";
    private Long id;
    private String url;
    private String title;
    private Long year;
    private Double rating;
    private Long runtime;
    private String summary;

    @SerializedName("medium_cover_image")
    private String mediumCoverImage;


    @BindingAdapter({"mediumCoverImage"})
    public static void loadImage(RoundedImageView view, String mediumCoverImage){

        Log.d(TAG, "loadImage: "+ mediumCoverImage);

        Glide.with(view.getContext())
                .load(mediumCoverImage)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(view);
    }
}
