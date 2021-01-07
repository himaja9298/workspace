package com.nt.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class IOCContainerMonitoringListener implements ApplicationListener{
	private long start,end;
	public IOCContainerMonitoringListener() {
		System.out.println("IOCContainerMonitoringListener.0-param constructor");
	}
	
	
	@Override
	public void onApplicationEvent(ApplicationEvent e) {
		
		if(e.toString().indexOf("Contextrefreshed")!=-1) {
			start=System.currentTimeMillis();
			System.out.println("ApplicationContextContainer startedd at"+start);
		}
		
		else if(e.toString().indexOf("ContextClosed")!=-1) {
				end=System.currentTimeMillis();
				System.out.println("ApplicationContextContainer stopped at"+end);
				System.out.println("AC container active time:"+(end-start));
		   }
	}

}
