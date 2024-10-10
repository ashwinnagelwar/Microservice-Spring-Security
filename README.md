1. On first commit All services created.
2. 2.1 on second commit lombok is added in local and configured with spring boot.
   2.2 then user service all layer created, jpa and eureka client configuration done on user service
   2.3 eureka server configuration also done
   2.4 create user post request successfully tested.
3. We have added two json binding dependency in user service and used anotation over user entity class and consume and produces over controller method for implementing consume/produce for xml and json as per requirement. 
4. we have created mobile service with same configuration as user service.
5. we have created Myorder service also updated with feign client dependency with user and mobile service wrt order service.
6. used feign client to communicate with user and mobile service by myorder service to place mobile buy order by user and successfully implemented.
7. we have craeted spring cloud gateway with following dependency
  <artifactId>spring-boot-starter-webflux</artifactId>
  <artifactId>spring-cloud-starter-gateway</artifactId>
  rtifactId>spring-boot-starter-actuator</artifactId>------->optional
and then did some configurartion in gatway service yaml file, and tested successfully.
