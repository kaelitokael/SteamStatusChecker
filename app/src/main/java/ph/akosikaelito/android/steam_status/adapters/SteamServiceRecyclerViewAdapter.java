package ph.akosikaelito.android.steam_status.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Bind;
import ph.akosikaelito.android.steam_status.R;
import ph.akosikaelito.android.steam_status.models.SteamService;

/**
 * Created by johneris on 6/8/2015.
 */
public class SteamServiceRecyclerViewAdapter extends RecyclerView.Adapter<SteamServiceRecyclerViewAdapter.SteamServiceViewHolder> {

    List<SteamService> mSteamServices;
    private Context mContext;

    public SteamServiceRecyclerViewAdapter(Context context, List<SteamService> steamService) {
        mContext = context;
        mSteamServices = steamService;
    }

    @Override
    public SteamServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_steam_service, parent, false);
        SteamServiceViewHolder steamServiceViewHolder = new SteamServiceViewHolder(view);
        return steamServiceViewHolder;
    }

    @Override
    public void onBindViewHolder(SteamServiceViewHolder holder, int position) {
        SteamService steamService = mSteamServices.get(position);

        holder.serviceNameTextView.setText(steamService.title);
        holder.statusTextView.setText(steamService.status);
        holder.infoTextView.setText(steamService.info);
    }

    @Override
    public int getItemCount() {
        return mSteamServices.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void changeData(List<SteamService> contributors) {
        mSteamServices = contributors;
        notifyDataSetChanged();
    }

    public static class SteamServiceViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.serviceNameTextView)
        TextView serviceNameTextView;

        @Bind(R.id.statusTextView)
        TextView statusTextView;

        @Bind(R.id.infoTextView)
        TextView infoTextView;

        SteamServiceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
