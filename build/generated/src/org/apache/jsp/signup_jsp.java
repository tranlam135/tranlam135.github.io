package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"author\" content=\"Kodinger\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n");
      out.write("\t<title>Sogn up</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/my-login.css\">\n");
      out.write("</head>\n");
      out.write("<body class=\"my-login-page\">\n");
      out.write("\t<section class=\"h-100\">\n");
      out.write("\t\t<div class=\"container h-100\">\n");
      out.write("\t\t\t<div class=\"row justify-content-md-center h-100\">\n");
      out.write("\t\t\t\t<div class=\"card-wrapper\">\n");
      out.write("\t\t\t\t\t<div class=\"brand\">\n");
      out.write("                                            <img src=\"img/logo.png\" alt=\"bootstrap 4 login page\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"card fat\">\n");
      out.write("\t\t\t\t\t\t<div class=\"card-body\">\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"card-title\">Sign up</h4>\n");
      out.write("                                                        <form action=\"signup\" method=\"post\" class=\"my-login-validation\" novalidate=\"\">\n");
      out.write("                                                                \n");
      out.write("                                                            \n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"user\">Username</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"name\" type=\"text\" class=\"form-control\" name=\"user\" required autofocus>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"invalid-feedback\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\tUsername is required\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"pass\">Password</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"password\" type=\"password\" class=\"form-control\" name=\"pass\" required data-eye>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"invalid-feedback\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\tPassword is required\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("                                                            \n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"repass\">Re-enter Password</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"password\" type=\"password\" class=\"form-control\" name=\"repass\" required data-eye>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"invalid-feedback\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\tRe-enter Password is required\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("                                                            \n");
      out.write("                                                                <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"custom-checkbox custom-control\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"agree\" id=\"agree\" class=\"custom-control-input\" required=\"\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"agree\" class=\"custom-control-label\">I agree to the <a href=\"#\">Terms and Conditions</a></label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"invalid-feedback\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tYou must agree with our Terms and Conditions\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group m-0\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary btn-block\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\tSign up\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"mt-4 text-center\">\n");
      out.write("\t\t\t\t\t\t\t\t\tAlready have an account? <a href=\"login.jsp\">Login</a>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</section>\n");
      out.write("\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("\t<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("\t<script src=\"js/my-login.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
