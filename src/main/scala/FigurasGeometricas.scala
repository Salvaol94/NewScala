class Rectangulo (val base :Double, val altura: Double) extends FigurasGeometrica {

  def area():Double={
    return base*altura;
  }
  def perimetro():Double={
    return 2*base+2*altura;
  }
}

class Cuadrado(val lado:Double) extends Rectangulo(lado, lado)

class Circulo(var radio :Double ) extends  FigurasGeometrica {

  def area():Double=    return math.Pi*radio*radio;
  def perimetro():Double=    return 2*math.Pi*radio;

  override def toString: String = {
    "Soy un circulo con radio:" +radio
  }
}
trait FigurasGeometrica{
  def area():Double
  def perimetro():Double
}



object FigurasGeometricas {
  def main(args:Array[String]):Unit= {
    val cuadrado1 = new Cuadrado(5);
    println(cuadrado1.area())
    println(cuadrado1.perimetro())

    val rectangulo1= new Rectangulo(5,2);
    println(rectangulo1.area())
    println(rectangulo1.perimetro())

    val circulo1= new Circulo(5);
    println(circulo1.area())
    println(circulo1.perimetro())

    println(circulo1)


    val figuras: List[FigurasGeometrica] = List {rectangulo1; cuadrado1; circulo1}

    figuras.foreach(imprimirAreafigura)

  }
  def imprimirAreafigura(figura:FigurasGeometrica):Unit={
    println("el area vale:" + figura.area())
  }

}