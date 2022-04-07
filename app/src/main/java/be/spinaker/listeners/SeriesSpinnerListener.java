package be.spinaker.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import be.spinaker.appcalendar.MainActivity;

public class SeriesSpinnerListener implements AdapterView.OnItemSelectedListener {

    private MainActivity plugin;
    private Spinner lectureSpinner;

    public SeriesSpinnerListener(MainActivity plugin, Spinner lectureSpinner) {
        this.plugin = plugin;
        this.lectureSpinner = lectureSpinner;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        String selectedItem =  parent.getSelectedItem().toString();
        plugin.setSelectedSeries(selectedItem);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
