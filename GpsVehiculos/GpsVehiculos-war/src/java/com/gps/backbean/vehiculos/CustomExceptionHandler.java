    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.backbean.vehiculos;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.servlet.ServletException;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {
    private boolean envioCorreoError = false;
    private ExceptionHandler wrapped;

    CustomExceptionHandler(ExceptionHandler exception) {
        this.wrapped = exception;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {
        final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();
        while (i.hasNext()) {
            ExceptionQueuedEvent event = i.next();
            ExceptionQueuedEventContext context
                    = (ExceptionQueuedEventContext) event.getSource();

            // get the exception from context
            Throwable t = context.getException();

            final FacesContext fc = FacesContext.getCurrentInstance();
            final Map<String, Object> requestMap = fc.getExternalContext().getRequestMap();
            final NavigationHandler nav = fc.getApplication().getNavigationHandler();

            //here you do what ever you want with exception
            try {

                //log error ?
                //log.log(Level.SEVERE, "Critical Exception!", t);
                if (t instanceof ViewExpiredException) {
                    requestMap.put("javax.servlet.error.message", "Session expired, try again!");
                    String errorPageLocation = "/error.xhtml";
                    fc.setViewRoot(fc.getApplication().getViewHandler().createView(fc, errorPageLocation));
                    fc.getPartialViewContext().setRenderAll(true);
                    fc.renderResponse();
                } else {
                    //redirect error page
                    requestMap.put("javax.servlet.error.message", t.getMessage());
                    StringWriter writer = new StringWriter();
                    PrintWriter  pw     = new PrintWriter( writer );
                    fillStackTrace(t, pw);
                    
                    
                    nav.handleNavigation(fc, null, "/error.xhtml");
                }

                fc.renderResponse();
                // remove the comment below if you want to report the error in a jsf error message
                //JsfUtil.addErrorMessage(t.getMessage());
            } finally {
                //remove it from queue
                i.remove();
            }
        }
        //parent hanle
        getWrapped().handle();
    }
    
      private void fillStackTrace(Throwable ex, PrintWriter pw) {
         if (null == ex) { return; }
         ex.printStackTrace(pw);

         if (ex instanceof ServletException){
            Throwable cause = ((ServletException) ex).getRootCause();
            if (null != cause) {
                pw.println("Root Cause:");
                fillStackTrace(cause, pw);
            }
         }else{
            Throwable cause = ex.getCause();
         
            if (null != cause) 
			{
                pw.println("Cause:");
                fillStackTrace(cause, pw);
            }
         }
      }
}
