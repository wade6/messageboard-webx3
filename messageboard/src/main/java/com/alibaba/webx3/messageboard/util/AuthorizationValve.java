package com.alibaba.webx3.messageboard.util;  
  
import java.util.List;  
import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;  
import org.springframework.beans.factory.annotation.Autowired;  
import com.alibaba.citrus.service.pipeline.PipelineContext;  
import com.alibaba.citrus.service.pipeline.support.AbstractValve;  
import com.alibaba.citrus.service.uribroker.URIBrokerService;  
import com.alibaba.citrus.service.uribroker.uri.URIBroker;  
import com.alibaba.citrus.turbine.TurbineRunData;  
import com.alibaba.citrus.turbine.util.TurbineUtil;  
import com.alibaba.citrus.util.ServletUtil;  
import com.alibaba.citrus.util.StringUtil;  
  
public class AuthorizationValve extends AbstractValve {  
      
    @Autowired  
    private HttpServletRequest request;  
      
    @Autowired  
    private URIBrokerService   uriBrokerService;  
      
    @Resource(name="whiteListForLogin")  
    private List<String>       whiteListForLogin;  
      
    public void invoke(PipelineContext pipelineContext) throws Exception {  
  
        // 获取session  
        HttpSession session = request.getSession();  
  
        TurbineRunData rundata = TurbineUtil.getTurbineRunData(request);  
        String  sessionUser=null;  
          
        //获取session中的用户名，到相应的sessionStore中获取，若设置为cookie，则到cookie中查找  
        sessionUser = (String) session.getAttribute("login_user");  
  
        //取得request所请求的资源路径。  
        String path = ServletUtil.getResourcePath(request);  
          
        if (sessionUser == null) {  
            //不是白名单的页面,跳回登陆页面  
            if (!checkUri(path)) {  
                URIBroker loginUrl = uriBrokerService.getURIBroker("loginLink");  
                rundata.setRedirectLocation(loginUrl.render());  
                return;  
            }  
        }  
        pipelineContext.invokeNext();  
    }  
      
    //检查白名单  
    private boolean checkUri(String path) {  
        int lastSlashIndex = path.lastIndexOf("/");  
        //最后的页面下划线大写处理  
        if (lastSlashIndex >= 0) {  
              
            path = path.substring(0, lastSlashIndex) + "/" + StringUtil.toCamelCase(path.substring(lastSlashIndex + 1));  
        } else {  
            path = StringUtil.toCamelCase(path);  
        }  
        return whiteListForLogin != null && whiteListForLogin.contains(path) ? true : false;  
    }  
}  