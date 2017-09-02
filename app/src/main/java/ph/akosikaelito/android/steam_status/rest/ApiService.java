package ph.akosikaelito.android.steam_status.rest;

import java.util.List;

import ph.akosikaelito.android.steam_status.models.SteamService;
import ph.akosikaelito.android.steam_status.models.SteamStatusResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by johneris on 6/5/2015.
 */
public interface ApiService {

    @GET("/Barney")
    Call<SteamStatusResponse> getSteamStatus();

}
