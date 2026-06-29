package dao;

import java.util.ArrayList;

public interface Crud<T> {

    boolean insertar(T objeto);

    ArrayList<T> listar();

    boolean actualizar(T objeto);

    boolean eliminar(int id);
}