package ksuhaylia.coursedata.controllers;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.io.Writer;

@ControllerAdvice
public class LayoutAdvice {

    @ModelAttribute("header")
    public Mustache.Lambda layout() {
        return new Layout();
    }

    @ModelAttribute("shortHeader")
    public Mustache.Lambda layout1() {
        return new Layout();
    }

}

class Layout implements Mustache.Lambda {
    String body;
    @Override
    public void execute(Template.Fragment frag, Writer out) throws IOException {
        body = frag.execute();
    }
}