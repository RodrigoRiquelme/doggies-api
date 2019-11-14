# Doggies API

Doggies Api Client for https://dog.ceo/dog-api/

[![Build Status](https://travis-ci.org/RodrigoRiquelme/doggies-api.svg?branch=master)](https://travis-ci.org/RodrigoRiquelme/doggies-api)
[![codecov](https://codecov.io/gh/RodrigoRiquelme/doggies-api/branch/master/graph/badge.svg)](https://codecov.io/gh/RodrigoRiquelme/doggies-api)
### Requirements
- Java 8 - https://www.java.com/es/download/
- Gradle - https://gradle.org/
- Doggies Config Server microservice - https://github.com/RodrigoRiquelme/doggies-config-server

Deploy
- Clone and Deploy Doggies Config Server
```
git clone https://github.com/RodrigoRiquelme/doggies-config-server.git
cd doggies-config-server
./gradlew build
./gradlew bootRun
```


- Deploy this app
```
git clone https://github.com/RodrigoRiquelme/doggies-api
cd doggies-api
./gradlew build
./gradlew bootRun
```

- Browse to `http://localhost:8080/doggies/breed/hound`, notice that the las part of URL is variable, for more information about available doggies check the Dog CEO API `https://dog.ceo/api/breeds/list/all` 




- Unit Tests
```
./gradlew test

```

Of course, you can use the IDE of your preferences to run this tasks, this was built using IntelliJ IDEA.