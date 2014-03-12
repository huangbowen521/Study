beans {

//   movieService huangbowen.net.service.DefaultMovieService
//
//   cinema huangbowen.net.service.Cinema, movieService : movieService


    movieService (huangbowen.net.service.DefaultMovieService)

    cinema(huangbowen.net.service.Cinema, {movieService : movieService})


    movieService huangbowen.net.service.DefaultMovieService

    cinema (huangbowen.net.service.Cinema) {
        movieService :ref movieService
    }

    movieService huangbowen.net.service.DefaultMovieService

    cinema (huangbowen.net.service.Cinema) {
        movieService : movieService
    }

}