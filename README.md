# QA Engineer Coding Challenge

## 1. Topic
### 1.1. Goal
To be able to run automated test on an independant IMDB application.

Plus, do some network traffic check.
### 1.2. Chosen solution
Will be used :
   - Java
   - Gradle
   - TestNG
   - Cucumber
   - Appium
   
## 2. Prerequisites 

### 2.1. Environment (to be installed)
- gradle 6 (or above) (code isn't compatible with older versions)
- Java
- Node
- Appium
- mitmproxy

### 2.2. Other Tools 
- Intellij IDEA (CE is enough) 

Note: Intellij IDEA include both Cucumber and TestNG support.

## 3. Solution

### 3.1. Cucumber Test using Java

#### 3.1.1. Test Cases

the tests are to be found in 
>src/test/resources/gradle.cucumber

They look like :
<img src="content/feature.png">

#### 3.1.2. Runner

Using TestNG runner, with cucumber options.
The called xml file is 
>src/test/java/utils/testng.xml

#### 3.1.3. Reports

Using basic cucumber reporting (pretty-html could be used, but not relevant here)
<img src="content/cucumber_report.png">

#### 3.1.4. Devices

This code can run on either AVD or real device.
Note that network tests will be done on AVD only.

#### 3.1.5. Chosen Application

Application build from project https://github.com/skydoves/TheMovies


### 3.2. Pre-launch

open 2 terminal:
- 1st one:
> appium
- 2nd one:
> mitmproxy

Open your AVD or connect your real device.

### 3.3. Launch tests

to launch project (CLI)
> gradle test

