package shahzaib.com.jsonparsingbitcoin;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import shahzaib.com.jsonparsingbitcoin.Activities.MainActivity;

/**
 * Created by shahzaib on 4/15/2018.
 */

public class fetchData extends AsyncTask<Void,Void,Void> {
        String price = "";

    @Override
    protected void onPostExecute(Void aVoid) {
        MainActivity.textView.setText(price);

        super.onPostExecute(aVoid);
    }

    @Override
    protected Void doInBackground(Void... voids) {

        price = GetPrice();
        return null;
    }

    private String GetPrice() {
        String data = "";
        String singlepasre = "";
        String dataparse = "";

        try {
            URL url = new URL("https://api.coinmarketcap.com/v1/ticker/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            try {
                JSONArray jsonArray = new JSONArray(data);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    if (jsonObject.get("id").equals(MainActivity.spinner.getSelectedItem())) {
                        singlepasre = "Current_Price" + jsonObject.get("price_usd");
                    }

                }
                dataparse = dataparse + singlepasre;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return dataparse;
    }
}
