# Spring Cloud


## External Configuration
- 12 factor methodology states configuration should be externalized
- Increases portability, just configuration while deploying to different envs


## Config Server
- backed by a git repo, so you get version control 
- centralized configuration
  
Config Sever Properties
```properties
# Point to local or remote git repo that has been initialized and committed to
spring.cloud.config.server.git.uri=${HOME}/CodeSpace/spring-cloud-tutorial/config
spring.cloud.config.server.git.force-pull=true
```
URL to find properties since no profile was specified: http://localhost:9000/guestservices/default

## Config Client
- Had to move to release `2.2.1.RELEASE` of `spring-boot-starter-parent` on the service 
  module and config server module to get this to work.
    - I think its because of this line `<spring-cloud.version>Hoxton.RC2</spring-cloud.version>`

Added the following things to the guestservices (config consumer) pom.xml:
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-client</artifactId>
        </dependency>

        <!-- Don't fully understand why we imported these yet, they are also found
         in the config server pom.xml-->
        <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
        </dependencyManagement>
        <repositories>
        <repository>
            <id>spring-milestones</id>
            <url>https://repo.spring.io/milestone</url>
        </repository>
        </repositories>
        
```

Then added a `bootstrap.properties` file:
```.properties
# Needs to be same name as config file on the config server
spring.application.name=guestservices
spring.cloud.config.uri:http://localhost:9000
```
