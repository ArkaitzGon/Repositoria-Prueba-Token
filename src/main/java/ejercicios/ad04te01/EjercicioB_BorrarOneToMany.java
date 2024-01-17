/**
 * Ejercicio B Borrar un objeto University
 */
package ejercicios.ad04te01;

import entidades.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Arkaitz
 */
public class EjercicioB_BorrarOneToMany {
    public static void main(String args[]){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
        EntityManager entityManager = factory.createEntityManager();
        
        // Id que queremos borrar
        int university_id = 3;
        // Comienza la transacción
        entityManager.getTransaction().begin();

        // Cambiamos el .get de hibernate por el .fin
        University tempUni = entityManager.find(University.class, university_id);

        // Borra el estudiante
        entityManager.remove(tempUni);

        // Hace commit de la transacción
        entityManager.getTransaction().commit();

        // Cierra el EntityManager y el EntityManagerFactory
        entityManager.close();
        factory.close();
    }
}
