/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Me
 */
public class Credentials {
    public int id;
    public String username;
    public String pwd;
    public String url;
    public String host;
    public String note;
    
    public void display(){
        System.out.println("#########################");
        System.out.println("id:"+this.id);
        System.out.println("username:"+this.username);
        System.out.println("password:"+this.pwd);
        System.out.println("url:"+this.url);
        System.out.println("note:"+this.note);
        System.out.println("#########################");
    }
    
    public String getHost() throws MalformedURLException{
        URL url=new URL(this.url);
        String hostName = url.getHost();
        String arr[] = hostName.split("\\.");
        System.out.println("arrlen: "+arr.length + "host: "+hostName);
        hostName= arr[arr.length-2];
        return hostName;
    }
}
