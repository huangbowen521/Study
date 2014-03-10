package huangbowen.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cinema {

    @Autowired
    private MovieService movieService;

    public void printMovieName() {
        System.out.println(movieService.getMovieName());
    }
}
