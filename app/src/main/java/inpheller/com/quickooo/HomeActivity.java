package inpheller.com.quickooo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import inpheller.com.quickooo.adapter.TimeListAdapter;
import inpheller.com.quickooo.model.TimeOption;


public class HomeActivity extends Activity {

    ListView timeList;
    private ArrayAdapter<String> timeListAdapter;
    private Firebase myFirebaseRef;
    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        timeList = (ListView) findViewById(R.id.time_list_view);
        timeListAdapter = new ArrayAdapter<String>(this, R.layout.time_item, R.id.text_view, new String[]{"15 minutes", "30 minutes", "1 hour"});
        timeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(getClass().getSimpleName(), "Clicked item");

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, "ooo.br@arctouch.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "[OOO] I'll be out for " + timeListAdapter.getItem(position));
                intent.putExtra(Intent.EXTRA_TEXT, "Hello guys,\n\nI'll be out for " + timeListAdapter.getItem(position)
                        + ". I'll be available by the usual means.\n\nThanks,\n\nBruno Pinheiro");

                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
        timeList.setAdapter(timeListAdapter);
    }

    private Firebase getService() {
        if (myFirebaseRef == null) {
            Firebase.setAndroidContext(this);
            myFirebaseRef = new Firebase("https://quickooo.firebaseio.com");
        }

        return myFirebaseRef;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_option) {
            TimeOption timeOption = new TimeOption("Fast", (count = count + 5) + " minutes", "I'll be back soon");
            getService().push().setValue(timeOption, new Firebase.CompletionListener() {

                @Override
                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                    Toast.makeText(HomeActivity.this, "New Value added", Toast.LENGTH_SHORT).show();
                }
            });

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
