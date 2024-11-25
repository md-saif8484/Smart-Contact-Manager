package productcrudapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import productcrudapp.model.Product;

@Repository
public class ProductDao {

    // Inject the EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createProduct(Product product) {
//        entityManager.persist(product); // Use EntityManager to persist the product
    	entityManager.merge(product); // Use merge to either save or update the product
    }

    public List<Product> getProducts() {
        // Use JPQL to retrieve all Product records
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Transactional
    public void deleteProduct(int pid) {
        // Retrieve and delete the Product by ID
        Product product = entityManager.find(Product.class, pid);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public Product getProduct(int id) {
        // Find a Product by ID
        return entityManager.find(Product.class, id);
    }
}
