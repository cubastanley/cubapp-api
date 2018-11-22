/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.cubappmessenger;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

public class AppConfig extends ResourceConfig {
    
    public AppConfig() {
        packages("fish.payara.cubappmessenger.resource");
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/");
        register(JspMvcFeature.class);
    }
    
}
