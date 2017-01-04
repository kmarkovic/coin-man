package hr.kmarkovic.coinman.interfaces;


/**
 * Created by Kristian on 4.1.2017..
 */

public interface ApiListener<T> {
    void onSuccess(T response);
    void onFailure(String errorMessage);
}
