package huangbowen.net;

import huangbowen.net.service.AccountService;
import huangbowen.net.service.Animal;
import huangbowen.net.service.Monkey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/inheritanceBean.xml"})
public class InheritanceBeansConfigurationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Animal monkey;

    @Autowired
    private Monkey smartMonkey;

    @Autowired
    private AccountService accountService;

    @Test(expected = BeanIsAbstractException.class)
    public void shouldGetErrorWhenRetrieveAnimal() {
        applicationContext.getBean("animal");
    }

    @Test
    public void shouldGetMonkey() {
        assertThat(monkey.getLegs(),is(4));
        assertThat(monkey.getName(),is("dudu"));
    }

    @Test
    public void shouldGetSmartMonkey() {
         assertThat(smartMonkey.getLegs(),is(4));
        assertThat(smartMonkey.getName(),is("smallDudu"));
        assertThat(smartMonkey.isCanDrawing(),is(true));
    }

    @Test
    public void shouldGetAccountService() {
        assertThat(accountService.getAccounts().size(),is(4));

    }
}
