/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package music_classifier;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author nouran
 */
public class Reduce extends Reducer<IntWritable,IntWritable,IntWritable,IntWritable>{

    public void reduce(IntWritable trackId, Iterable<IntWritable> userIds,Reducer<IntWritable,IntWritable,IntWritable,IntWritable>.Context context) throws IOException, InterruptedException{
    
        Set<Integer> userIdSet=new HashSet<Integer>() ;
        for(IntWritable userId:userIds){
            userIdSet.add(userId.get());
        }
        IntWritable size=new IntWritable(userIdSet.size());
        context.write(trackId,size);
    }
}
