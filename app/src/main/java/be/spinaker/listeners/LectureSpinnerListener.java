package be.spinaker.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import be.spinaker.appcalendar.MainActivity;

public class LectureSpinnerListener implements AdapterView.OnItemSelectedListener {

    private MainActivity plugin;

    public LectureSpinnerListener(MainActivity plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println("teeeeeeest");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
