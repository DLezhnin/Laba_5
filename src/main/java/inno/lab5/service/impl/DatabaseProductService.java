package inno.lab5.service.impl;

import inno.lab5.exception.EntityNotFoundException;
import inno.lab5.model.Product;
import inno.lab5.repository.DatabaseProductRepository;
import inno.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class DatabaseProductService implements ProductService {

    @Autowired
    private final DatabaseProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById((id))
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Продуктс ID {0} не найден!",id)));
    }
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

}
