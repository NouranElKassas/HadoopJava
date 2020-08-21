# Get the number of hits on Songs
This project is classifing the number of times the user listened to this song based on number of users that shares the song, no of times its published on radio and if the song is skipped or not.

create a new folder called song dataset

```
hadoop fs -mkdir /music_dataset
```
create a new folder called output
```
hadoop fs -mkdir /music_output
```

Copy files on hadoop

```
hadoop fs -put sample_data.txt /music_dataset
```

Run the project on HDFS
```
hadoop jar weather.jar  music_dataset /music_output
```