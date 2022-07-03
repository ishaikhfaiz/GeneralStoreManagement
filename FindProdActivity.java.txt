package mhssp.yfa.gsm;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class FindProdActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_find_prod);
 }
 public void findProduct(View v){
 String name="";
 int id=0,qty,shelfID,price;
 int f=0;
 
if(((TextView)findViewById(R.id.fpId)).getText().length()!=0){
 id = 
Integer.parseInt(((TextView)findViewById(R.id.fpId)).getText().toStr
ing());
 f =1;
 }
 
if(((TextView)findViewById(R.id.fpName)).getText().length()!=0){
 f=2;
 name = 
((TextView)findViewById(R.id.fpName)).getText().toString();
 }
 TextView res = ((TextView)findViewById(R.id.fpResult));
 if(f==0){
 res.setText("Enter Name or ID of product");
 return;
 }
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
 if(f==1) {
 rs = db.rawQuery("SELECT * FROM GSM WHERE 
id="+id+";",null);
 rs.moveToFirst();
 if(rs.getCount()==0) {
 res.setText("Invalid ID");
 return;
 }
 name = rs.getString(1);
 qty = rs.getInt(2);
 shelfID = rs.getInt(3);
 price = rs.getInt(4);
 }
 else {
 Toast.makeText(getApplicationContext(), name, 
Toast.LENGTH_SHORT).show();
 rs = db.rawQuery("SELECT * FROM GSM WHERE 
name='"+name+"';",null);
 rs.moveToFirst();
 if(rs.getCount()==0) {
 res.setText("Invalid Name");
 return;
 }
 id = rs.getInt(0);
 qty = rs.getInt(2);
 shelfID = rs.getInt(3);
 price = rs.getInt(4);
 }
 rs.close();
 res.setText(id+" : "+name+" is kept at shelf: "+shelfID+"\n 
qty: "+qty+" \n price: "+price);
 }
}