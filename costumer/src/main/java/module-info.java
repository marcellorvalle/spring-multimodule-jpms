module com.app.costumer {
    requires com.app.shared;
    requires spring.context;
    requires spring.web;
    requires java.sql;
    requires jakarta.persistence;
    requires static lombok;
    exports com.app.customer.api;
    exports com.app.customer.domain;
    // Enabling reflection access from unnamed Spring modules
    opens com.app.customer.controller;
    opens com.app.customer.service;
}
