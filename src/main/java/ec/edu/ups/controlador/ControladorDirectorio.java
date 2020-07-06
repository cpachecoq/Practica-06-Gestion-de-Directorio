/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author linar
 */
public class ControladorDirectorio {
    
    private String ruta;
    private File archivo;
    private File[] archivos;
    
    
 
    public ControladorDirectorio() {    
    }
    
     
    
    public List<String> listarArchivos(String ruta) {
        
        List<String> lista = new ArrayList<>();
        lista.clear();
        
        archivo = new File(ruta);
        archivos = archivo.listFiles();

            for (File elemento: archivos) {
          
                if (!elemento.isHidden()) {
                
                    lista.add(elemento.getName());
            }

        }

        return lista;
    }

    
    
    
    public List<String> listarArchivosOcultos(String ruta) {
        
        List<String> lista = new ArrayList<>();
        lista.clear();
        
        archivo = new File(ruta);
        archivos = archivo.listFiles();

        for (File elemento : archivos) {
            if (elemento.isHidden() && elemento.isFile()) {
                lista.add(elemento.getName());
            }
        }

        for (File elemento : archivos) {
            
            if (elemento.isDirectory()) {
                File[] subdirectorios = elemento.listFiles();
                
                for (File subelemento : subdirectorios) {
                    
                    if (subelemento.isHidden() && subelemento.isFile()) {
                        lista.add(subelemento.getName());
                    }

                }

            }
        }

        return lista;
    }
    
    
    
     public List<String> listarDirectoriosOcultos(String ruta) {
         
        List<String> lista = new ArrayList<>();
        lista.clear();
        
        archivo = new File(ruta);
        archivos = archivo.listFiles();

        for (File elemento : archivos) {
            
            if (elemento.isHidden() && elemento.isDirectory()) {
                lista.add(elemento.getName());
                
            }
        }

        return lista;
    }
    
    
 
    public void crearDirectorio(String ruta, String nombre) {
        
        archivo = new File(ruta + File.separator + nombre);
        archivo.mkdir();
        
    }
    

     
   
}
