/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Store;

import Enums.CompanyEnum;
import static Enums.CompanyEnum.Apple;
import static Enums.CompanyEnum.Dell;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author vickysaldivia
 */
public class JSONStore {
    private final Gson gson = new Gson();
    private final File appleFile = new File("./src/Store/AppleJSON.json");
    private final File dellFile = new File("./src/Store/DellJSON.json");

    /**
     * Constructor por defecto.
     */
    public JSONStore() {}

    /**
     * Método encargado para la lectura del JSON.
     * @param companyType CompanyEnum - Tipo de compañía (Apple o Dell)
     * @return FileEntity - Entidad con la información de configuración de la compañía.
     * @throws IOException - Error si no se encuentra o no se puede leer el archivo.
     */
    public FileEntity getFile(CompanyEnum companyType) throws IOException {
        File selectedFile = null;

        // Escoje el archivo correspondiente según el tipo de compañía.
        switch (companyType) {
            case Apple:
                selectedFile = appleFile;
                break;
            case Dell:
                selectedFile = dellFile;
                break;
            default:
                throw new IllegalArgumentException("Tipo de compañía no soportado.");
        }

        // Lee y devuelve los datos del JSON.
        try (FileReader myreader = new FileReader(selectedFile)) {
            return gson.fromJson(myreader, FileEntity.class);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Método encargado de la escritura del JSON.
     * @param file FileEntity - Entidad con la información para la escritura.
     * @param companyType CompanyEnum - Tipo de compañía (Apple o Dell)
     * @throws IOException - Error si no se puede escribir el archivo.
     */
    public void setFile(FileEntity file, CompanyEnum companyType) throws IOException {
        File selectedFile = null;

        // Escoje el archivo correspondiente según el tipo de compañía.
        switch (companyType) {
            case Apple:
                selectedFile = appleFile;
                break;
            case Dell:
                selectedFile = dellFile;
                break;
            default:
                throw new IllegalArgumentException("Tipo de compañía no soportado.");
        }

        // Escribe los datos en el archivo JSON.
        try (FileWriter fileWriter = new FileWriter(selectedFile)) {
            gson.toJson(file, fileWriter);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
            throw e;
        }
    }
}
