package mhssp.yfa.gsm;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class AddProdActivity extends AppCompatActivity {
 SQLiteDatabase db;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_add_prod);
 db = openOrCreateDatabase("GSM",MODE_PRIVATE,null);
 Cursor rs = db.rawQuery("SELECT * FROM sqlite_master where 
type='table' and name='GSM';", null);
 rs.moveToFirst();
 String id;
((TextView)findViewById(R.id.apResult)).setText(String.valueOf(rs.ge
tCount()));
 if(rs.getCount()==0){
 id="0";
 }
 else {
 rs = db.rawQuery("SELECT id FROM GSM;",null);
 rs.moveToLast();
 int tmp = rs.getInt(0)+1;
 id = String.valueOf(tmp);
 }
 rs.close();
 ((TextView)findViewById(R.id.apId)).setText(id);
 }
 public void addProduct(View v){
 String name;
 int id,qty,shelfID,price;
 id = Integer.parseInt 
(((TextView)findViewById(R.id.apId)).getText().toString());
 name = 
((TextView)findViewById(R.id.apName)).getText().toString();
 qty = 
Integer.parseInt(((TextView)findViewById(R.id.apQty)).getText().toSt
ring());
 shelfID = 
Integer.parseInt(((TextView)findViewById(R.id.apShelfID)).getText().
toString());
 price = 
Integer.parseInt(((TextView)findViewById(R.id.apPrice)).getText().to
String());
 db.execSQL("CREATE TABLE IF NOT EXISTS GSM(id INTEGER, name 
VARCHAR, qty INTEGER, shelfID INTEGER, price INTEGER);");
 db.execSQL("INSERT INTO GSM VALUES('" + id + "','" + name + 
"','" + qty + "','" + shelfID + "','" + price + "');");
 ((TextView) findViewById(R.id.apResult)).setText(name + " 
has been added with id: " + id);
 }
}
