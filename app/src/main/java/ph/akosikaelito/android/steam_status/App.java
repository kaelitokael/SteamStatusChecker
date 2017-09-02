package ph.akosikaelito.android.steam_status;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ivankocijan.magicviews.MagicViews;

/**
 * Created by johneris on 6/5/2015.
 */
public class App extends com.activeandroid.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MagicViews.setFontFolderPath(this, "fonts");
    }

    public static void setDefaultRecyclerView(Context context, RecyclerView recyclerView, RecyclerView.Adapter face) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(face);
        face.notifyDataSetChanged();
    }

    public static void setDefaultHorizontalRecyclerView(Context context, RecyclerView recyclerView, RecyclerView.Adapter face) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(face);
        face.notifyDataSetChanged();
    }


}
