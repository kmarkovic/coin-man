package hr.kmarkovic.coinman.interfaces;

import java.util.List;

import hr.kmarkovic.coinman.models.HNBrates;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by Kristian on 1.12.2016..
 */

public interface HNBservice {

    @GET("rates/daily/")
    Call<List<HNBrates>> getRates();

}
