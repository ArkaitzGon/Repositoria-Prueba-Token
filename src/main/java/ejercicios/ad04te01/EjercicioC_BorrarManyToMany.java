/**
 * Ejercicio C Borrar objetos
 * Borra el estudiante con el id seleccionado
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
public class EjercicioC_BorrarManyToMany {
    
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
        EntityManager entityManager = factory.createEntityManager();
        // ID del estudiante que se quiere borrar
        int student_id = 13;
			
        Student tempStudent= entityManager.find(Student.class, student_id);
        
        // Borra estudiante y el student_course
        entityManager.getTransaction().begin();
        entityManager.remove(tempStudent);
        entityManager.getTransaction().commit();

        // Cierra el EntityManager y el EntityManagerFactory
        entityManager.close();
        factory.close();
    }
}
