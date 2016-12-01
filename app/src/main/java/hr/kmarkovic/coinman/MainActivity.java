package hr.kmarkovic.coinman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hr.kmarkovic.coinman.adapters.RatesListAdapter;
import hr.kmarkovic.coinman.interfaces.HNBservice;
import hr.kmarkovic.coinman.models.HNBrates;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String URL = "http://hnbex.eu/api/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App app = (App) getApplication();
        List<HNBrates> listRates = app.getRatesList();

        for(HNBrates temp : listRates){
            System.out.println(temp.getCurrencyCode());
        }

        if(!listRates.isEmpty()){
            RatesListAdapter adapter = new RatesListAdapter(this, listRates);
            ListView listView = (ListView)findViewById(R.id.listMain);
            listView.setAdapter(adapter);
        }
        else{
            Toast.makeText(this, "Error fetching exchange rates!", Toast.LENGTH_LONG).show();
        }
    }
}
