package isaias.santana.imc

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import isaias.santana.imc.funcoes.imc
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calcular_imc.setOnClickListener{ view ->
            imc(inputPeso.text.toString(),inputAltura.text.toString(),getContext())
        }
    }

    fun showToastAlerta() =  Toast.makeText(this,"Preencha os campos",Toast.LENGTH_SHORT).show()

    fun mostrarResultado(resultadoImc: Pair<Pair<String,Int>,Double>)
    {

        val ptbr: Locale = Locale("pt","BR")
        val numberFormat = NumberFormat.getNumberInstance(ptbr)

        resultado.setTextColor(ContextCompat.getColor(this,resultadoImc.first.second))
        resultado.text = numberFormat.format(resultadoImc.second)

        descricao_resultado.setTextColor(ContextCompat.getColor(this,resultadoImc.first.second))
        descricao_resultado.text = resultadoImc.first.first
    }

    private fun getContext() : MainActivity = this
}
