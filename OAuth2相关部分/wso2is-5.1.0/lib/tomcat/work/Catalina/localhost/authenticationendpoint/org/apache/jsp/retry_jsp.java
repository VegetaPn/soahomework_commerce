/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.59
 * Generated at: 2016-06-23 15:50:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.owasp.encoder.Encode;
import org.owasp.encoder.Encode;

public final class retry_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fbundle_0026_005fbasename;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmt_005fbundle_0026_005fbasename = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005fbundle_0026_005fbasename.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      //  fmt:bundle
      org.apache.taglibs.standard.tag.rt.fmt.BundleTag _jspx_th_fmt_005fbundle_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.BundleTag) _005fjspx_005ftagPool_005ffmt_005fbundle_0026_005fbasename.get(org.apache.taglibs.standard.tag.rt.fmt.BundleTag.class);
      _jspx_th_fmt_005fbundle_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fbundle_005f0.setParent(null);
      // /retry.jsp(24,0) name = basename type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fbundle_005f0.setBasename("org.wso2.carbon.identity.application.authentication.endpoint.i18n.Resources");
      int _jspx_eval_fmt_005fbundle_005f0 = _jspx_th_fmt_005fbundle_005f0.doStartTag();
      if (_jspx_eval_fmt_005fbundle_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_fmt_005fbundle_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_fmt_005fbundle_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_fmt_005fbundle_005f0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("\n");
          out.write("    ");

        String stat = request.getParameter("status");
        String statusMessage = request.getParameter("statusMsg");
        if (stat == null || statusMessage == null) {
            stat = "Authentication Error !";
            statusMessage = "Something went wrong during the authentication process. Please try signing in again.";
        }
        session.invalidate();
    
          out.write("\n");
          out.write("\n");
          out.write("    <html>\n");
          out.write("    <head>\n");
          out.write("        <meta charset=\"utf-8\">\n");
          out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
          out.write("        <title>WSO2 Identity Server</title>\n");
          out.write("\n");
          out.write("        <link rel=\"icon\" href=\"images/favicon.png\" type=\"image/x-icon\"/>\n");
          out.write("        <link href=\"libs/bootstrap_3.3.5/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
          out.write("        <link href=\"css/Roboto.css\" rel=\"stylesheet\">\n");
          out.write("        <link href=\"css/custom-common.css\" rel=\"stylesheet\">\n");
          out.write("\n");
          out.write("\n");
          out.write("        <!--[if lt IE 9]>\n");
          out.write("        <script src=\"js/html5shiv.min.js\"></script>\n");
          out.write("        <script src=\"js/respond.min.js\"></script>\n");
          out.write("        <![endif]-->\n");
          out.write("    </head>\n");
          out.write("\n");
          out.write("    <body>\n");
          out.write("\n");
          out.write("    <!-- header -->\n");
          out.write("    <header class=\"header header-default\">\n");
          out.write("        <div class=\"container-fluid\"><br></div>\n");
          out.write("        <div class=\"container-fluid\">\n");
          out.write("            <div class=\"pull-left brand float-remove-xs text-center-xs\">\n");
          out.write("                <a href=\"#\">\n");
          out.write("                    <img src=\"images/logo-inverse.svg\" alt=\"wso2\" title=\"wso2\" class=\"logo\">\n");
          out.write("\n");
          out.write("                    <h1><em>Identity Server</em></h1>\n");
          out.write("                </a>\n");
          out.write("            </div>\n");
          out.write("        </div>\n");
          out.write("    </header>\n");
          out.write("\n");
          out.write("    <!-- page content -->\n");
          out.write("    <div class=\"row\">\n");
          out.write("        <div class=\"col-md-12\">\n");
          out.write("            <!-- content -->\n");
          out.write("            <div class=\"container col-xs-7 col-sm-5 col-md-4 col-lg-3 col-centered wr-content wr-login col-centered\">\n");
          out.write("                <div>\n");
          out.write("                    <h2 class=\"wr-title uppercase blue-bg padding-double white boarder-bottom-blue margin-none\">");
          out.print(Encode.forHtmlContent(stat));
          out.write(" </h2>\n");
          out.write("                </div>\n");
          out.write("\n");
          out.write("                <div class=\"boarder-all col-lg-12 padding-top-double padding-bottom-double error-alert  \">\n");
          out.write("                    <div class=\"font-medium\"><strong>Attention:</strong> </div>\n");
          out.write("                    <div class=\"padding-bottom-double\">\n");
          out.write("                        ");
          out.print(Encode.forHtmlContent(statusMessage));
          out.write("\n");
          out.write("                    </div>\n");
          out.write("                </div>\n");
          out.write("            </div>\n");
          out.write("            <!-- /content -->\n");
          out.write("\n");
          out.write("        </div>\n");
          out.write("    </div>\n");
          out.write("\n");
          out.write("    <!-- footer -->\n");
          out.write("    <footer class=\"footer\">\n");
          out.write("        <div class=\"container-fluid\">\n");
          out.write("            <p>WSO2 Identity Server | &copy;\n");
          out.write("                <script>document.write(new Date().getFullYear());</script>\n");
          out.write("                <a href=\"http://wso2.com/\" target=\"_blank\"><i class=\"icon fw fw-wso2\"></i> Inc</a>. All Rights Reserved.\n");
          out.write("            </p>\n");
          out.write("        </div>\n");
          out.write("    </footer>\n");
          out.write("\n");
          out.write("    <script src=\"libs/jquery_1.11.3/jquery-1.11.3.js\"></script>\n");
          out.write("    <script src=\"libs/bootstrap_3.3.5/js/bootstrap.min.js\"></script>\n");
          out.write("\n");
          out.write("    <script>\n");
          out.write("\n");
          out.write("\n");
          out.write("        $('#popover').popover({\n");
          out.write("            html: true,\n");
          out.write("            title: function () {\n");
          out.write("                return $(\"#popover-head\").html();\n");
          out.write("            },\n");
          out.write("            content: function () {\n");
          out.write("                return $(\"#popover-content\").html();\n");
          out.write("            }\n");
          out.write("        });\n");
          out.write("\n");
          out.write("    </script>\n");
          out.write("\n");
          out.write("    <script type=\"text/javascript\" src=\"js/u2f-api.js\"></script>\n");
          out.write("\n");
          out.write("    </body>\n");
          out.write("    </html>\n");
          out.write("\n");
          out.write("\n");
          int evalDoAfterBody = _jspx_th_fmt_005fbundle_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_fmt_005fbundle_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_fmt_005fbundle_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005ffmt_005fbundle_0026_005fbasename.reuse(_jspx_th_fmt_005fbundle_005f0);
        return;
      }
      _005fjspx_005ftagPool_005ffmt_005fbundle_0026_005fbasename.reuse(_jspx_th_fmt_005fbundle_005f0);
      out.write('\n');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
