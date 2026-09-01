package ejercicio4;

public class Puerto {
}
//. Puerto de Carga
//El Puerto de Rosario nos ha solicitado el desarrollo
// de un programa con el propósito de conocer información referida al operatorio de carga y
// descarga en los diferentes muelles del mismo en un periodo de tiempo, para ello nos proveen de un
// archivo barcos.csv que contendrá dicha información, la cual deberemos importar en nuestro programa.
// A continuación detallamos el conjunto de clases que se desprendieron del análisis determinado.
//
//- Puerto: que va a contener todos los barcos que necesitan ser procesados para generar la informacion del sistema pedido
//- Barco: qde una embarcacion se conoce matricula, numero de muelle de carga, capacidad de carga permitida en
//toneladas, costo alquiler por hora de amarre y quien comanda la nave
//- Capitan: abstraccion que representa a una persona a cargo de una embarcación, se conocen un identificador, un nombre, apellido y la antigüedad en el cargo
//
//En base a esto se pide:
//1 - Generar el modelo de clases que soporte este dominio de problema con la estructura basica de atributos y metodos
//
//2 - Cargar las embarcaciones del archivo csv en un array de objetos del tipo Barco
//
//3 - Asumiendo que el tiempo promedio de carga de una embarcacion son 15 hs, cual seria el total de carga que recaudaria el puerto con todos los barcos amarrados (barcos cargados en el array)
//
//4 - Informar todos los barcos, en un listado, cuyo capitan tiene mas de 18 años de experiencia.
//
//5 - Determinar la carga promedio en toneladas de todos los barcos en posiciones pares de amarre.