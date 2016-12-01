package hr.kmarkovic.coinman.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import hr.kmarkovic.coinman.R;
import hr.kmarkovic.coinman.models.HNBrates;

/**
 * Created by Kristian on 1.12.2016..
 */

public class RatesListAdapter extends ArrayAdapter<HNBrates> {
    public RatesListAdapter(Context context, List<HNBrates> ratesList) {
        super(context, 0, ratesList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HNBrates rate = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_basic, parent, false);
        }

        TextView currencyText = (TextView)convertView.findViewById(R.id.text_currency);
        currencyText.setText(rate.getCurrencyCode());

        return convertView;
    }
}
