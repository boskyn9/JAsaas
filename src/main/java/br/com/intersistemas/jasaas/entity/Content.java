package br.com.intersistemas.jasaas.entity;

/**
 *
 * @author bosco
 */
public class Content {
 
    private City city;
    private Customer customer;
    private Payment payment;
    private Notification notification;   
    private Subscription subscription;      

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
    
    
    
}
