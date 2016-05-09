package me.haolee.gp.serverside;

import java.util.HashSet;

public class StreamName {
	private static final int MAX = 65535;
	private static int stream = 0;
	private static HashSet<Integer> streamNameSet = new HashSet<>();
	
	//获取可用的数据流名字
	public static int getStreamName() {
		while(true){
			stream = (stream+1)%MAX;
			if(streamNameSet.add(stream))
				return stream;
			if (streamNameSet.size() == MAX)
				return -1;//如果集合满了说明当前达到了视频流数量的极限，返回-1
		}
	}
	//释放用完的数据流名字
	public static void releaseStreamName(int sname) {
		streamNameSet.remove(sname);
	}
}