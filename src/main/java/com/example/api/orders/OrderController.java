package com.example.api.orders;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Получить список заказов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список заказов получен"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping(path = "list")
    public List<Order> orders() {
        return orderService.orders();
    }

    @Operation(summary = "Добавить новый заказ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заказ успешно добавлен"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PostMapping(path = "item")
    public void add(@RequestBody Order order) {
        orderService.add(order);
    }

    @Operation(summary = "Удалить заказ по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Заказ успешно удалён"),
            @ApiResponse(responseCode = "404", description = "Заказ не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @DeleteMapping(path = "delete/{id}")
    public void delete(@PathVariable Long id) {
        Order order = new Order();
        order.setId(id);
        orderService.delete(order);
    }

    @Operation(summary = "Получить заказ по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Заказ найден"),
            @ApiResponse(responseCode = "404", description = "Заказ не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping(path = "{id}")
    public Order get(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @Operation(summary = "Обновить заказ по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Заказ успешно обновлён"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "404", description = "Заказ не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PutMapping(path = "put/{id}")
    public void put(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        orderService.update(order);
    }
}