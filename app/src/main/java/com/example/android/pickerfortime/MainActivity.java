
package com.example.android.pickerfortime;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * untuk menampilkan tombol agar menampilkan pemilihan waktu
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * klik tombol untuk membuat fragmen pemilih waktu baru dan
     dan menampilkannya
     */
    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),
                getString(R.string.timepicker));
    }

    /**
     * proses pemilihan waktu menjadi string yg dapat di tampilkan
     * menentukan jam yg dipilih dan menit
     */
    public void processTimePickerResult(int hourOfDay, int minute) {
        // mengubah elemen menjadi string
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // menetapkan string dan menggabungkan ke timemessage
        String timeMessage = (hour_string + ":" + minute_string);

        Toast.makeText(this,getString(R.string.time_toast)
                + timeMessage, Toast.LENGTH_SHORT).show();
    }
}
