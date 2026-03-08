package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entity.Producto;
import org.example.util.JPAUtil;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void guardar(Producto producto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin(); // Iniciamos transacción
            em.persist(producto);        // INSERT
            em.getTransaction().commit(); // Confirmamos
        } catch (Exception e) {
            em.getTransaction().rollback(); // Cancelamos si hay error
            e.printStackTrace();
        } finally {
            em.close(); // Siempre cerrar el EntityManager
        }
    }

    @Override
    public Producto buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Producto.class, id); // SELECT * FROM productos WHERE id = ?
        } finally {
            em.close();
        }
    }

    @Override
    public List<Producto> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Usamos JPQL (Java Persistence Query Language) en lugar de SQL
            return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Producto producto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(producto);         // UPDATE
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Producto p = em.find(Producto.class, id);
            if (p != null) {
                em.remove(p);           // DELETE
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}