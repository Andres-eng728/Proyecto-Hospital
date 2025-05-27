package co.edu.uniquindio.prohospi.ViewController;

import java.io.*;

public class Persistencia {
    /**
     * Metodo que permite serializar un objeto en un archivo en la ruta especificada
     * @param objeto Objeto a serializar
     * @throws IOException
     */
    public static void serializarObjeto(String ruta, Object objeto) throws IOException {
        File archivo = new File(ruta);
        archivo.getParentFile().mkdirs(); // Crea los directorios si no existen

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data\\BaseDatos.txt"))) {
            oos.writeObject(objeto);
        }
    }


    /**
     * Metodo que permite deserializar un objeto de un archivo en la ruta especificada
     * @return Objeto deserializado
     * @throws Exception
     */
    public static Object deserializarObjeto(String ruta) throws IOException, ClassNotFoundException {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data\\BaseDatos.txt"))) {
            return ois.readObject();
        }
    }

}
