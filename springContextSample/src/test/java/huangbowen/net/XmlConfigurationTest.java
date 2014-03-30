package huangbowen.net;

import huangbowen.net.DependecyInjection.ConstructorInjection.MessageHandler;
import huangbowen.net.DependecyInjection.ConstructorInjection.Person;
import huangbowen.net.service.*;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/configuration.xml"})
public class XmlConfigurationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Cinema cinema;

    @Autowired
    private MessageHandler messageHandler;

    @Autowired
    private Person person;

    @Autowired
    private AccountService accountService;

    @Autowired
    private Cookbook cookbook;

    @Autowired
    private DatabaseSource databaseSource;

    @Autowired
    private Restaurant restaurant;

    @Test
    public void shouldGetCinemaInstance()  {
        Cinema cinema = applicationContext.getBean(Cinema.class);
        assertNotNull(cinema);
    }

    @Test
    public void shouldGetAutowiredCinema() {
        assertNotNull(cinema);
    }

    @Test
    public void shouldGetMovieServiceInstance() {
        assertNotNull(cinema.getMovieService());
        assertThat(cinema.getMovieService(), instanceOf(DefaultMovieService.class));
        assertThat(cinema.getServiceRef(),is("movieService"));
    }

    @Test
    public void shouldGetMessageHandler() {
        assertNotNull(messageHandler);
        assertThat(messageHandler.handle(), is("hello world!"));
    }

    @Test
    public void shouldGetPerson() {
        assertThat(person.getName(), is("Tom"));
        assertThat(person.getAge(), is(20));

    }


    @Test
    public void shouldGetAccountService() {
        Map<String,Integer> accounts = accountService.getAccounts();
        assertThat(accounts.size(),is(2));
        assertThat(accounts.get("bowen"),is(1234));
    }

    @Test
    public void shouldGetCookbook() {
        List<String> recipe = cookbook.getRecipe();
        assertThat(recipe.size(), is(3));
        assertThat(recipe.get(0),is("noodle"));
    }

    @Test
    public void shouldGetDataSource() {

        assertThat(databaseSource.getSource().get("port"), Is.<Object>is("2012"));

    }

    @Test
    public void shouldGetRestaurant() {
        assertThat(restaurant.getManager().getAge(),is(20));

    }
}
