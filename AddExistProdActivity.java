package mhssp.yfa.gsm;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class AddExistProdActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_add_exist_prod);
 }
 public void addExistProduct(View v){
 String name;
 int id,qty,shelfID,price;
 id = 
Integer.parseInt(((TextView)findViewById(R.id.aepId)).getText().toSt
ring());
 qty = 
Integer.parseInt(((TextView)findViewById(R.id.aepQty)).getText().toS
tring());
 price = 
Integer.parseInt(((TextView)findViewById(R.id.aepPrice)).getText().t
oString());
 TextView res = ((TextView)findViewById(R.id.aepResult));
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
 shelfID = rs.getInt(3);
 int tmp = rs.getInt(2);
 qty = tmp+qty;
 db.execSQL("UPDATE GSM SET qty="+qty+", price="+price+" 
WHERE id="+id);
 rs.close();
 res.setText(name+" has been added with id: "+id+"\n Put it 
in shelf: "+shelfID);
 }
}
