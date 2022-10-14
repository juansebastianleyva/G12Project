package usa.mintic.g12proyecto.entities.custom;

public class PersonasPorEdad {


    private int edad;
    private int cantidad;

    public PersonasPorEdad(int edad,int cantidad){
        this.edad=edad;
        this.cantidad=cantidad;
    }

    public PersonasPorEdad(Object e, Object c){
        this.edad=Integer.parseInt(e.toString());
        this.cantidad=Integer.parseInt(c.toString());

    }



    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
