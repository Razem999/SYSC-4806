package org.example;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HttpRequestTest {

    HttpEntity<AddressBook> request = new HttpEntity<>(new AddressBook("Book1"));

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

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
////        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Hello, World")));
////        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Hello, World")));
//        String resourceUrl = "http://localhost:" + port + "/addressBooks";
//        HttpEntity<AddressBook> request = new HttpEntity<>(new AddressBook("Book1"));
//        AddressBook addressBook = restTemplate.postForObject(resourceUrl, request, AddressBook.class);
//        this.mockMvc.perform(post("/buddyInfoes").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
//    }

//    @Test
//    public void postRequestsBuddyInfoTest() throws Exception {
//        this.mockMvc.perform(put("/addressBooks")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("\"id\"")));
//        this.mockMvc.perform(post("/buddies?bookId=1").contentType(MediaType.APPLICATION_JSON).content("{\n" +
//                "\t\"name\":\"Sahil\",\n" +
//                "\t\"number\":\"613\"\n" +
//                "}")).andDo(print()).andExpect(status().isOk());
//    }

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
//
//
////        AddressBook addressBook = restTemplate.postForObject(resourceUrl, request, AddressBook.class);
//
//    }
}
