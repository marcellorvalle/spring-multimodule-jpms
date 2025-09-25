module com.app.app {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires com.app.shared;
    requires com.app.costumer;
    requires com.app.order;

    // Enabling reflection access from unnamed Spring modules
    opens com.app.app;
}
