from resources.variables import MoviesListLocators, RunVariables
from pages.app import app
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class MoviesListPage():
    instance = None

    @classmethod
    def get_instance(cls):
        if cls.instance is None:
            cls.instance = MoviesListPage()
        return cls.instance

    def __init__(self):
        pass

    def check_moviesListPage(self):
        WebDriverWait(app.get_driver(), RunVariables.WAIT_TIMEOUT).until(EC.presence_of_element_located(MoviesListLocators.TITLE))
        view = app.get_driver().find_element(*MoviesListLocators.VIEWER_PAGE)
        footer = app.get_driver().find_element(*MoviesListLocators.FOOTER)
        WebDriverWait(app.get_driver(), RunVariables.WAIT_TIMEOUT).until(EC.presence_of_element_located(MoviesListLocators.MOVIES_CONTENT))
        print(" - Movies list page check.")


    def click_on_movie(self, text):
        found = False
        WebDriverWait(app.get_driver(), RunVariables.WAIT_TIMEOUT).until(EC.presence_of_element_located(MoviesListLocators.MOVIES_CONTENT))
        movies = app.get_driver().find_elements(*MoviesListLocators.MOVIES_CONTENT)
        for i in range(0,len(movies)):
            WebDriverWait(app.get_driver(), RunVariables.WAIT_TIMEOUT).until(EC.presence_of_element_located(MoviesListLocators.MOVIES_CONTENT))
            title = app.get_driver().find_elements(*MoviesListLocators.MOVIES_CONTENT)[i].text
            if text in title:
                WebDriverWait(app.get_driver(), RunVariables.WAIT_TIMEOUT).until(EC.presence_of_element_located(MoviesListLocators.MOVIES_CONTENT))
                app.get_driver().find_elements(*MoviesListLocators.MOVIES_CONTENT)[i].click()
                found = True
                print(" - Film " + text + " found. Click on it.")
                break
        if not found:
            print(" - Film " + text + " not found. Swipe.")
            location = app.get_driver().find_element(*MoviesListLocators.MOVIES_PANEL).location
            size = app.get_driver().find_element(*MoviesListLocators.MOVIES_PANEL).size
            origX = location['x'] + size['width']/2
            origY = size['height']
            destX = size['width']/2
            destY = location['y']
            app.get_driver().swipe(origX, origY, destX, destY)
            self.click_on_movie(text)

movieListPage = MoviesListPage.get_instance()