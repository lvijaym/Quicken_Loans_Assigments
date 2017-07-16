package mr.analytics;
import java.io.IOException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.conf.Configuration;

/* The input for the mapper are 
A : B C D
B : A C D E
C : A B D E
D : A B C E
E : B C D
*/
public class Mutual_Friends {
	public static class MyMap extends Mapper<LongWritable,Text,Text,Text>
	{
		public void map(LongWritable key,Text value,Context con)throws IOException,InterruptedException
		{
			StringTokenizer tokenizer = new StringTokenizer(value.toString(), "\n");
			while(tokenizer.hasMoreTokens()){
                String line = tokenizer.nextToken();
                String[] me = line.split(" : ");
                String[] friends = me[1].split(" ");
                String[] meandfriends = new String[2];
                for(int i = 0; i < friends.length; i++){
                        meandfriends[0] = friends[i];
                        meandfriends[1] = me[0];
                        Arrays.sort(meandfriends);
                        con.write(new Text(meandfriends[0] + " " + meandfriends[1]), new Text(me[1])); 
                }
		}	
	}
}
	public static class Red extends Reducer<Text,Text,Text,Text>
	{
		public void reduce(Text key,Iterable<Text> values,Context con)throws IOException,InterruptedException
		
		{
	        Text[] texts = new Text[2];
            int index = 0;
            for(Text val: values){
                    texts[index++] = new Text(val);
            }
            String[] list1 = texts[0].toString().split(" ");
            String[] list2 = texts[1].toString().split(" ");
            List<String> list = new LinkedList<String>();
            for(String friend1 : list1){
                    for(String friend2 : list2){
                            if(friend1.equals(friend2)){
                                    list.add(friend1);
                            }
                    }
            }
            StringBuffer sb = new StringBuffer();
            
            for(int i = 0; i < list.size(); i++){
                    sb.append(list.get(i));
                    if(i != list.size() - 1)
                            sb.append(" ");
            }
            con.write(key, new Text(sb.toString()));
		}

		
	}
	public static void main(String [] args)throws Exception
	{
	   Configuration c=new Configuration();
	String [] files=new GenericOptionsParser(c,args).getRemainingArgs();
	Path p1=new Path(files[0]);
	Path p2= new Path(files[1]);
	Job j=new Job(c,"MyJob");
	j.setJarByClass(Mutual_Friends.class);
	j.setMapperClass(MyMap.class);
	j.setReducerClass(Red.class);
	j.setOutputKeyClass(Text.class);
	j.setOutputValueClass(Text.class);
	FileInputFormat.addInputPath(j,p1);
	FileOutputFormat.setOutputPath(j,p2);
	System.exit(j.waitForCompletion(true)? 0:1);
	}
	}


