package com.zhxx.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean>{
	
	Text k = new Text();
	FlowBean v = new FlowBean();
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] s = value.toString().split("\t");
		k.set(s[1]);
		
		v.setSum(Long.parseLong(s[s.length-3]), Long.parseLong(s[s.length-2]));
		
		context.write(k, v);
		
	}

}
