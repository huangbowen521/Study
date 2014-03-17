package huangbowen.net;

import huangbowen.net.DependecyInjection.SetterInjection.Cat;
import huangbowen.net.DependecyInjection.SetterInjection.MessageHandler;
import huangbowen.net.DependecyInjection.SetterInjection.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-context.xml"})
public class ApplicationContextTest {

    @Autowired
    private MessageHandler messageHandler;

    @Autowired
    private Person person;

    @Autowired
    private Cat cat;

    @Test
    public void shouldGetMessageHandler() {
        assertThat(messageHandler.handle(), is("hello world!"));
    }

    @Test
    public void shouldGetPerson() {
        assertThat(person.getAge(),is(20));
        assertThat(person.getName(),is("Tom"));

    }

    @Test
    public void shouldGetCat() {
        assertThat(cat.isFat(), is(true));

    }
}
