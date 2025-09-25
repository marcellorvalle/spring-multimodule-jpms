module com.app.costumer {
    requires com.app.shared;
    requires spring.context;
    requires spring.web;
    requires java.sql;
    requires jakarta.persistence;
    requires static lombok;
    exports com.app.costumer.api;
    exports com.app.costumer.domain;
    // Enabling reflection access from unnamed Spring modules
    opens com.app.costumer.controller;
    opens com.app.costumer.service;
}
