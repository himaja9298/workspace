package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.CollegeInfo;
import com.nt.beans.ContactsInfo;
import com.nt.beans.FruitsInfo;
import com.nt.beans.MarksInfo;
import com.nt.beans.UniversityInfo;

public class CollectionInjectionTest {

	public static void main(String[] args) {
		MarksInfo mks=null;
		CollegeInfo clg=null;
		ContactsInfo cinfo=null;
		UniversityInfo uinfo=null;
		FruitsInfo finfo=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		//create factory 
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get marksInfo class object
		mks=factory.getBean("mks",MarksInfo.class);
		System.out.println(mks);
		//get CollegeInfo class object
		clg=factory.getBean("clg",CollegeInfo.class);
		System.out.println(clg);
		//get ContacsInfo class object
		cinfo=factory.getBean("cInfo",ContactsInfo.class);
		System.out.println(cinfo);
		//get UniversityInfo class object
		uinfo=factory.getBean("uInfo",UniversityInfo.class);
		System.out.println(uinfo);
		finfo=factory.getBean("fInfo",FruitsInfo.class);
		System.out.println(finfo);
	}

}

