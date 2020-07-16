package com.bytedance.tiktok.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.bytedance.tiktok.R;
import com.bytedance.tiktok.utils.PathUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
        视频录制页
 */

public class VideoActivity extends AppCompatActivity{
    private Camera mCamera;
    private SurfaceView mSurfaceView;
    private SurfaceHolder mHolder;
    private VideoView mVideoView;
    private Button btn2;
    private MediaRecorder mMediaRecorder;
    private String mp4Path;
    private boolean isRecording;
    public static final String KEY = "result_key";

    private static String[] permissions = new String[]{Manifest.permission.CAMERA,Manifest.permission.RECORD_AUDIO};
    private static int PERMISSION_CODE = 1;

    private void requestForPermission(){
        if(PackageManager.PERMISSION_GRANTED != getPackageManager().checkPermission(permissions[0], getPackageName())
                || PackageManager.PERMISSION_GRANTED != getPackageManager().checkPermission(permissions[1], getPackageName()))
            ActivityCompat.requestPermissions(this,permissions,PERMISSION_CODE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_getvideo);
        mSurfaceView = findViewById(R.id.surfaceView);
        mVideoView = findViewById(R.id.videoView);
        btn2 = findViewById(R.id.buttonVideo);

        requestForPermission();
        initCamera();
        mHolder = mSurfaceView.getHolder();
        mHolder.addCallback(new PlayerCallBack());

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                record();
            }
        });
    }

    private void initCamera(){
        mCamera = Camera.open(1);
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPictureFormat(ImageFormat.JPEG);
        parameters.setFocusMode(Camera.Parameters.FLASH_MODE_AUTO);
        parameters.set("orientation","portrait");
        parameters.set("rotation",90);
        mCamera.setParameters(parameters);
        mCamera.setDisplayOrientation(90);
    }

    private class PlayerCallBack implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            try{
                mCamera.setPreviewDisplay(holder);
                mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            if(holder.getSurface() == null){
                return;
            }
            //停止预览效果
            mCamera.stopPreview();
            //重新设置预览效果
            try{
                mCamera.setPreviewDisplay(holder);
                mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (mCamera == null){
            initCamera();
        }
        mCamera.startPreview();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mCamera.stopPreview();
    }

    private boolean prepareVideoRecorder(){
        mMediaRecorder = new MediaRecorder();
        mCamera.unlock();
        mMediaRecorder.setCamera(mCamera);
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

        mMediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));
        mp4Path = getOutputMediaPath();
        mMediaRecorder.setOutputFile(mp4Path);
        mMediaRecorder.setOrientationHint(90);
        try {
            mMediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
            mMediaRecorder.release();
            return false;
        }
        return true;
    }

    public void record(){
        if(isRecording){
            mMediaRecorder.stop();
            mMediaRecorder.reset();
            mMediaRecorder.release();
            mMediaRecorder = null;
            mCamera.lock();

            Intent intent = new Intent();
            intent.putExtra(KEY,mp4Path);
            if (mp4Path.isEmpty()) {
                setResult(RESULT_CANCELED, intent);
            } else {
                setResult(RESULT_OK, intent);
            }
            finish();
        }else{
            if(prepareVideoRecorder()){
                btn2.setText("停止");
                mMediaRecorder.start();
            }
        }
        isRecording = !isRecording;
    }

    public String getOutputMediaPath(){
        File mediaDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile = new File(mediaDir,"IMG_" + timeStamp + ".mp4");
        if(!mediaFile.exists()){
            mediaFile.getParentFile().mkdirs();
        }
        return mediaFile.getAbsolutePath();
    }
}
