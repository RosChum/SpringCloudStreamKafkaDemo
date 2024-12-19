package rost.example;

public class OrderPurchaseEvent implements Event {

    private Long orderId;

    private Long userId;

    private Double cost;

    private OrderStatus status;

    @Override
    public String toString() {
        return "OrderPurchaseEvent{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", cost=" + cost +
                ", status=" + status +
                '}';
    }

    public OrderPurchaseEvent(Long orderId, Long userId, Double cost, OrderStatus status) {
        this.orderId = orderId;
        this.userId = userId;
        this.cost = cost;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
