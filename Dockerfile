# ベースイメージを指定
FROM adoptopenjdk/openjdk11:alpine-slim

# 作業ディレクトリを指定
WORKDIR /app

# Mavenプロジェクトをビルド
COPY . /app
RUN ./mvnw package -DskipTests

# 実行
CMD ["java", "-jar", ".mvn/wrapper/maven-wrapper.jar"]