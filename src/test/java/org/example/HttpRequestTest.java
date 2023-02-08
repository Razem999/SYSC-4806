package org.example;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("addressBooks");
    }

    @Test
    public void postRequestsAddressBookTest() throws Exception {
        String resourceUrl = "http://localhost:" + port + "/addressBooks";
        HttpEntity<AddressBook> request = new HttpEntity<>(new AddressBook("Book1"));
        AddressBook addressBook = restTemplate.postForObject(resourceUrl, request, AddressBook.class);
        Assertions.assertNotNull(addressBook);
        Assertions.assertEquals(addressBook.getBookName(), "Book1");
    }

//    @Test
//    public void postRequestsBuddyInfoTest() throws Exception {
//        BuddyInfoRepository buddyInfoRepository;
//        String addressResourceUrl = "http://localhost:" + port + "/addressBooks";
//        HttpEntity<AddressBook> aRequest = new HttpEntity<>(new AddressBook("Book1"));
//        AddressBook addressBook = restTemplate.postForObject(addressResourceUrl, aRequest, AddressBook.class);
////        String buddyResourceUrl = "http://localhost:" + port + "/addressBooks/" + addressBook.getId() + "/buddies";
//        String buddyResourceUrl = "http://localhost:" + port + "/buddyInfoes";
//        HttpEntity<BuddyInfo> bRequest = new HttpEntity<>(new BuddyInfo("Sahil", "613"));
//        BuddyInfo buddyInfo = restTemplate.postForObject(buddyResourceUrl, bRequest, BuddyInfo.class);
//        Assertions.assertNotNull(buddyInfo);
//        System.out.println(buddyInfo);
//        Assertions.assertEquals(buddyInfo.getId(), 1L);


//        AddressBook addressBook = restTemplate.postForObject(resourceUrl, request, AddressBook.class);

//    }
}
