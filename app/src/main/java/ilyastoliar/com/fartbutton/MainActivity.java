package ilyastoliar.com.fartbutton;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import java.util.Random;

public class MainActivity extends Activity {


    
    ImageButton button;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "204612886", true);
        setContentView(R.layout.activity_main);

        button = (ImageButton) findViewById(R.id.button);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.sound1);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.sound2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = rand.nextInt(2) + 1;
                if (n == 1) mp1.start();
                if (n == 2) mp2.start();
            }

        });

    }

}
