package ph.akosikaelito.android.steam_status.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by johneris on 6/5/2015.
 */
public class SteamService {

    public String status;

    public String title;

    public String info;

    public SteamService(String status, String title, String info) {
        this.status = status;
        this.title = title;
        this.info = info;
    }

}
