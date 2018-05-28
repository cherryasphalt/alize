package systems.texture.alize.util;

import android.content.Context;
import android.content.SharedPreferences;

import systems.texture.alize.model.paperspace.Login;

public final class SharedPrefUtil {
    private static final String PREF_NAME = "systems_texture_alize_prefs";
    private static final String PAPERSPACE_API_KEY_KEY = "paperspace_api_key";

    private SharedPrefUtil() {}

    public static void setPaperspaceAPIKey(Context context, Login login) {
        SharedPreferences.Editor editor =
                context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(PAPERSPACE_API_KEY_KEY, login.getId());
        editor.apply();
    }

    public static String getPaperspaceAPIKey(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(PAPERSPACE_API_KEY_KEY, null);
    }

}
