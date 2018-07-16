/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkia_dami_c11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author dmorenoar
 */
public class LINKIA_DAMI_C11 {

    public static void main(String[] args) throws IOException {

        //Definir el separador para las rutas de las carpetas según el SO -> /
        String separador = File.separator;

        //Definir la ruta hasta dónde está nuestro proyecto
        String rutaProyecto = System.getProperty("user.dir");

        //Montar la ruta del proyecto para generar la carpeta
        String rutaCarpeta = rutaProyecto + separador + "archivos";

        //Utilizaremos el objeto file para crear nuestra carpeta en la ruta que le hemos indicado        
        File carpeta = new File(rutaCarpeta);

        //Comprobar si la carpeta existe, y si no la creamos
        if (!carpeta.exists()) {
            carpeta.mkdir(); // Creamos la carpeta utilizando el método mkdir
        } else {
            System.out.println("La carpeta ya existe");
        }

        //Obtener la ruta del path del fichero
        System.out.println(carpeta.getAbsolutePath());

        /*CREAR UN ARCHIVO Y ESCRIBIR DATOS*/
        
        /*Utilizar la clase FileWriter, porque es la que nos permite escribir en un fichero*/
        //Para crear un fichero repito el proceso de creación de una carpeta, pero indicando el nombre del fichero
        //Creamos el Stream de escritura vinculado con el nombre del archivo.
        FileWriter fw = new FileWriter(rutaCarpeta + separador + "starwars.txt");

        //Para escribir en el fichero hemos de utilizar el Buffer de escritura
        //este nos permitira escribir String en lugar de bytes.
        BufferedWriter bw = new BufferedWriter(fw);

        //Escribir en el fichero
        bw.write("La República Galáctica está\n"
                + "sumida en el caos. Los\n"
                + "impuestos de las rutas\n"
                + "comerciales a los sistemas\n"
                + "estelares exteriores están en\n"
                + "disputa.");
        //Obligar al buffer a que guarde los cambios realizados en el fichero
        bw.flush();
        //Cerrar el buffer y vaciarlo
        bw.close();
        
        /*BORRAR UN FICHERO*/
        
        //Creamos la instancia del fichero que queremos trabajar
        File ficheroBorrar = new File(rutaCarpeta + separador + "godzilla.txt");
        
        ficheroBorrar.delete();
        
        System.out.println("El fichero con nombre: " + ficheroBorrar.getName() + " ha sido eliminado");
        
        /*RENOMBRAR UN FICHERO*/
        //Instanciar el fichero al que queremos cambiarle el nombre
        File ficheroAntiguo = new File(rutaCarpeta + separador + "pepe.txt");

        //Crear un nuevo fichero con el nombre nuevo
        File ficheroNuevo = new File(rutaCarpeta + separador + "jumanji.txt");
        
        //Modificamos el nombre del fichero al nuevo nombre sin alterar el contenido
        ficheroAntiguo.renameTo(ficheroNuevo);
        
        
        /*RECUPERA INFORMACIÓN DE UN FICHERO*/
        //Comprobar si el fichero tiene algo -> Utilizar el length de la clase File
        
        //Instanciar el fichero que quiero leer
        //Utilizamos la clase FileReader para vincular el fichero a el stream
        FileReader fr = new FileReader(rutaCarpeta + separador + "ranking.txt");
        
        //Utilizamos el BufferReader para transformar el stream de datos a String
        //Utilizando el FileReader en su entrada
        BufferedReader br = new BufferedReader(fr);
        
        
        //Cómo el buffer lee línea por línea hemos de ir verificando si en el fichero
        //Existen líneas a leer, mientras existan continuamos leyendo, y si no paramos
        String linea = "";
        
        while(linea != null){
            System.out.println(linea);
            linea = br.readLine();
        }
        
        //Cerrar el buffer al acabar de leer
        br.close();
    }

}
