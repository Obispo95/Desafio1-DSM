package sv.edu.udb.desafio1dsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcularCuadratica extends AppCompatActivity {

    private Button btnCalcula;
    private EditText txt1;
    private EditText txt2;
    private EditText txt3;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cuadratica);
        txt1 = findViewById(R.id.txtNum1);
        txt2 = findViewById(R.id.txtNum2);
        txt3 = findViewById(R.id.txtNum3);
        txtRes = findViewById(R.id.txtResult);
    }

    public void CalcularCuadra(View view){
        try{
            //Calculando//
            String a1 = txt1.getText().toString();
            double a = Double.parseDouble(a1);
            String b1 = txt2.getText().toString();
            double b = Double.parseDouble(b1);
            String c1 = txt3.getText().toString();
            double c = Double.parseDouble(c1);
            double disc;
            if(a != 0) {
                //Calculando Discriminante
                disc = b * b - 4 * a * c;
                if (disc == 0) {
                    txtRes.setText(DiscIgualCero(a, b, disc));
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                }
                if (disc > 0) {
                    txtRes.setText(DiscMayorCero(a, b, disc));
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                }
                if (disc < 0) {
                    txtRes.setText(DiscMenorCero(a, b, c, disc));
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                }
            }else{
                txtRes.setText(EcuacionLineal(b,c));
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
            }
        }catch(Exception e){
            txtRes.setText("Por favor llena todos los campos, en caso de no tener valor poner 0");
        }

    }

    private String DiscIgualCero(double a, double b, double disc){
        return "La ecuacion tiene solo 1 raiz.\n\r"+"Discriminante: "+disc+"\n\rRaizt: "+(-b-Math.sqrt(disc))/(2*a);
    }
    private String DiscMayorCero(double a, double b, double disc){
        double x1 = (-b - Math.sqrt(disc)) / (2 * a);
        double x2 = (-b + Math.sqrt(disc)) / (2 * a);
        return "La ecuacion tiene dos raices.\n\r"+"Discriminante: "+disc+"\n\rRaiz1: "+x1+"\n\r"+"Raiz2: "+x2;
    }
    private String DiscMenorCero(double a, double b, double c, double disc){
        double xReal = -b / (2 * a);
        double xImaginario = (Math.sqrt(4 * a * c - b * b)) / (2 * a);

        return "La ecuacion tiene dos raices complejas\n\r"+"Discriminante: "+disc+"\n\rRaiz1: "+xReal+" + i"+xImaginario+"\n\rRaiz2: "+xReal+" - i"+xImaginario;
    }
    private String EcuacionLineal(double b, double c){
        return "Ecuacion lineal con una raiz: "+(-c/b);
    }
}