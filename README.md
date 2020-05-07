# SETUP
## Topic
### Goal
To be able to run automated test on an independant IMDB application.

Plus, do some network traffic check.
### Chosen solution
Will be used :
   - Java
   - Gradle
   - TestNG
   - Cucumber
   - Appium
   
## Prerequisites 

### Environment (to be installed)
- gradle 6 (or above) (code isn't compatible with older versions)
- Java
- Node
- Appium
- mitmproxy

### Other Tools 
- Intellij IDEA (CE is enough) 

Note: Intellij IDEA include both Cucumber and TestNG support.

## Solution

### Cucumber Test using Java

#### Test Cases

the tests are to be found in 
>src/test/resources/gradle.cucumber

They look like <img src="content/feature.png">

#### Runner

Using TestNG runner, with cucumber options.
The called xml file is 
>src/test/java/utils/testng.xml

#### Reports

Using basic cucumber reporting (pretty-html could be used, but not relevant here)
<img src="content/cucumber_report.png">

#### Devices

This code can run on either AVD or real device.
Note that network tests will be done on AVD only.

### Pre-launch

open 2 terminal:
- 1st one:
> appium
- 2nd one:
> mitmproxy

Open your AVD or connect your real device.

### Launch tests

to launch project (CLI)
> gradle test



Application build from project https://github.com/skydoves/TheMovies

