package com.example.projectmad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Doctor Name: Ahsan", "Hospital Address: Islamabad", "Exp: 5yrs", "Mobile No: 98765432", "600"},
                    {"Doctor Name: Faisal", "Hospital Address: H-8", "Exp: 15yrs", "Mobile No:7898989", "900"},
                    {"Doctor Name: Kashan", "Hospital Address: Rawalpindi","Exp: 40yrs", "Mobile No:8989898", "300"},
                    {"Doctor Name: Junaid", "Hospital Address: Chakwal", "Exp: 9yrs", "Mobile No:989807600", "500"},
                    {"Doctor Name: Bilal", "Hospital Address: Golra Mor", "Exp: 7yrs", "Mobile No: 77989898", "800"}
            };
    //Second Array
    private String[][] doctor_details2=
            {
                    {"Doctor Name: Ahsan", "Hospital Address: Islamabad", "Exp: 5yrs", "Mobile No: 98765432", "600"},
                    {"Doctor Name: Faisal", "Hospital Address: H-8", "Exp: 15yrs", "Mobile No:7898989", "900"},
                    {"Doctor Name: Kashan", "Hospital Address: Rawalpindi","Exp: 40yrs", "Mobile No:8989898", "300"},
                    {"Doctor Name: Junaid", "Hospital Address: Chakwal", "Exp: 9yrs", "Mobile No:989807600", "500"},
                    {"Doctor Name: Bilal", "Hospital Address: Golra Mor", "Exp: 7yrs", "Mobile No: 77989898", "800"}
            };
    //3 Array
    private String[][] doctor_details3=
            {
                    {"Doctor Name: Ahsan", "Hospital Address: Islamabad", "Exp: 5yrs", "Mobile No: 98765432", "600"},
                    {"Doctor Name: Faisal", "Hospital Address: H-8", "Exp: 15yrs", "Mobile No:7898989", "900"},
                    {"Doctor Name: Kashan", "Hospital Address: Rawalpindi","Exp: 40yrs", "Mobile No:8989898", "300"},
                    {"Doctor Name: Junaid", "Hospital Address: Chakwal", "Exp: 9yrs", "Mobile No:989807600", "500"},
                    {"Doctor Name: Bilal", "Hospital Address: Golra Mor", "Exp: 7yrs", "Mobile No: 77989898", "800"}
            };
    //4 Array
    private String[][] doctor_details4=
            {
                    {"Doctor Name: Ahsan", "Hospital Address: Islamabad", "Exp: 5yrs", "Mobile No: 98765432", "600"},
                    {"Doctor Name: Faisal", "Hospital Address: H-8", "Exp: 15yrs", "Mobile No:7898989", "900"},
                    {"Doctor Name: Kashan", "Hospital Address: Rawalpindi","Exp: 40yrs", "Mobile No:8989898", "300"},
                    {"Doctor Name: Junaid", "Hospital Address: Chakwal", "Exp: 9yrs", "Mobile No:989807600", "500"},
                    {"Doctor Name: Bilal", "Hospital Address: Golra Mor", "Exp: 7yrs", "Mobile No: 77989898", "800"}
            };
    //5 Array
    private String[][] doctor_details5=
            {
                    {"Doctor Name: Ahsan", "Hospital Address: Islamabad", "Exp: 5yrs", "Mobile No: 98765432", "600"},
                    {"Doctor Name: Faisal", "Hospital Address: H-8", "Exp: 15yrs", "Mobile No:7898989", "900"},
                    {"Doctor Name: Kashan", "Hospital Address: Rawalpindi","Exp: 40yrs", "Mobile No:8989898", "300"},
                    {"Doctor Name: Junaid", "Hospital Address: Chakwal", "Exp: 9yrs", "Mobile No:989807600", "500"},
                    {"Doctor Name: Bilal", "Hospital Address: Golra Mor", "Exp: 7yrs", "Mobile No: 77989898", "800"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDtitle);
        btn=findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title =it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dieticians")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
            item= new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Consultant Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
//Mapping
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);
        //when i click any hardcoded value in selecting doctor it redirects me to book appointment
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}