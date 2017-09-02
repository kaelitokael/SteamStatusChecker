package ph.akosikaelito.android.steam_status.activities;

import android.content.Intent;
import android.os.Bundle;

import com.coreproc.android.kitchen.utils.KitchenRestClient;

import ph.akosikaelito.android.steam_status.R;
import ph.akosikaelito.android.steam_status.models.SteamStatusResponse;
import ph.akosikaelito.android.steam_status.rest.ApiService;
import ph.akosikaelito.android.steam_status.utils.UiUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by johneris on 6/1/2015.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();

    }

    private void initialize() {

        ApiService apiService = KitchenRestClient.create(mContext, ApiService.class, false);
        Call<SteamStatusResponse> steamStatusResponseCall = apiService.getSteamStatus();
        steamStatusResponseCall.enqueue(new Callback<SteamStatusResponse>() {
            @Override
            public void onResponse(Call<SteamStatusResponse> call, Response<SteamStatusResponse> response) {
                if (!response.isSuccessful()) {
                    return;
                }

                

            }

            @Override
            public void onFailure(Call<SteamStatusResponse> call, Throwable t) {

            }
        });

    }




}
