# Java labs at RFE
<br>

## Homework 1
Example args: 
```java
--filename image.png --output jpeg --quality 1
```

If you compile and run in CMD, then:
1) go to project folder
```java
cd Homework 
```
2) compile classes
```java
javac -sourcepath src -d bin -classpath lib\commons-cli-1.3.1.jar src\ImageConverter\ImageConverter.java
```
3) run app
```java
java -classpath bin;lib\commons-cli-1.3.1.jar ImageConverter
```
4) run with params like
```java
java -classpath bin;lib\commons-cli-1.3.1.jar ImageConverter --filename image.png --output jpeg --quality 1
```

## Homework 2