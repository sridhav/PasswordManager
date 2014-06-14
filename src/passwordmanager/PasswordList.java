/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Me
 */
public class PasswordList extends JFrame{
    JSONObject jsonObject=null;
    Credentials cred[]=null;
    JPanel listPanel = new JPanel();
    JButton add = null;
    public PasswordList(String filepath) throws FileNotFoundException, IOException, ParseException{
        
        JSONParser parser=new JSONParser();
        Object obj = parser.parse(new FileReader(filepath));
        jsonObject = (JSONObject) obj;
        JSONObject list = (JSONObject) jsonObject.get("list");
        System.out.println(list);
        JSONArray credentials=(JSONArray)list.get("credentials");
        System.out.println(credentials);
        cred=new Credentials[credentials.size()];
        listPanel.setLayout(new BoxLayout(listPanel,BoxLayout.PAGE_AXIS));
        for(int i = 0; i < credentials.size(); i++){
            cred[i]=new Credentials();
            JSONObject jsonobj = (JSONObject) credentials.get(i);
            cred[i].id=i;
            cred[i].username=(String) jsonobj.get("username");
            cred[i].pwd=(String) jsonobj.get("pwd");
            cred[i].url=(String) jsonobj.get("url");
            cred[i].note=(String) jsonobj.get("note");
            
            cred[i].host = cred[i].getHost();
            cred[i].display();
            
            JButton button =  new JButton(cred[i].host);
            listPanel.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("in here!");
                }
            });
        }
        add=new JButton("Add");
        listPanel.add(add);
        
        this.add(listPanel);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
