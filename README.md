# Cloud Native Zwitscher Showcase

This showcase demonstrates how to build a cloud native application using
Spring Boot, Spring Cloud and Netflix OSS components. The individual parts
will later be deployed and run on Mesos with Kubernetes.

![Zwitscher Showcase Overview](https://github.com/qaware/cloud-native-zwitscher/blob/master/zwitscher.png)

## Build instructions

In order to compile and run the examples you do not need much. A recent JDK8 needs to
be available in your SEU.
```shell
$ ./gradlew clean build
```

## Usage instructions

For the showcase to be fully operational you need to configure your own Twitter API key and secret. First, follow
the instructions on https://spring.io/guides/gs/register-twitter-app/. Once you have a API key and secret, insert
these into the configuration `zwitscher-config/src/main/resources/config/zwitscher-service.yml`

```yml
spring:
  social:
    twitter:
      appId: <<Insert Twitter API key here>>
      appSecret: <<Insert Twitter API key secret here>>
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

Start the Zwitscher board UI server
```shell
$ cd cloud-native-zwitscher
$ ./gradlew :zwitscher-board:bootRun
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
* **Board server**: http://localhost:8081
* **Edge server**: http://localhost:8765
* **Monitoring server**: http://localhost:8989


### Docker

To run the complete showcase using docker locally, please ensure that Docker is running and can be accessed
by Gradle correctly:
```shell
$ cd cloud-native-zwitscher
$ ./gradlew dockerVersion dockerInfo
```

If the connection to the Docker daemon can be established, you will see some version and detail information printed
in the console. Assuming you have already build the project, you need to build the Docker images:
In order to compile and run the examples you do not need much. A recent JDK8 needs to
be available in your SEU.
```shell
$ ./gradlew buildDockerImage
```

Once this is done, open a Docker terminal and issue the following command in the project directory:

```shell
$ cd cloud-native-zwitscher
$ docker-compose up -d
$ docker-compose logs
```

This will start all the Docker images in the correct order. The instances can then be accessed via their known ports
and the IP address of your Docker installation, usually something like `192.168.99.100`.

To shutdown and remove everything again, kill and remove the Docker containers first, and finally you can remove the
Docker images again if you wish.

```shell
$ docker-compose kill
$ docker-compose rm
$ ./gradlew removeDockerImage
```


### Mesos with Kubernetes

_To be continued..._


## References

* [Spring Initializr](https://start.spring.io)
* [Spring Cloud](http://projects.spring.io/spring-cloud/)

## License

This software is provided under the MIT open source license, read the `LICENSE.txt` file for details.
