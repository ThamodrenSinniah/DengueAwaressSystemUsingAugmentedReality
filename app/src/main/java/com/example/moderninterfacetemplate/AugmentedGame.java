package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.sceneform.Camera;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.collision.Ray;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.rendering.Texture;

import java.util.Random;

public class AugmentedGame extends AppCompatActivity {


    private Scene scene;
    private Camera camera;
    private ModelRenderable bulletRenderable;


    private boolean shouldStartTimer = true;
    private int balloonsLeft = 10;
    private Point point;
    private TextView balloonsLeftTxt;
    private SoundPool soundPool;
    private int sound;

    private int minuteTest;
    private int secondTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getRealSize(point);

        setContentView(R.layout.activity_augmented_game);

        loadSoundPool();

        balloonsLeftTxt = findViewById(R.id.balloonsCntTxt);
        CustomArFragment arFragment =
                (CustomArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);


        scene = arFragment.getArSceneView().getScene();
        camera = scene.getCamera();

        addMosquitoesToScene();
       //addButteflytoScene();
        buildBulletModel();


        Button shoot = findViewById(R.id.shootButton);

        shoot.setOnClickListener(v -> {

            if (shouldStartTimer) {
                startTimer();
                shouldStartTimer = false;
            }

            shoot();

        });

    }

    private void loadSoundPool() {

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build();

        sound = soundPool.load(this, R.raw.blop_sound, 1);

    }

    private void shoot() {
       Ray ray = camera.screenPointToRay(point.x / 2f, point.y / 2f);
        Node node = new Node();
        node.setRenderable(bulletRenderable);

        //  Toast.makeText(this, "This is my Toast message!",Toast.LENGTH_LONG).show();
        scene.addChild(node);

        new Thread(() -> {

            for (int i = 0;i < 200;i++) {

                int finalI = i;
                runOnUiThread(() -> {

                    Vector3 vector3 = ray.getPoint(finalI * 0.1f);
                    node.setWorldPosition(vector3);


                    Node nodeInContact = scene.overlapTest(node);


                    if (nodeInContact != null) {

                        balloonsLeft--;
                        balloonsLeftTxt.setText("Mosquitoes Left: " + balloonsLeft);
                        scene.removeChild(nodeInContact);
                        soundPool.play(sound, 1f, 1f, 1, 0, 1f);
                    }


                });

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            runOnUiThread(() -> scene.removeChild(node));

        }).start();


    }

    private void startTimer() {

        TextView timer = findViewById(R.id.timerText);

        new Thread(() -> {

            int seconds = 59;

            while (balloonsLeft > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                seconds--;

                int minutesPassed = seconds / 60;
                int secondsPassed = seconds % 60;

                minuteTest = minutesPassed;
                secondTest = secondsPassed;

                if (secondTest < 0){
                    tryAgain();
                    Thread.interrupted();
                    break;
                }

                runOnUiThread(() -> timer.setText(minutesPassed + ":" + secondsPassed));

            }if (secondTest > 0){
                success();
                Thread.interrupted();
            }


        }).start();

    }

    private void buildBulletModel() {

        Texture
                .builder()
                .setSource(this, R.drawable.texture)
                .build()
                .thenAccept(texture -> {


                    MaterialFactory
                            .makeOpaqueWithTexture(this, texture)
                            .thenAccept(material -> {

                                bulletRenderable = ShapeFactory
                                        .makeSphere(0.01f,
                                                new Vector3(0f, 0f, 0f),
                                                material);

                            });


                });

    }

    private void addMosquitoesToScene() {


        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("MOSQUITO_3DMODELFORGAME.sfb"))
                .build()
                .thenAccept(renderable -> {

                    for (int i = 0;i < 10;i++) {

                        Node node = new Node();
                        node.setRenderable(renderable);
                        scene.addChild(node);


                        Random random = new Random();
                        int x = random.nextInt(10);
                        int z = random.nextInt(10);
                        int y = random.nextInt(10);

                        z = -z;

                        node.setWorldPosition(new Vector3(
                                (float) x,
                                y / 10f,
                                (float) z
                        ));

                    }

                });

    }


    public void tryAgain(){
        TimerFinish timerFinish = new TimerFinish();
        timerFinish.show(getSupportFragmentManager(),"EXAMPLE DIALOG");
    }

    public void success(){
        TimerSuccess timerSuccess = new TimerSuccess();
        timerSuccess.show(getSupportFragmentManager(),"EXAMPLE DIALOG");
    }
}