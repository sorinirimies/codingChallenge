from appium import webdriver
import os

class AndroidApp():
    dirname = os.path.dirname(__file__)
    filename = os.path.join(dirname, '..\\app\\app-debug.apk')
    desired_caps = {
            "deviceName": "laureDevice",
            "app": filename,
            "platformName": "ANDROID"}
    instance = None

    @classmethod
    def get_instance(cls):
        if cls.instance is None:
            cls.instance = AndroidApp()
            return cls.instance

    def __init__(self):
        self.driver = ""
        pass

    def load_app(self):
        self.driver = webdriver.Remote("http://localhost:4723/wd/hub", self.desired_caps)

    def get_driver(self):
        return self.driver

app = AndroidApp.get_instance()
