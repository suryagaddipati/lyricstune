package importer.models;

import importer.models.leoslyrics.Response;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import junit.framework.TestCase;

public class ResponseUnMarshallerTest extends TestCase {
	private static final String URL = "http://api.leoslyrics.com/api_search.php?auth=duane&artist=Bush&songtitle=Glycerine";
	
	public void testBoot() throws Exception {
		
		   try {
		         Runtime rt = Runtime.getRuntime();
		         JAXBContext jaxbContext=JAXBContext.newInstance("importer.models");
		         Unmarshaller umarshaller = jaxbContext.createUnmarshaller();
		  
		         for(int i = 16 ; i< 30; i++){
		             String[] args = { "osascript", "-e","tell app \"iTunes\" to artist of  track "+ i+" of playlist \"iphone\" as string"};
		             final Process proc = rt.exec(args);
		             InputStream in = proc.getInputStream();
		             String artist = new DataInputStream(in).readLine();
		             in.close();
		             
		             
		             String[]   args1 = { "osascript", "-e","tell app \"iTunes\" to name of  track "+ i+" of playlist \"iphone\" as string"};
		             final Process proc1 = rt.exec(args1);
		              in = proc1.getInputStream();
		             String name = new DataInputStream(in).readLine();
		             in.close();
		          
		             System.out.println("got: Name : " + name + "Artist : " + artist);
		             
String urlStrng =makeUrl(artist, name);
System.out.println(urlStrng);
		     		URL url = new URL(urlStrng);
		     		
		     		Response response = (Response) umarshaller.unmarshal(url);
		     		System.out.println(response.searchResults);
		         }
		         

		      } catch (IOException ex) {
		         System.out.println("exception : " + ex.getMessage());
		         ex.printStackTrace();
		      }
	
		
	}
  private  String makeUrl(String artist , String trackName){
	  return "http://api.leoslyrics.com/api_search.php?auth=duane&artist="+artist+"&songtitle="+trackName;
  }
}
