package mhssp.yfa.gsm;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class OutOfStockActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_out_of_stock);
 String name;
 int id,qty,shelfID,price;
 TextView res = ((TextView)findViewById(R.id.oosRes));
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
 rs = db.rawQuery("SELECT * FROM GSM;",null);
 rs.moveToPosition(-1);
 Boolean flag = true;
 while(rs.moveToNext()){
 id = rs.getInt(0);
 name = rs.getString(1);
 qty =rs.getInt(2);
 shelfID=rs.getInt(3);
 price=rs.getInt(4);
 if(qty<=0){
 flag =false;
 res.setText(id+ " : "+name+" with price: "+price+" 
in shelf: "+shelfID+" is out of stock\n\n");
 }
 }
 if(flag){
 res.setText("No Products are out of stock");
 }
 rs.close();
 }
}
