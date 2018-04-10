package app;
public class Mascota {
    
    private String id;
    private String  nombre;
    private byte    edad;
    private char    sexo;
    private String  raza;
    private boolean vacunado;
    private String  foto;
    
    public Mascota(){
    }

    public Mascota(String id, String nombre, byte edad, char sexo, String raza, boolean vacunado, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.raza = raza;
        this.vacunado = vacunado;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return  "ID =" + id + ",    nombre=" + nombre + ",  edad=" + edad +
                ",  sexo=" + sexo + ",  raza=" + raza + ",  vacunado=" + vacunado + 
                ", foto     =<img src=fotos/" + foto + ">";
    }
    
    
    

    
}
