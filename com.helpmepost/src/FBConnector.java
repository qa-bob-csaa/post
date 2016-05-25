/**
 * Created by gn11sma on 5/14/2016.
 */
/*
import static com.emobus.stuff.LoggerConstants.facebookUserId;
import static com.emobus.stuff.LoggerConstants.ipAddress;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.w3c.dom.Document;
import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookWebappHelper;
import com.google.code.facebookapi.FacebookXmlRestClient;
import com.google.code.facebookapi.IFacebookRestClient;
*/

public class FBConnector {
    public FBConnector() {
    System.out.println("Entering the FB Connector");
    }
}

/** * The Facebook User Filter ensures that a Facebook client that pertains to * the logged in user is available in the session object named "facebook.user.client". * * The session ID is stored as "facebook.user.session". It's important to get * the session ID only when the application actually needs it. The user has to * authorise to give the application a session key. * * @author Dave */
/*
public class FacebookUserFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(FacebookUserFilter.class);

    private String api_key;
    private String secret;

    private static final String FACEBOOK_USER_CLIENT = "facebook.user.client";

    public void init(FilterConfig filterConfig) throws ServletException {
        api_key = filterConfig.getServletContext().getInitParameter("facebook_api_key");
        secret = filterConfig.getServletContext().getInitParameter("facebook_secret");
        if(api_key == null || secret == null) {
            throw new ServletException("Cannot initialise Facebook User Filter because the " +
                    "facebook_api_key or facebook_secret context init " +
                    "params have not been set. Check that they're there " +
                    "in your servlet context descriptor.");
        } else {
            logger.info("Using facebook API key: " + api_key);
        }
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        try {
            MDC.put(ipAddress, req.getRemoteAddr());

            HttpServletRequest request = (HttpServletRequest)req;
            HttpServletResponse response = (HttpServletResponse)res;

            HttpSession session = request.getSession(true);
            IFacebookRestClient<Document> userClient = getUserClient(session);
            if(userClient == null) {
                logger.debug("User session doesn't have a Facebook API client setup yet. Creating one and storing it in the user's session.");
                userClient = new FacebookXmlRestClient(api_key, secret);
                session.setAttribute(FACEBOOK_USER_CLIENT, userClient);
            }

            logger.trace("Creating a FacebookWebappHelper, which copies fb_ request param data into the userClient");
            FacebookWebappHelper<Document> facebook = new FacebookWebappHelper<Document>(request, response, api_key, secret, userClient);
            String nextPage = request.getRequestURI();
            nextPage = nextPage.substring(nextPage.indexOf("/", 1) + 1); //cut out the first /, the context path and the 2nd /
            logger.trace(nextPage);
            boolean redirectOccurred = facebook.requireLogin(nextPage);
            if(redirectOccurred) {
                return;
            }
            redirectOccurred = facebook.requireFrame(nextPage);
            if(redirectOccurred) {
                return;
            }

            long facebookUserID;
            try {
                facebookUserID = userClient.users_getLoggedInUser();
            } catch(FacebookException ex) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while fetching user's facebook ID");
                logger.error("Error while getting cached (supplied by request params) value " +
                        "of the user's facebook ID or while fetching it from the Facebook service " +
                        "if the cached value was not present for some reason. Cached value = {}", userClient.getCacheUserId());
                return;
            }

            MDC.put(facebookUserId, String.valueOf(facebookUserID));

            chain.doFilter(request, response);
        } finally {
            MDC.remove(ipAddress);
            MDC.remove(facebookUserId);
        }
    }

    public static FacebookXmlRestClient getUserClient(HttpSession session) {
        return (FacebookXmlRestClient)session.getAttribute(FACEBOOK_USER_CLIENT);
    }  */
}