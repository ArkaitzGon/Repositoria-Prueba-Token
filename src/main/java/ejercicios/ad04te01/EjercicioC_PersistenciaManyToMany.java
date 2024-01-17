/**
 * Ejercicio C Guardar un objeto student y uno course
 * Entiendo que no hay que elegir un alumno, si no crear un estudiante y un curso y guardarlos
 */
package ejercicios.ad04te01;

import entidades.Address;
import entidades.Course;
import entidades.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class EjercicioC_PersistenciaManyToMany {
    public static void main(String args[]){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
        EntityManager entityManager = factory.createEntityManager();

        Student student = createStudent();
        Course course = createCourse();

        student.getCourses().add(course);
        course.getStudents().add(student);
        
        // Empieza la transaccion del student
        entityManager.getTransaction().begin();
        
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        
        // Empieza la transaccion del curso
        entityManager.getTransaction().begin();
        
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
    
    /**
     * Metodo para crear un Student
     * @return Student creado
     */
    private static Student createStudent() {
        Student tempStudent = new Student();
        Address tempAddress = new Address();
        tempStudent.setFirstName("Koldo");
        tempStudent.setLastName("Bilbao");
        tempStudent.setEmail("kbilbao@birt.eus");
        tempAddress.setAddressLine1("Kale Nagusia 10");
        tempAddress.setAddressLine2("4B");
        tempAddress.setCity("Erandio");
        tempAddress.setZipCode("20003");
        tempStudent.setAddress(tempAddress);
        return tempStudent;		
	}
    
    /**
     * Metodo que crea un cruso
     * @return Course con el curso creado
     */
    private static Course createCourse() {
        Course tempCourse = new Course();

        tempCourse.setName("Bases de datos");
        tempCourse.setCredits(6);
        return tempCourse;		
    }
}
