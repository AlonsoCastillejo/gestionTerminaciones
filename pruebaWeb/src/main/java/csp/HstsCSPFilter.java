package csp;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"}, asyncSupported = true)
public class HstsCSPFilter implements Filter {

	public static final String POLICY = "default-src 'self'; "
			+ "script-src 'self' 'unsafe-inline';"
			+ "style-src 'self' 'unsafe-inline';"
			+ " img-src 'self'; child-src 'self'; frame-ancestors 'self';";	
	
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

//        if (httpRequest.isSecure()) {
//            httpResponse.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
//        }

        httpResponse.setHeader("Content-Security-Policy", POLICY);
        httpResponse.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
        httpResponse.setHeader("X-Content-Type-Options", "nosniff");


        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
       
    }
}

