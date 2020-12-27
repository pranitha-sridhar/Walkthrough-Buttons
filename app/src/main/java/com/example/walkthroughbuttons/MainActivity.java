package com.example.walkthroughbuttons;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import tourguide.tourguide.ChainTourGuide;
import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.Sequence;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class MainActivity extends AppCompatActivity {
    Button button,button2,button3;
    AlertDialog.Builder builder,builder2,builder1;
    Boolean firstrun;
    //TourGuide mTourGuideHandler,mTourGuideHandler2,mTourGuideHandler3;

    public ChainTourGuide mTourGuideHandler;
    public Activity mActivity;
    //private Button mButton1, mButton2, mButton3;
    private Animation mEnterAnimation, mExitAnimation;

    public static final int OVERLAY_METHOD = 1;
    public static final int OVERLAY_LISTENER_METHOD = 2;

    public static final String CONTINUE_METHOD = "continue_method";
    private int mChosenContinueMethod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstrun = true;
        //boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
        //if (firstrun == true) {
           /* builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.myDialog));


            //View custom = getLayoutInflater().inflate(R.layout.message, null);
            //builder.setView(custom);
            builder.setMessage("HI1");
            AlertDialog alertDialog = null;
            AlertDialog alertDialog1 = null;
            AlertDialog alertDialog2=null;
            builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Next selected", Toast.LENGTH_SHORT).show();
                }
            });
            final AlertDialog finalAlertDialog = alertDialog;
            builder.setNegativeButton("Skip", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finalAlertDialog.dismiss();

                }
            });
           // alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog=builder.create();
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.show();
            if (firstrun==true) {
                builder1 = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.myDialog));
                //View custom1 = getLayoutInflater().inflate(R.layout.message, null);
                //builder1.setView(custom1);
                builder1.setMessage("HI2");
                builder1.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Next selected", Toast.LENGTH_SHORT).show();
                    }
                });
                final AlertDialog finalAlertDialog1 = alertDialog;
                builder1.setNegativeButton("Skip", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();
                        finalAlertDialog1.dismiss();
                    }
                });
                alertDialog1 = builder1.create();
                alertDialog1.setCanceledOnTouchOutside(false);
                //alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog1.show();

                if (firstrun==true) {
                    builder2 = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.myDialog));
                    //View custom2 = getLayoutInflater().inflate(R.layout.message, null);
                    //builder2.setView(custom2);
                    builder2.setMessage("HI3");
                    builder2.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "Next selected", Toast.LENGTH_SHORT).show();
                        }
                    });
                    final AlertDialog finalAlertDialog2 = alertDialog1;
                    final AlertDialog finalAlertDialog3 = alertDialog;
                    builder2.setNegativeButton("Skip", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();
                            finalAlertDialog3.dismiss();
                            finalAlertDialog2.dismiss();
                        }
                    });
                    alertDialog2 = builder2.create();
                    alertDialog2.setCanceledOnTouchOutside(false);
                    alertDialog2.show();
                }
            }

        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();


           /* but1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                   AlertDialog.Builder builder1=new AlertDialog.Builder(getApplicationContext());
                    final AlertDialog alertDialog1=builder1.create();
                    LayoutInflater inflater1= LayoutInflater.from(getApplicationContext());
                    alertDialog1.setContentView(inflater1.inflate(R.layout.message,null));
                    TextView but1=alertDialog1.findViewById(R.id.but1);
                    TextView but2=alertDialog1.findViewById(R.id.but2);
                    but1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog.Builder builder2=new AlertDialog.Builder(getApplicationContext());
                            final AlertDialog alertDialog2=builder2.create();
                            LayoutInflater inflater2= LayoutInflater.from(getApplicationContext());
                            alertDialog2.setContentView(inflater2.inflate(R.layout.message,null));
                            TextView but1=alertDialog2.findViewById(R.id.but1);
                            TextView but2=alertDialog2.findViewById(R.id.but2);
                            but1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();

                                }
                            });
                            but2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();

                                }
                            });
                        }
                    });
                    but2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();

                        }
                    });
                }
            });
            but2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();
                }
            });
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.show();


        }*/

            button = findViewById(R.id.button);
            button2 = findViewById(R.id.button2);
            button3 = findViewById(R.id.button3);






            /*mTourGuideHandler = TourGuide.init(this).with(TourGuide.Technique.CLICK).setPointer(new Pointer()).setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin...")).setOverlay(new Overlay()).playOn(button);
            //mTourGuideHandler.cleanUp();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mTourGuideHandler.cleanUp();
                    clickMe1();
                    //mTourGuideHandler2 = TourGuide.init(getParent()).with(TourGuide.Technique.CLICK).setPointer(new Pointer()).setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin...")).setOverlay(new Overlay()).playOn(button2);

                }
            },2000);
            //mTourGuideHandler = TourGuide.init(this).with(TourGuide.Technique.CLICK).setPointer(new Pointer()).setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin...")).setOverlay(new Overlay()).playOn(button2);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mTourGuideHandler.cleanUp();
                    clickMe2();
                    //mTourGuideHandler2 = TourGuide.init(getParent()).with(TourGuide.Technique.CLICK).setPointer(new Pointer()).setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin...")).setOverlay(new Overlay()).playOn(button2);

                }
            },4000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mTourGuideHandler.cleanUp();
                    //clickMe3();
                    //mTourGuideHandler2 = TourGuide.init(getParent()).with(TourGuide.Technique.CLICK).setPointer(new Pointer()).setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin...")).setOverlay(new Overlay()).playOn(button2);

                }
            },6000);


            //mTourGuideHandler2 = TourGuide.init(this).with(TourGuide.Technique.CLICK).setPointer(new Pointer()).setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin...")).setOverlay(new Overlay()).playOn(button2);


            //TourGuide mTourGuideHandler3 = TourGuide.init(this).with(TourGuide.Technique.CLICK).setPointer(new Pointer()).setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin...")).setOverlay(new Overlay()).playOn(button3);

            //mTourGuideHandler.setToolTip(new ToolTip() .setTitle("Here you'll find...") .setDescription("... a lot of good tutorials") .setBackgroundColor(Color.parseColor("#4b4b4b"))) .playOn(button2);
            //mTourGuideHandler.cleanUp();
           // mTourGuideHandler3=TourGuide.init(this).with(TourGuide.Technique.CLICK).setPointer(new Pointer()).setToolTip(new ToolTip() .setTitle("Here you'll find...") .setDescription("... a lot of good tutorials") .setBackgroundColor(Color.parseColor("#4b4b4b"))) .playOn(button3);
            //mTourGuideHandler.cleanUp();
            //getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();

        }


    }
    public void clickMe1() {
        mTourGuideHandler .setToolTip(new ToolTip() .setTitle("Here you'll find...") .setDescription("... a lot of good tutorials") .setBackgroundColor(Color.parseColor("#4b4b4b"))) .playOn(button2);
    }
    public void clickMe2() {
        mTourGuideHandler .setToolTip(new ToolTip() .setTitle("Here you'll find...") .setDescription("... a lot of good tutorials") .setBackgroundColor(Color.parseColor("#4b4b4b"))) .playOn(button3);
    }
    public void clickMe3() {
        mTourGuideHandler.cleanUp();
        //mTourGuideHandler .setToolTip(new ToolTip() .setTitle("Here you'll find...") .setDescription("... a lot of good tutorials") .setBackgroundColor(Color.parseColor("#4b4b4b"))) .playOn(button2);
    }*/


            mExitAnimation = new AlphaAnimation(1f, 0f);
            mExitAnimation.setDuration(600);
            mExitAnimation.setFillAfter(true);
            mChosenContinueMethod=OVERLAY_LISTENER_METHOD;

            if (mChosenContinueMethod == OVERLAY_METHOD) {
                runOverlay_ContinueMethod();
            } else if (mChosenContinueMethod == OVERLAY_LISTENER_METHOD) {
                runOverlayListener_ContinueMethod();
            }
        }

        private void runOverlay_ContinueMethod(){
            // the return handler is used to manipulate the cleanup of all the tutorial elements
            ChainTourGuide tourGuide1 = ChainTourGuide.init(this)
                    .setToolTip(new ToolTip()
                            .setTitle("ContinueMethod.Overlay")
                            .setDescription("When using this ContinueMethod, you can't specify the additional action before going to next TourGuide.")
                            .setGravity(Gravity.BOTTOM)
                            .setBackgroundColor(Color.parseColor("#c0392b"))
                    )
                    .setOverlay(new Overlay()
                            .setBackgroundColor(Color.parseColor("#EE2c3e50"))
                            .setEnterAnimation(mEnterAnimation)
                            .setExitAnimation(mExitAnimation)
                    )
                    // note that there is not Overlay here, so the default one will be used
                    .playLater(button);

            ChainTourGuide tourGuide2 = ChainTourGuide.init(this)
                    .setToolTip(new ToolTip()
                            .setTitle("Tip")
                            .setDescription("Individual Overlay will be used when it's supplied.")
                            .setGravity(Gravity.BOTTOM | Gravity.LEFT)
                            .setBackgroundColor(Color.parseColor("#c0392b"))
                    )
                    .setOverlay(new Overlay()
                            .setBackgroundColor(Color.parseColor("#EE2c3e50"))
                            .setEnterAnimation(mEnterAnimation)
                            .setExitAnimation(mExitAnimation)
                    )
                    .playLater(button2);

            ChainTourGuide tourGuide3 = ChainTourGuide.init(this)
                    .setToolTip(new ToolTip()
                            .setTitle("ContinueMethod.Overlay")
                            .setDescription("When using this ContinueMethod, you don't need to call tourGuide.next() explicitly, TourGuide will do it for you.")
                            .setGravity(Gravity.TOP)
                    )
                    // note that there is not Overlay here, so the default one will be used
                    .playLater(button3);

            Sequence sequence = new Sequence.SequenceBuilder()
                    .add(tourGuide1, tourGuide2, tourGuide3)
                    .setDefaultOverlay(new Overlay()
                            .setEnterAnimation(mEnterAnimation)
                            .setExitAnimation(mExitAnimation)
                    )
                    .setDefaultPointer(null)
                    .setContinueMethod(Sequence.ContinueMethod.OVERLAY)
                    .build();


            ChainTourGuide.init(this).playInSequence(sequence);
        }

        private void runOverlayListener_ContinueMethod(){
            // the return handler is used to manipulate the cleanup of all the tutorial elements
            ChainTourGuide tourGuide1 = ChainTourGuide.init(this)
                    .setToolTip(new ToolTip()
                            .setTitle("Check your profile")
                            .setDescription("Update the details now, to save it")
                            .setGravity(Gravity.BOTTOM)
                    )
                    // note that there is not Overlay here, so the default one will be used
                    .playLater(button);

            ChainTourGuide tourGuide2 = ChainTourGuide.init(this)
                    .setToolTip(new ToolTip()
                            .setTitle("Tip")
                            .setDescription("Cart is empty! Fill it now")
                            .setBackgroundColor(Color.parseColor("#c0392b"))
                            .setGravity(Gravity.BOTTOM | Gravity.LEFT)
                    )
                    .setOverlay(new Overlay()
                            .setEnterAnimation(mEnterAnimation)
                            .setExitAnimation(mExitAnimation)
                            .setBackgroundColor(Color.parseColor("#EE2c3e50"))
                            .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mTourGuideHandler.next();
                                }
                            })
                    )
                    .playLater(button3);

            ChainTourGuide tourGuide3 = ChainTourGuide.init(this)
                    .setToolTip(new ToolTip()
                            .setTitle("Look at your feed")
                            .setDescription("Can view other people's stories")
                            .setGravity(Gravity.BOTTOM)
                    )
                    // note that there is not Overlay here, so the default one will be used
                    .playLater(button2);

            Sequence sequence = new Sequence.SequenceBuilder()
                    .add(tourGuide1, tourGuide2, tourGuide3)
                    .setDefaultOverlay(new Overlay()
                            .setEnterAnimation(mEnterAnimation)
                            .setExitAnimation(mExitAnimation)
                            .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "The button is Clicked", Toast.LENGTH_SHORT).show();
                                    mTourGuideHandler.next();
                                }
                            })
                    )
                    .setDefaultPointer(null)
                    .setContinueMethod(Sequence.ContinueMethod.OVERLAY_LISTENER)
                    .build();

            mTourGuideHandler = ChainTourGuide.init(this).playInSequence(sequence);

        }




}