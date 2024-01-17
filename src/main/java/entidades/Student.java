package entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.annotations.Formula;

@Entity
@Table(name="student")
public class Student {
    
    // Atributos
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
    
    @Embedded
    private Address address;
    
    @ElementCollection 
    @CollectionTable(name= "student_phone", joinColumns=@JoinColumn(name="student_id"))
    @Column(name="student_phone")
    private List<String> phones = new ArrayList<String>();
    
    @Column (name="birthdate")
    private LocalDate birthdate;
  
    @Formula ("floor(datediff(curdate(), birthdate)/365)")
    private Integer age;
    
    @OneToOne(mappedBy="student",cascade = CascadeType.ALL)
    private Tuition tuition; 
    
    @ManyToOne
    @JoinColumn(name="university_id")
    private University university;
    
    // No queremos que si borra el student se borre el curso
    @ManyToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="student_course", joinColumns=@JoinColumn(name="student_id"), 
                    inverseJoinColumns=@JoinColumn(name="course_id"))
    private Set<Course> courses = new HashSet<>();
    
    
    // Constructores
    public Student() {

    }
        
    public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
    
    // Getters y Setters
    public int getId() {
		return id;
	}

    public void setId(int id) {
            this.id = id;
    }

    public String getFirstName() {
            return firstName;
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    public String getLastName() {
            return lastName;
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }
    
    public Address getAddress() {
            return address;
    }

    public void setAddress(Address address) {
            this.address = address;
    }
    public List<String> getPhones(){
            return phones;
        }
        
    public void setPhones(List<String> phone){
        this.phones = phone;
    }

    public LocalDate getBirthdate() {
            return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
    }

    public int getAge() {
            return age;
    }

    public void setAge(int age) {
            this.age = age;
    }


    public Tuition getTuition() {
            return tuition;
    }

    public void setTuition(Tuition tuition) {
            this.tuition = tuition;
    }

    public University getUniversity() {
            return university;
    }

    public void setUniversity(University university) {
            this.university = university;
    }
    
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


    @Override
    public String toString() {
            return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
