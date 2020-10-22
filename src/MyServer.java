import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 王旻爽
 * 2020/10/22
 * @ClassName MyServer.java
 */
public class MyServer {

    public static void StartServer(int port) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = null;

        while (true){
            socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            MyRequest request = new MyRequest(inputStream);
            MyResponse response = new MyResponse(outputStream);

            String clazz = new MyMapping().getMapping().get(request.getRequestUrl());
            if (clazz != null) {
                Class<MyServlet> aClass = (Class<MyServlet>) Class.forName(clazz);
                Constructor<MyServlet> constructor = aClass.getConstructor();
                MyServlet myServlet = constructor.newInstance();
                myServlet.service(request,response);
            }
        }
    }
}
