package controller;

import model.Trabajador;

import java.util.ArrayList;

public interface TrabajadorService {
    void crearTrabajador(Trabajador trabajador);

    Trabajador obtenerTrabajador(long id);

    ArrayList<Trabajador> obtenerTrabajadores();

    void actualizarTrabajador(long id, Trabajador trabajador);

    void eliminarTrabajador(long id);
}
