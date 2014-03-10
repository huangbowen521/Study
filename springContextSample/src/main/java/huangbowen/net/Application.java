package huangbowen.net;

import huangbowen.net.service.Cinema;
import huangbowen.net.service.DefaultMovieService;
import huangbowen.net.service.MovieService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application
{

    @Bean
    public MovieService getMovieService() {
        return new DefaultMovieService();
    }

    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        Cinema cinema = applicationContext.getBean(Cinema.class);
        cinema.printMovieName();

    }
}
