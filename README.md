# Doggies API

Doggies Api Client for https://dog.ceo/dog-api/

### Requirements
- Java 8 - https://www.java.com/es/download/
- Gradle - https://gradle.org/
- Doggies Config Server microservice - https://github.com/RodrigoRiquelme/doggies-config-server

Deploy
- Clone and Deploy Doggies Config Server with
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



- Test this app
```
./gradlew test

```

Of course, you can use the IDE of your preferences to run this tasks, this was built using IntelliJ IDEA.