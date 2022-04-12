package com.example.connectwithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Customer> listCus;
    private ListView listView;

    DatabaseHandler dataUser;
    ArrayList cusList;
    CustomerAdapter adapter;

    Button btnAdd;
    EditText edName;
    Button btnRemove;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         dataUser = new DatabaseHandler(this);
         cusList = new ArrayList();

//        dataUser.addUser(new Customer("Nguyen Thanh Nhan"));
//        dataUser.addUser(new Customer("Nguyen Van A"));
//        dataUser.addUser(new Customer("Nguyen Thi B"));

        listView = findViewById(R.id.idListView);
        btnAdd = findViewById(R.id.btnAdd);
        edName = findViewById(R.id.edName);
        btnRemove = findViewById(R.id.btnRemove);

        cusList.clear();
        for (Iterator iterator = dataUser.getAllCustomers().iterator(); iterator.hasNext(); ) {
            Customer customer = (Customer) iterator.next();
            cusList.add(customer.getId());
        }

        showAll();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
            }
        });

        eventBtnAdd();
        eventBtnRemove();
    }

   public void showAll() {
        List<Customer> list = dataUser.getAllCustomers();

        adapter = new CustomerAdapter(getApplicationContext(), R.layout.custom_item, list);
        listView.setAdapter(adapter);
   }

    public void eventBtnAdd(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();

                if (!name.equals("")){
                    dataUser.addUser(new Customer(name));
                    showAll();
                    edName.setText("");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Tên không được rỗng !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void eventBtnRemove() {

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataUser.deleteCustomer(adapter.tempIndex+1);
                showAll();
                Toast.makeText(getApplicationContext(), "Thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}