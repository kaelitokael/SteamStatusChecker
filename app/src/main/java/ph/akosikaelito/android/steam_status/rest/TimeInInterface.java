package ph.akosikaelito.android.steam_status.rest;

import com.google.gson.JsonObject;

import retrofit.http.POST;
import retrofit2.Call;
import retrofit2.http.Body;

/**
 * Created by willm on 3/2/2017.
 */

public interface TimeInInterface {

    @POST("/repos/")
    Call<JsonObject> timeInUser(
            @Body JsonObject jsonObject
    );

}
