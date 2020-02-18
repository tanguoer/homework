package com.tt.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupTeacher {
    public static void main(String[] args) throws IOException {
        List<Teacher> teachers = new ArrayList<Teacher>();
        String path = JsoupTeacher.class.getClassLoader().getResource("teachers.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements names = document.getElementsByTag("name");
        Elements genders = document.getElementsByTag("gender");
        Elements salarys = document.getElementsByTag("salary");
        for (int i = 0; i < 2; i++) {
            String name = names.get(i).text();
            String gender = genders.get(i).text();
            String salary = salarys.get(i).text();

            Teacher teacher = new Teacher();
            teacher.setName(name);
            teacher.setGender(gender);
            teacher.setSalary(Double.parseDouble(salary));
            teachers.add(teacher);
        }
        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }
}
