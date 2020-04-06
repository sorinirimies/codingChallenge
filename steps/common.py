from behave import given, when, then
from pages.app import app
from pages.moviesList import movieListPage
from pages.movieDetails import movieDetailsPage
from hamcrest import *


@given(u'I am on "movies list" page')
def step_impl(context):
    app.load_app()
    movieListPage.check_moviesListPage()
    
@when(u'I go to detail page of "{title}"')
def step_impl(context, title):
    movieListPage.click_on_movie(title)
    
@then(u'I see the release date "{release_date}" of "{title}"')
def step_impl(context, release_date, title):
    assert_that(movieDetailsPage.get_title(), equal_to(title))
    assert_that(movieDetailsPage.get_release_date(), equal_to("Release Date : "+release_date))

