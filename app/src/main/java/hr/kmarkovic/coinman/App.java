package hr.kmarkovic.coinman;

import android.app.Application;
import android.app.ProgressDialog;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import hr.kmarkovic.coinman.interfaces.ApiListener;
import hr.kmarkovic.coinman.interfaces.HNBservice;
import hr.kmarkovic.coinman.models.HNBrates;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kristian on 1.12.2016..
 */

public class App extends Application{
    private String url = "http://hnbex.eu/api/v1/";
    private HNBservice apiService;
    private Retrofit retrofit;
    private List<HNBrates> resultList;
    private ApiListener apiListener;
    private ProgressDialog pDialog;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(HNBservice.class);
    }

    public void setApiListener(ApiListener apiListener) {
        this.apiListener = apiListener;
    }

    public void removeApiListener(){
        this.apiListener = null;
    }

    public void getRatesList() {
        apiService.getRates().enqueue(new Callback<List<HNBrates>>() {
            @Override
            public void onResponse(Call<List<HNBrates>> call, Response<List<HNBrates>> response) {
                if (response.isSuccessful()) {
                    apiListener.onSuccess(response.body());
                } else {
                    apiListener.onFailure(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<HNBrates>> call, Throwable t) {
                Log.i("getRatesList", t.getMessage());
            }
        });
    }
}
