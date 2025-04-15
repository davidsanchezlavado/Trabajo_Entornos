/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

public class Usuario {
    private String nombre;
    private String email;
    private boolean empleado;
    private boolean miembroGold;
    private boolean miembroSilver;

 
    public Usuario(String nombre, String email, boolean empleado, boolean miembroGold, boolean miembroSilver) {
        this.nombre = nombre;
        this.email = email;
        this.empleado = empleado;
        this.miembroGold = miembroGold;
        this.miembroSilver = miembroSilver;
    }

   
    public boolean esEmpleado() {
        return empleado;
    }

    public boolean esMiembroGold() {
        return miembroGold;
    }

    public boolean esMiembroSilver() {
        return miembroSilver;
    }


    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", empleado=" + empleado +
                ", miembroGold=" + miembroGold +
                ", miembroSilver=" + miembroSilver +
                '}';
    }
}
