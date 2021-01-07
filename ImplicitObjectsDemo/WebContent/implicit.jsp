<%! public void jspinit(){
   //get access servletconfig object
   ServletConfig cg=getServletConfig();
    System.out.println("init parameter value::"+cg.getInitParameter("p2"));
 
    //get Access to ServletContext object
     ServletContext sc=getServletContext();
     System.out.println("context param value::"+cg.getInitParameter("p1"));
 }
%>
    
    