package showimage;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class showimage extends HttpServlet {

public void doGet(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException
{

try{
FileInputStream hFile = new FileInputStream("d:\1.jpg"); // 以byte流的方式打開文件 d:1.gif
int i=hFile.available(); //得到文件大小
byte data[]=new byte[i];
hFile.read(data); //讀數據
hFile.close();
res.setContentType("image/*"); //設置返回的文件類型
OutputStream toClient=res.getOutputStream(); //得到向客戶端輸出二進制數據的對象
toClient.write(data); //輸出數據
toClient.close();
}
catch(IOException e) //錯誤處理
{
PrintWriter toClient = res.getWriter(); //得到向客戶端輸出文本的對象
res.setContentType("text/html;charset=gb2312");
toClient.write("無法打開圖片!");
toClient.close();
}

}

}