package systems.texture.alize.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import rx.Observable;
import systems.texture.alize.model.common.PaperspaceAccount;
import systems.texture.alize.model.paperspace.Login;

public final class SharedPrefUtil {
    private static final String PREF_NAME = "systems_texture_alize_prefs";
    private static final String PAPERSPACE_API_KEY_KEY = "paperspace_api_key";
    private static final String PAPERSPACE_ACCOUNTS = "paperspace_accounts";

    private SharedPrefUtil() {}

    public static Set<PaperspaceAccount> getPaperspaceAccounts(Context context) {
        Set<String> accountStringSets = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getStringSet(PAPERSPACE_ACCOUNTS, null);
        if (accountStringSets != null) {
            Gson gson = new Gson();
            Set<PaperspaceAccount> paperspaceAccountSet = new HashSet<>();
            for (String accountString : accountStringSets)
                paperspaceAccountSet.add(gson.fromJson(accountString, PaperspaceAccount.class));
            return paperspaceAccountSet;
        }
        return null;
    }

    public static void setPaperspaceAccounts(Context context, Set<PaperspaceAccount> paperspaceAccountSet) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        Set<String> paperspaceAccountStringSet = new HashSet<>();
        for (PaperspaceAccount paperspaceAccount : paperspaceAccountSet)
            paperspaceAccountStringSet.add(gson.toJson(paperspaceAccount));
        editor.putStringSet(PAPERSPACE_ACCOUNTS, paperspaceAccountStringSet);
        editor.apply();
    }

    public static void setPaperspaceAPIKey(Context context, String apiKey) {
        SharedPreferences.Editor editor =
                context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(PAPERSPACE_API_KEY_KEY, apiKey);
        editor.apply();
    }

    public static void addPaperspaceAccount(Context context, PaperspaceAccount account) {
        Set<PaperspaceAccount> paperspaceAccountSet = getPaperspaceAccounts(context);
        if (paperspaceAccountSet == null)
            paperspaceAccountSet = new HashSet<>();
        paperspaceAccountSet.add(account);
        setPaperspaceAccounts(context, paperspaceAccountSet);
    }

    public static String getPaperspaceAPIKey(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(PAPERSPACE_API_KEY_KEY, null);
    }

}
