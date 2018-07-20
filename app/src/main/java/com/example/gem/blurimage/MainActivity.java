package com.example.gem.blurimage;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.picasso.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity {

  CircleImageView mIv;
  TextView mBt;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initViews();
  }

  private void initViews() {
    mIv = findViewById(R.id.ivImage);
    mBt = findViewById(R.id.bt_click_change);
    Picasso.with(MainActivity.this).load(Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTJl8Yjeh1dmjbqPydlg_39xKi65rmK1xL9wZr9_lRP4Evjv5S"))
        .fit()
        .into(mIv);


    mBt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // load image from internet
        Picasso.with(MainActivity.this).load(Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTJl8Yjeh1dmjbqPydlg_39xKi65rmK1xL9wZr9_lRP4Evjv5S"))
            .fit()
            .transform(new BlurTransformation(getApplicationContext(), 90))
            .into(mIv);

        //blur image

      }
    });
  }
}
