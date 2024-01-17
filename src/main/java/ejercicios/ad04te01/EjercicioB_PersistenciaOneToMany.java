/**
 * Ejercicio b Guardar un objeto university y otro student
 */
package ejercicios.ad04te01;

import entidades.Address;
import entidades.Student;
import entidades.Tuition;
import entidades.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Arkaitz
 */
public class EjercicioB_PersistenciaOneToMany {
    public static void main(String args[]){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
        EntityManager entityManager = factory.createEntityManager();

        Student student = createStudent();
        University uni = createUniversity();
        
        // Relacion Bidireccional
        uni.getStudents().add(student);
        student.setUniversity(uni);
        
        // Empieza la transaccion
        entityManager.getTransaction().begin();
        
        // Guardamos la universidad en vez de el student 
        // con cascadeType.all guarda tambien el student
        entityManager.persist(uni);
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
        tempStudent.setFirstName("Peio");
        tempStudent.setLastName("Unamuno");
        tempStudent.setEmail("punamuno@birt.eus");
        tempAddress.setAddressLine1("Kale Nagusia 10");
        tempAddress.setAddressLine2("4B");
        tempAddress.setCity("Bilbao");
        tempAddress.setZipCode("20003");
        tempStudent.setAddress(tempAddress);
        return tempStudent;		
	}
    /**
     * Metodo que crea una universidad
     * @return University con la universidad creada
     */
    private static University createUniversity() {
		University tempUniversity = new University();
		Address uniAddress = new Address();
		
		tempUniversity.setName("EHU");
		uniAddress.setAddressLine1("Asrriena");
		uniAddress.setAddressLine2("8");
		uniAddress.setCity("Leioa");
		uniAddress.setZipCode("41455");
		tempUniversity.setAddress(uniAddress);
		return tempUniversity;		
	}
}
