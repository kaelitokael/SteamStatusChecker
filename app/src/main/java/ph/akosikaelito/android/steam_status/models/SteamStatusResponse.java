package ph.akosikaelito.android.steam_status.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

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

    @SerializedName("services")
    public JsonObject services;

    public String getTime() {
        return new SimpleDateFormat("MMMM dd, yyyy HH:mm").format(new Date(this.time));
    }

    public ArrayList<SteamService> getSteamServices() {
        ArrayList<SteamService> steamServices = new ArrayList<>();
        for (Map.Entry<String, JsonElement> entry : this.services.entrySet()) {

            if (entry.getValue() instanceof JsonObject) {

                JsonObject jsonObject = entry.getValue().getAsJsonObject();

                String title = entry.getKey();
                String info = jsonObject.get("title").getAsString();
                String status = jsonObject.get("status").getAsString();
                SteamService steamService = new SteamService(status, title, info);
                steamServices.add(steamService);
            }
        }
        return steamServices;
    }
}
