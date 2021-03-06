/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package weather1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.*;

class Place {
    int id;
    int pid;
    String city_code;
    String city_name;

    @Override
    public String toString() {
        return "city_code:" + this.city_code + " " + "city_name:" + this.city_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    public String getCitycode() {
        return city_code;
    }

    public void setCitycode(String city_code) {
        this.city_code = city_code;
    }

    public String getCityname() {
        return city_name;
    }

    public void setCityname(String city_name) {
        this.city_name = city_name;
    }
}

public class App {
    public static void main(String[] args) throws IOException {

        Gson gson = new GsonBuilder().create();

        Map<Place, List<Place>> cmap = new HashMap<>();

        String fileName = "_city.json";

        List<Place> provinces = new ArrayList<>();
        
        InputStream in = App.class.getClassLoader().getResourceAsStream(fileName);

        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String content = sb.toString();
        //-----------------------------
        String content1 = new String(content.getBytes(), "UTF-8");
        Place[] places = gson.fromJson(content1, Place[].class);
        
        Arrays.stream(places).forEach( e -> {
            if (e.pid == 0) {
                provinces.add(e);
            }
        });
        // System.out.println(provinces);

        for (Place p : provinces) {
            List<Place> cities = new ArrayList<>();
            for (int i=0; i<places.length; i++) {
                if (places[i].pid == p.id && !places[i].city_code.equals("")) {
                    cities.add(places[i]);
                }
            }
            cmap.put(p, cities);
        }
        System.out.println(cmap);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/weather?characterEncoding=utf-8";
            String user = "root";
            String pwd = "1234";
            Connection con = DriverManager.getConnection(url, user, pwd);

            String sql = "insert into province (id, name) values (?, ?)";

            PreparedStatement pstmt = con.prepareStatement(sql);
            for (Place p: provinces) {
                pstmt.setInt(1, p.getId());
                pstmt.setString(2, p.getCityname());
                
                pstmt.execute();  //执行传入的sql语句
            }

            // String sql = "insert into city (pid, code, name) values(?, ?, ?)";
            // PreparedStatement pstmt = con.prepareStatement(sql);
            // for (Map.Entry<Place, List<Place>> c: cmap.entrySet()) {
            //     for (Place x: c.getValue()) {
            //         pstmt.setInt(1, x.getPid());
            //         pstmt.setString(2, x.getCitycode());
            //         pstmt.setString(3, x.getCityname());
            //         pstmt.execute();
            //     }
            // }
        }
        catch(Exception e){
			e.printStackTrace();
		}
    }
}
