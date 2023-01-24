# 기본 베이스 이미지
FROM openjdk:19

# (생략 가능) jar 파일 경로가 길어서 변수로 선언
ARG JAR_FILE=./build/libs/playground-0.0.1-SNAPSHOT.jar

# 컨테이너에 jar 파일 복사 및 이름 변경
COPY ${JAR_FILE} app.jar

# 컨테이너 실행 시, 자동으로 "java -jar /app.jar" 실행 -> spring 실행됨
ENTRYPOINT ["java","-jar","/app.jar"]