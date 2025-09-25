module com.app.order {
    requires com.app.costumer;
    requires com.app.product;
    requires com.app.shared;

    requires spring.context;
    requires spring.web;

    requires jakarta.persistence;
    requires static lombok;

    requires org.slf4j;

    exports com.app.order.api;
    exports com.app.order.domain;

    // Enabling reflection access from unnamed Spring modules
    opens com.app.order.service;
    opens com.app.order.controller;
}
