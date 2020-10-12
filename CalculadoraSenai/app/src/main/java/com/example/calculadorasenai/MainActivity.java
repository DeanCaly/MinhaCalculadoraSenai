package com.example.calculadorasenai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String primeiroNumero;
    private String proximoNumero;
    private String operacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Minha Calculadora");
        display = findViewById(R.id.visorTextT);

        }


    public void onClickBotao1(View v) {
        obter("1");
    }

    public void onClickBotao2(View v) {
        obter("2");
    }

    public void onClickBotao3(View v) {
        obter("3");
    }

    public void onClickBotao4(View v) {
        obter("4");
    }

    public void onClickBotao5(View v) {
        obter("5");
    }

    public void onClickBotao6(View v) {
        obter("6");
    }

    public void onClickBotao7(View v) {
        obter("7");
    }
    public void onClickBotao8(View v) {
        obter("8");
    }
    public void onClickBotao9(View v) {
        obter("9");
    }

    public void onClickBotaoDot(View v) {
        obter(".");
    }

    public void onClickBotao0(View v) {
        String textoDisplay = display.getText().toString();
        if(textoDisplay.equals("0")) {
            textoDisplay = "0";
            display.setText(textoDisplay);
        }
        else {
            textoDisplay += "0";
            display.setText(textoDisplay);
        }

    }

    public void obter( String b) {
        String textoDisplay = display.getText().toString();
        if(textoDisplay.equals("0")) {
            textoDisplay = b;
            display.setText(textoDisplay);
        }
        else {
            textoDisplay += b;
            display.setText(textoDisplay);
        }
    }

    public void OnClickAdicao(View v) {
        String textoDisplay = display.getText().toString();
        if(!textoDisplay.equals("0")) {
            primeiroNumero = textoDisplay;
            textoDisplay += "+";
            display.setText(textoDisplay);
            operacao = "+";
        }
    }
    
    public void OnClickSubtracao(View v) {
        String textoDisplay = display.getText().toString();
        if(!textoDisplay.equals("0")) {
            primeiroNumero = textoDisplay;
            textoDisplay += "-";
            display.setText(textoDisplay);
            operacao = "-";
            
        }
            
    }

    public void OnClickMultiplic(View v) {
        String textoDisplay = display.getText().toString();
        if(!textoDisplay.equals("0")) {
            primeiroNumero = textoDisplay;
            textoDisplay += "x";
            display.setText(textoDisplay);
            operacao = "x";

        }

    }

    public void OnClickDivid(View v) {
        String textoDisplay = display.getText().toString();
        if(!textoDisplay.equals("0")) {
            primeiroNumero = textoDisplay;
            textoDisplay += "÷";
            display.setText(textoDisplay);
            operacao = "÷";

        }
    }

    public void OnclickIgual(View v) {
        String textoDisplay = display.getText().toString();
        proximoNumero = textoDisplay.substring(textoDisplay.indexOf(operacao) + 1);
        Double num1 =  Conversor(primeiroNumero);
        Double  num2 = Conversor(proximoNumero);
        Double resultado;

        if(!textoDisplay.equals("0")) {
           switch(operacao){
               case "+":
                   resultado = num1 + num2;
                   textoDisplay = Double.toString(resultado);
                   display.setText(FormatTexto(textoDisplay));
                   break;
               case "-":
                   resultado = num1 - num2;
                   textoDisplay = Double.toString(resultado);
                   display.setText(FormatTexto(textoDisplay));
                    break;
               case "x":
                   resultado = num1 * num2;
                   textoDisplay = Double.toString(resultado);
                   display.setText(FormatTexto(textoDisplay));
                   break;
               case "÷":
                   if(!proximoNumero.equals("0")) {
                   resultado = num1 / num2;
                   textoDisplay = Double.toString(resultado);
                   display.setText(FormatTexto(textoDisplay));
                   }
                   else {
                       textoDisplay = "Divisão inválida";
                       display.setText(textoDisplay);
                   }
            }
        }
    }


    public void OnClickBotaoC(View v) {
        display = findViewById(R.id.visorTextT);
        String textoDisplay = display.getText().toString();
        textoDisplay = "0";
        display.setText(textoDisplay);
    }

    public Double Conversor(String num){
        Double numero = Double.parseDouble(num);

        return numero;
    }

    public String FormatTexto(String texto) {
        String novoTexto = texto;
        String numeroTexto = texto.substring(texto.indexOf(".") + 1);
        if(numeroTexto.equals("0")) {
            novoTexto = texto.substring(0, texto.indexOf("."));
        }
        return novoTexto;
    }

}