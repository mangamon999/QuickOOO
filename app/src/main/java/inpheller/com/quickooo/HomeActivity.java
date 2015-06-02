package inpheller.com.quickooo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;

import inpheller.com.quickooo.adapter.TimeListAdapter;


public class HomeActivity extends Activity {

    ListView timeList;
    private ArrayAdapter<String> timeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://dazzling-fire-8331.firebaseio.com/#-JqlwagCR6--XTmm1UIY|1496887f38c81997f0f4190a5f0ba44b");

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
