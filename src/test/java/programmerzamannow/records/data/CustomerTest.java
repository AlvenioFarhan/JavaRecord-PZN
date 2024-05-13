package programmerzamannow.records.data;

import org.junit.jupiter.api.Test;

import java.lang.reflect.RecordComponent;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void createNewRecord() {
        Customer customer = new Customer("1", "Alvenio", "alveniofarhan@gmail.com", "085156066856");
        assertNotNull(customer);

        System.out.println(customer);
    }

    @Test
    void getProperty() {
        Customer customer = new Customer("1", "Alvenio", "alveniofarhan@gmail.com", "085156066856");
        assertNotNull(customer);
        assertEquals("1", customer.id());
        assertEquals("Alvenio", customer.name());
        assertEquals("alveniofarhan@gmail.com", customer.email());
        assertEquals("085156066856", customer.phone());
    }

    @Test
    void custructor() {
        Customer customer = new Customer("1", "Alvenio", "alveniofarhan@gmail.com");
        assertNotNull(customer);
        assertEquals("1", customer.id());
        assertEquals("Alvenio", customer.name());
        assertEquals("alveniofarhan@gmail.com", customer.email());
        assertNull(customer.phone());
    }

    @Test
    void canonicalCustructor() {
        Customer customer = new Customer("1", "Alvenio", "ALVENIOFARHAN@GMAIL.COM");
        assertNotNull(customer);
        assertEquals("1", customer.id());
        assertEquals("Alvenio", customer.name());
        assertEquals("alveniofarhan@gmail.com", customer.email());
        assertNull(customer.phone());
    }

    @Test
    void recordMethod() {
        Customer customer = new Customer("1", "Alvenio", "ALVENIOFARHAN@GMAIL.COM");
        assertEquals("Hello Budi, my name is Alvenio", customer.sayHello("Budi"));
    }

    @Test
    void recordEquals() {
        Customer customer1 = new Customer("1", "Alvenio", "alveniofarhan@gmail.com");
        Customer customer2 = new Customer("1", "Alvenio", "alveniofarhan@gmail.com");

        assertTrue(customer1.equals(customer2));
        assertEquals(customer1.hashCode(), customer2.hashCode());
        assertEquals(customer1.toString(), customer2.toString());
    }

    @Test
    void reflection() {
        assertTrue(Customer.class.isRecord());

        RecordComponent[] components = Customer.class.getRecordComponents();
        assertEquals(4, components.length);

        for (RecordComponent component : components){
            System.out.println(component.getName());
            System.out.println(component.getType());
        }
    }
}