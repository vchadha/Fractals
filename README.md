# Fractals
L -Systems test

## Guide
### Fields
#### Axiom (bottom left text field)
  * Valid Inputs
    * "F" : Move forward and draw line
    * "f" : Move forward, but do not draw a line
    * "+" : Rotate counter clockwise by angle delta value
    * "-" : Rotate clockwise by angle delta value

#### Iterations (Field above axiom)
  * Valid inputs: integers
    * number of iterations to apply after start button has been pressed

#### Production F
  * Replace "F" in axiom with input string

#### Production f
  * Replace "f" in axiom with input string

#### Production +
  * Replace "+" in axiom with input string

#### Production -
  * Replace "-" in axiom with input string

#### Edit Entity
  * Allows user to edit start angle and angle delta value

## Installation
```
  1. Navigate to local repository
  2. Create res/ folder
  3. Create a bin/ folder
  4. Run cmd: find -name "*.java" > source.txt
  5. Run cmd: javac -d ./bin @source.txt
  6. Cd into bin/
  7. Run cmd: jar cvfm ../Fractals.jar ../manifest.txt com/ ../res/
```
