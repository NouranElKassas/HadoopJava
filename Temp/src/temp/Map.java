/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package temp;

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
public class Map extends Mapper<LongWritable, Text, Text, IntWritable> {
    public static final int MISSING=9999;
    public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (!(line.length()==0)){
            String date=line.substring(6,14);
            float TMax=Float.parseFloat(line.substring(39,45).trim());
            float TMin=Float.parseFloat(line.substring(47,53).trim());
            
            if(TMax>35.0 && TMax!=MISSING){
                context.write(new Text("Hot Day"+date),new Text(String.valueOf(TMax)));
            }
            if(TMin<10.0 && TMin!=MISSING){
                context.write(new Text("Cold Day"+date),new Text(String.valueOf(TMax)));
            }
        }
        StringTokenizer token = new StringTokenizer(line);
        while (token.hasMoreTokens()) {
            value.set(token.nextToken());
            context.write(value, new IntWritable(1));
        }
    }
}
