package com.ecommerce.service;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile({"customer", "default"})
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Método 1: Obtener todos los clientes
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Método 2: Obtener un cliente por ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Método 3: Guardar un nuevo cliente o actualizar un cliente existente
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Método 4: Eliminar un cliente por ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Método 5: Actualizar la información de perfil de un cliente
    public Customer updateCustomerProfile(Long id, String firstName, String lastName, String email) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            return customerRepository.save(customer);
        }
        return null;
    }

    // Método 6: Verificar las credenciales de inicio de sesión
    public boolean verifyLogin(String email, String password) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        return customer.map(c -> c.getPassword().equals(password)).orElse(false);
    }

    // Método 7: Recuperar la contraseña
    public String recoverPassword(String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        return customer.map(Customer::getPassword).orElse("Email not found");
    }

    // Método 8: Ver historial de órdenes de un cliente
    public List<Order> getOrderHistory(Long customerId) {
        // Lógica para obtener el historial de órdenes del cliente
        return List.of(); // Simulación
    }

    // Método 9: Realizar un pedido
    public Order placeOrder(Long customerId, List<Product> products) {
        // Lógica para realizar un pedido
        return new Order(); // Simulación
    }

    // Método 10: Cancelar un pedido
    public boolean cancelOrder(Long orderId) {
        // Lógica para cancelar el pedido
        return true; // Simulación
    }

    // Método 11: Ver detalles de un pedido
    public Optional<Order> viewOrderDetails(Long orderId) {
        // Lógica para obtener los detalles de un pedido
        return Optional.of(new Order()); // Simulación
    }

    // Método 12: Devolver un producto
    public boolean returnProduct(Long orderId, Long productId) {
        // Lógica para devolver un producto de un pedido
        return true; // Simulación
    }

    // Método 13: Ver el carrito de compras del cliente
    public List<Product> viewCart(Long customerId) {
        // Lógica para ver los productos en el carrito
        return List.of(); // Simulación
    }

    // Método 14: Añadir un producto al carrito
    public void addToCart(Long customerId, Product product) {
        // Lógica para añadir un producto al carrito
        System.out.println("Product added to cart");
    }

    // Método 15: Eliminar un producto del carrito
    public void removeFromCart(Long customerId, Long productId) {
        // Lógica para eliminar un producto del carrito
        System.out.println("Product removed from cart");
    }

    // Método 16: Aplicar un cupón de descuento
    public boolean applyCoupon(Long customerId, String couponCode) {
        // Lógica para aplicar un cupón de descuento
        return true; // Simulación
    }

    // Método 17: Guardar productos en la lista de deseos
    public void addToWishlist(Long customerId, Product product) {
        // Lógica para añadir productos a la lista de deseos
        System.out.println("Product added to wishlist");
    }

    // Método 18: Ver la lista de deseos del cliente
    public List<Product> viewWishlist(Long customerId) {
        // Lógica para ver la lista de deseos
        return List.of(); // Simulación
    }

    // Método 19: Gestionar direcciones de envío
    public void updateShippingAddress(Long customerId, String newAddress) {
        // Lógica para actualizar la dirección de envío del cliente
        System.out.println("Shipping address updated");
    }

    // Método 20: Ver notificaciones del cliente
    public List<String> viewNotifications(Long customerId) {
        // Lógica para ver notificaciones del cliente
        return List.of("Notification 1", "Notification 2"); // Simulación
    }
}
