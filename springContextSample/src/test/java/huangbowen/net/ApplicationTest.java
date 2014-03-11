package huangbowen.net;


import huangbowen.net.service.Cinema;
import huangbowen.net.service.DefaultMovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class ApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Cinema cinema;

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
    }
}
