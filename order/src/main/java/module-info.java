module com.app.order {
    requires com.app.costumer;
    requires com.app.shared;
    requires spring.context;
    // Enabling reflection access from unnamed Spring modules
    opens com.app.order.service;
}
