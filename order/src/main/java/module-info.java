module com.app.order {
    requires com.app.costumer;
    requires com.app.shared;
    requires spring.context;
    opens com.app.order.service to spring.beans, spring.context;
}
