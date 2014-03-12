package huangbowen.net;

import huangbowen.net.service.Cinema;
import huangbowen.net.service.DefaultMovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AbstractGenericContextLoader;

import static huangbowen.net.GroovyDSLConfigurationTest.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:Configuration.groovy", loader = GenericGroovyContextLoader.class)
public class GroovyDSLConfigurationTest {

    public static class GenericGroovyContextLoader extends
            AbstractGenericContextLoader {

        @Override
        protected BeanDefinitionReader createBeanDefinitionReader(
                GenericApplicationContext context) {
            return new GroovyBeanDefinitionReader(context);
        }

        @Override
        protected String getResourceSuffix() {
            return ".groovy";
        }

    }

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
