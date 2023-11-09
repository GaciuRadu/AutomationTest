# AutomationTest

## macOS Installers for Jenkins LTS
### https://www.jenkins.io/download/lts/macos/
###  
Homebrew Installer 
homebrew 2.414.3

Jenkins can be installed using the Homebrew package manager. Homebrew formula: jenkins-lts This is a package supported by a third party which may be not as frequently updated as packages supported by the Jenkins project directly.

Sample commands:
- Install the latest LTS version: brew install jenkins-lts
- Start the Jenkins service: brew services start jenkins-lts
- Restart the Jenkins service: brew services restart jenkins-lts
- Update the Jenkins version: brew upgrade jenkins-lts
  
After starting the Jenkins service, browse to http://localhost:8080 and follow the instructions to complete the installation. Also see the external materials for installation guidelines. For example, this blogpost describes the installation process.

## In terminal- start Jenkins-  sudo brew services start jenkins-lts
![image](https://github.com/GaciuRadu/AutomationTest/assets/136181535/369d9edf-2eec-4f63-978c-0fe453d66910)


## In terminal- stop Jenkins-  sudo brew services stop jenkins-lts
![image](https://github.com/GaciuRadu/AutomationTest/assets/136181535/06a1bd5b-17ab-45b0-933d-28bf1ca53c41)

## In Jenkins-> Configure-> Build Steps
      -> Maven Version- Maven
      -> Goals        - clean test (run all the tests)   
      -> Goals        - clean test -Dtest="SearchTest" (run only the SearchTest test)
