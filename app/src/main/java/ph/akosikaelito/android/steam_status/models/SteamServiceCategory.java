package ph.akosikaelito.android.steam_status.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by willm on 9/2/2017.
 */

public class SteamServiceCategory implements Serializable {

    public String name;
    public ArrayList<SteamService> steamServices;

    public SteamServiceCategory(String name, ArrayList<SteamService> steamServices) {
        this.name = name;
        this.steamServices = steamServices;
    }

}
