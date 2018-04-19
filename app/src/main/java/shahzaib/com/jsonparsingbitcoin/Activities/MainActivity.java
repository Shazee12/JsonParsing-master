package shahzaib.com.jsonparsingbitcoin.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import shahzaib.com.jsonparsingbitcoin.R;
import shahzaib.com.jsonparsingbitcoin.fetchData;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static Spinner spinner;
    public  static TextView textView;
    private static final String[]paths = {"bitcoin", "ethereum", "ripple"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.btn);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
               execute();

                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
              execute();
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
               execute();
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void execute() {
        fetchData fetchData = new fetchData();
        fetchData.execute();
    }
}
