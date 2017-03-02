/**
 * $Id: EncodingFilter.java 49 2013-10-17 05:17:47Z fenglei.you $
 * Copyright(C) 2010-2016 mbkele.com.cn. All rights reserved.
 */
package cc.hansam.jee;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author <a href="mailto:fenglei.you@mbkele.com.cn">fenglei.you</a>
 * @version 1.0
 * @since 1.0
 */
public class EncodingFilter implements Filter {
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		HttpServletResponse rsp = (HttpServletResponse)response;
		try {
			chain.doFilter(request, response);
		} catch(ServletException e) {
			e.printStackTrace();
			Throwable c = e.getCause();
			if(c != null) {
				request.setAttribute("errmsg", c.getMessage());
			}
			rsp.sendError(500);
		} finally {
		}
	}

	@Override
	public void destroy() {
	}

}
