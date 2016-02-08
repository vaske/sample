package com.milanvasic.sample;

import static spark.Spark.*;
import com.milanvasic.sample.models.*;
import com.milanvasic.sample.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.hibernate.Session;

import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Route;

public class App {

    public static void main(final String[] args) {
        setPort(8080);
        externalStaticFileLocation("public"); // Static files

        get("/", (request, response) -> {
            response.redirect("/index.html");
            return "";
        });


        get("sample/companies", "application/json", (request, response) -> {
            List<Company> objs = HibernateUtil.getSession().createCriteria(Company.class).list();
            return objs;
        }, new JsonTransformer());

        get("sample/companies/:id", "application/json", (request, response) -> {
            long id = Long.parseLong(request.params(":id"));
            Company obj = (Company)HibernateUtil.getSession().get(Company.class, id);
            if (obj == null) halt(404);
            return obj;
        }, new JsonTransformer());

        post("sample/companies", "application/json", (request, response) -> {
            Company obj = JacksonUtil.readValue(request.body(), Company.class);
            HibernateUtil.getSession().saveOrUpdate(obj);
            response.status(201);
            return obj;
        }, new JsonTransformer());

        put("sample/companies/:id", "application/json", (request, response) -> {
            long id = Long.parseLong(request.params(":id"));
            Company obj = (Company)HibernateUtil.getSession().get(Company.class, id);
            if (obj == null) halt(404);
            obj = JacksonUtil.readValue(request.body(), Company.class);
            obj = (Company)HibernateUtil.getSession().merge(obj);
            return obj;
        }, new JsonTransformer());

        delete("sample/companies/:id", (request, response) -> {
            long id = Long.parseLong(request.params(":id"));
            Company obj = (Company)HibernateUtil.getSession().get(Company.class, id);
            if (obj == null) halt(404);
            HibernateUtil.getSession().delete(obj);
            response.status(204);
            return "";
        });

        get("sample/company_owners", "application/json", (request, response) -> {
            List<CompanyOwners> objs = HibernateUtil.getSession().createCriteria(CompanyOwners.class).list();
            return objs;
        }, new JsonTransformer());

        get("sample/company_owners/:id", "application/json", (request, response) -> {
            long id = Long.parseLong(request.params(":id"));
            CompanyOwners obj = (CompanyOwners)HibernateUtil.getSession().get(CompanyOwners.class, id);
            if (obj == null) halt(404);
            return obj;
        }, new JsonTransformer());

        post("sample/company_owners", "application/json", (request, response) -> {
            CompanyOwners obj = JacksonUtil.readValue(request.body(), CompanyOwners.class);
            HibernateUtil.getSession().saveOrUpdate(obj);
            response.status(201);
            return obj;
        }, new JsonTransformer());

        put("sample/company_owners/:id", "application/json", (request, response) -> {
            long id = Long.parseLong(request.params(":id"));
            CompanyOwners obj = (CompanyOwners)HibernateUtil.getSession().get(CompanyOwners.class, id);
            if (obj == null) halt(404);
            obj = JacksonUtil.readValue(request.body(), CompanyOwners.class);
            obj = (CompanyOwners)HibernateUtil.getSession().merge(obj);
            return obj;
        }, new JsonTransformer());

        delete("sample/company_owners/:id", (request, response) -> {
            long id = Long.parseLong(request.params(":id"));
            CompanyOwners obj = (CompanyOwners)HibernateUtil.getSession().get(CompanyOwners.class, id);
            if (obj == null) halt(404);
            HibernateUtil.getSession().delete(obj);
            response.status(204);
            return "";
        });


        before((request, response) -> {
            HibernateUtil.getSession().beginTransaction();
        });

        after((request, response) -> {
            HibernateUtil.getSession().getTransaction().commit();
            HibernateUtil.closeSession();
        });

        exception(Exception.class, (e, request, response) -> {
            HibernateUtil.getSession().getTransaction().rollback();
            HibernateUtil.closeSession();
            response.status(500);
        });
    }
}
