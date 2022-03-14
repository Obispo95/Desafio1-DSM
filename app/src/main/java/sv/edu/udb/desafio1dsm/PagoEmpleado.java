package sv.edu.udb.desafio1dsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PagoEmpleado extends AppCompatActivity {

    private EditText txtEmp1Nombre;
    private EditText txtEmp1Cargo;
    private EditText txtEmp1Horas;

    private EditText txtEmp2Nombre;
    private EditText txtEmp2Cargo;
    private EditText txtEmp2Horas;

    private EditText txtEmp3Nombre;
    private EditText txtEmp3Cargo;
    private EditText txtEmp3Horas;

    private double sueldoNeto;
    private double sueldoLiquido;
    private double descuentoIsss;
    private double descuentoRenta;
    private double descuentoAfp;

    private double sueldoNeto2;
    private double sueldoLiquido2;
    private double descuentoIsss2;
    private double descuentoRenta2;
    private double descuentoAfp2;

    private double sueldoNeto3;
    private double sueldoLiquido3;
    private double descuentoIsss3;
    private double descuentoRenta3;
    private double descuentoAfp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_empleado);

        txtEmp1Nombre = findViewById(R.id.txtEmpleado1Nombre);
        String nombre1 = txtEmp1Nombre.getText().toString();

        txtEmp2Nombre = findViewById(R.id.txtEmpleado2Nombre);

        Button btnCalculaSueldo = (Button) findViewById(R.id.btnCalculaSueldo);
        btnCalculaSueldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombre1 != null){
                    txtEmp2Nombre.setText(nombre1);
                }else{
                    Toast.makeText(getApplicationContext(),"Por favor rellene todos los campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void CalcularComision (){

        txtEmp1Nombre = findViewById(R.id.txtEmpleado1Nombre);
        txtEmp1Cargo = findViewById(R.id.txtEmpleado1Cargo);
        txtEmp1Horas = findViewById(R.id.txtEmpleado1Horas);

        txtEmp2Nombre = findViewById(R.id.txtEmpleado2Nombre);
        txtEmp2Cargo = findViewById(R.id.txtEmpleado2Cargo);
        txtEmp2Horas = findViewById(R.id.txtEmpleado2Horas);

        txtEmp3Nombre = findViewById(R.id.txtEmpleado3Nombre);
        txtEmp3Cargo = findViewById(R.id.txtEmpleado1Cargo3);
        txtEmp3Horas = findViewById(R.id.txtEmpleado1Horas3);

        String nombre1 = txtEmp1Nombre.getText().toString();
        String cargo1 = txtEmp1Cargo.getText().toString();
        String horas1 = txtEmp1Horas.getText().toString();
        int hrs1 = Integer.parseInt(horas1);

        String nombre2 = txtEmp2Nombre.getText().toString();
        String cargo2 = txtEmp2Cargo.getText().toString();
        String horas2 = txtEmp2Horas.getText().toString();
        int hrs2 = Integer.parseInt(horas2);

        String nombre3 = txtEmp3Nombre.getText().toString();
        String cargo3 = txtEmp3Cargo.getText().toString();
        String horas3 = txtEmp3Horas.getText().toString();
        int hrs3 = Integer.parseInt(horas3);

        if(hrs1 <= 0){
            Toast.makeText(getApplicationContext(),"La hora no debe ser menor o igual a 0 para el primer empleado.", Toast.LENGTH_SHORT).show();
        }else if(hrs2 <= 0){
            Toast.makeText(getApplicationContext(),"La hora no debe ser menor o igual a 0 para el segundo empleado.", Toast.LENGTH_SHORT).show();
        }else if(hrs3 <= 0){
            Toast.makeText(getApplicationContext(),"La hora no debe ser menor o igual a 0 para el tercer empleado.", Toast.LENGTH_SHORT).show();
        }else{
            if(hrs1 <= 160){
                sueldoNeto = hrs1 * 9.75;
                descuentoIsss = sueldoNeto / 5.25;
                descuentoAfp = sueldoNeto / 6.88;
                descuentoRenta = sueldoNeto / 1.00;

                sueldoLiquido = sueldoNeto - (descuentoIsss + descuentoAfp + descuentoRenta);

            }else if(hrs1 >= 160){
                sueldoNeto = (hrs1 - 160) * 11.50;

            }
        }



    }

}