package example

import javax.persistence.*

@Entity
class Person implements Serializable{

	@Id
	@GeneratedValue
	Integer personId
	String firstName
	String lastName
}