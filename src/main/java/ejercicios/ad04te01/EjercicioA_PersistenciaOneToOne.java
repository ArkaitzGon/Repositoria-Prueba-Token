/**
 * Ejercicio A. Guadar un objeto student y otro tuition
 */
package ejercicios.ad04te01;

import entidades.Address;
import entidades.Student;
import entidades.Tuition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Arkaitz
 */
public class EjercicioA_PersistenciaOneToOne {
    
    public static void main(String args[]){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
        EntityManager entityManager = factory.createEntityManager();

        Student student = createStudent();
        
        Tuition tuition = new Tuition();
        tuition.setFee(2600.23);
        tuition.setStudent(student);
        // Empieza la transaccion
        entityManager.getTransaction().begin();
        
        // Guardamos el tuiton en vez de el student 
        // con cascadeType.all guarda tambien el student
        entityManager.persist(tuition);
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
		tempStudent.setFirstName("Aritz");
		tempStudent.setLastName("Lekue");
		tempStudent.setEmail("alekue@birt.eus");
		tempAddress.setAddressLine1("Kale Nagusia 18");
		tempAddress.setAddressLine2("5A");
		tempAddress.setCity("Gasteiz");
		tempAddress.setZipCode("20003");
		tempStudent.setAddress(tempAddress);
		return tempStudent;		
	}
    
}
