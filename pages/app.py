import sys

from appium import webdriver
import os

class AndroidApp():

    dirname = os.path.dirname(__file__)
    filename = os.path.join(dirname, '..\\app\\app-debug.apk')
    appium_url = "http://localhost:4723/wd/hub"

    laure_device = {
            "deviceName": "laure_device",
            "app": filename,
            "platformName": "ANDROID"}
    emulator_Pixel_3 = {
        "deviceName": "Pixel_3_android_8.1",
        "app": filename,
        "platformVersion": "8.1",
        "platformName": "ANDROID"}
    direct_device = {
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

    def load_app(self, context):
        device = context.config.userdata.get("device")
        if device == "laure_device":
            desired_caps = self.laure_device
        elif device == "emulator_Pixel_3":
            desired_caps = self.emulator_Pixel_3
        elif device == "direct_device":
            desired_caps = self.direct_device
        else:
            print("No desired capabilities found for this device name.")
            sys.exit();
        self.driver = webdriver.Remote(self.appium_url, desired_caps)

    def get_driver(self):
        return self.driver

    def close_driver(self):
        return self.driver.quit()

app = AndroidApp.get_instance()
