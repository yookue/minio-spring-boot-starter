# Minio Spring Boot Starter

Spring Boot application integrates `minio` quickly, which is a high performance object Storage.

## Quickstart

- Import dependencies

```xml
    <dependency>
        <groupId>com.yookue.springstarter</groupId>
        <artifactId>minio-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> By default, this starter will auto take effect, you can turn it off by `spring.minio.enabled = false`

- Configure Spring Boot `application.yml` with prefix `spring.minio`

```yml
spring:
    minio:
        host: '127.0.0.1'
        port: 9000
        secure-http: true
        access-key: 'foo'
        secret-key: 'bar'
        bucket-name: 'app'
```

- Configure your beans with a `MinioClient` bean by constructor or `@Autowired`/`@Resource` annotation, then you can access it as you wish.

## Document

- Github: https://github.com/yookue/minio-spring-boot-starter
- Minio homepage: https://min.io
- Minio github: https://github.com/minio/minio

## Requirement

- jdk 17+

## License

This project is under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)

See the `NOTICE.txt` file for required notices and attributions.

## Donation

You like this package? Then [donate to Yookue](https://yookue.com/public/donate) to support the development.

## Website

- Yookue: https://yookue.com
