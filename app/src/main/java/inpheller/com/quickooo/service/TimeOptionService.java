package inpheller.com.quickooo.service;

import android.content.Context;

import java.util.ArrayList;

import inpheller.com.quickooo.model.TimeOption;

/**
 * Created by brunopinheiro on 6/2/15.
 */
public class TimeOptionService extends Service<TimeOption> {

    private String path = "options";

    private TimeOptionService(Context context) {
        super(context);

    }

    public static TimeOptionService createWithContext(Context context) {
        return new TimeOptionService(context);
    }

    @Override
    public void save(TimeOption timeOption) {
        getFirebaseRef().push().setValue(timeOption);
    }

    @Override
    public void fetchAll(FetchCompletionHandler<TimeOption> completionHandler) {
        getFirebaseRef().child(getPath());
    }

    @Override
    public String getPath() {
        return path;
    }
}
