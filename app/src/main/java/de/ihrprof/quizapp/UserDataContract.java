package de.ihrprof.quizapp;

import android.provider.BaseColumns;

public final class UserDataContract {

    // Macht man den Konstruktor private, kann niemand versehentlich eine Instanz anlegen
    private UserDataContract() {
    }

    /* Eine innere Klasse definiert den Namen und die Spalten der Tabelle */
    public static class UserDataEntry implements BaseColumns {
        public static final String TABLE_NAME = "usage";
        public static final String COLUMN_NAME_USER = "user";
        public static final String COLUMN_NAME_TIME = "time";
    }
}
