package com.products.Products.services;

import com.products.Products.dtos.RequestProductDTO;
import com.products.Products.dtos.ResponseProductDTO;
import com.products.Products.exceptions.ProductExceptions;
import com.products.Products.models.ProductModel;
import com.products.Products.repositories.ProductRepository;
import com.products.Products.services.interfaces.ProductInterface;
import com.products.Products.validations.ProductValidations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductInterface {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductValidations productValidations;

   @Override
   public void createProduct(RequestProductDTO requestProductDTO){
       // Verifica se o nome do produto já existe
       productValidations.validateProductName(requestProductDTO.getName());
//       productValidations.validateProductFields(requestProductDTO);
       if (requestProductDTO.getName().trim().isBlank()) {
           throw new ProductExceptions.RequiredFieldMissingException("name");
       }

//       // Validação do campo typeProduct (se necessário)
//       if (requestProductDTO.getTypeProduct() == null) {
//           throw new ProductExceptions.RequiredFieldMissingException("typeProduct");
//       }

       // Validação do campo price
//       if (requestProductDTO.getPrice() == null) {
//           throw new ProductExceptions.RequiredFieldMissingException("price");
//       }
       ProductModel productModel = new ProductModel();
       BeanUtils.copyProperties(requestProductDTO, productModel);
       productRepository.save(productModel);
   }

    @Override
    public List<ResponseProductDTO> getAllProducts(){
        List<ProductModel> productModels = productRepository.findAll();
        // Converte cada ProductModel para ResponseProductDTO usando o BeanUtils
        return productModels.stream()
                .map(productModel -> {
                    ResponseProductDTO dto = new ResponseProductDTO();
                    BeanUtils.copyProperties(productModel, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResponseProductDTO> getProductById (UUID idProduct){
        productValidations.validateIdFormat(idProduct);
        return productRepository.findById(idProduct)
                .map(productModel -> {
                    ResponseProductDTO responseProductDTO = new ResponseProductDTO();
                    BeanUtils.copyProperties(productModel, responseProductDTO);
                    return responseProductDTO;
                });
    }

    public void deleteProductById(UUID idProduct){
            productRepository.deleteById(idProduct);
    }

    @Override
    public void updateProduct(RequestProductDTO requestProductDTO, ProductModel product) {
        BeanUtils.copyProperties(requestProductDTO, product);
        productRepository.save(product);
    }


}
