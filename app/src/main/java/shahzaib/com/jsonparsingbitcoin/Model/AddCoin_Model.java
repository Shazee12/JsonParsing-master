package shahzaib.com.jsonparsingbitcoin.Model;

/**
 * Created by shahzaib on 4/18/2018.
 */

public class AddCoin_Model {
       int Coin_Image;
       String Coin_Name,Nick_name;

    public AddCoin_Model(int coin_Image, String coin_Name, String nick_name) {
        Coin_Image = coin_Image;
        Coin_Name = coin_Name;
        Nick_name = nick_name;
    }

    public AddCoin_Model() {
    }

    public int getCoin_Image() {
        return Coin_Image;
    }

    public void setCoin_Image(int coin_Image) {
        Coin_Image = coin_Image;
    }

    public String getCoin_Name() {
        return Coin_Name;
    }

    public void setCoin_Name(String coin_Name) {
        Coin_Name = coin_Name;
    }

    public String getNick_name() {
        return Nick_name;
    }

    public void setNick_name(String nick_name) {
        Nick_name = nick_name;
    }
}
