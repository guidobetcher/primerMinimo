package dsa.models;

import java.util.List;
import java.util.Queue;

public class User {
    public String name;
    public List<Order> historyOrders;

    public void setName(String name) {
        this.name = name;
    }

    public void setHistoryOrders(List<Order> historyOrders) {
        this.historyOrders = historyOrders;
    }
}
