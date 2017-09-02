package ph.akosikaelito.android.steam_status;

import com.ivankocijan.magicviews.MagicViews;

/**
 * Created by johneris on 6/5/2015.
 */
public class App extends com.activeandroid.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MagicViews.setFontFolderPath(this, "fonts");
    }

}
