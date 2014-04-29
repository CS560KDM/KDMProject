package com.gontuseries.university;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

@Path("/university")
public class UniversityRESTWS {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHTMLUniversityInfo(){
		return "<html>" + "<title>"+"university info" + "</title>"+
	"<body> <h1> Name</h1></body></html> "; 
	}
	
	@POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createDataInJSON(String data) { 

        String result = "Data post: "+data;
        System.out.println(result);
        return result; 
    }
	
}
