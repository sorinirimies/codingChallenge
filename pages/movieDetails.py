from resources.locators import *
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
        el = WebDriverWait(app.get_driver(), 20).until(EC.presence_of_element_located((By.ID, 'detail_header_title')))
        return el.text

    def get_release_date(self):
       el = WebDriverWait(app.get_driver(), 20).until(EC.presence_of_element_located((By.ID, 'detail_header_release')))
       return el.text

movieDetailsPage = MovieDetailsPage.get_instance()