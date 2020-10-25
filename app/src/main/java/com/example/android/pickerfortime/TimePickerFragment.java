

package com.example.android.pickerfortime;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;


public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {


    /**
     * Membuat dialog pemilih waktu dengan waktu saat ini dari Kalender.
     * @param savedInstanceState    Paket status instance tersimpan
     
     * @return TimePickerDialog    timepicker dialog
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // membuat instance baru TimePickerDialog dan di ulang.
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }


    /**
     * memperoleh waktu dan mengubahnya menjadi string untuk dilewati
     * ke Aktivitas Utama untuk menampilkannya dengan processTimePickerResult ().
     * @param timePicker    menampilkan time picker
     * @param hourOfDay     memilih jam
     * @param minute        memilih menit
     */
    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        MainActivity activity = (MainActivity) getActivity();
        activity.processTimePickerResult(hourOfDay, minute);
    }
}
