package com.nt.test1;

public class WishMessageGenarator {
	public String GetWishMessage(String user){
		return "Hello"+user;
	}
public static void main(String[] args) {
	WishMessageGenarator msg=new WishMessageGenarator();
    System.out.println(msg.GetWishMessage("raja"));
   }    

}
