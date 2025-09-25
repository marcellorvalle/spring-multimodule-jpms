module com.app.billing {
    requires com.app.costumer;

    requires org.slf4j;

    requires static lombok;
    requires spring.context;

    exports com.app.billing.api;
    exports com.app.billing.event;

    opens com.app.billing.service;
}
