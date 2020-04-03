

object Pruebas {
  def main(args:Array[String]):Unit= {
    var numeros:List[Int] = List(1,2,3,4,5,6,7,8,9,10)

    var numero=5
    var dobleDelNumero=doble(numero)

    numeros.foreach(numero => doble(numero))
    numeros.par.foreach(unNumero =>println(doble(unNumero)))

    var resultado = numeros.par.map(doble)

    print(resultado)


  }
  def doble(numero:Int):Int= numero*2

}