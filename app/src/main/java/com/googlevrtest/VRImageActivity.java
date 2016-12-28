package com.googlevrtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;

public class VRImageActivity extends AppCompatActivity {

    private VrPanoramaView mVrPanoramaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_vr_image);
        mVrPanoramaView = (VrPanoramaView) findViewById(R.id.vrPanoramaView);

        InputStream is = null;
        try {
            is = getAssets().open("andes.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;

        mVrPanoramaView.loadImageFromBitmap(bitmap, options);
    }
}
