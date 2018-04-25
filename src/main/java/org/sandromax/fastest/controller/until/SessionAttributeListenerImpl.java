package org.sandromax.fastest.controller.until;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListenerImpl implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("add: " + httpSessionBindingEvent.getClass().getSimpleName() + " : " + httpSessionBindingEvent.getName() + " : " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("replace: " + httpSessionBindingEvent.getClass().getSimpleName() + " : " + httpSessionBindingEvent.getName() + " : " + httpSessionBindingEvent.getValue());

    }
}
