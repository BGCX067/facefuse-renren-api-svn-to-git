
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class FileUploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, java.io.IOException {
		SingleFileUpload upload = new SingleFileUpload();
        upload.parseRequest(request);
        File parent = new File("C:\\upload\\");    
        
        try {
            upload.upload(parent);
        }
        catch(org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e){            
            // 文件大小超出最大值
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
	}
}