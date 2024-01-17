/**
 * Ejercicio A. Borrar un objeto tuition y asu ves uno student
 */
package ejercicios.ad04te01;

import entidades.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Arkaitz
 */
public class EjercicioA_BorrarOneToOne {
    public static void main(String args[]){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
        EntityManager entityManager = factory.createEntityManager();
        
        // Id que queremos borrar
        int student_id = 8;
        // Comienza la transacción
        entityManager.getTransaction().begin();

        // Cambiamos el .get de hibernate por el .fin
        Student tempStudent = entityManager.find(Student.class, student_id);

        // Borra el estudiante
        entityManager.remove(tempStudent);

        // Hace commit de la transacción
        entityManager.getTransaction().commit();

        // Cierra el EntityManager y el EntityManagerFactory
        entityManager.close();
        factory.close();
    }
    
}
