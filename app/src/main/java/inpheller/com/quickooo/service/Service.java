package inpheller.com.quickooo.service;

import android.content.Context;

import com.firebase.client.Firebase;

import java.util.ArrayList;

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

    abstract void save(T timeOption);

    abstract ArrayList<T> fetchAll();

    public Firebase getFirebaseRef() {
        return myFirebaseRef;
    }
}
