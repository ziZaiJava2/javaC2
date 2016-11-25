package com.zizaitianyuan.javac2.lesson06;

public class GundarmStrike {

    /*
     * 这是基本配置
     */
    public GundarmStrike() {
        // 安装火神炮
        setCIWS();
        // 安装战术匕首
        setKnife();
        // 启动引擎
        startEngine();
        // 启动操作系统
        startOS();
        // 启动维生系统
        startLifeSupportSystem();
    }
    
    /*
     * 还有盾装，强化防御
     */
    public GundarmStrike(Shield shield) {
    	this();
        setShield(shield);
    }


	private void setShield(Shield shield) {
		// TODO Auto-generated method stub
		
	}

	private void startLifeSupportSystem() {
		// TODO Auto-generated method stub
		
	}

	private void startOS() {
		// TODO Auto-generated method stub
		
	}

	private void startEngine() {
		// TODO Auto-generated method stub
		
	}

	private void setKnife() {
		// TODO Auto-generated method stub
		
	}

	private void setCIWS() {
		// TODO Auto-generated method stub
		
	}
}
