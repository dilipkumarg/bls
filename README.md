## Barren Land Analysis

An application to solve the below problem statement.

>You have a farm of 400m by 600m where coordinates of the field are from (0, 0) to (399,
599). A portion of the farm is barren, and all the barren land is in the form of rectangles.
Due to these rectangles of barren land, the remaining area of fertile land is in no
particular shape. An area of fertile land is defined as the largest area of land that is not
covered by any of the rectangles of barren land.

### System Requirements
* JDK 8
* Maven 3

### Build Instructions
Run below command to compile and generate the jar file.

    mvn clean package

This command will generate `barren-land-analysis-<version>.jar` file in `target` folder.


### Execution

Run below command to run the app

    java -jar target/barren-land-analysis-<version>.jar
    
We need pass the input through Standard Input i.e console.

#### Input Format
> You are given a set of rectangles that contain the barren land. These rectangles are
  defined in a string, which consists of four integers separated by single spaces, with no
  additional spaces in the string. The first two integers are the coordinates of the bottom
  left corner in the given rectangle, and the last two integers are the coordinates of the
  top right corner.

#### Output Format
> Output all the fertile land area in square meters, sorted from smallest area to greatest,
  separated by a space.
  
#### Example
##### Input
    {"0 292 399 307"}

##### Output
    116800 116800


