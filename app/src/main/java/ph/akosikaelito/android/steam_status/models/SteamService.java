package ph.akosikaelito.android.steam_status.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by johneris on 6/5/2015.
 */
@Table(name = "SteamService")
public class SteamService extends Model {

    @Expose
    @SerializedName("login")
    @Column(name = "user_name")
    public String userName;

    @Expose
    @SerializedName("contributions")
    @Column(name = "contributions")
    public int contributions;

    @Expose
    @SerializedName("avatar_url")
    @Column(name = "avatar_url")
    public String avatarUrl;

    public SteamService() {
        super();    // required by ActiveAndroid
    }

}
