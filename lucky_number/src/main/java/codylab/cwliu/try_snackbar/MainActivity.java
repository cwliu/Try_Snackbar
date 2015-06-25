package codylab.cwliu.try_snackbar;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View coordinator_layout;
    private int previous_lucky_number = -1;
    private int current_lucky_number = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init_activity();

        init_lucky_number_value();  // Snackbar without action
        init_float_action_button(); // Snackbar with action
    }

    private void init_activity(){
        ActionBar actionbar = getActionBar();
        if(actionbar != null){
            actionbar.hide();
        }
        setContentView(R.layout.activity_main);
        coordinator_layout = findViewById(R.id.coordinatorlayout);
    }

    private void init_lucky_number_value(){
        int new_lucky_number = generate_lucky_number();

        Snackbar.make(coordinator_layout,
                "Your lucky number is: " + Integer.toString(new_lucky_number),
                Snackbar.LENGTH_LONG).show();
    }

    private void init_float_action_button(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.lucky_number_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int new_lucky_number = generate_lucky_number();

                Snackbar snackbar = Snackbar.make(coordinator_layout,
                        "New lucky number is: " + new_lucky_number,
                        Snackbar.LENGTH_LONG);

                snackbar.setAction("Restore", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        undo_lucky_number();
                        Snackbar.make(coordinator_layout,
                                "Lucky number is restored",
                                Snackbar.LENGTH_LONG).show();

                    }
                });

                snackbar.setActionTextColor(Color.RED);
                snackbar.show();
            }
        });
    }

    private int generate_lucky_number() {
        Random r = new Random();
        previous_lucky_number = current_lucky_number;
        current_lucky_number = r.nextInt(101);

        update_lucky_number_text_view(current_lucky_number);
        return current_lucky_number;
    }

    private void update_lucky_number_text_view(int number){
        TextView lucky_number_value = (TextView) findViewById(R.id.lucky_number_value);
        lucky_number_value.setText(Integer.toString(number));
    }

    private void undo_lucky_number(){
        current_lucky_number = previous_lucky_number;
        previous_lucky_number = -1;
        update_lucky_number_text_view(current_lucky_number);
    }
}
