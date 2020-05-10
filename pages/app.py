import sys

from appium import webdriver
from resources.variables import RunVariables, Devices

class AndroidApp():

    instance = None

    @classmethod
    def get_instance(cls):
        if cls.instance is None:
            cls.instance = AndroidApp()
            return cls.instance

    def __init__(self):
        self.driver = ""
        pass

    def load_app(self, context):
        device = context.config.userdata.get("device")
        desired_caps = getattr(Devices, device)
        self.driver = webdriver.Remote(RunVariables.APPIUM_URL, desired_caps)

    def get_driver(self):
        return self.driver

    def close_driver(self):
        return self.driver.quit()

app = AndroidApp.get_instance()
