package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class IocProj76BootWishAppApplication {
    public static void main(String[] args) {
    	ApplicationContext ctx=null;
    	WishMessageGenerator wmsg=null;
        //create container
    	ctx=SpringApplication.run(IocProj76BootWishAppApplication.class, args);
	    //get target class object
		wmsg=ctx.getBean("wmsg",WishMessageGenerator.class);
		System.out.println(wmsg.generateWishMessage("raja"));
	}

}
