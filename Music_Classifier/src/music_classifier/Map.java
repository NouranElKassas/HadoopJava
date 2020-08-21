/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package music_classifier;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author nouran
 */
public class Map extends Mapper<Object, Text, Text, IntWritable> {

    IntWritable trackId = new IntWritable();
    IntWritable userId = new IntWritable();
    
    public void map(Object key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String [] parts=value.toString().split("[|]");
        trackId.set(Integer.parseInt(parts[User.track_id]));
        userId.set(Integer.parseInt(parts[User.user_id]));
        
        context.write(trackId,userId);

    }
}
