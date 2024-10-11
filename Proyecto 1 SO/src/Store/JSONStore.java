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
    Gson gson = new Gson();
    File appleFile = new File("./src/Store/AppleJSON.json");
    File dellFile = new File("./src/Store/DellJSON.json");
    
    public JSONStore(){}
    
    /**
     * Método encargado de la lectura del JSON.
     * @param companyType CompanyEnum - Tipo de compañía (Apple o Dell)
     * @return FileEntity - Entidad con la información necesaria
     * @throws IOException - Error si no se encuentra o no se puede leer el archivo
     */
    public FileEntity getFile(CompanyEnum companyType) throws IOException {
        try {
            // Selecciona el archivo de la compañía
            File selectedFile = null;
            switch (companyType) {
                case Apple:
                    selectedFile = appleFile;
                    break;
                case Dell:
                    selectedFile = dellFile;
                    break;
            }
            
            // Lee el JSON
            FileReader myReader = new FileReader(selectedFile);
            FileEntity file = gson.fromJson(myReader, FileEntity.class);
            myReader.close();
            return file;
        } catch (IOException e) {
            return null;
        }
    }
    
    /**
     * Método encargado de la escritura del JSON.
     * @param file FileEntity - Entidad con la información para la escritura
     * @param companyType CompanyEnum - Tipo de compañía (Apple o Dell)
     * @throws IOException - Error si no se encuentra o no se puede escribir el archivo
     */
    public void setFile(FileEntity file, CompanyEnum companyType) throws IOException {
        try {
            // Selecciona el archivo de la compañía
            File selectedFile = null;
            switch (companyType) {
                case Apple:
                    selectedFile = appleFile;
                    break;
                case Dell:
                    selectedFile = dellFile;
                    break;
            }
    
            // Escribe el JSON
            FileWriter fileWriter = new FileWriter(selectedFile);
            gson.toJson(file, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            // Manejo del error
        }
    }

   
}