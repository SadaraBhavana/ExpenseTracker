FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY ExpenseTracker.java .

RUN javac ExpenseTracker.java

CMD ["java", "ExpenseTracker"]