package ph.akosikaelito.android.steam_status.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.coreproc.android.kitchen.Kitchen;
import com.coreproc.android.kitchen.utils.KitchenRestClient;

import java.util.ArrayList;

import butterknife.Bind;
import ph.akosikaelito.android.steam_status.App;
import ph.akosikaelito.android.steam_status.R;
import ph.akosikaelito.android.steam_status.adapters.SteamServiceRecyclerViewAdapter;
import ph.akosikaelito.android.steam_status.models.SteamService;
import ph.akosikaelito.android.steam_status.models.SteamServiceCategory;
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

    @Bind(R.id.servicesRecyclerView)
    public RecyclerView mServicesRecyclerView;

    // RETROFIT
    private Call<SteamStatusResponse> mSteamStatusResponseCall;
    private SteamStatusResponse mSteamStatusResponse;

    private ArrayList<SteamService> mSteamServices;


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
        if (mSteamStatusResponseCall != null)
            mSteamStatusResponseCall.cancel();

        ApiService apiService = KitchenRestClient.create(mContext, ApiService.class, false);
        mSteamStatusResponseCall = apiService.getSteamStatus();
        mSteamStatusResponseCall.enqueue(new Callback<SteamStatusResponse>() {
            @Override
            public void onResponse(Call<SteamStatusResponse> call, Response<SteamStatusResponse> response) {
                if (!response.isSuccessful()) {
                    return;
                }

                mSteamStatusResponse = response.body();
                initSteamServices();
            }

            @Override
            public void onFailure(Call<SteamStatusResponse> call, Throwable t) {

            }
        });

    }

    private void initSteamServices() {

        ArrayList<SteamServiceCategory> steamServiceCategories = new ArrayList<>();
        SteamServiceCategory steamServiceCategory = new SteamServiceCategory("Dota2", mSteamStatusResponse.getDota2Services());
        steamServiceCategories.add(steamServiceCategory);

        steamServiceCategory = new SteamServiceCategory("CSGO", mSteamStatusResponse.getCsGoServices());
        steamServiceCategories.add(steamServiceCategory);

        steamServiceCategory = new SteamServiceCategory("Other Services", mSteamStatusResponse.getSteamServices());
        steamServiceCategories.add(steamServiceCategory);

        SteamServiceRecyclerViewAdapter steamServiceRecyclerViewAdapter =
                new SteamServiceRecyclerViewAdapter(mContext, steamServiceCategories);
        App.setDefaultRecyclerView(mContext, mServicesRecyclerView, steamServiceRecyclerViewAdapter);
    }


}
