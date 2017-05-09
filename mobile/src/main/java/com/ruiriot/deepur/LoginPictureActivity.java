package com.ruiriot.deepur;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.ruiriot.deepur.utils.ActivityUtils.requestPermission;

public class LoginPictureActivity extends BaseActivity{

    Intent intent;
    String userEmail;
    String userName;
    Context context;

    @BindView(R.id.activity_login_user_email)
    TextView userEmailText;

    @BindView(R.id.activity_login_picture_user_image)
    CircleImageView userImageView;

    @BindView(R.id.activity_login_picture_add)
    ImageView addPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_picture);

        intent = getIntent();

        userEmail = intent.getStringExtra(Intent.EXTRA_EMAIL);
        userEmailText.setText(userEmail);

        addPicture.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();

        if(i == R.id.activity_login_picture_add){
            requestPermission(this, Constants.PERMISSIONS_REQUEST_CAMERA, Manifest.permission.CAMERA);
        }
    }
}

