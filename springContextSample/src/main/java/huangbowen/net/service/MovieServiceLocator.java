package huangbowen.net.service;

public class MovieServiceLocator {

    private static DefaultMovieService defaultMovieService = new DefaultMovieService();

    public MovieService GetMovieService() {
        return defaultMovieService;
    }
}
