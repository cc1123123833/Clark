package com.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {
    /**
     * 前置过滤器。
     *
     * 但是在 zuul 中定义了四种不同生命周期的过滤器类型：
     *
     *      1、pre：可以在请求被路由之前调用；
     *
     *      2、route：在路由请求时候被调用；
     *
     *      3、post：在route和error过滤器之后被调用；
     *
     *      4、error：处理请求时发生错误时被调用；
     *
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的优先级，数字越大，优先级越低。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器。
     *
     * true：说明需要过滤；
     *
     * false：说明不要过滤；
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。
     *
     */
    @Override
    public Object run() throws ZuulException {
        //1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2.获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //3.获取userToken参数 一般是在头文件中
        String userToken = request.getParameter("userToken");
        if(Strings.isBlank(userToken))
        {
            //不会继续执行后续流程
            currentContext.setSendZuulResponse(false);
            //错误信息
            currentContext.setResponseBody("have not userToken!!!");
            //错误码
            currentContext.setResponseStatusCode(500);
        }
        //正常执行下面filter或调用接口
        return null;
    }
}
