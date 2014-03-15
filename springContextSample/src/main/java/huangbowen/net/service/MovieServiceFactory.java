package huangbowen.net.service;

public class MovieServiceFactory {

    private static DefaultMovieService defaultMovieService = new DefaultMovieService();

    public static MovieService GetMovieService() {
        return defaultMovieService;
    }
}
