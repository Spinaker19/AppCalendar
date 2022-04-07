package be.spinaker.appcalendar;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import be.spinaker.listeners.LectureSpinnerListener;
import be.spinaker.listeners.SeriesSpinnerListener;
import be.spinaker.listeners.YearSpinnerListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Years selectedYear = Years.BA1;
    private String selectedSeries = "1a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //Init the year spinner
        Spinner yearSpinner = findViewById(R.id.spinner_year);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, Years.getYears());
        yearSpinner.setAdapter(adapter);

        //Init the series spinner
        Spinner seriesSpinner = findViewById(R.id.spinner_series);
        ArrayAdapter<String> seriesAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, Years.BA1.getSeries());
        seriesSpinner.setAdapter(seriesAdapter);

        //Init the lecture spinner
        Spinner lectureSpinner = findViewById(R.id.spinner_lecture);
        ArrayAdapter<String> lectureAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, Years.BA1.getLectures());
        lectureSpinner.setAdapter(lectureAdapter);

        //Init the onClickListener
        yearSpinner.setOnItemSelectedListener(new YearSpinnerListener(this, seriesSpinner, lectureSpinner));
        seriesSpinner.setOnItemSelectedListener(new SeriesSpinnerListener(this, lectureSpinner));
        lectureSpinner.setOnItemSelectedListener(new LectureSpinnerListener(this));

    }

    public void setSelectedYear(Years selectedYear) {
        this.selectedYear = selectedYear;
    }

    public void setSelectedSeries(String selectedSeries) {
        this.selectedSeries = selectedSeries;
    }

    public Years getSelectedYear() {
        return selectedYear;
    }

    public String getSelectedSeries() {
        return selectedSeries;
    }
}