module com.app.product {
    requires static lombok;
    requires spring.context;
    requires jakarta.persistence;
    exports com.app.product.api;
    exports com.app.product.domain;

    opens com.app.product.service;
}
