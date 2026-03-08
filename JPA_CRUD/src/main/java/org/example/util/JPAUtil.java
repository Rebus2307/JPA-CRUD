package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    // El nombre debe ser EXACTAMENTE el mismo que pusiste en el persistence.xml
    private static final String PERSISTENCE_UNIT_NAME = "EjemploJPA";
    private static EntityManagerFactory factory;

    static {
        try {
            // Se inicializa la fábrica una sola vez al cargar la clase
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Throwable ex) {
            System.err.println("Error al crear la factoría de JPA: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        // Retorna un nuevo gestor de entidades para realizar operaciones
        return factory.createEntityManager();
    }

    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}