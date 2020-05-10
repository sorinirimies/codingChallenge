from resources.variables import MovieDetailsLocators, RunVariables
from pages.app import app
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class MovieDetailsPage():
    instance = None

    @classmethod
    def get_instance(cls):
        if cls.instance is None:
            cls.instance = MovieDetailsPage()
        return cls.instance

    def __init__(self):
        self.driver = app.get_driver()

    def get_title(self):
        el = WebDriverWait(app.get_driver(), RunVariables.WAIT_TIMEOUT).until(EC.presence_of_element_located(MovieDetailsLocators.TITLE))
        return el.text

    def get_release_date(self):
       el = WebDriverWait(app.get_driver(), RunVariables.WAIT_TIMEOUT).until(EC.presence_of_element_located(MovieDetailsLocators.RELEASE_DATE))
       return el.text

movieDetailsPage = MovieDetailsPage.get_instance()