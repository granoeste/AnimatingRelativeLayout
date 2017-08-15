package net.granoeste.animatingrelativelayoutsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.granoeste.animatingrelativelayout.widget.AnimatingRelativeLayout;

public class MainActivity extends AppCompatActivity {

    AnimatingRelativeLayout firstly;
    AnimatingRelativeLayout secondly;
    AnimatingRelativeLayout thirdly;
    AnimatingRelativeLayout fourthly;
    AnimatingRelativeLayout fifthly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstly = (AnimatingRelativeLayout) findViewById(R.id.firstly);
        secondly = (AnimatingRelativeLayout) findViewById(R.id.secondly);
        thirdly = (AnimatingRelativeLayout) findViewById(R.id.thirdly);
        fourthly = (AnimatingRelativeLayout) findViewById(R.id.fourthly);
        fifthly = (AnimatingRelativeLayout) findViewById(R.id.fifthly);

        findViewById(R.id.animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstly.isVisible()) {
                    firstly.hide();
                    secondly.show();
                } else if (secondly.isVisible()) {
                    secondly.hide();
                    thirdly.show();
                } else if (thirdly.isVisible()) {
                    thirdly.hide();
                    fourthly.show();
                } else if (fourthly.isVisible()) {
                    fourthly.hide();
                    fifthly.show();
                } else if (fifthly.isVisible()) {
                    fifthly.hide();
                    firstly.show();
                }
            }
        });
    }

    private void toggle() {
        if (firstly.isVisible()) {
            firstly.hide();
            secondly.show();
        } else if (secondly.isVisible()) {
            secondly.hide();
            thirdly.show();
        }
    }
}
