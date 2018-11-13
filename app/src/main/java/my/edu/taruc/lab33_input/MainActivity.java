package my.edu.taruc.lab33_input;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup RadioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = findViewById(R.id.spinnerAge);
        RadioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        textViewPremium = findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence>adapter =
                ArrayAdapter.createFromResource(
                        this,R.array.age_group,
                        android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Position :" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view)
    {
        int position;
        double premium = 0.0;
        position = spinnerAge.getSelectedItemPosition();
        switch(position)
        {
            case 0:
            {
                premium = 50;
            } break;
            case 1:
            {
                premium = 55;
            } break;
            case 2:
            {
                premium = 60;
            } break;
            case 3:
            {
                premium = 70;
            } break;

            case 4:
            {
                premium = 120;
            } break;

            case 5:
            {
                premium = 160;
            } break;

            case 6:
            {
                premium = 200;
            } break;

            case 7:
            {
                premium = 250;
            } break;
        }

        int gender = RadioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale)
        {
            if (position == 2 || position == 5)
            {
                premium += 50;
            }
            else if (position == 3 || position == 4)
            {
                premium += 100;
            }
        }


        if(checkBoxSmoker.isChecked())
        {
            if (position == 3)
            {
                premium += 100;
            }
            else if (position == 4 || position == 5)
            {
                premium += 150;
            }
            else if (position == 6 || position == 7)
            {
                premium += 250;
            }
        }

        textViewPremium.setText("Premium :" + premium);
    }
}
