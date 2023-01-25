# 기본 베이스 이미지
FROM gradle:7.6.0-jdk19-alpine as builder
WORKDIR /build

# 그래들 파일이 변경되었을 때만 새롭게 의존패키지 다운로드 받게함.
COPY build.gradle settings.gradle /build/
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

# 빌더 이미지에서 애플리케이션 빌드
COPY . /build
RUN gradle build -x test --parallel

# App stage
FROM openjdk:19
WORKDIR /app
COPY --from=builder /build/build/libs/playground-0.0.1.jar .

EXPOSE 8080

# root 대신 nobody 권한으로 실행
USER nobody
# 컨테이너 실행 시, 자동으로 "java -jar /app.jar" 실행 -> spring 실행됨
ENTRYPOINT [                                                \
    "java",                                                 \
    "-jar",                                                 \
    "playground-0.0.1.jar"              \
]