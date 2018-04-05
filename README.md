# JAVA-DesignPatterns-MultiThreading #

## Data Structure(s) Used ##

### TREE: Unbalanced Binary Search Tree.

* Node Structure: 
 1. String word
 2. WordCount
 
* Operation(s) performed are all thread safe and synchronized:
 1. insertNode() => Time Complexity: O(log n), Space Complexity: O(1)
 2. serachNode() => Time complexity: O(log n), Space Complexity: O(1)
 3. deleteNode() => Time Complexity: O(log n), Space Complexity: O(1)

* Why I choose unbalanced Binary Search Tree over AVL: AVL consumes more 
memory as it has to maintain balance factor and each operation can be more 
slower in order to perform rotations. BST in the average case has O(log n), 
worst case has O(n) time complexity while AVL has O(log n). As BST consumes 
less memory and is easy to debug, and know that the worst case will be 
rare here, hence BST is better to implement than AVL. 

### ArrayList for storing results:

* ArrayList is not fixed size, hence we can modify it more frequently when 
needed.Storing results needs constant change in size of the list according 
to the test cases.Even if we set an initial size, we can still modify the size 
* We store only three final counts in this array list.
* Big O Time complexity:O(n) under normal circumstances.

### Working Protocol / Algorithm for this project ###

* Driver: Reads a command line input arguments and validates them. 
* Driver creates the instances of following classes :
	1. FileProcessor - which reads the input file line by line
	2. InputProcessor - which parses the line read by FileProcessor.
	3. Results - used to store the results and write to files.
	4. CreateWorkers - which is responsible for creating threads.
* Driver calls the method createWorkerThreads() in the instance of CreateWorker 
class and passes an integer for number of input threads received from command line input.
* CreateWorker class creates two types of threads : 
	1. PopulateThreads - responsible for inserting data words into the tree
	2. DeleteThreads - responsible for deleteing data words from the tree
* PopulateThreads threads reads the parsed input by InputProcessor and starts inserting 
each node into the tree based on the lexicograhical manner.
* The string comparison is done using equals() method of the string class.
* After populating the tree, the DeleteThreads are created by the CreateWorkers class.
* The DeleteThreads starts deleting one word each provided.
* Driver code now calls the writeSchedulesToFile() method on the instance of Results.
* The writeSchedulesToFile() method writes the final word, character and distinct word 
counts into the output file provided by user successfully.

## Debugger Level Desciptions ##

* DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
* BUG_VALUE=3 [Print to stdout everytime the thread is run] 
* BUG_VALUE=2 [Print to stdout everytime an inertion is attempted in the tree]
* BUG_VALUE=1 [Print to stdout everytime a deletiontion is attempted in the tree]
* BUG_VALUE=0 [No output should be printed from the application to stdout. 
It is ok to write to the output file though" ]

## How To Run This Project ##

You need to be in the base directory of the project to perform following operations :

* To clean : ant -buildfile src/build.xml clean
* To build : ant -buildfile src/build.xml all
* To run : ant -buildfile src/build.xml run -Darg0=InputFile -Darg1=OutputFile 
-Darg2=NumberOfThreads -Darg3=word1 -Darg4=word2 -Darg5=word3 -Darg6=DebugLevelInteger

## File Structure ##

 wordTree 
 == README.md
 == src
	=== build.xml
	=== wordTree
      	=== driver
           === Driver.java
        === util
           === FileProcessor.java
           === InputProcessor.java
           === FileDisplayInterface.java
           === StdoutDisplayInterface.java 
   		=== MyLogger.java 
 	   	=== store
	   		=== Results.java
	   	=== threadMgmt
	   		=== CreateWorkers.java
	   		=== PopulateThread.java
	   		=== DeleteThread.java

## Cautions about the project ##

* It accepts minimum 7 arguments: input file name, output file name, 
an integer for number of threads, words to deleted, an integer for debug level.
* If the number of words to be deleted should be equal to the number of threads. 
Throws exception and exists the program; otherwise.
* Input and output file paths should be valid and accessible. Throws exception otherwise.
* If the output file specified does not exist, then it creates the file 
"Output.txt" and writes theh final output into it.
* This project considers case-sensitivity between the strings being compared.
