import java.io.IOException;

/**
 * @author 王旻爽
 * 2020/10/22
 * @ClassName MyServlet.java
 */
public class MyServlet extends MyHttpServlet {


    @Override
    public void doGet(MyRequest request, MyResponse response) throws IOException {
        response.write("mytomcat get");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws IOException {
        response.write("post tomcat");
    }
}
