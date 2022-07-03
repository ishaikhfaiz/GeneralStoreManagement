package mhssp.yfa.gsm;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class SellProdActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_sell_prod);
 }
 public void sellProduct(View v) {
 String name;
 int id,qty,shelfID,price;
 id = 
Integer.parseInt(((TextView)findViewById(R.id.spId)).getText().toStr
ing());
 qty = 
Integer.parseInt(((TextView)findViewById(R.id.spQty)).getText().toSt
ring());
 TextView res = ((TextView)findViewById(R.id.spResult));
 SQLiteDatabase db = 
openOrCreateDatabase("GSM",MODE_PRIVATE,null);
 Cursor rs = db.rawQuery("SELECT * FROM sqlite_master WHERE 
type='table' AND name='GSM';", null);
 rs.moveToFirst();
 if(rs.getCount()==0) {
 res.setText("You have No products yet, chose \"add a 
product\" from menu");
 return;
 }
 rs = db.rawQuery("SELECT * FROM GSM WHERE id="+id+";",null);
 rs.moveToFirst();
 if(rs.getCount()==0) {
 res.setText("Invalid ID");
 return;
 }
 name = rs.getString(1);
 int tmp = rs.getInt(2);
 shelfID = rs.getInt(3);
 price = rs.getInt(4);
 if(tmp==0) {
 res.setText(id+":"+name+" is not in stocks");
 return;
 }
 if((tmp-qty)<0) {
 res.setText(id+":"+name+" available qty is "+tmp+" 
only");
 return;
 }
 qty = tmp-qty;
 db.execSQL("UPDATE GSM SET qty="+qty+" WHERE id="+id);
 rs.close();
 res.setText(id+" : "+name+" is sold\n Amount: "+(price*(tmpqty)));
 }
}
