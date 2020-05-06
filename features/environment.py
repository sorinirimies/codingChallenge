from pages.app import app

def before_scenario(context, scenario):
    print("\nBefore scenario : Install and open app 'The Movies'.")
    app.load_app(context)

def after_scenario(context, scenario):
    print("\nAfter scenario : Close appium session.")
    app.close_driver()
