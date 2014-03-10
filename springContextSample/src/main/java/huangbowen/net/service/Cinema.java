package huangbowen.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by twer on 3/11/14.
 */
@Component
public class Cinema {

    @Autowired
    private MovieService movieService;

    public void printMovieName() {
        System.out.println(movieService.getMovieName());
    }
}
