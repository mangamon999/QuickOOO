package inpheller.com.quickooo.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import inpheller.com.quickooo.HomeActivity;
import inpheller.com.quickooo.model.TimeOption;

/**
 * Created by brunopinheiro on 5/24/15.
 */
public class TimeListAdapter extends ArrayAdapter<String> {

    public TimeListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    public TimeListAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public TimeListAdapter(HomeActivity homeActivity, int time_item, int text_view, String[] strings) {
        super(homeActivity, time_item, text_view, strings);
    }
}
