package example

import groovy.util.*
import javax.persistence.*

class BasicPersistenceTest extends GroovyTestCase{
	
	void test_basic_persistence(){
		def factory = Persistence.createEntityManagerFactory("yourunitname")
		def manager = factory.createEntityManager()
		def fname = 'Matt'
		def lname = 'Givney'
		def person = new Person(firstName: fname, lastName: lname)
		manager.transaction.begin()
		manager.persist(person)
		manager.transaction.commit()
		def result =  manager.createQuery('SELECT p FROM Person p WHERE p.firstName = :firstName')
			.setParameter('firstName', fname)
			.getSingleResult()
			
		assertEquals(fname, result.firstName)
		assertEquals(lname, result.lastName)
		manager.close()
		factory.close()
	}	
	
}