import org.apache.commons.lang3.StringUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession

import scala.collection.mutable.ListBuffer

object Contador_Palabras {
  def main(args: Array[String]): Unit = {
    var lista = contar_palabras_unicas_spark("texto.txt")
    lista.foreach(println)

  }


  def contarpalabras(texto: String): Array[String] = {
    val palabras = texto.split(
      "[.+]|" +
        "[,+]|" +
        "[:+]|" +
        "[;+]|" +
        "[-+]|" +
        "[–+]|" +
        "[_+]|" +
        "[{+]|" +
        "[}+]|" +
        "['+]|" +
        "[¡+]|" +
        "[!+]|" +
        "[¿+]|" +
        "[?+]|" +
        "[(+]|" +
        "[)+]|" +
        "[>+]|" +
        "[<+]|" +
        "[#+]|" +
        "[&+]|" +
        "[/+]|" +
        "[\\]+]|" +
        "[\\[+]|" +
        "[“+]|" +
        "[\"+]|" +
        "[”+]|" +
        "[”+]|" +
        "[—+]|" +
        "[0-9]+|" +
        "\\s")
   palabras
  }


    def limpiar_acentos(texto: String): String = {

      StringUtils.stripAccents(texto)

    }


    def mayusculas(texto: String): String = {
      texto.toUpperCase()
    }

    def borrar_stop_word(texto: String): Boolean = {
      var Palabras_vacias: String = "siendo\nsin\nsobre\nsois\nsomos\nson\nME"

      !Palabras_vacias.contains(texto)
    }

    def contar_palabras_unicas_spark(texto: String): org.apache.spark.rdd.RDD[(String, Int)] = {

      val session = SparkSession.builder.master("local[3]").appName("cotadorpalabras").getOrCreate()

      val textFile = session.sparkContext.textFile("src/main/scala/"+texto)
      textFile.foreach(println)
      val lista_puntuada = textFile.flatMap(contarpalabras).map(limpiar_acentos).map(mayusculas).filter(palabra => borrar_stop_word(palabra)).map(palabra => (palabra, 1)).reduceByKey(_ + _).sortBy(_._2)

      return lista_puntuada;
    }

}