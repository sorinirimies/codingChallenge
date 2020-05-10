import os

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

class RunVariables(object):
    APPIUM_URL = "http://localhost:4723/wd/hub"
    WAIT_TIMEOUT = 20

class Devices(object):
    APK_PATH = os.path.join(os.path.dirname(__file__), '..\\app\\app-release-unsigned.apk')
    laure_device = {
        "deviceName": "laure_device",
        "app": APK_PATH,
        "platformVersion": "8.0",
        "platformName": "ANDROID"}
    emulator_Nexus_6P_Android_7 = {
        "deviceName": "Nexus_6P_Android_7",
        "app": APK_PATH,
        "platformVersion": "7.1.1",
        "platformName": "ANDROID"}
    direct_device = {
        "app": APK_PATH,
        "automationName": "uiautomator1",
        "noSign": True,
        "platformName": "ANDROID"}

def get_element_by_text(text):
    return (By.XPATH, "//*[contains(@text, '" + text + "')")

