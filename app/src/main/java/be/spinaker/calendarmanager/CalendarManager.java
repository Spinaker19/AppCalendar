package be.spinaker.calendarmanager;

import android.widget.Toast;
import be.spinaker.appcalendar.MainActivity;
import be.spinaker.appcalendar.Years;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CertPathBuilder;
import java.util.ArrayList;

public class CalendarManager {

    private MainActivity plugin;
    private static String baseURL = "https://calendar.ecam.be/ics/serie_";
    CalendarBuilder builder = new CalendarBuilder();

    public CalendarManager(MainActivity plugin) {
        this.plugin = plugin;
    }

    public void getCalendars(Years year) {
        try {
            buildCalendars(buildURLs(year));
        } catch (IOException | ParserException e) {
            e.printStackTrace();
            Toast.makeText(plugin.getApplicationContext(), "An error has occured", Toast.LENGTH_SHORT).show();
        }
    }

    public void getCalendar(Years year, String serie) {
        try {
            buildCalendar(buildURL(year, serie));
        } catch (IOException | ParserException e) {
            e.printStackTrace();
            Toast.makeText(plugin.getApplicationContext(), "An error has occured", Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<String> buildURLs(Years year) {
        ArrayList<String> urls = new ArrayList<>();

        // For every year in Years
        for(Years y : Years.values()) {

            String urlWithYear = baseURL + y.getYearName();

            // For each series, adds the URL for the A AND B groups
            for (int i = 1; i <= y.getSeriesAmount(); i++) {
                urls.add(urlWithYear + i + "A");
                urls.add(urlWithYear + i + "B");
            }
        }
        return urls;
    }

    private String buildURL(Years year, String serie) {
        return baseURL+serie;
    }

    private ArrayList<Calendar> buildCalendars(ArrayList<String> urls) throws IOException, ParserException {
        ArrayList<Calendar> calendars = new ArrayList<>();
        for(String url : urls) {
            InputStream is = new URL(url).openStream();
            Calendar cal = builder.build(is);
            is.close();
            calendars.add(cal);
        }
        return calendars;
    }

    private Calendar buildCalendar(String url) throws IOException, ParserException {
        InputStream is = new URL(url).openStream();
        Calendar cal = builder.build(is);
        is.close();
        return cal;
    }
}
