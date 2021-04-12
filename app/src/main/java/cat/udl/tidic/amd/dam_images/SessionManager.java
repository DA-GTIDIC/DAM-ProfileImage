package cat.udl.tidic.amd.dam_images;

import android.content.SharedPreferences;

public class SessionManager {

    private final SharedPreferences sharedPreferences;

    public SessionManager() {
        this.sharedPreferences = PreferencesProvider.providePreferences();
    }

    public void firstTimeAsking(String permission, boolean isFirstTime) {
        sharedPreferences.edit().putBoolean(permission, isFirstTime).apply();
    }

    public boolean isFirstTimeAsking(String permission) {
        return sharedPreferences.getBoolean(permission, true);
    }
}
