package com.example.alcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View){
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()
        val validaCampos = validarCampos(precoAlcool, precoGasolina)

        if(validaCampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            textResultado.setText("Preencha os preços primeiros!")
        }

    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{
        var camposValidados: Boolean = true

        if( precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if( precoGasolina == null ||precoGasolina.equals("")){
            camposValidados = false
        }

        return camposValidados
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        if((valorAlcool/valorGasolina)>= 0.7){
            textResultado.setText("Melhor usar gasolina!")
        }else{
            textResultado.setText("Melhor usar alcool!")
        }
    }
}
