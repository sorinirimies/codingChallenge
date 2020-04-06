# QA Engineer Coding Challenge

Hello there and welcome to our coding challenge. Buckel up and enjoy the ride. 

## Rules
Before we start there are some rules of engagement:
1. Submissions must be formulated as GitHub merge requests
2. You can make smaller commits and MRs so that we can see the gradual progress
3. Please respect the given deadline

## Setup before starting
- create a GitHub Account if not having one already => github user : lolotoms
- create a TMDB account https://www.themoviedb.org/documentation/api => TMDB user : lolotoms
- use a proxy tool, e.g. https://mitmproxy.org

## The Challenge

The challenge consits in:
1. Choose one of an already existing Android or iOS TMDB client Apps from these:

https://github.com/skydoves/TheMovies => I choose this one

https://github.com/alfianlosari/MovieInfoMVVMiOS

https://github.com/haroldadmin/MovieDB

https://github.com/IhwanID/belajar-android-jetpack-pro

2. Write automation tests based on the sample project you chose. Automations tests should include:
- going from main movies list screen to the details screen of the app => 1 scenario outline : Check movie details (features folder)
- filtering movies based on year or popularity => No filtering functionality found !

3. Cucumber UI features:
- based on the screens in the app write Cucumber features => 1 scenario outline : Check movie details (features folder)

4. Network tests => Not possible on real device which need to be root
- use one of the tracing tools to trace the app network traffic
- simulate network velocity

## Run tests

- Install appium with npm and run it => Appium runing on http://localhost:4723
- Connect your real device to computer
- double click on run_tests.sh
