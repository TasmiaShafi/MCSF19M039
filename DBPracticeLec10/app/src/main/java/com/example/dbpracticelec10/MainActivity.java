package com.example.dbpracticelec10;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

 Button buttonAdd,buttonView;
 EditText editName,editAge;
 Switch isActiveOrNot;
 ListView ListViewDetail;
 List<CustomerModel> allCust;
 ArrayAdapter<CustomerModel> arrayAdapter;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  buttonAdd=findViewById(R.id.buttonAdd);
  buttonView=findViewById(R.id.buttonView);
  editName=findViewById(R.id.editTextName);
  ListViewDetail=findViewById(R.id.allView);
  editAge=findViewById(R.id.editTextAge);
  isActiveOrNot=findViewById(R.id.switch1);
  Refresh();
  buttonAdd.setOnClickListener(new View.OnClickListener(){
   CustomerModel cust;
   @Override
   public void onClick(View v) {
    try{
     cust=new CustomerModel(editName.getText().toString(),Integer.parseInt(editAge.getText().toString()),isActiveOrNot.isChecked(),1);
     Toast.makeText(MainActivity.this,cust.toString(), Toast.LENGTH_SHORT).show();
    }
    catch (Exception e){
     Toast.makeText(MainActivity.this,"Error", Toast.LENGTH_SHORT).show();
    }
    DatabaseHelper helper=new DatabaseHelper(MainActivity.this);
    boolean b=helper.addCustomer(cust);
    Refresh();
    editName.setText("");
    editAge.setText("");
    isActiveOrNot.setChecked(false);

    //Toast.makeText(MainActivity.this,"Added", Toast.LENGTH_SHORT).show();
   }
  });
  buttonView.setOnClickListener(new View.OnClickListener(){

   @Override
   public void onClick(View v) {
    Refresh();
    // Toast.makeText(MainActivity.this,allCust.toString(),Toast.LENGTH_SHORT).show();
   }
  });
  ListViewDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    DatabaseHelper helper=new DatabaseHelper(MainActivity.this);
    CustomerModel selectedCust=allCust.get(position);
    //Log.d("you clicked", String.valueOf(selectedCust.getId()));
    boolean result=helper.deleteCustmoer(selectedCust.getId());
    if(result){
      Refresh();
      Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
    }

    else{
     Refresh();
     Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
    }
   }
  });
 }

 private void Refresh() {
  DatabaseHelper helper=new DatabaseHelper(MainActivity.this);
  allCust=helper.getAllRecord();
  arrayAdapter=new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1,allCust);
  ListViewDetail.setAdapter(arrayAdapter);
 }
}
