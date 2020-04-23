//
//  MockMovieService.swift
//  MovieInfoTests
//
//  Created by Fabio Santos on 23.04.20.
//  Copyright © 2020 Alfian Losari. All rights reserved.
//

import Foundation

@testable import MovieInfo

class MockMovieService: MovieService {

	var error: Error?

	func fetchMovies(from endpoint: Endpoint, params: [String : String]?, successHandler: @escaping (MoviesResponse) -> Void, errorHandler: @escaping (Error) -> Void) {
		switch endpoint {
		case .nowPlaying:
			let movie = Movie(testTitle: MovieTestTitle.playingNow)
			let movieResponse = MoviesResponse(page: 1, totalResults: 1, totalPages: 1, results: [movie])

			if let error = error {
				errorHandler(error)
				return
			} else {
				// invoke completion handler
				successHandler(movieResponse)
			}

		case .topRated:
			let movie = Movie(testTitle: MovieTestTitle.topRated)
			let movieResponse = MoviesResponse(page: 1, totalResults: 1, totalPages: 1, results: [movie])

			if let error = error {
				errorHandler(error)
				return
			} else {
				// invoke completion handler
				successHandler(movieResponse)
			}

		case .popular:
			let movie = Movie(testTitle: MovieTestTitle.popular)
			let movieResponse = MoviesResponse(page: 1, totalResults: 1, totalPages: 1, results: [movie])

			if let error = error {
				errorHandler(error)
				return
			} else {
				// invoke completion handler
				successHandler(movieResponse)
			}

		case .upcoming:
			let movie = Movie(testTitle: MovieTestTitle.ucoming)
			let movieResponse = MoviesResponse(page: 1, totalResults: 1, totalPages: 1, results: [movie])

			if let error = error {
				errorHandler(error)
				return
			} else {
				// invoke completion handler
				successHandler(movieResponse)
			}
		}
	}

	func fetchMovie(id: Int, successHandler: @escaping (Movie) -> Void, errorHandler: @escaping (Error) -> Void) {
		// TODO
	}

	func searchMovie(query: String, params: [String : String]?, successHandler: @escaping (MoviesResponse) -> Void, errorHandler: @escaping (Error) -> Void) {
		// TODO
	}
}

struct MovieTestTitle {
	static let playingNow = "Test Playing Now"
	static let topRated = "Test Top Rated"
	static let popular = "Test Popular"
	static let ucoming = "Test Upcoming"
}

extension Movie {
	init(testTitle: String) {
		self.init(id: 123, title: testTitle, backdropPath: nil, posterPath: nil, overview: "overview", releaseDate: Date(timeIntervalSince1970: 1), voteAverage: 2.3, voteCount: 2, tagline: nil, genres: [MovieGenre(name: "Comedy")], videos: nil, credits: nil, adult: true, runtime: nil)
	}
}
