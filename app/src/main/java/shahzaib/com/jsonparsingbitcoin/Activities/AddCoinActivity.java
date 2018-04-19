package shahzaib.com.jsonparsingbitcoin.Activities;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

import shahzaib.com.jsonparsingbitcoin.Adaptors.AddCoin_Adaptor;
import shahzaib.com.jsonparsingbitcoin.Model.AddCoin_Model;
import shahzaib.com.jsonparsingbitcoin.R;
import shahzaib.com.jsonparsingbitcoin.SimpleDividerItemDecoration;

public class AddCoinActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    RecyclerView postsList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<AddCoin_Model> arrayList, itemcopy;
    ArrayList<String> names;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coin);


        postsList = (RecyclerView) findViewById(R.id.fr);
        postsList.addItemDecoration(new SimpleDividerItemDecoration(this));
        layoutManager = new LinearLayoutManager(getApplicationContext());

        itemcopy = new ArrayList<>();
        arrayList = new ArrayList<>();
        adapter = new AddCoin_Adaptor(arrayList, this);

        postsList.setLayoutManager(layoutManager);

        arrayList.add(new AddCoin_Model(R.drawable.btc, "BitCoin", "BTC"));
        arrayList.add(new AddCoin_Model(R.drawable.eth, "Ethereum", "ETH"));
        arrayList.add(new AddCoin_Model(R.drawable.ric, "Ripple", "XRP"));
        arrayList.add(new AddCoin_Model(R.drawable.bch, "Bitcoin Cash", "BCH"));
        arrayList.add(new AddCoin_Model(R.drawable.ltc, "Litecoin", "LTC"));
        arrayList.add(new AddCoin_Model(R.drawable.eos, "EOS", "EOS"));
        arrayList.add(new AddCoin_Model(R.drawable.ada, "Cardano", "ADA"));
        arrayList.add(new AddCoin_Model(R.drawable.xlm, "Stellar", "XLM"));
        arrayList.add(new AddCoin_Model(R.drawable.neo, "NEO", "NEO"));
        arrayList.add(new AddCoin_Model(R.drawable.miota, "IOTA", "MIOTA"));
        arrayList.add(new AddCoin_Model(R.drawable.xmr, "Monero", "XMR"));
        arrayList.add(new AddCoin_Model(R.drawable.xem, "NEM", "XEM"));
        arrayList.add(new AddCoin_Model(R.drawable.dash, "Dash", "DASH"));
        arrayList.add(new AddCoin_Model(R.drawable.trx, "TRON", "TRX"));
        arrayList.add(new AddCoin_Model(R.drawable.usdt, "Tether", "USDT"));
        arrayList.add(new AddCoin_Model(R.drawable.ven, "VeChain", "VEN"));
        arrayList.add(new AddCoin_Model(R.drawable.etc, "Ethereum Classic", "ETC"));
        arrayList.add(new AddCoin_Model(R.drawable.qtum, "Qtum", "QTUM"));
        arrayList.add(new AddCoin_Model(R.drawable.omg, "OmiseGo", "OMG"));
        arrayList.add(new AddCoin_Model(R.drawable.bnb, "Binance-Coin", "BNB"));
        arrayList.add(new AddCoin_Model(R.drawable.icx, "Icon", "ICX"));
        arrayList.add(new AddCoin_Model(R.drawable.lsk, "Lisk", "LSK"));
        arrayList.add(new AddCoin_Model(R.drawable.xvg, "Verge", "XVG"));


        postsList.setAdapter(adapter);


    }
    private void filter(String text){
        ArrayList<AddCoin_Model> items = new ArrayList<>();
        for(AddCoin_Model a:arrayList){
            if(a.getCoin_Name().toLowerCase().contains(text.toLowerCase()) || a.getNick_name().toLowerCase().contains(text.toLowerCase())){
                items.add(a);
            }

        }
        adapter = new AddCoin_Adaptor(items, AddCoinActivity.this);
        postsList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        filter(newText);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
