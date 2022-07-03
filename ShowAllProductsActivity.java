package mhssp.yfa.gsm;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
public class ShowAllProductsActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_show_all_products);
 String name;
 int id,qty,shelfID,price;
 try {
 TableLayout res = (TableLayout) 
findViewById(R.id.allProdTable);
 SQLiteDatabase db = openOrCreateDatabase("GSM", 
MODE_PRIVATE, null);
 Cursor rs = db.rawQuery("SELECT * FROM sqlite_master 
WHERE type='table' AND name='GSM';", null);
 rs.moveToFirst();
 if (rs.getCount() == 0) {
 //Toast.makeText(getApplicationContext(), "trStart", 
Toast.LENGTH_SHORT).show();
 TableRow tr = new TableRow(getApplicationContext());
 //Toast.makeText(getApplicationContext(), "trEnd", 
Toast.LENGTH_SHORT).show();
 TextView resV = new 
TextView(getApplicationContext());
 resV.setText("You have No products yet, chose \"add 
a product\" from menu");
 tr.addView(resV);
 res.addView(tr);
 return;
 }
 rs = db.rawQuery("SELECT * FROM GSM;", null);
 rs.moveToPosition(-1);
 TableRow th = new TableRow(getApplicationContext());
 th.setBackgroundColor(Color.GRAY);
 TextView idhV = new TextView(getApplicationContext());
 idhV.setText("ID");
 TextView namehV = new TextView(getApplicationContext());
 namehV.setText("Name");
 TextView qtyhV = new TextView(getApplicationContext());
 qtyhV.setText("Quantity");
 TextView shelfhV = new 
TextView(getApplicationContext());
 shelfhV.setText("Shelf ID");
 TextView pricehV = new 
TextView(getApplicationContext());
 pricehV.setText("Price");
 th.addView(idhV);
 th.addView(namehV);
 th.addView(qtyhV);
 th.addView(shelfhV);
 th.addView(pricehV);
 res.addView(th);
 while (rs.moveToNext()) {
 TableRow tr = new TableRow(getApplicationContext());
 TextView idV = new 
TextView(getApplicationContext());
 idV.setText(rs.getString(0));
 TextView nameV = new 
TextView(getApplicationContext());
 nameV.setText(rs.getString(1));
 TextView qtyV = new 
TextView(getApplicationContext());
 qtyV.setText(rs.getString(2));
 TextView shelfV = new 
TextView(getApplicationContext());
 shelfV.setText(rs.getString(3));
 TextView priceV = new 
TextView(getApplicationContext());
 priceV.setText(rs.getString(4));
 tr.addView(idV);
 tr.addView(nameV);
 tr.addView(qtyV);
 tr.addView(shelfV);
 tr.addView(priceV);
 res.addView(tr);
 }
 rs.close();
 }
 catch(Exception e){
 //Toast.makeText(getApplicationContext(), e.toString(), 
Toast.LENGTH_SHORT).show();
 }
 }
}
