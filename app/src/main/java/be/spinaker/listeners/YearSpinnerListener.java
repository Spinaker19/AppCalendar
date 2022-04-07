package be.spinaker.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import be.spinaker.appcalendar.MainActivity;
import be.spinaker.appcalendar.R;
import be.spinaker.appcalendar.Years;

public class YearSpinnerListener implements AdapterView.OnItemSelectedListener {

    private MainActivity plugin;
    private Spinner seriesSpinner;
    private Spinner lectureSpinner;

    public YearSpinnerListener(MainActivity plugin, Spinner seriesSpinner, Spinner lectureSpinner) {
        this.plugin = plugin;
        this.seriesSpinner = seriesSpinner;
        this.lectureSpinner = lectureSpinner;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        String selectedItem =  parent.getSelectedItem().toString();
        Years year = Years.getByName(selectedItem);
        plugin.setSelectedYear(year);

        ArrayAdapter<String> seriesAdapter = new ArrayAdapter<String>(parent.getContext(), R.layout.support_simple_spinner_dropdown_item, year.getSeries());
        seriesSpinner.setAdapter(seriesAdapter);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
