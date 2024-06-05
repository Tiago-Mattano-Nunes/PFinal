package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("       <title>Login</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"./cadastro.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.2/css/all.css\"\n");
      out.write("        integrity=\"sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay\" crossorigin=\"anonymous\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"content first-content\">\n");
      out.write("            <div class=\"first-column\">\n");
      out.write("                <h2 class=\"title title-primary\">welcome back!</h2>\n");
      out.write("                <p class=\"description description-primary\">To keep connected with us</p>\n");
      out.write("                <p class=\"description description-primary\">please login with your personal info</p>\n");
      out.write("                <button id=\"signin\" class=\"btn btn-primary\">sign in</button>\n");
      out.write("            </div>    \n");
      out.write("            <div class=\"second-column\">\n");
      out.write("                <h2 class=\"title title-second\">create account</h2>\n");
      out.write("                <div class=\"social-media\">\n");
      out.write("                    <ul class=\"list-social-media\">\n");
      out.write("                        <a class=\"link-social-media\" href=\"#\">\n");
      out.write("                            <li class=\"item-social-media\">\n");
      out.write("                                <i class=\"fab fa-facebook-f\"></i>        \n");
      out.write("                            </li>\n");
      out.write("                        </a>\n");
      out.write("                        <a class=\"link-social-media\" href=\"#\">\n");
      out.write("                            <li class=\"item-social-media\">\n");
      out.write("                                <i class=\"fab fa-google-plus-g\"></i>\n");
      out.write("                            </li>\n");
      out.write("                        </a>\n");
      out.write("                        <a class=\"link-social-media\" href=\"#\">\n");
      out.write("                            <li class=\"item-social-media\">\n");
      out.write("                                <i class=\"fab fa-linkedin-in\"></i>\n");
      out.write("                            </li>\n");
      out.write("                        </a>\n");
      out.write("                    </ul>\n");
      out.write("                </div><!-- social media -->\n");
      out.write("                <p class=\"description description-second\">or use your email for registration:</p>\n");
      out.write("                <form class=\"form\">\n");
      out.write("                    <label class=\"label-input\" for=\"\">\n");
      out.write("                        <i class=\"far fa-user icon-modify\"></i>\n");
      out.write("                        <input type=\"text\" placeholder=\"Name\">\n");
      out.write("                    </label>\n");
      out.write("                    \n");
      out.write("                    <label class=\"label-input\" for=\"\">\n");
      out.write("                        <i class=\"far fa-envelope icon-modify\"></i>\n");
      out.write("                        <input type=\"email\" placeholder=\"Email\">\n");
      out.write("                    </label>\n");
      out.write("                    \n");
      out.write("                    <label class=\"label-input\" for=\"\">\n");
      out.write("                        <i class=\"fas fa-lock icon-modify\"></i>\n");
      out.write("                        <input type=\"password\" placeholder=\"Password\">\n");
      out.write("                    </label>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <button class=\"btn btn-second\">sign up</button>        \n");
      out.write("                </form>\n");
      out.write("            </div><!-- second column -->\n");
      out.write("        </div><!-- first content -->\n");
      out.write("        <div class=\"content second-content\">\n");
      out.write("            <div class=\"first-column\">\n");
      out.write("                <h2 class=\"title title-primary\">hello, friend!</h2>\n");
      out.write("                <p class=\"description description-primary\">Enter your personal details</p>\n");
      out.write("                <p class=\"description description-primary\">and start journey with us</p>\n");
      out.write("                <button id=\"signup\" class=\"btn btn-primary\">sign up</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"second-column\">\n");
      out.write("                <h2 class=\"title title-second\">sign in to developer</h2>\n");
      out.write("                <div class=\"social-media\">\n");
      out.write("                    <ul class=\"list-social-media\">\n");
      out.write("                        <a class=\"link-social-media\" href=\"#\">\n");
      out.write("                            <li class=\"item-social-media\">\n");
      out.write("                                <i class=\"fab fa-facebook-f\"></i>\n");
      out.write("                            </li>\n");
      out.write("                        </a>\n");
      out.write("                        <a class=\"link-social-media\" href=\"#\">\n");
      out.write("                            <li class=\"item-social-media\">\n");
      out.write("                                <i class=\"fab fa-google-plus-g\"></i>\n");
      out.write("                            </li>\n");
      out.write("                        </a>\n");
      out.write("                        <a class=\"link-social-media\" href=\"#\">\n");
      out.write("                            <li class=\"item-social-media\">\n");
      out.write("                                <i class=\"fab fa-linkedin-in\"></i>\n");
      out.write("                            </li>\n");
      out.write("                        </a>\n");
      out.write("                    </ul>\n");
      out.write("                </div><!-- social media -->\n");
      out.write("                <p class=\"description description-second\">or use your email account:</p>\n");
      out.write("                <form class=\"form\">\n");
      out.write("                \n");
      out.write("                    <label class=\"label-input\" for=\"\">\n");
      out.write("                        <i class=\"far fa-envelope icon-modify\"></i>\n");
      out.write("                        <input type=\"email\" placeholder=\"Email\">\n");
      out.write("                    </label>\n");
      out.write("                \n");
      out.write("                    <label class=\"label-input\" for=\"\">\n");
      out.write("                        <i class=\"fas fa-lock icon-modify\"></i>\n");
      out.write("                        <input type=\"password\" placeholder=\"Password\">\n");
      out.write("                    </label>\n");
      out.write("                \n");
      out.write("                    <a class=\"password\" href=\"#\">forgot your password?</a>\n");
      out.write("                    <button class=\"btn btn-second\">sign in</button>\n");
      out.write("                </form>\n");
      out.write("            </div><!-- second column -->\n");
      out.write("        </div><!-- second-content -->\n");
      out.write("    </div>\n");
      out.write("    <script src=\"js/app.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
