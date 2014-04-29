package com.edu.postwebservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


@Path("/upload")
public class PostUpload {
	//static for testing
public String user ="tempUser";
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveUser(@Context UriInfo info){
		 String username = info.getQueryParameters().getFirst("username");
		user=username;
		System.out.println(user);
		return "success";
	}
	
	
	@POST
	@Path("/file")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createDataInJSON(String data) { 
		String result = "Data post: "+data;
		JSONObject obj = new JSONObject();
        File file = new File(user);
        
		try {
			if(file==null || !file.exists()){
	        	file.createNewFile();
	        }else{
	        	System.out.println("file exists");
	        }
	        FileWriter fw;
			fw = new FileWriter(file.getAbsoluteFile(),true);
			System.out.println(file.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(data+"\n");
			bw.close();
			obj.put("data", result);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 
		System.out.println(result);
        return obj.toString(); 
    }
	
}
