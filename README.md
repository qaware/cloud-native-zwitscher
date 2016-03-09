# Cloud Native Zwitscher Showcase

This showcase demonstrates how to build a cloud native application using
Spring Boot, Spring Cloud and Netflix OSS components. The individual parts
will later be deployed and run on Mesos with Kubernetes.

## Usage instructions

In order to compile and run the examples you do not need much. A recent JDK8 needs to
be available in your SEU.
```shell
$ ./gradlew clean build
```

## Running the Cloud Native Zwitscher showcase

The showcase can be run on your local machine as well as on Mesos with Kubernetes.

### Local maschine

To run the showcase locally build the showcase and run the individual parts in a
separate console window.

Start the Zwitscher Eureka server
```shell
$ cd cloud-native-zwitscher
$ ./gradlew :zwitscher-eureka:bootRun
```

Start the Zwitscher config server
```shell
$ cd cloud-native-zwitscher
$ ./gradlew :zwitscher-config:bootRun
```

Start the Zwitscher service server
```shell
$ cd cloud-native-zwitscher
$ ./gradlew :zwitscher-config:bootRun
```

Start the Zwitscher edge server
```shell
$ cd cloud-native-zwitscher
$ ./gradlew :zwitscher-service:bootRun
```

Start the Zwitscher monitoring server
```shell
$ cd cloud-native-zwitscher
$ ./gradlew :zwitscher-monitor:bootRun
```

If everything has started OK, you can access the the services under the following URLs:

* **Eureka server**: http://localhost:8761
* **Config server**: http://localhost:8888
* **Service server**: http://localhost:8080
* **Edge server**: http://localhost:8765
* **Monitoring server**: http://localhost:8989


### Docker

_To be continued..._


### Mesos with Kubernetes

_To be continued..._


## References

* [Spring Initializr](https://start.spring.io)
* [Spring Cloud](http://projects.spring.io/spring-cloud/)

## License

This software is provided under the MIT open source license, read the `LICENSE.txt` file for details.
