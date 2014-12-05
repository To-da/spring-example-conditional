Custom @Conditional annotation example
=======================================

## What is @Conditional
 [@Conditional](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Conditional.html) is an
 annotation added to Spring 4 to specify condition(s) under which specific configuration will be processed or specific bean will be registered to the Spring context.

## Why is important
Spring Boot project auto-configuration support rely on @Conditional - it has own stereotype annotations like
[@ConditionalOnClass](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/condition/ConditionalOnClass.java) or
[@ConditionalOnBean](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/condition/ConditionalOnBean.java)
to initialize Spring context in order to dependencies on classpath (or other custom condition annotations applicable to any other condition).

## This example
This sample shows how to register specifics bean to the Spring context in order to JVM vendor on platform where you running this example.
Run Application.java (by **simply run the main method** [in your IDE] or **./gradlew run** [unix] or **gradlew.bat run** [windows] or build jar and run like **java -jar build/lib/spring-boot-example-conditional-*-*-*.jar**).

## Video
Related [youtube video](http://youtu.be/i-vSlkMHskI)
