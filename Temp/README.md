# Weather Measurment Classifier

This is a classifier use to classify the weathe if it's "hot weather" or "cold weather"

get data on 2020 from the dataset ftp://ftp.ncdc.noaa.gov/pub/data/uscrn/products/daily01

```
ftp://ftp.ncdc.noaa.gov/pub/data/uscrn/products/daily01/2020/CRND0103-2020-AK_Aleknagik_1_NNE.txt
```
create a new folder called weather dataset

```
hadoop fs -mkdir /weather_dataset
```
create a new folder called output
```
hadoop fs -mkdir /weather_output
```

Copy files on hadoop

```
hadoop fs -put weather_dataset/CRND0103-2020-AK_Aleknagik_1_NNE.txt 
```

Run the project on HDFS
```
hadoop jar weather.jar  weather_dataset/CRND0103-2020-AK_Aleknagik_1_NNE.txt /weather_output
```
