package ru.mobystudio.alarmclock;

import android.app.AlarmManager;
import java.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button onButton, offButton;
    TextView updateTimeTextView;
    TimePicker timePicker;
    AlarmManager alarmManager;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initElements();
        setClickListenerButtons();



    }
    private void initElements(){
        onButton = (Button)findViewById(R.id.alarm_on_button);
        offButton = (Button)findViewById(R.id.alarm_off_button);
        updateTimeTextView = (TextView)findViewById(R.id.update_time_text);
        updateTimeTextView.setText("Alarm no set");
        timePicker = (TimePicker)findViewById(R.id.timepicker);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        calendar = Calendar.getInstance();
    }

    private void setClickListenerButtons(){
        onButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                setCalendar();
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);
                setTimeText("Alarm set on " + hour_string + ":" + minute_string);
            }
        });
        offButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                setTimeText("Alarm off");
            }
        });
    }
    public void setCalendar(){
        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
        calendar.set(Calendar.MINUTE, timePicker.getMinute());
    }
    private void setTimeText(String text){
        updateTimeTextView.setText(text);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
