class Punto (var x:Double, var y: Double) {

  def cuadrante():Int={
    var cuadrante:Int=0;
    if(x>0 && y>0){
      cuadrante=1 ;
    }else if (x>0 && y<0){
      cuadrante = 4;
    }else if (x<0 && y>0){
      cuadrante = 2;
    }else  {
      cuadrante = 3;
    }
    return cuadrante;
  }
  def distanciaOrigen():Double ={
    return math.sqrt((x*x + y*y))
  }
}

class vector(var origen: Punto, var destino:Punto)

object Punto {
  def main(args:Array[String]):Unit={
    val miPunto = new Punto(-3.5,5.1)
    println(miPunto.cuadrante())
    println(miPunto.distanciaOrigen())
  }
}
