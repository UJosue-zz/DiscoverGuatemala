package me.ujosue.discoverguatemala.methods;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by HP240 on 24/05/2016.
 */
public class Imagen {
    public static String guardarImagen (Context context, String nombre, Bitmap imagen){
        String directorio = "Imagenes";
        ContextWrapper cw = new ContextWrapper(context);
        File dirImages = cw.getDir(directorio, Context.MODE_PRIVATE);
        File myPath = new File(dirImages, nombre + ".png");

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(myPath);
            imagen.compress(Bitmap.CompressFormat.JPEG, 10, fos);
            fos.flush();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return myPath.getAbsolutePath();
    }
}
