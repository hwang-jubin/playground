# playground

## Build & Deploy

### In Local
1. build spring: `./gradlew build` -> .jar file 생성
1. build docker: `docker build --build-arg DEPENDENCY=build/dependency --platform linux/amd64 -t playground .` -> docker image 생성
1. push docker image: ``

### In EC2
1. pull docker image: ``
1. run docker container: `docker run -p 80:8080 playground`
