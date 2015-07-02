package inpheller.com.quickooo.service;

import android.content.Context;

import com.fasterxml.jackson.core.type.TypeReference;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.GenericTypeIndicator;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import inpheller.com.quickooo.model.Subject;

/**
 * Created by brunopinheiro on 7/1/15.
 */
public class SubjectService extends Service<Subject> {

    private static String path = "subjects";

    public SubjectService(Context context) {
        super(context);
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void save(Subject subject) {
        getFirebaseRef().push().setValue(subject);
    }

    @Override
    public void fetchAll(final FetchCompletionHandler<Subject> completionHandler) {
        Firebase subjectsRef = getFirebaseRef();

        subjectsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {


                HashMap<String, Subject> value = snapshot.getValue(new GenericTypeIndicator<HashMap<String, Subject>>() {});
//                completionHandler.onSuccess((ArrayList<Subject>) value.values());
                Object stringSubjectHashMap = value.values().iterator().next();
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}
