package ph.akosikaelito.android.steam_status.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Bind;
import ph.akosikaelito.android.steam_status.R;
import ph.akosikaelito.android.steam_status.activities.MainActivity;
import ph.akosikaelito.android.steam_status.models.SteamService;
import ph.akosikaelito.android.steam_status.models.SteamServiceCategory;

/**
 * Created by johneris on 6/8/2015.
 */
public class SteamServiceRecyclerViewAdapter extends RecyclerView.Adapter<SteamServiceRecyclerViewAdapter.SteamServiceViewHolder> {

    private List<SteamServiceCategory> mSteamServicesCategory;
    private Context mContext;
    private MainActivity mMainActivity;

    public SteamServiceRecyclerViewAdapter(Context context, List<SteamServiceCategory> steamServiceCategories) {
        mContext = context;
        mSteamServicesCategory = steamServiceCategories;
        mMainActivity = (MainActivity) context;
    }

    @Override
    public SteamServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_steam_service, parent, false);
        SteamServiceViewHolder steamServiceViewHolder = new SteamServiceViewHolder(view);
        return steamServiceViewHolder;
    }

    @Override
    public void onBindViewHolder(final SteamServiceViewHolder holder, final int position) {
        final SteamServiceCategory steamServiceCategory = mSteamServicesCategory.get(position);

        holder.serviceNameTextView.setText(steamServiceCategory.name);

        holder.serviceCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.steamServicesLinearLayout.removeAllViews();
                if (holder.steamServicesLinearLayout.getVisibility() == View.GONE) {
                    for (SteamService steamService: steamServiceCategory.steamServices) {
                        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_steam_service_item, null);
                        TextView serviceNameTextView = (TextView) view.findViewById(R.id.serviceNameTextView);
                        TextView statusTextView = (TextView) view.findViewById(R.id.statusTextView);
                        TextView infoTextView = (TextView) view.findViewById(R.id.infoTextView);

                        serviceNameTextView.setText(steamService.title);
                        statusTextView.setText(steamService.status.toUpperCase());
                        infoTextView.setText(steamService.info);

                        if (steamService.info.toLowerCase().contains("no session")) {
                            infoTextView.setTextColor(ContextCompat.getColor(mContext, R.color.dark_yellow));
                        }

                        holder.steamServicesLinearLayout.addView(view);
                    }

                    RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(mContext) {
                        @Override protected int getVerticalSnapPreference() {
                            return LinearSmoothScroller.SNAP_TO_START;
                        }
                    };
                    smoothScroller.setTargetPosition(position);
                    mMainActivity.mServicesRecyclerView.getLayoutManager().startSmoothScroll(smoothScroller);

                    holder.steamServicesLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    holder.steamServicesLinearLayout.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSteamServicesCategory.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void changeData(List<SteamServiceCategory> steamServiceCategories) {
        mSteamServicesCategory = steamServiceCategories;
        notifyDataSetChanged();
    }

    public static class SteamServiceViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.steamServicesLinearLayout)
        LinearLayout steamServicesLinearLayout;

        @Bind(R.id.serviceNameTextView)
        TextView serviceNameTextView;

        @Bind(R.id.serviceCardView)
        CardView serviceCardView;

        SteamServiceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
