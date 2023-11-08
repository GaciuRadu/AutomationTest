# AutomationTest

## In terminal- start Jenkins-  brew services start jenkins-lts
![image](https://github.com/GaciuRadu/AutomationTest/assets/136181535/369d9edf-2eec-4f63-978c-0fe453d66910)


## In terminal- stop Jenkins-  brew services stop jenkins-lts
![image](https://github.com/GaciuRadu/AutomationTest/assets/136181535/06a1bd5b-17ab-45b0-933d-28bf1ca53c41)

## In Jenkins-> Configure-> Build Steps
      -> Maven Version- Maven
      -> Goals        - clean test (run all the tests)   
      -> Goals        - clean test -Dtest="SearchTest" (run only the SearchTest test)
