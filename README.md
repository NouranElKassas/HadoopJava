# Hadoop Setup Enviroment
Before we start the locations and paths found in this file are my local file location
please replace replace those locations with your file locations
Moreover, I used Linux OS. 


# Let's get started

Open Terminal

Download the required version
```wget https://archive.apache.org/dist/hadoop/common/hadoop-2.7.2/hadoop-2.7.2.tar.gz```

extract the file
```tar -xvf hadoop-2.7.2.tar.gz```

go to hadoop-2.7.2/etc/cd hadoop

```
cd hadoop-2.7.2
cd etc
cd hadoop
```

# setup hadoop cluster

open core-site.xml

```gedit core-site.xml```

you will find in this file a tag <configurations> setup your local hadoop cluster to be exposed to 9000 add this property inside it:

```
    <property>
    <name>fs.default.name</name>
    <value>hdfs://localhost:9000</value>
    </property>
```
save and close the file

open hdfs-site.xml
```gedit hdfs-site.xml```

you will find in this file a tag <configurations> setup your local hadoop cluster number of duplicates, permissions,location of the cluster's datanode and namenode add this properties inside it:
  
```
    <property>
    <name>dfs.replications</name>
    <value>1</value>
    </property>
    <property>
    <name>dfs.permission</name>
    <value>false</value>
    </property>
    <property>
    <name>dfs.namenode.name.dir</name>
    <value>/home/user/hadoop-2.7.2/hadoop2_data/hdfs/namenode</value>
    </property>
    <property>
    <name>dfs.datanode.data.dir</name>
    <value>/home/user/hadoop-2.7.2/hadoop2_data/hdfs/datanode</value>
    </property>
```

save and close the file

open yarn-site.xml
```gedit yarn-site.xml```

you will find in this file a tag <configurations> setup your local hadoop cluster techniques to manage the data add this properties inside it:
  
```
    <property>
    <name>yarn.nodemanager.aux.services</name>
    <value>mapreduce_shuffle</value>
    </property>
    <property>
    <name>yarn.nodemanager.auxservices.mapreduce.shuffle.class</name>
    <value>org.apache.hadoop.mapred.ShuffleHandler</value>
    </property>
```

save and close the file

copy map reduce site template to be in map reduce site
```cp mapred-site.xml.template mapred-site.xml```

open mapred-site.xml
```gedit mapred-site.xml```

you will find in this file a tag <configurations> setup your local hadoop cluster to set properties for yarn and mapreduce add this properties inside it:
  
```
    <property>
    <name>mapreduce.framework.name</name>
    <value>yarn</value>
    </property>
```
save and close the file

# setup enviroment variables

open hadoop env file
```gedit hadoop-env.sh```

set your java path file
```export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64```

save and close the file

open .bashrc
``` gedit bashrc ```

add those parameters in the file
```
    #set Hadoop paths
    export HADOOP_HOME=/home/usr/hadoop-2.7.2
    export HADOOP_MAPPER_HOME=/home/usr/hadoop-2.7.2
    export HADOOP_CONF_DIR=/home/usr/hadoop-2.7.2/etc/hadoop
    export HADOOP_HAPRED_HOME=/home/usr/hadoop-2.7.2
    export HADOOP_COMMON_HOME=/home/usr/hadoop-2.7.2
    export HADOOP_HDFS_HOME=/home/usr/hadoop-2.7.2
    export YARN_HOME=/home/usr/hadoop-2.7.2
    export HADOOP_COMMON_LIB_NATIVE_HOME=$HADOOP_HOME/lib/native
    export HADOOP_OPTS="-Djava.librarypath=$HADOOP_HOME/lib"

    #set Java Home
    export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64
    export PATH=$PATH:/usr/lib/jvm/java-7-openjdk-amd64

    #set Hadoop bin/ directory to path
    export PATH=$PATH:/home/usr/hadoop-2.7.2
    export HADOOP_PID_DIR=/home/user/hadoop-2.7.2/hadoop2_data/hdfs/pid
```
save and close the file

```
cd ..
cd hadoop-2.7.2
```

formate name node
```bin/hadoop namenode -format```

start hadoop daemons
```cd sbin```

start the data file system
```./start-dfs.sh```

start yarn daemon
```./start-yarn.sh```

start history server
```./mr-jobhistory-damon.sh start historyserver```

check all the processes are running
```sudo jps```

run in the browser to check our cluster is sucessfully setup
```localhost::50070```
