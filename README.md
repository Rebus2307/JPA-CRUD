# CRUD Java con Jakarta Persistence API (JPA) e Hibernate

Este proyecto implementa un sistema CRUD (Create, Read, Update, Delete) completo utilizando el estándar oficial **Jakarta Persistence API (JPA)** para la gestión de persistencia de datos, abstrayendo por completo el uso de SQL nativo.

## 🚀 Características

* **Persistencia:** Implementación mediante Hibernate 6.4.
* **Patrón de Diseño:** Uso del patrón **DAO (Data Access Object)** para separar la lógica de negocio del acceso a datos.
* **Gestión de Entidades:** Mapeo Objeto-Relacional (ORM) con anotaciones de Jakarta.
* **Conexión:** Configuración centralizada en `persistence.xml` y gestión de `EntityManager` mediante una clase de utilidad Singleton.

## 🛠️ Requisitos

* **Java JDK:** 17 o superior (desarrollado con JDK 25).
* **Maven:** 3.8 o superior.
* **Base de Datos:** MySQL 8.0+.

## 📦 Configuración del Proyecto

### 1. Base de Datos
Ejecuta el siguiente script en tu terminal de MySQL o Workbench:

```sql
CREATE DATABASE IF NOT EXISTS curso_jpa;
USE curso_jpa;

```

### 2. Archivo persistence.xml

Asegúrate de configurar tus credenciales de MySQL en `src/main/resources/META-INF/persistence.xml`:

```xml
<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/curso_jpa" />
<property name="jakarta.persistence.jdbc.user" value="root" />
<property name="jakarta.persistence.jdbc.password" value="TU_CONTRASEÑA" />

```

### 3. Dependencias Principales

El archivo `pom.xml` incluye:

* `hibernate-core`: Motor de persistencia.
* `mysql-connector-j`: Driver de conexión para MySQL.

## 🖥️ Ejecución

La clase `Main.java` realiza las siguientes operaciones automáticamente:

1. **Create:** Inserta dos productos (Laptop y Mouse) en la base de datos.
2. **Read:** Recupera y muestra la lista de productos.
3. **Update:** Modifica el precio de un registro existente.
4. **Delete:** Elimina un registro por su ID.

## 📊 Resultados en Consola

Al ejecutar el proyecto, Hibernate generará automáticamente el esquema de la tabla y mostrará las sentencias SQL ejecutadas:

<img width="1176" height="916" alt="imagen" src="https://github.com/user-attachments/assets/ebb72938-fdf4-45a2-b89e-6b9c52e69669" />


> **Nota:** La tabla `productos` se crea automáticamente gracias a la propiedad `hibernate.hbm2ddl.auto` con valor `update`.

---

**Desarrollado por:** Wilfrido Cruz Merlin
**Institución:** Escuela Superior de Cómputo (ESCOM - IPN)
