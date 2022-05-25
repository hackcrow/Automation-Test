# Automation-Test
QA Challenge

This project is about to Automation Test Challenge

Requirements:

* Access Gmail site and validate a user (Using any email and password no need to share that with us).

* Go to label list click more on the categories list.

* Create a new category and save it.

* Go to spam folder and then empty the spam folder.

* Sign out of the account.

Technical Requirements:

* JSDK 1.8 (This file is iclude on "jars and others" folder).

* Add the next JARs as modules (Those JARs are iclude on "jars and others" folder).

  - byte-buddy-1.8.15.jar

  - client-combined-3.141.59-sources.jar

  - client-combined-3.141.59.jar

  - commons-exec-1.3.jar
  
  - commons-io-2.11.0.jar

  - guava-25.0-jre.jar

  - okhttp-3.11.0.jar

  - okio-1.14.0.jar

* I have been testing on Google Chrome version 101.0.4951.64,

* Hardcoding needs to be added to the Chrome driver as follows: 

  - System.setProperty("webdriver.chrome.driver", "/directory/chromedriver"); 
