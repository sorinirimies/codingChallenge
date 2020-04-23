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
	var movieService: MockMovieService!


	override func setUp() {
		// Initialize endpoint
		endpoint = BehaviorRelay<Endpoint>(value:Endpoint.init(index: 0)!)

		// Initialize movie service
		movieService = MockMovieService()

		// Initialize view model
		viewModel = MovieListViewViewModel(endpoint: endpoint.asDriver(), movieService: movieService)

		// Initialize scheduler
		scheduler = ConcurrentDispatchQueueScheduler(qos: .default)
	}

	func testHasError() {

		movieService.error = MovieError.noData

		// Subscription
		let observable = viewModel.movies.asObservable().subscribeOn(scheduler)

		endpoint.accept(Endpoint.init(index: 0)!)

		// Fetch Result
		let result = try! observable.toBlocking().first()!

		XCTAssertEqual(result.count, 0)
		XCTAssertTrue(viewModel.hasError)
	}

	func testFilterByPlayingNow() {

		// Subscription
		let observable = viewModel.movies.asObservable().subscribeOn(scheduler)

		endpoint.accept(Endpoint.init(index: 0)!)

		// Fetch Result
		let result = try! observable.toBlocking().first()!

		XCTAssertNotNil(result)
		XCTAssertEqual(result.count, 1)

		// Fetch Movie
		let movie = result.first!

		XCTAssertEqual(movie.title, MovieTestTitle.playingNow)
	}

	func testFilterByTopRated() {

		// Subscription
		let observable = viewModel.movies.asObservable().subscribeOn(scheduler)

		endpoint.accept(Endpoint.init(index: 3)!)

		// Fetch Result
		let result = try! observable.toBlocking().first()!

		XCTAssertNotNil(result)
		XCTAssertEqual(result.count, 1)

		// Fetch Movie
		let movie = result.first!

		XCTAssertEqual(movie.title, MovieTestTitle.topRated)
	}

	func testFilterByPopular() {

		// Subscription
		let observable = viewModel.movies.asObservable().subscribeOn(scheduler)

		endpoint.accept(Endpoint.init(index: 1)!)

		// Fetch Result
		let result = try! observable.toBlocking().first()!

		XCTAssertNotNil(result)
		XCTAssertEqual(result.count, 1)

		// Fetch Movie
		let movie = result.first!

		XCTAssertEqual(movie.title, MovieTestTitle.popular)
	}

	func testFilterByUpcoming() {

		// Subscription
		let observable = viewModel.movies.asObservable().subscribeOn(scheduler)

		endpoint.accept(Endpoint.init(index: 2)!)

		// Fetch Result
		let result = try! observable.toBlocking().first()!

		XCTAssertNotNil(result)
		XCTAssertEqual(result.count, 1)

		// Fetch Movie
		let movie = result.first!

		XCTAssertEqual(movie.title, MovieTestTitle.ucoming)
	}

	override func tearDown() {
		viewModel = nil
		scheduler = nil
		endpoint = nil
		movieService = nil
	}
}


