import java.io.IOException;

/**
 * @author 王旻爽
 * 2020/10/22
 * @ClassName MyHttpServlet.java
 */
public abstract class MyHttpServlet {

    // 定义常量
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    public abstract void doGet(MyRequest request,MyResponse response) throws IOException;
    public abstract void doPost(MyRequest request,MyResponse response) throws IOException;

    public void service(MyRequest request,MyResponse response) throws IOException {
        if(METHOD_GET.equals(request.getRequestMethod())){
            doGet(request,response);
        } else if(METHOD_POST.equals(request.getRequestMethod())){
            doPost(request,response);
        }
    }

}
