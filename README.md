# Spring Cloud Tutorial

Sample Spring Boot projects created from a LinkedIn Learning course.
Shows how to create a config server and have other spring apps consume the config.  

In this case the service apps now run all on different ports based 
on the configs defined in [Spring Cloud Config Files](https://github.com/scmathew/spring-cloud-config).


## Modules

### Simple REST APIs + Config Consumers
- [Guest Services](guest-services/README.md)
- [Room Services](room-services/README.md)
- [Reservation Services](reservation-services/README.md)

### Config Server
- [Config Server](config-server/README.md)
    - Build this module first
    -  Pulls config from: [Spring Cloud Config Files](https://github.com/scmathew/spring-cloud-config)

## Helpful Links
- [Notes](notes/)
- [LinkedIn Learning Course](https://www.linkedin.com/learning/spring-spring-cloud-2/spring-to-the-cloud?u=2079044)