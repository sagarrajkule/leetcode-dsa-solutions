# Java DSA Solutions

This folder contains Java implementations of DSA problems solved from platforms like LeetCode.

# Option 1: Run without Maven (Direct Java CLI)

## 🛠️ Compile

```bash
javac -d out src/main/java/<package_path>/<ClassName>.java

E.g. javac -d out src/main/java/arrays/FizzBuzz.java
```

## 🛠️ Run

```bash
java -cp out <package_path>.<ClassName> <args>

E.g. java -cp out arrays.FizzBuzz 10
```

# Option 2: Run with Maven

## How to Run Tests

Open a terminal and navigate to the root of the project (leetcode-dsa-solutions/):

```bash
cd /path/to/leetcode-dsa-solutions
```

Then run:

```bash
mvn clean test
```

This will:

Clean any previous build output
Compile your code
Run all test cases defined in *.java

Expected Output:

```bash
[INFO] BUILD SUCCESS
```
