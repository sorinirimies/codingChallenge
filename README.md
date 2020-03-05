# QA Engineer Coding Challenge

Hello there and wellcome to our coding challenge. Buckel up and enjoy the ride. 

## Rules
Before we start there are some rules of engagement:
1. Submissions must be formulated as GitHub merge requests
2. You can make smaller commits and MRs so that we can see the gradual progress
3. Please respect the given deadline

## Setup before starting
- create a GitHub Account if not having one already
- create a TMDB account https://www.themoviedb.org/documentation/api
- use a proxy tool, e.g. https://mitmproxy.org

## The Challenge

The challenge consits in:
- creating a small `Java`, preferably `Kotlin` project. The project can be either a Backend service (preferably Spring or Ktor), or a simple iOS or Android app
- the project should contain some http client that calls TMDB API https://www.themoviedb.org/documentation/api
- the requests can be query movies based on `release_date`, `popularity` etc. It is up to you how you want to use TMDB API
- Java, Kotlin or Swift Unit Tests dealing with checking the requests and their response
- traces recorded through a proxy client (e.g.  mitmproxy) containing traffic for the specific request

