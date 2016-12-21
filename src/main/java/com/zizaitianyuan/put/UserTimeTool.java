package com.zizaitianyuan.put;

public class UserTimeTool {
	private static UserTimeTool utt = new UserTimeTool();
    private UserTimeTool() {
    }
    public static UserTimeTool getInstance() {
        return utt;
    }
    private long start;
    public void start() {
        start = System.currentTimeMillis();
    }
    public void stop() {
        long end = System.currentTimeMillis();
        System.out.println("所用時間 : " + (end - start) + "毫秒");
    }
}
