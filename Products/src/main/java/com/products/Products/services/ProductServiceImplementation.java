package com.products.Products.services;

import com.products.Products.dtos.RequestProductDTO;
import com.products.Products.dtos.ResponseProductDTO;
import com.products.Products.exceptions.ProductAlreadyExistsException;
import com.products.Products.exceptions.ProductNotFoundException;
import com.products.Products.models.ProductModel;
import com.products.Products.repositories.ProductRepository;
import com.products.Products.services.interfaces.ProductInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductInterface {

    @Autowired
    private ProductRepository productRepository;

   @Override
   public void createProduct(RequestProductDTO requestProductDTO){

       if (productRepository.existsByName(requestProductDTO.getName())) {
           throw new ProductAlreadyExistsException("Esse produto já foi cadastrado");
       }

       ProductModel productModel = new ProductModel();
       BeanUtils.copyProperties(requestProductDTO, productModel);

       productRepository.save(productModel);
   }

    @Override
    public List<ResponseProductDTO> getAllProducts(){
        List<ProductModel> products = productRepository.findAll();

        return products.stream()
                .map(productModel -> {
                    ResponseProductDTO productDTO = new ResponseProductDTO();
                    BeanUtils.copyProperties(productModel, productDTO);
                    return productDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ResponseProductDTO getProductById(UUID idProduct) {

        if (!productRepository.existsById(idProduct)) {
            throw new ProductNotFoundException();
        }

        return productRepository.findById(idProduct)
                .map(products -> {
                    ResponseProductDTO responseProductDTO = new ResponseProductDTO();
                    BeanUtils.copyProperties(products, responseProductDTO);
                    return responseProductDTO;
                })
                .orElseThrow();
    }

    @Override
    public void deleteProductById(UUID idProduct) {
        productRepository.deleteById(idProduct);
    }

    @Override
    public void updateProduct(RequestProductDTO requestProductDTO, ProductModel productModel) {

        BeanUtils.copyProperties(requestProductDTO, productModel);
        productModel.setDateUpdate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        productRepository.save(productModel);
    }


}
