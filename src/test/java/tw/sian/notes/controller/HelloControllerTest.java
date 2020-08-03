package tw.sian.notes.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.sian.notes.NotesApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { NotesApplication.class })
public class HelloControllerTest {

    @Autowired
    HelloController helloController;

    @Test
    public void testHelloReturnExpectedString() {
        final String expected = "hello moneynote";
        final String actual = helloController.hello();
        assertEquals(expected, actual);
    }

    @Test
    public void testHelloReturnUnexceptedString() {
        final String expected = "hello";
        final String actual = helloController.hello();
        assertNotEquals(expected, actual);
    }

}