package ph.akosikaelito.android.steam_status.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by willm on 9/2/2017.
 */

public class SteamStatusResponse implements Serializable {

    @SerializedName("status")
    public boolean status;

    @SerializedName("time")
    private Long time;

    @SerializedName("online")
    public int online;

    @SerializedName("online_info")
    public String onlineInfo;

    public String getTime() {

        return new SimpleDateFormat("MMMM dd, yyyy HH:mm").format(new Date(this.time));
    }
}
