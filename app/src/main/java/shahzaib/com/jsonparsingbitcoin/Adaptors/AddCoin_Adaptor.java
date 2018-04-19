package shahzaib.com.jsonparsingbitcoin.Adaptors;

/**
 * Created by shahzaib on 4/18/2018.
 */
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import shahzaib.com.jsonparsingbitcoin.Model.AddCoin_Model;
import shahzaib.com.jsonparsingbitcoin.R;

public class AddCoin_Adaptor extends RecyclerView.Adapter<AddCoin_Adaptor.ViewHolder> {

    ArrayList<AddCoin_Model> menu_models,itemcopy;
    private Context context;



    public AddCoin_Adaptor(ArrayList<AddCoin_Model> menu_models, Context context) {
        this.menu_models = menu_models;
        this.context = context;
    }

    @Override
    public AddCoin_Adaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.addcoin_item, parent, false));
    }

    @Override
    public void onBindViewHolder(AddCoin_Adaptor.ViewHolder holder, int position) {
        AddCoin_Model menu_model = menu_models.get(position);
        holder.name.setText(menu_model.getCoin_Name());
        holder.nickname.setText(menu_model.getNick_name());
        holder.profilePic.setImageResource(menu_model.getCoin_Image());

    }

    @Override
    public int getItemCount() {
        return menu_models.size();
    }
    public void filterlist (ArrayList<AddCoin_Model> addCoin_models){
        menu_models = addCoin_models;
        notifyDataSetChanged();
    }


  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView profilePic;
        TextView name,nickname;


        public ViewHolder(View itemView) {
            super(itemView);
            profilePic = (ImageView) itemView.findViewById(R.id.coinimage);
            name = (TextView) itemView.findViewById(R.id.coinname);
            nickname = itemView.findViewById(R.id.nickname);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
       public  void filter(String text) {
        menu_models.clear();
        if(text.isEmpty()){
            menu_models.addAll(itemcopy);
        } else{
            text = text.toLowerCase();
            for(AddCoin_Model item: itemcopy){
                if(item.getCoin_Name().toLowerCase().contains(text) || item.getNick_name().toLowerCase().contains(text)){
                    menu_models.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

}
