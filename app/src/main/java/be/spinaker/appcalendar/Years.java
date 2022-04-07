package be.spinaker.appcalendar;

import java.util.ArrayList;

public enum Years {

    BA1("1BA", 1, 10),
    BA2("2BA", 2, 6),
    BA3("3BA", 3, 9);

    private String name;
    private int value;
    private int seriesAmount;

    Years(String name, int value, int seriesAmount) {
        this.name = name;
        this.value = value;
        this.seriesAmount = seriesAmount;
    }

    public String getYearName() {return this.name;}
    public int getValue() {return this.value;}
    public int getSeriesAmount() {return this.seriesAmount;}

    public static Years getByValue(int val) {
        /*
            Returns <val>th year of the values list
            (from 1 to length)
         */
        Years[] values = values();
        if (val > values.length ) return null;
        return values[val-1];
    }

    public static Years getByName(String name) {
        for(Years y : values()) {
            if(y.getYearName().equalsIgnoreCase(name)) return y;
        }
        return null;
    }

    public ArrayList<String> getSeries() {
        ArrayList<String> series = new ArrayList<>();

        for(int i = 1; i <= this.seriesAmount; i++) {
            String serieNumber = String.valueOf(i);
            series.add(serieNumber + "a");
            series.add(serieNumber + "b");
        }

        return series;
    }

    public static ArrayList<String> getYears() {

        ArrayList<String> res = new ArrayList<>();

        for(Years year : Years.values()) {
            res.add(year.getYearName());
        }

        return res;
    }

    public ArrayList<String> getLectures() {
        ArrayList<String> lectures =  new ArrayList<>();

        lectures.add("Math");
        lectures.add("Méca");
        lectures.add("Dyna");
        lectures.add("Elec");

        return lectures;
    }
}
