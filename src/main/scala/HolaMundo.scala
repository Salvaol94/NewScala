
object HolaMundo {

  def suma( numero1: Int,  numero2: Int): Int ={
    var numero3 = 5 ;
    if (numero1 > 4){
      return numero3 ;
    }
    4
  }


  def main(args: Array[String]):Unit ={

    var numero : Int = 3 ;
    var texto: String ="Hola3" ;
    var logica : Boolean = true ;
    var decimal : Double = 4.3



    var numero2 = 4 ;

    suma (4 ,5 )



    val nummero3 = 5 ; // Constantes


    println(numero)
    println(texto)
    println(logica)
    numero = 4 ;
    texto = null;
    //numero = '5' : String;

    logica =false;
    if (texto!=null && texto.length()>3){// && y || evalua expression a expresion, en el momento que algo de falso (verdadero en el caso del or) ya no evalua la soguiente
      println("estoy dentro")
      println("Estoy Fuera")
    } else if(numero2>3) {
      println("Estoy dentro")
    }else{
      println("Estoy no se donde")
    }



  }

}
