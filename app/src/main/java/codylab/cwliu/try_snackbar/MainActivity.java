package codylab.cwliu.try_snackbar;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    View rootView;
    int previous_lucky_number = -1;
    int current_lucky_number = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init_activity();

        init_lucky_number_value();
        init_generate_button();
    }

    private void init_activity(){
        ActionBar actionbar = getActionBar();
        if(actionbar != null){
            actionbar.hide();
        }
        setContentView(R.layout.activity_main);
        rootView = getWindow().getDecorView().findViewById(android.R.id.content);
    }
    private void init_generate_button() {
        Button button = (Button) findViewById(R.id.generate_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int new_lucky_number = generate_lucky_number();
                Snackbar snackbar = Snackbar.make(rootView, "New lucky number is: " + new_lucky_number, Snackbar.LENGTH_LONG);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        undo_lucky_number();
                        Snackbar.make(rootView, "Lucky number is restored", Snackbar.LENGTH_LONG).show();

                    }
                });
//                snackbar.setActionTextColor(R.color.accent_material_light);
                snackbar.show();
            }
        });
    }

    private void init_lucky_number_value(){
        int new_lucky_number = generate_lucky_number();

        Snackbar.make(rootView, "Your lucky number is: " + Integer.toString(new_lucky_number),
                Snackbar.LENGTH_LONG).show();
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
        update_lucky_number_text_view(current_lucky_number);
    }
}
