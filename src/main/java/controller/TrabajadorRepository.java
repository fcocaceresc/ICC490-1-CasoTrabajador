package controller;

import model.Trabajador;

import java.util.ArrayList;

public class TrabajadorRepository {
    private final ArrayList<Trabajador> trabajadores = new ArrayList<>();
    private long nextId = 1;

    public void crearTrabajador(Trabajador trabajador) {
        long id = nextId;
        trabajador.setId(id);
        trabajadores.add(trabajador);
        nextId++;
    }

    public Trabajador obtenerTrabajador(long id) {
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getId() == id) {
                return trabajador;
            }
        }
        return null;
    }

    public ArrayList<Trabajador> obtenerTrabajadores() {
        return trabajadores;
    }

    public void actualizarTrabajador(long id, Trabajador trabajadorActualizado) {
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getId() == id) {
                trabajadorActualizado.setId(id);
                trabajadores.set(i, trabajadorActualizado);
                return;
            }
        }
    }

    public void eliminarTrabajador(long id) {
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getId() == id) {
                trabajadores.remove(i);
                return;
            }
        }
    }
}
