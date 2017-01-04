package hr.kmarkovic.coinman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hr.kmarkovic.coinman.interfaces.ApiListener;
import hr.kmarkovic.coinman.models.HNBrates;

public class DetailsActivity extends AppCompatActivity implements ApiListener<List<HNBrates>> {

    List<HNBrates> listResponse;
    HNBrates rate;
    String currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Log.i("DetailsActivity: ", "OK");

        currency = getIntent().getStringExtra("currency");

        App app = (App) getApplication();
        app.setApiListener(this);
        app.getRatesList();
        Toast.makeText(DetailsActivity.this, "Loading...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(List<HNBrates> response) {
        TextView dateText = (TextView)findViewById(R.id.date_text);
        TextView currencyText= (TextView)findViewById(R.id.currency_value_text);
        TextView buyText = (TextView)findViewById(R.id.buy_value_text);
        TextView medianText = (TextView)findViewById(R.id.median_value_text);
        TextView sellText = (TextView)findViewById(R.id.sell_value_text);

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());

        dateText.setText(formattedDate);

        for(HNBrates temp : response){
            if(temp.getCurrencyCode().equals(currency)){
                currencyText.setText(temp.getUnitValue() + " " + temp.getCurrencyCode());
                buyText.setText(temp.getBuyingRate());
                medianText.setText(temp.getMedianRate());
                sellText.setText(temp.getSellingRate());
            }
        }
    }

    @Override
    public void onFailure(String errorMessage) {
        Toast.makeText(this, "Error fetching rates", Toast.LENGTH_LONG);
        Log.i("Details", errorMessage);
    }
}
