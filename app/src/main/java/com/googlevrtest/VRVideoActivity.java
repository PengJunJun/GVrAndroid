package com.googlevrtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.google.vr.sdk.widgets.video.VrVideoView;

import java.io.IOException;
import java.io.InputStream;

public class VRVideoActivity extends AppCompatActivity {

    private VrVideoView mVrVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_vr_video);
        mVrVideoView = (VrVideoView) findViewById(R.id.vrVideoView);

        VrVideoView.Options options = new VrVideoView.Options();
        options.inputFormat = VrVideoView.Options.FORMAT_DEFAULT;
        options.inputType = VrVideoView.Options.TYPE_STEREO_OVER_UNDER;
        try {
            mVrVideoView.loadVideoFromAsset("congo.mp4", options);
            mVrVideoView.setVolume(1.0f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
