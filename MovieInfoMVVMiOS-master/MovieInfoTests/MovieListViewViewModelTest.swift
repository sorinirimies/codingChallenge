//
//  MovieListViewViewModelTest.swift
//  MovieInfoTests
//
//  Created by Fabio Santos on 23.04.20.
//  Copyright © 2020 Alfian Losari. All rights reserved.
//

import XCTest
import RxTest
import RxSwift
import RxCocoa
import RxBlocking

@testable import MovieInfo

class MovieListViewViewModelTest: XCTestCase {

	// MARK: - Properties

	var viewModel: MovieListViewViewModel!
	var scheduler: SchedulerType!
	var endpoint: BehaviorRelay<Endpoint>!


	override func setUp() {
		// Initialize endpoint
		endpoint = BehaviorRelay<Endpoint>(value:Endpoint.init(index: 0)!)

		// Initialize movie service
		let movieService = MockMovieService()

		// Initialize view model
		viewModel = MovieListViewViewModel(endpoint: endpoint.asDriver(), movieService: movieService)

		// Initialize scheduler
		scheduler = ConcurrentDispatchQueueScheduler(qos: .default)
	}

	func testFilterByPlayingNow() {

		// Subscription
		let observable = viewModel.movies.asObservable().subscribeOn(scheduler)

		// Emit event ".value"
		endpoint.accept(Endpoint.init(index: 0)!)

		// Fetch Result
		let result = try! observable.toBlocking().first()!

		XCTAssertNotNil(result)
		XCTAssertEqual(result.count, 1)

		// Fetch Movie
		let movie = result.first!

		XCTAssertEqual(movie.title, MovieTestTitle.playingNow)
	}

	override func tearDown() {
		viewModel = nil
		scheduler = nil
		endpoint = nil
	}
}


