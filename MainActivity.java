package mhssp.yfa.gsm;
import androidx.appcompat.app.AppCompatActivity;
19
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
 Button addProd, addExistProd, sellProd, findProd, 
outOfStock,about,exit;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 addProd = findViewById(R.id.addProd);
 addExistProd = findViewById(R.id.addExistProd);
 sellProd = findViewById(R.id.sellProd);
 findProd = findViewById(R.id.findProd);
 outOfStock = findViewById(R.id.outOfStock);
 about = findViewById(R.id.about);
 exit = findViewById(R.id.exit);
 addProd.setOnClickListener(new View.OnClickListener(){
 public void onClick ( View v){
 handleAddProd();
 }
 });
 addExistProd.setOnClickListener(new View.OnClickListener(){
 public void onClick ( View v){
 handleAddExistProd();
 }
 });
 sellProd.setOnClickListener(new View.OnClickListener(){
 public void onClick ( View v){
 handleSellProd();
 }
 });
 findProd.setOnClickListener(new View.OnClickListener(){
 public void onClick ( View v){
 handleFindProd();
 }
 });
 outOfStock.setOnClickListener(new View.OnClickListener(){
 public void onClick ( View v){
 handleOutOfStock();
 }
 });
 about.setOnClickListener(new View.OnClickListener(){
 public void onClick ( View v){
 handleAbout();
 }
 });
 exit.setOnClickListener(new View.OnClickListener(){
 public void onClick ( View v){
 handleExit();
 }
 });
 }
 public void handleAddProd(){
 Toast.makeText(getApplicationContext(),"Add 
Product",Toast.LENGTH_SHORT).show();
 Intent i = new Intent(getApplicationContext(), 
mhssp.yfa.gsm.AddProdActivity.class);
 startActivity(i);
 }
 public void handleAddExistProd(){
 Toast.makeText(getApplicationContext(),"Add Exist 
Product",Toast.LENGTH_SHORT).show();
 Intent i = new Intent(getApplicationContext(), 
mhssp.yfa.gsm.AddExistProdActivity.class);
 startActivity(i);
 }
 public void handleSellProd(){
 Toast.makeText(getApplicationContext(),"Sell 
Product",Toast.LENGTH_SHORT).show();
 Intent i = new Intent(getApplicationContext(), 
mhssp.yfa.gsm.SellProdActivity.class);
 startActivity(i);
 }
 public void handleFindProd(){
 Toast.makeText(getApplicationContext(),"Find 
Product",Toast.LENGTH_SHORT).show();
 Intent i = new Intent(getApplicationContext(), 
mhssp.yfa.gsm.FindProdActivity.class);
 startActivity(i);
 }
 public void handleOutOfStock(){
 Toast.makeText(getApplicationContext(),"Out of 
stock",Toast.LENGTH_SHORT).show();
 Intent i = new Intent(getApplicationContext(), 
mhssp.yfa.gsm.OutOfStockActivity.class);
 startActivity(i);
 }
 public void handleAbout(){
 
Toast.makeText(getApplicationContext(),"About",Toast.LENGTH_SHORT).s
how();
 Intent i = new Intent(getApplicationContext(), 
mhssp.yfa.gsm.AboutActivity.class);
 startActivity(i);
 }
 public void listProduct(View v){
 Toast.makeText(getApplicationContext(), "List Product", 
Toast.LENGTH_SHORT).show();
 Intent i = new Intent(getApplicationContext(), 
mhssp.yfa.gsm.ShowAllProductsActivity.class);
 startActivity(i);
 }
 public void handleExit(){
 
Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_SHORT).sh
ow();
 finish();
 }
}
