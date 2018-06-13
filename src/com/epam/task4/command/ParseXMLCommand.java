package com.epam.task4.command;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ParseXMLCommand extends XMLCommand {

    public ParseXMLCommand(Handler handler) {
        super(handler);
    }

    public ParseXMLCommand() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        getHandler().handle(XMLCommandType.PARSE_COMMAND,request,response,servletContext);
    }
}
