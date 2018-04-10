package app;

import java.util.ArrayList;

public class Datos {

    private static boolean sw=false;
    public static boolean isSW(){

    return sw;
    }
    private static ArrayList<Mascota> arrmasc=new ArrayList<Mascota>();
    
    protected static void cargarDatos(){
    
        arrmasc.add(new Mascota("1","blanca",(byte)2,'h',"Pitbull",true,"pitbull.jpg"));
        arrmasc.add(new Mascota("2","hercules",(byte)2,'m',"Boyero",true,"boyero.jpg"));
        arrmasc.add(new Mascota("3","tito",(byte)1,'m',"Siberiano",false,"siberiano.jpg"));
        sw=true;
    }
    
    public static boolean agregar(Mascota   masc){
    
        if((masc!=null)&&(buscar(masc.getId())==null)){
        
            arrmasc.add(masc);
            return true;
        }
        return false;
    }
    
    public static ArrayList<Mascota> listar(){
        
        return arrmasc;
    }
    
    public static Mascota buscar(String id){
    
        Mascota mascfind=null;
        for(Mascota m:arrmasc){
        
            if(m.getId().equals(id)){
            
                mascfind=m;
                return mascfind;
            }
        }
        return mascfind;
    }
    
    public static boolean eliminar(String id){
    
            for(Mascota m:arrmasc){
            
                if(m.getId().equals(id)){
                
                    arrmasc.remove(m);
                    return true;
                }
            }
        
        return false;
    }
    
    public static boolean modificar(Mascota masc){
        
        int i=0;
            for(Mascota m:arrmasc){
            
                if(m.getId().equals(masc.getId())){
                
                    arrmasc.set(i, masc);
                    return true;
                }
                i++;
            }
        
        return false;
        
    
    }
    
    
}

