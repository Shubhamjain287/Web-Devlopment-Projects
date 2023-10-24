
import com.vmm.JHTTPServer;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerForChatRoom extends JHTTPServer {

    public ServerForChatRoom(int port) throws IOException {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header,
            Properties parms, Properties files) {

        Response res = null;

        System.out.println("URI" + uri);

        if (uri.contains("/GetResource")) //request should be of the form /GetResource/src/content/one.jpg
        {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri + " *** ");
            res = sendCompleteFile(uri);
        } else if (uri.contains("/StreamMedia")) //request should be of the form /GetResource/one.jpg
        {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri + " *** ");
            res = streamFile(uri, method, header);
        } else if (uri.contains("/AdminLogin")) {
            String u = parms.getProperty("username");
            String p = parms.getProperty("password");

            try {
                ResultSet rs = DBLoader.executeQuery("select * from adminlogin where username=\'" + u + "\' and password=\'" + p + "\'");

                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "Login Successfull !!!");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "Login Failed !!!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/addcategory")) {
            String n = parms.getProperty("name");
            String d = parms.getProperty("description");

            try {
                ResultSet rs = DBLoader.executeQuery("select * from categories where Name='" + n + "'");

                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "Category Already Exists");
                } else {

                    rs.moveToInsertRow();

                    rs.updateString("Name", n);
                    rs.updateString("Description", d);
                    rs.insertRow();

                    res = new Response(HTTP_OK, "text/plain", "Category Created");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/fetchallcategories")) {

            try {
                String ans = "";
                ResultSet rs = DBLoader.executeQuery("select * from categories");

                while (rs.next()) {
                    String c = rs.getString("Name");
                    String d = rs.getString("Description");

                    ans+= c + "~~" + d + ";;";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/deletecategory")) {
            String c = parms.getProperty("Name");

            try {
                ResultSet rs = DBLoader.executeQuery("select * from categories where Name='" + c + "'");

                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "Category Deleted");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "no such category");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/addroom")) {
            String roomname, category;

            roomname = parms.getProperty("roomname");
            category = parms.getProperty("category");
            System.out.println("" + roomname);
            try {
                ResultSet rs = DBLoader.executeQuery("select * from rooms where roomname='" + roomname + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "Roomname already exits");
                } else {
                    String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/content");
                    rs.moveToInsertRow();
                    rs.updateString("roomname", roomname);
                    rs.updateString("category", category);
                    rs.updateString("photo", "src/content/" + filename);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "Room Created");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/fetchallrooms")) {

            try {
                String ans = "";
                ResultSet rs = DBLoader.executeQuery("select * from rooms");

                while (rs.next()) {
                    String c = rs.getString("Roomid");
                    String d = rs.getString("Roomname");
                    String e = rs.getString("Category");
                    String f = rs.getString("Photo");

                    ans += c + ";;" + d + ";;" + e + ";;" + f + "~~";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/deleteroom")) {
            String c = parms.getProperty("Roomid");

            try {
                ResultSet rs = DBLoader.executeQuery("select * from rooms where Roomid=" + c);

                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "Room Deleted");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "no such room");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/usersignup")) {
            String a, b, c, d, e, f;
            a = parms.getProperty("username");
            b = parms.getProperty("password");
            c = parms.getProperty("displayname");
            d = parms.getProperty("gender");
            e = parms.getProperty("email");
            f = parms.getProperty("mobile");

            try {
                ResultSet rs = DBLoader.executeQuery("select * from user where username='" + a + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "Username Already Taken");
                } else {
                    String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/content");
                    rs.moveToInsertRow();
                    rs.updateString("username", a);
                    rs.updateString("password", b);
                    rs.updateString("displayname", c);
                    rs.updateString("gender", d);
                    rs.updateString("email", e);
                    rs.updateString("mobile", f);
                    rs.updateString("photo", "src/content/" + filename);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "User SignUp Successful");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/userlogin")) {
            try {
                String a = parms.getProperty("username");
                String b = parms.getProperty("password");
                ResultSet rs = DBLoader.executeQuery("select * from user where username='" + a + "'and password='" + b + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "Login Successful");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "Invalid login");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (uri.contains("/getnameandphoto")) {
            String a = parms.getProperty("username");
            System.out.println(a);
            try {
                ResultSet rs = DBLoader.executeQuery("select * from user where username='" + a + "'");
                if (rs.next());
                {
                    String b = rs.getString("displayname");
                    String c = rs.getString("photo");
                    String ans = b + "~~" + c;
                    res = new Response(HTTP_OK, "text/plain", ans);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/changepassword")) {
            try {
                String a = parms.getProperty("oldpass");
                String b = parms.getProperty("newpass");
                ResultSet rs = DBLoader.executeQuery("select * from user where password='" + a + "'");
                if (rs.next()) {
                    rs.updateString("password", b);
                    res = new Response(HTTP_OK, "text/plain", "Password Updated");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "Password don't match");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.contains("/GetRooms")) {
            String category = parms.getProperty("category");
            System.out.println(category);
            String ans = "";
            try {
                ResultSet rs = DBLoader.executeQuery("select * from rooms where Category='" + category + "'");
                while (rs.next()) {
                    String Roomid = rs.getString("Roomid");
                    String roomname = rs.getString("Roomname");
                    String catname = rs.getString("Category");
                    String photo = rs.getString("Photo");
                    System.out.println(Roomid);
                    System.out.println(roomname);
                    System.out.println(category);
                    System.out.println(photo);
                    ans = ans + Roomid + "~~" + roomname + "~~" + catname + "~~" + photo + ";;";
                    System.out.println(ans);
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/getroomdetails")) {
            try {
                int roomid = Integer.parseInt(parms.getProperty("roomid"));
                ResultSet rs = DBLoader.executeQuery("select * from rooms where Roomid=" + roomid);
                if (rs.next()) {
                    String roomname = rs.getString("Roomname");
                    String category = rs.getString("Category");
                    String photo = rs.getString("Photo");
                    String ans = roomname + "~~" + category + "~~" + photo;
                    res = new Response(HTTP_OK, "text/plain", ans);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (uri.contains("/checkroomjoin")) {
            try {
                String username = parms.getProperty("username");
                String roomid = parms.getProperty("roomid");
                ResultSet rs = DBLoader.executeQuery("select * from myrooms where username='" + username + "'and roomid=" + roomid);
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "yes");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "no");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (uri.contains("/joinroom")) {
            try {
                String username = parms.getProperty("username");
                int roomid = Integer.parseInt(parms.getProperty("roomid"));
                ResultSet rs = DBLoader.executeQuery("select * from myrooms where username='" + username + "' and roomid=" + roomid);
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "no");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("username", username);
                    rs.updateInt("roomid", roomid);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "yes");

                }
            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (uri.contains("/addtextmsg")) {
            try {
                String msg = parms.getProperty("msg");
                String msgtype = parms.getProperty("msgtype");
                String username = parms.getProperty("username");
                String roomid = parms.getProperty("roomid");
                ResultSet rs = DBLoader.executeQuery("select * from message");

                rs.moveToInsertRow();
                rs.updateString("message", msg);
                rs.updateString("msgtype", msgtype);
                rs.updateString("postedby", username);
                rs.updateString("roomid", roomid);
                rs.insertRow();
                res = new Response(HTTP_OK, "text/plain", "sent");

            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.contains("/addfilemsg")) {
            try {
                String username = parms.getProperty("username");
                String roomid = parms.getProperty("roomid");
                String msgtype = parms.getProperty("msgtype");

                String filename = saveFileOnServerWithRandomName(files, parms, "msg", "src/content");
                ResultSet rs = DBLoader.executeQuery("select * from message");
                rs.moveToInsertRow();
                rs.updateString("message", "src/content/" + filename);
                rs.updateString("msgtype", msgtype);
                rs.updateString("postedby", username);
                rs.updateString("roomid", roomid);
                rs.insertRow();
                res = new Response(HTTP_OK, "text/plain", "sent");
            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (uri.contains("/getmembersofroom")) {
            String ans = "";
            try {
                int roomid = Integer.parseInt(parms.getProperty("roomid"));
                ResultSet rs = DBLoader.executeQuery("select * from myrooms where roomid=" + roomid);
                while (rs.next()) {
                    String username = rs.getString("username");
                    ResultSet rs2 = DBLoader.executeQuery("select * from user where username='" + username + "'");
                    rs2.next();
                    String display = rs2.getString("displayname");
                    ans = ans + display + "~~";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else if(uri.contains("/fetchmyrooms"))
        {   
            try {
                String ans="";
                String username=parms.getProperty("username");
                ResultSet rs=DBLoader.executeQuery("select * from myrooms where username='"+username+"'");
                while(rs.next())
                {
                    String a=rs.getString("roomid");
                    ResultSet rs2=DBLoader.executeQuery("select * from rooms where Roomid="+a);
                    rs2.next();
                    String b=rs2.getString("Roomname");
                    String c=rs2.getString("category");
                    String d=rs2.getString("photo");
                    ans=ans+a+"~~"+b+"~~"+c+"~~"+d+";;";
                }
                res= new Response(HTTP_OK, "text/plain", ans);
            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(uri.contains("/leaveroom"))
        {
            try {
                String roomid=parms.getProperty("roomid");
                String user=parms.getProperty("username");
                ResultSet rs=DBLoader.executeQuery("select * from myrooms where roomid ='"+roomid+"'and username='"+user+"'");   
                rs.next();
                rs.deleteRow();
                res= new Response(HTTP_OK, "text/plain", "RoomLeft");
            } catch (SQLException ex) {
                Logger.getLogger(ServerForChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (uri.contains("/uploadfile")) {
            String a = parms.getProperty("a");
            String f1 = files.getProperty("f1");

            System.out.println("--- File Upload Example ---");
            System.out.println(a);
            System.out.println(f1);

            saveFileOnServerWithRandomName(files, parms, "f1", "src/uploaded_pics");

            System.out.println("File Saved on Server");
        } else if (uri.contains("/fetchmessages")) {
            String ans = "";
            try {
                String rid = parms.getProperty("roomid");
                ResultSet rs = DBLoader.executeQuery("select * from message where roomid='" + rid + "'");

                while (rs.next()) {

                    String message = rs.getString("message");
                    String postedby = rs.getString("postedby");
                    String time = rs.getString("datetime");
                    String type = rs.getString("msgtype");
                    ResultSet rs2 = DBLoader.executeQuery("select * from user where username='" + postedby + "'");
                    if (rs2.next()) {
                        String displayname = rs2.getString("displayname");
                        ans = ans + message + "~~" + postedby + "~~" + time + "~~" + displayname + "~~" + type + ";;";

                    }
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            res = new Response(HTTP_OK, "text/html", "<body style='background: #D46A6A; color: #fff'><center><h1>Hello</h1><br> <h3>Welcome To JHTTP Server (Version 1.0)</h3></body></center>");

        }

        return res;
    }
}
