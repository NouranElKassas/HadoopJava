# Count Words

In this Project, we are going to practice more about map reduce concept by counting the number of words found in a sample file. 

create a new file
```hadoop fs -mkdir /wordcount```

add a new input folder
```hadoop fs -mkdir /wordcount/input```

add a new output folder
```hadoop fs -mkdir /wordcount/output```

add a text file in HDFS
```hadoop fs -put test.txt /wordcount/input```

Run the project on HDFS
```hadoop jar wordcount.jar hadoop/Hadoop/ /wordcount/input /wordcount/output```

to see the output files
```hadoop fs -ls /wordcount/output```

to see the output
```hadoop fs -cat /wordcount/output/*0```
