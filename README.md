# 관련 소스

* [sample-api]
* [demo server](https://github.com/poscoict-glueframework/msa-demo-server.git)
* [local config](https://github.com/poscoict-glueframework/template-config/blob/master/sample-api-local.yml)
* [vdi config](https://github.com/poscoict-glueframework/template-config/blob/master/sample-api-vdi.yml)
* [마이크로서비스 연계테스트용](https://github.com/poscoict-glueframework/msa-second.git)

```
git clone https://github.com/poscoict-glueframework/msa-sample.git sample
git clone https://github.com/poscoict-glueframework/msa-second.git second
```

# sample-api 마이크로 서비스


```
cd second
mvn -Plocal clean install
java -jar second-spring-boot/target/second-spring-boot-0.0.2-SNAPSHOT.jar
```

```
cd sample
mvn -Plocal clean install
java -jar sample-spring-boot/target/sample-spring-boot-0.0.2-SNAPSHOT.jar
```


## 확인

* -Plocal 로 빌드한 경우 :

```
http://localhost:9080/actuator
http://localhost:9080/sample
http://localhost:9080/sample/proxy?name=1st
http://localhost:9080/sample/proxy?name=2nd
http://localhost:9080/swagger-ui.html
http://localhost:9180/actuator
http://localhost:9180/adapter/second?name=1st
http://localhost:9180/adapter/second?name=2nd
http://localhost:8080/sample-api/actuator
http://localhost:8080/sample-api/sample
http://localhost:8080/sample-api/sample/proxy?name=1st
http://localhost:8080/sample-api/sample/proxy?name=2nd
http://localhost:8080/second-api/actuator
http://localhost:8080/second-api/adapter/second?name=1st
http://localhost:8080/second-api/adapter/second?name=2nd
```

* -Pvdi 로 빌드한 경우 :

```
http://sample-api:8180/actuator
http://sample-api:8180/sample
http://sample-api:8180/sample/proxy?name=1st
http://sample-api:8180/sample/proxy?name=2nd
http://sample-api:8180/swagger-ui.html
http://second-api:8280/actuator
http://second-api:8280/adapter/second?name=1st
http://second-api:8280/adapter/second?name=2nd
http://zuul-server:8080/sample-api/actuator
http://zuul-server:8080/sample-api/sample
http://zuul-server:8080/sample-api/sample/proxy?name=1st
http://zuul-server:8080/sample-api/sample/proxy?name=2nd
http://zuul-server:8080/second-api/actuator
http://zuul-server:8080/second-api/adapter/second?name=1st
http://zuul-server:8080/second-api/adapter/second?name=2nd
```
