package mx.edu.ittepic.u4_animacion_frame;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable caballo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        if (imageView == null) throw new AssertionError();

        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackgroundResource(R.drawable.animation_list);

        caballo = (AnimationDrawable) imageView.getBackground();
        caballo.setOneShot(true);
    }

    public void onStartBtnClick(View v) {
        imageView.setVisibility(View.VISIBLE);
        if (caballo.isRunning()) {
            caballo.stop();
        }
        caballo.start();
    }

    public void onStopBtnClick(View v) {
        caballo.stop();
    }
}
