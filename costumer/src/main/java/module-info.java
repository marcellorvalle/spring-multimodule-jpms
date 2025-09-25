module com.app.costumer {
    requires com.app.shared;
    requires spring.context;
    requires spring.web;
    requires java.sql;
    exports com.app.costumer.api;
    exports com.app.costumer.domain;
    opens com.app.costumer.controller to spring.beans, spring.context;
    opens com.app.costumer.service to spring.beans, spring.context;
}
