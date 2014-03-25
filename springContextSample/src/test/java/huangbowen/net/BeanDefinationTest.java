package huangbowen.net;

import huangbowen.net.PAndCNamespace.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beanDefination.xml"})
public class BeanDefinationTest {

    @Autowired
    private ApplicationContext applicationContext;


    @Autowired
    private Person person;

    @Test
    public void shouldGetPerson() {
        assertThat(person.getNameRef(), is("Tom"));
        assertThat(person.getAge(), is(20));

    }
}
