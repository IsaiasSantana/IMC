package isaias.santana.imc.funcoes

import isaias.santana.imc.MainActivity

/**
 * @author Isaías Santana on 06/07/17.
 * email: isds.santana@gmail.com
 */

private fun calcularIMC(peso: Double, altura: Double) : Double = peso / (altura * altura)

private fun mostraResultadoIMC(imc: Double) : Pair<String,Int>?
{
    if(imc < 18.5) return Pair("Abaixo do peso!", android.R.color.holo_red_dark)

    if(imc >= 18.5 && imc < 25) return Pair("Peso Ideal!",android.R.color.holo_green_light)

    if(imc >= 25 && imc < 30) return Pair("Sobrepeso!",android.R.color.holo_orange_dark)

    if(imc >= 0) return Pair("Obesidade",android.R.color.holo_red_dark)

    return null
}

fun imc(peso: String, altura: String, activity: MainActivity)
{
    try
    {
	val alturaEmMetros = altura.toDouble()/100

	if(alturaEmMetros > 0.5)
    {
		val imc = calcularIMC(peso.toDouble(),alturaEmMetros)
		val  resultado = mostraResultadoIMC(imc)

		if(resultado != null)
		    activity.mostrarResultado(Pair(resultado,imc))
		else
		    activity.mostrarResultado(Pair(Pair("IMC não esperado.",android.R.color.holo_red_dark),imc))        
	}

    }
    catch (nfe: NumberFormatException)
    {
        activity.showToastAlerta()
    }

}
