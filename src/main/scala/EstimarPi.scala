import org.apache.spark.sql.SparkSession

import scala.collection.mutable.ListBuffer

object EstimadorPi {
  def main(args:Array[String]):Unit= {
    print(estimarPi(1000000))
    println(EstimarPiBloques(1000000,3))
    println(EstimarPiBloquesSpark(1000000,3))
  }

  def estimarPi(numeroCalculos: Int):Double={

    var dentroDelCirculo:Double=0;

    for(i<-0 until numeroCalculos){
      val x:Double=math.random()
      val y:Double=math.random()
      val distanciaAlCentro:Double =x*x +y*y
      if(distanciaAlCentro<=1){
        dentroDelCirculo = dentroDelCirculo+1;
      }

    }
    return (dentroDelCirculo/numeroCalculos)*4
  }
  def EstimarPiBloques(numdeCalculos:Int, bloques:Int):Double={
    var lista: ListBuffer[Int] = ListBuffer ()
    for(i<-0 until bloques) lista+=(numdeCalculos/bloques)
    return(lista.map(estimarPi).sum/bloques)
  }
  def EstimarPiBloquesSpark(numdeCalculos:Int, bloques:Int):Double={

    val session =SparkSession.builder.master("local[3]").appName("EstimadorPi").getOrCreate()

    var lista: ListBuffer[Int] = ListBuffer ()
    for(i<-0 until bloques) lista+=(numdeCalculos/bloques)
    val pi=session.sparkContext.parallelize(lista).map(estimarPi).sum/bloques
    session.stop()
    pi

  }
}