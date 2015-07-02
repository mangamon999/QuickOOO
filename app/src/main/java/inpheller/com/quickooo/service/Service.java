package inpheller.com.quickooo.service;

import android.content.Context;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Collection;

import inpheller.com.quickooo.model.TimeOption;

/**
 * Created by brunopinheiro on 6/2/15.
 */
public abstract class Service<T> {
    public static final String FIREBASE_BASE_URL = "https://quickooo.firebaseio.com";
    private final Firebase myFirebaseRef;

    protected Service(Context context) {
        Firebase.setAndroidContext(context);
        myFirebaseRef = new Firebase(FIREBASE_BASE_URL);
    }

    public abstract String getPath();

    public abstract void save(T timeOption);

    public abstract void fetchAll(FetchCompletionHandler<T> completionHandler);

    public Firebase getFirebaseRef() {
        return myFirebaseRef.child(getPath());
    }

    public interface FetchCompletionHandler<T> {
        void onSuccess(ArrayList<T> items);
        void onFailure(String errorMessage);
    }
}
