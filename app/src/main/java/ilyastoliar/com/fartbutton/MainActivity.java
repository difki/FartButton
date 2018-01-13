package ilyastoliar.com.fartbutton;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import java.util.Random;

public class MainActivity extends Activity {
    
    ImageButton button;
    ImageButton share;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "204612886", true);
        setContentView(R.layout.activity_main);

        button = (ImageButton) findViewById(R.id.button);
        share = (ImageButton) findViewById(R.id.share);

        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.sound1);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.sound2);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.sound3);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.sound4);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.sound5);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.sound6);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.sound7);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.sound8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = rand.nextInt(8) + 1;
                if (n == 1) mp1.start();
                if (n == 2) mp2.start();
                if (n == 3) mp3.start();
                if (n == 4) mp4.start();
                if (n == 5) mp5.start();
                if (n == 6) mp6.start();
                if (n == 7) mp7.start();
                if (n == 8) mp8.start();
            }

        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Download the super funny fart button https://play.google.com/store/apps/details?id=ilyastoliar.com.fartbutton&hl=en";
                String shareSub = "Fart button";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });

    }

}
