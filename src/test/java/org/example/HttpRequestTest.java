package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Value(value = "${local.server.port}")

    private int port;

    // Inject the controller before the test methods run
    @Autowired
    private AddressBookController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void baseAddressDefaultMessage() {
        // this guy seems to grab the whole template for the provided url, and search the entire thing for the string provided
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Hello!");
    }

    @Test
    public void testCreateAddressBook() {
        this.restTemplate.getForEntity("http://localhost:" + port + "/addressBook/new", String.class);

        ResponseEntity<AddressBook> response = this.restTemplate.getForEntity("http://localhost:" + port
                + "/test/addressBook?id=1", AddressBook.class);

        assertEquals(1, response.getBody().getId());
    }

    @Test
    public void testAddBuddy() {
        this.restTemplate.getForEntity("http://localhost:" + port + "/addressBook/new", String.class);
        this.restTemplate.getForEntity("http://localhost:" + port
                + "/addressBook/buddy/add?address_id=1&name=Bilal&phoneNumber=613-999-9999", String.class);

        ResponseEntity<AddressBook> response = this.restTemplate.getForEntity("http://localhost:" + port
                + "/test/addressBook?id=1", AddressBook.class);

        assertEquals(1, response.getBody().getAddressBook().size());
    }

}
