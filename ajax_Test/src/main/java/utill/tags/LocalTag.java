package utill.tags;

import utill.UTF8Control;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class LocalTag extends TagSupport {
    private String message;
    private UTF8Control utf8Control = new UTF8Control();
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();

        if (session.getAttribute("LOCALE") == null) {
            if (pageContext.getRequest().getLocale() == null) {
                session.setAttribute("LOCALE", new Locale("en", "US"));
            } else {
                session.setAttribute("LOCALE", pageContext.getRequest().getLocale());
            }
        }

        Locale locale = (Locale) session.getAttribute("LOCALE");

        if (message != null && !message.isEmpty()) {
            ResourceBundle messages = ResourceBundle.getBundle("i18n.messages", locale, utf8Control);
            String locMessage = messages.getString(message);

            try {
                pageContext.getOut().print(locMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SKIP_BODY;
    }
}

