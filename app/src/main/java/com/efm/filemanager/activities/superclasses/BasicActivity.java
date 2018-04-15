package com.efm.filemanager.activities.superclasses;

import android.support.v7.app.AppCompatActivity;

import com.efm.filemanager.utils.application.AppConfig;
import com.efm.filemanager.utils.color.ColorPreference;
import com.efm.filemanager.utils.provider.UtilitiesProvider;
import com.efm.filemanager.utils.theme.AppTheme;

/**
 * Created by rpiotaix on 17/10/16.
 */
public class BasicActivity extends AppCompatActivity {

    protected AppConfig getAppConfig() {
        return (AppConfig) getApplication();
    }

    public ColorPreference getColorPreference() {
        return getAppConfig().getUtilsProvider().getColorPreference();
    }

    public AppTheme getAppTheme() {
        return getAppConfig().getUtilsProvider().getAppTheme();
    }

    public UtilitiesProvider getUtilsProvider() {
        return getAppConfig().getUtilsProvider();
    }
}
