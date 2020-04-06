from selenium.webdriver.common.by import By

class MoviesListLocators(object):
    TITLE = (By.ID, 'toolbar_title')
    VIEWER_PAGE = (By.ID, 'main_viewpager')
    FOOTER = (By.ID, 'main_bottom_navigation')
    MOVIES_CONTENT = (By.XPATH, "//android.widget.RelativeLayout/android.widget.TextView")
    MOVIES_PANEL = (By.XPATH, "//androidx.recyclerview.widget.RecyclerView")

class MovieDetailsLocators(object):
    TITLE = (By.ID, 'detail_header_title')
    RELEASE_DATE = (By.ID, 'detail_header_release')


def get_element_by_text(text):
    return (By.XPATH, "//*[contains(@text, '" + text + "')")

