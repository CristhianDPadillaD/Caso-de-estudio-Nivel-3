/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Omar Salazar
 */
package Mundo;

public class Jugador {
    private final String nombre;
    private final String nickname;
    private final String correo;
    private final String telefono;

    public Jugador(String nombre, String nickname, String correo, String telefono) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getNickname() { return nickname; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", nickname=" + nickname + 
               ", correo=" + correo + ", telefono=" + telefono + '}';
    }
}
