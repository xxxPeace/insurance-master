package com.synergy.insurance.dao;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUploadDao {

	public String getFile(String id) throws IOException {
		Path dir;
		try{
		dir = Paths.get("/Users/peace/Desktop/POC/insurance-master/insurance-bank/src/main/webapp/document/" + id);
		} catch(Exception ex){
			return "empty";
		}
		List<Path> result = new ArrayList<>();
	       try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{jpg, png}")) {
	           for (Path entry: stream) {
	               result.add(entry);
	           }
	       } catch (Exception ex) {
	           // I/O error encounted during the iteration, the cause is an IOException
	           return "empty";
	       }
	       if(result.isEmpty()){
	    	   return "empty";
	       }
	       System.out.println(result.get(0).getFileName());
	       return result.get(0).getFileName().toString();
	}
	
}
