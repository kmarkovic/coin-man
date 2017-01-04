package hr.kmarkovic.coinman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hr.kmarkovic.coinman.adapters.RatesListAdapter;
import hr.kmarkovic.coinman.interfaces.ApiListener;
import hr.kmarkovic.coinman.interfaces.HNBservice;
import hr.kmarkovic.coinman.models.HNBrates;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ApiListener<List<HNBrates>>{

    private final String URL = "http://hnbex.eu/api/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity: ", "OK");

        App app = (App) getApplication();
        app.setApiListener(this);
        app.getRatesList();
    }

    @Override
    public void onSuccess(List<HNBrates> response) {
        RatesListAdapter adapter = new RatesListAdapter(this, response);
        ListView listView = (ListView)findViewById(R.id.listMain);
        listView.setAdapter(adapter);
    }

    @Override
    public void onFailure(String errorMessage) {
        Toast.makeText(this, "Error fetching rates", Toast.LENGTH_LONG);
        Log.i("Main", errorMessage);
    }
}
