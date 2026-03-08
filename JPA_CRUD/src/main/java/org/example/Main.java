package org.example;

import org.example.dao.ProductoDAO;
import org.example.dao.ProductoDAOImpl;
import org.example.entity.Producto;
import org.example.util.JPAUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar el DAO
        ProductoDAO dao = new ProductoDAOImpl();

        // --- OPERACIÓN: CREATE ---
        System.out.println("=== Guardando productos ===");
        Producto p1 = new Producto("Laptop Dell", 15000.0);
        Producto p2 = new Producto("Mouse Gamer", 450.0);
        dao.guardar(p1);
        dao.guardar(p2);

        // --- OPERACIÓN: READ (Listar todos) ---
        System.out.println("\n=== Listado de productos ===");
        List<Producto> lista = dao.listarTodos();
        lista.forEach(System.out::println);

        // --- OPERACIÓN: UPDATE ---
        System.out.println("\n=== Actualizando el precio del primer producto ===");
        if (!lista.isEmpty()) {
            Producto productoAEditar = lista.get(0);
            productoAEditar.setPrecio(14200.0); // Aplicamos un descuento
            dao.actualizar(productoAEditar);
            System.out.println("Producto actualizado: " + dao.buscarPorId(productoAEditar.getId()));
        }

        // --- OPERACIÓN: DELETE ---
        System.out.println("\n=== Eliminando el segundo producto ===");
        if (lista.size() >= 2) {
            Long idEliminar = lista.get(1).getId();
            dao.eliminar(idEliminar);
            System.out.println("Producto con ID " + idEliminar + " eliminado.");
        }

        // --- LISTADO FINAL ---
        System.out.println("\n=== Inventario Final ===");
        dao.listarTodos().forEach(System.out::println);

        // Cerrar la fábrica de JPA al terminar la app
        JPAUtil.close();
    }
}