package org.example.dao;

import org.example.entity.Producto;
import java.util.List;

public interface ProductoDAO {
    void guardar(Producto producto);
    Producto buscarPorId(Long id);
    List<Producto> listarTodos();
    void actualizar(Producto producto);
    void eliminar(Long id);
}