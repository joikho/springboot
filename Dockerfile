# dockerfile
# 1. JDK 이미지 가져와서 (openjdk)
# 2. 환경변수 및 실행 코드(sh 코드) 맞춰줘야됨 (https://kim-jong-hyun.tistory.com/91 이거 참고해서 셋팅해보삼)
# docker run (port 옵션값) 명령어를 이용해서 컨테이너 띄우기 https://hub.docker.com/_/openjdk
# 실제로 local로 접속되는지 확인까지 




# FROM openjdk:17-oracle

# ARG port
# EXPOSE ${port}
# COPY ./gradle/wrapper/gradle-wrapper.jar /usr/local/gradle-wrapper.jar
# RUN chmod +x /usr/local/gradle-wrapper.jar
# ENV docker-app 'Hello, Docker App !'
# WORKDIR /usr/local
# ENTRYPOINT ["java", "-jar", "gradle-wrapper.jar"]